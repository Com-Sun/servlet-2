package com.nhnacademy.homework;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@WebServlet(name = "loginServlet", urlPatterns = "/login", initParams = {
    @WebInitParam(name = "id", value = "hyunjin"),
    @WebInitParam(name = "pwd", value = "12345")
})
@Slf4j
public class LoginServlet extends HttpServlet {
    private String configId;
    private String configPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        configId = config.getInitParameter("id");
        configPwd = config.getInitParameter("pwd");
    }

    //세션에다가 로그인 객체를 넣는 경우도 있다..
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.error("/login.doGet");
        HttpSession session = req.getSession(false);// 반드시세션. 세션이 없으면 로그인되면 안됨.
        if(Objects.isNull(session) /*Objects.isNull(session.getAttribute("id))*/) {
            resp.sendRedirect("/login.html");
        } else {
//            resp.setContentType("text/plain");
//            resp.setCharacterEncoding("UTF-8");
//            resp.getWriter().println("Login Success: " + session.getAttribute("id"));
            resp.sendRedirect("/foods");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if (configId.equals(id) && configPwd.equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            resp.sendRedirect("/login");

        }else {
            resp.sendRedirect("/login.html");
        }
    }
}

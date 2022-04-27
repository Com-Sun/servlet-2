package com.nhnacademy.homework;

import static java.util.Objects.nonNull;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (nonNull(session)) {
            session.invalidate();
            // resp.sendRedirect("/login.html");
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req, resp);
        }
    }
}

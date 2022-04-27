package com.nhnacademy.homework;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;


@WebServlet(name = "foodsServlet", urlPatterns = "/foods" )
public class FoodsServlet extends HttpServlet {
    private FoodStand foodStand;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        foodStand = (FoodStand) getServletContext().getAttribute("foodStand");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            for (Food food : foodStand.getFoods()) {
                out.println(food);
                out.println();
            }
            out.println(Jsoup.parse("<form method = \"post\" action = \"/cart\">" +
                "양파 : <input type = \"text\" name = \"onion\">" +
                "계란 : <input type = \"text\" name = \"egg\">" +
                "파 : <input type = \"text\" name = \"greenOnion\">" +
                "사과 : <input type = \"text\" name = \"apple\">" +
                "<input type = \"submit\" />" +
                "</form>"));
        }
    }
}

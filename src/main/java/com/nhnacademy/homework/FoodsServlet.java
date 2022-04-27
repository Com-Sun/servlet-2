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

//web initializer 에서 객체 자체를 생성해서 context에 넣어놓자.
@WebServlet(name = "foodsServlet", urlPatterns = "/foods" )
//    initParams = {
//    @WebInitParam(name = "foodStand", value =
//        "{" +
//            "양파;2000;2\n" +
//            "계란;2000;5\n" +
//            "파;500;10\n" +
//            "사과;2000;20\n" +
//            "}")
//})
public class FoodsServlet extends HttpServlet {
    private FoodStand foodStand;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        foodStand = (FoodStand) getServletContext().getAttribute("foodStand");
//        ServletContext sc = getServletContext();
//        String[] foods = config.getInitParameter("foodStand").split("\n");
//        String[] onionStr = foods[0].split(";");
//        Food onion = new Food(onionStr[0], onionStr[1], onionStr[2]);
//        String[] eggStr = foods[1].split(";");
//        Food egg = new Food(eggStr[0], eggStr[1], eggStr[2]);
//        String[] paStr = foods[2].split(";");
//        Food pa = new Food(paStr[0], paStr[1], paStr[2]);
//        String[] appleStr = foods[3].split(";");
//        Food apple = new Food(appleStr[0], appleStr[1], appleStr[2]);
//
//        foodStand.foods.add(onion);
//        foodStand.foods.add(egg);
//        foodStand.foods.add(pa);
//        foodStand.foods.add(apple);

//        sc.setAttribute("foodStand", foodStand);
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

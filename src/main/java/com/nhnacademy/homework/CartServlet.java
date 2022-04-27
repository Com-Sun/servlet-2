package com.nhnacademy.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("text/plain");
        try(PrintWriter out = resp.getWriter()) {
            FoodStand buyList = (FoodStand) req.getServletContext().getAttribute("buyList");

            int price = 0;
            for (Food f : buyList.getFoods()) {
                price += Integer.parseInt(f.getCost());
                out.println(f);
            }
            out.println("전체금액: " + price);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("text/html");
        int onionCnt = Integer.parseInt(req.getParameter("onion"));
        int eggCnt = Integer.parseInt(req.getParameter("egg"));
        int greenOnionCnt = Integer.parseInt(req.getParameter("greenOnion"));
        int appleCnt = Integer.parseInt(req.getParameter("apple"));
        int[] foodsCnt = {onionCnt, eggCnt, greenOnionCnt, appleCnt};

        FoodStand foodStand = (FoodStand) req.getServletContext().getAttribute("foodStand");


        Food onion = new Food("onion", "1000", onionCnt);
        Food egg = new Food("egg", "2000", eggCnt);
        Food pa = new Food("pa", "500", greenOnionCnt);
        Food apple = new Food("apple", "2000", appleCnt);


        try(PrintWriter out = resp.getWriter()) {
            int i = 0;
            for (Food f : foodStand.getFoods()) {
                if (f.getQuantity() < foodsCnt[i]) {
                    log.error("Exceed ERROR!");
                    resp.sendError(500, "장바구니에 담긴 과일이 너무 많습니다.");
                }
                f.quantity -= foodsCnt[i];
                i++;
            }
            out.println("카트에 담은 상품 목록");
            out.println(onion);
            out.println(egg);
            out.println(pa);
            out.println(apple);
            out.println("<a href=\"http://localhost:8081/cart\">이동하기!</a>");
       }

        FoodStand buyList = new FoodStand();
        buyList.add(onion);
        buyList.add(egg);
        buyList.add(pa);
        buyList.add(apple);
        req.getServletContext().setAttribute("foodStand", foodStand);
        req.getServletContext().setAttribute("buyList", buyList);

    }
}

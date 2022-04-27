package com.nhnacademy.homework;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    String[] html;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        try(PrintWriter out = resp.getWriter()) {
            out.println(html);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        html = req.getParameterValues("html");
        String onionCnt = req.getParameter("onion");
        String eggCnt = req.getParameter("egg");
        String greenOnionCnt = req.getParameter("greenOnion");
        String appleCnt = req.getParameter("apple");

        Food onion = new Food("onion", "1000", onionCnt);
        Food egg = new Food("egg", "2000", eggCnt);
        Food pa = new Food("pa", "500", greenOnionCnt);
        Food apple = new Food("apple", "2000", appleCnt);
        try(PrintWriter out = resp.getWriter()) {
            out.println(onion);
            out.println(egg);
            out.println(pa);
            out.println(apple);
       }

    }
}

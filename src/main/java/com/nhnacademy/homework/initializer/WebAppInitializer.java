package com.nhnacademy.homework.initializer;

import com.nhnacademy.homework.Food;
import com.nhnacademy.homework.FoodStand;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes(
    {javax.servlet.http.HttpServlet.class,
        javax.servlet.Filter.class,
        javax.servlet.ServletContextListener.class,
        javax.servlet.http.HttpSessionListener.class
    }
)
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
        Food onion = new Food("양파", "1000", 2);
        Food egg = new Food("게란", "2000", 5);
        Food pa = new Food("파", "500", 10);
        Food apple = new Food("사과", "2000", 20);

        FoodStand foodStand = new FoodStand();
        foodStand.add(onion);
        foodStand.add(egg);
        foodStand.add(pa);
        foodStand.add(apple);

        servletContext.setAttribute("foodStand", foodStand);

    }
}

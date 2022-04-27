package com.nhnacademy.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodStand {
    List<Food> foods = new ArrayList<>();

    public List<Food> getFoods() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }

}

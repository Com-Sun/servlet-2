package com.nhnacademy.homework;

import java.util.HashMap;
import java.util.Map;

public class Food {
    String name;
    String cost;
    String quantity;

    public Food(String name, String cost, String quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
            "name='" + name + '\'' +
            ", cost=" + cost +
            ", quantity=" + quantity +
            '}';
    }
}

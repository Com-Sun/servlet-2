package com.nhnacademy.homework;

public class Food {
    String name;
    String cost;
    int quantity;

    public Food(String name, String cost, int quantity) {
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

    public int getQuantity() {
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

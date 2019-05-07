package com.wei.proxy;

public class Food {
    private String name;
    private String category;

    Food(String name, String category) {
        this.name = name;
        this.category = category;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

package com.wei.proxy;

public class Vihichle implements Moveable {
    @Override
    public void move(Animal animal, Food food, int number) {
        animal.eat(food,number);
    }
}

package com.wei.proxy;

public class Dog implements Animal {
    private String name;

    public Dog() {

    }
    public Dog(String name) {
        this();
        this.name = name;
    }
    public void eat(Food f, int num) {
        System.out.println("小狗喜欢吃" + num + "斤" + f);
    }

    public String sleep(int hours) {
       return "小狗一天睡" + hours + "小时";
    }

    public void eat(Food food) {
        System.out.println("小狗喜欢吃" + food);
    }

    @Override
    public String toString() {
        return "小狗" + name;
    }
}

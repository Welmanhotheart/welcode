package com.wei.singleton;

public class Hungry1 {
    private static Hungry1 instance = new Hungry1();

    private Hungry1() {}
    public static Hungry1 getInstance() {
        return instance;
    }

}

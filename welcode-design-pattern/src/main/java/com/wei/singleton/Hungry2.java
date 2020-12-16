package com.wei.singleton;

public class Hungry2 {
    private static Hungry2 instance ;
    static {
        instance = new Hungry2();
    }

    private Hungry2() {}
    public static Hungry2 getInstance() {
        return instance;
    }
}

package com.wei.singleton;

public class Hungry3 {
    private static class InnerHungry {
        private static final Hungry3 instance = new Hungry3();
    }

    public static Hungry3 getInstance() {
        return InnerHungry.instance;
    }
}

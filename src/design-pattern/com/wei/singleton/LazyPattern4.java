package com.wei.singleton;

public class LazyPattern4 {
    private static volatile LazyPattern4 instance;

    public static LazyPattern4 getInstance() {
        if (instance == null) {
            synchronized (LazyPattern4.class) {
                if (instance == null) {
                    instance = new LazyPattern4();
                }
            }
        }
        return instance;
    }

}

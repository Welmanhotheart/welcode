package com.wei.singleton;

/**
 * 懒汉式,此种情况会容易产生多个实例
 */
public class LazyPattern3 {
    private static LazyPattern3 instance;

    private LazyPattern3() {}

    public static LazyPattern3 getInstance() {
        if (instance == null) {
            synchronized (LazyPattern3.class) {
                instance = new LazyPattern3();
            }
        }
        return instance;
    }
}

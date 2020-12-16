package com.wei.singleton;

/**
 * 懒汉式2
 */
public class LazyPattern2 {
    private LazyPattern2() {}
    private static LazyPattern2 instance = null;

    public synchronized static LazyPattern2  getInstance() {
        if (instance == null) {
            instance = new LazyPattern2();
        }
        return instance;
    }

}

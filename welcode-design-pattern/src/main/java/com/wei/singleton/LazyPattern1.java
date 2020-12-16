package com.wei.singleton;

/**
 * 懒汉式
 */
public class LazyPattern1 {

    private static LazyPattern1 instance = null;
    private LazyPattern1() {}
    public static LazyPattern1 getInstance() {
        if (null == instance) {
            instance = new LazyPattern1();
        }
        return  instance;
    }
}

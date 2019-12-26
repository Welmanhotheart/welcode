package com.wei.BreakSingleton;

import java.io.Serializable;

public class SingletonInstance  implements Serializable {
    private static final long serialVersionUID = -7327434548808172995L;

    private static volatile SingletonInstance  instance;
    private static boolean flag = true;
    private SingletonInstance() {
        if(flag) {
            System.out.println(" SingletonInstance build singleton the first time");
            flag = false;
        } else {
            throw new RuntimeException("single pattern invaded, " +
                    "second instance unsuccessfully constructed");
        }
    }
    public static SingletonInstance getInstance() {
        if(instance == null) {
            synchronized (SingletonInstance.class) {
                if (instance == null) {
                    instance = new SingletonInstance();
                }
            }
        }
        return instance;
    }

    //
    private  Object readResolve() {
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

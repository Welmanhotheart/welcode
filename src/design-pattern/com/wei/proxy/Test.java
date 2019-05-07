package com.wei.proxy;

import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for (Object o : properties.keySet()) {
            System.out.println(o + "=" + properties.get(o));
        }

        System.out.println(Dog.class.getPackage().getName().replaceAll("\\.","/"));
        Method[] declaredMethods = Dog.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());

        }
    }
}

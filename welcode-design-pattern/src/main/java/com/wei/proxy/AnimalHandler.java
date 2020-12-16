package com.wei.proxy;

import java.lang.reflect.Method;

public class AnimalHandler implements InvocationHandler {
    private Animal animal;
    AnimalHandler(Animal animal) {
        this.animal = animal;
    }
    @Override
    public Object invoke(Object o, Method method, Object... args) {
        try {
            long start = System.currentTimeMillis();
            Object result =  method.invoke(animal, args);
            System.out.println(animal + "吃食物耗时" + (double)(System.currentTimeMillis() - start)/1000 + "s");
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
}

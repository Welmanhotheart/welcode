package com.wei.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoveableHandler implements InvocationHandler {
    private Moveable moveable;
    MoveableHandler(Moveable moveable) {
        this.moveable = moveable;
    }
    @Override
    public Object invoke(Object o, Method method, Object... args) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        Object invoke = method.invoke(moveable, args);
        System.out.println("耗时：" + (System.currentTimeMillis() - start)/1000 + "s");
        return invoke;
    }
}

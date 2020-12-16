package com.wei.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface InvocationHandler {
    /**
     *
     * @param o 代理对象
     * @param method 方法
     * @param args 参数
     * @return
     */
    public Object invoke(Object o, Method method, Object...args) throws InvocationTargetException, IllegalAccessException;
}

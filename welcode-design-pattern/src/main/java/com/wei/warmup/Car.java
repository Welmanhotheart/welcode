package com.wei.warmup;

public class Car implements Moveable{
    public Car() {

    }

    @Override
    public void go(Address address) {
        System.out.println("哼着歌，冒着烟去了：" + address.getName());
    }
}

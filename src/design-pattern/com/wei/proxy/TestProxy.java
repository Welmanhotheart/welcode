package com.wei.proxy;

public class TestProxy  {
    public static void main(String[] args) {
        Animal animal = (Animal) Proxy.newInstance(Dog.class.getClassLoader(), Dog.class.getInterfaces(),
                new AnimalHandler(new Dog("小黄")));
//        animal.eat(new Apple("红苹果", "热性食物"), 8);
//        animal.sleep(9);
//        animal.eat(new Apple("绿苹果","热性食物"));


        Moveable moveable = (Moveable)Proxy.newInstance(Vihichle.class.getClassLoader(), Vihichle.class.getInterfaces(), new MoveableHandler(new Vihichle()));
        moveable.move(animal,  new Apple("红苹果", "热性食物"), 8);

    }
}

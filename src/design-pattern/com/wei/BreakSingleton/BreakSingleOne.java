package com.wei.BreakSingleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class BreakSingleOne {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException, CloneNotSupportedException {
//        SingletonInstance instance = new SingletonInstance();

        SingletonInstance instance = SingletonInstance.getInstance();

        Object clone = instance.clone();

        //I am going to break the singleton pattern，but failed
//        Constructor<SingletonInstance> constructor = SingletonInstance.class.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        SingletonInstance instance2 = constructor.newInstance();
//        System.out.println(instance == instance2);

        //I am going to break the singleton pattern again，suceed, any method to prevent
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("break-singleton"));
        out.writeObject(instance);
        out.flush();
//

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("break-singleton"));
        SingletonInstance instance2 = (SingletonInstance) in.readObject();
         in.close();
//         in.reset();
//        SingletonInstance instance2 = (SingletonInstance) in.readObject();
        System.out.println(instance == instance2);
    }
}

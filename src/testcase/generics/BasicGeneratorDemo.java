package testcase.generics;

//: generics/BasicGeneratorDemo.java

import testcase.net.mindview.util.*;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        //when pass type object , It can still do type inference
        Generator<CountedObject> gen =
                BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~

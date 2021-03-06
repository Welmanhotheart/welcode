package exercise.generics;

import generics.CountedObject;
import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

//: generics/BasicGeneratorDemo.java

class BasicGeneratorDemo {
    public static void main(String[] args) {
        /*
         * when use the explicit contructor to create the generator,is seems to be
         * a little redundant,you have to repeat type 'CountedObject'
         */
        Generator<CountedObject> gen =
                new BasicGenerator<CountedObject>(CountedObject.class);
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

public class Exercise14 {
    public static void main(String[] args) {
        GenericMethods_.main(null);
    }
}

/**
 * output:
 * java.lang.String
 * java.lang.String
 * java.lang.Float
 * <p>
 * java.lang.Character
 * java.lang.Long
 * java.lang.Double
 * <p>
 * java.lang.Integer
 * java.lang.Byte
 * exercise.generics.GenericMethods_
 */

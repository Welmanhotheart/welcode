package exercise.arrays;


import java.util.Arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;


public class Exercise13 {
    public static void main(String[] args) {
        Character[] array = Generated.array(Character.class, new CountingGenerator.Character(), 7);
        System.out.println(new String(ConvertTo.primitive(array)));
    }
}

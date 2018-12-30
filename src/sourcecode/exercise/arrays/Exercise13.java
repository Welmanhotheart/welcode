package exercise.arrays;


import java.util.Arrays;

import testcase.net.mindview.util.CountingGenerator;
import testcase.net.mindview.util.ConvertTo;
import testcase.net.mindview.util.Generated;


public class Exercise13 {
    public static void main(String[] args) {
        Character[] array = Generated.array(Character.class, new CountingGenerator.Character(), 7);
        System.out.println(new String(ConvertTo.primitive(array)));
    }
}

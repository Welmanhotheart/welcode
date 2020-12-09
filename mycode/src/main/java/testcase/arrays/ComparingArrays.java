package testcase.arrays;

//: arrays/ComparingArrays.java
// Using Arrays.equals()

import java.util.*;

import static testcase.net.mindview.util.Print.*;

/*
 * As for Arrrays.equals,there are many overloaded versions, if the parameters are
 * Object type, it will call the equals method of the parameters
 * if the parameters are primitive double, it will tranfer the double paramters to long bytes
 * and then compare
 */
public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        print(Arrays.equals(a1, a2));
        a2[3] = 11;
        print(Arrays.equals(a1, a2));
        String[] s1 = new String[4];
        Arrays.fill(s1, "Hi");
        String[] s2 = {new String("Hi"), new String("Hi"),
                new String("Hi"), new String("Hi")};
        print(Arrays.equals(s1, s2));
    }
} /* Output:
true
false
true
*///:~

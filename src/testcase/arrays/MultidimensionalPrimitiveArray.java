package testcase.arrays;

//: arrays/MultidimensionalPrimitiveArray.java
// Creating multidimensional arrays.
import java.util.*;

public class MultidimensionalPrimitiveArray {
  public static void main(String[] args) {
    int[][] a = {
      { 1, 2, 3, },
      { 4, 5, 6, },
    };
    System.out.println(Arrays.deepToString(a));// continue recursive going on
    System.out.println(Arrays.toString(a));
  }
} /* Output:
[[1, 2, 3], [4, 5, 6]]
[[I@252f0999, [I@331f2ee1]
*///:~

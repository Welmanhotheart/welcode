package testcase.generics;

//: generics/GenericVarargs.java
import java.util.*;

import testcase.typeinfo.pets.*;

public class GenericVarargs {
  public static <T> List<T> makeList(T... args) {
    List<T> result = new ArrayList<T>();
    for(T item : args)
      result.add(item);
    return result;
  }
  public static void main(String[] args) {
    List<String> ls = makeList("A");
    System.out.println(ls);
    ls = makeList("A", "B", "C");
    System.out.println(ls);
    ls = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
    System.out.println(ls);
 /*
  *  first they are autoboxed into their wrapped type and then their base class type are inferred,It's Number
  *  Is this rule always true when applied to a hierarchy ?
  */
    System.out.println(makeList((byte)1, 2, 3f));
    System.out.println(makeList(new Mutt(), new Rat(), 3f));// their commom ancestor is 'Comparable' interface
  }
} /* Output:
[A]
[A, B, C]
[, A, B, C, D, E, F, F, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
*///:~

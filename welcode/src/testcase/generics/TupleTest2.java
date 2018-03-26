package testcase.generics;

//: generics/TupleTest2.java
import testcase.net.mindview.util.*;
import static testcase.net.mindview.util.Tuple.*;

public class TupleTest2 {
  static TwoTuple<String,Integer> f() {
    return tuple("hi", 47);
  }
  static TwoTuple f2() { return tuple("hi", 47); }
  static ThreeTuple<Amphibian,String,Integer> g() {
    return tuple(new Amphibian(), "hi", 47);
  }
  static
  FourTuple<Vehicle,Amphibian,String,Integer> h() {
    return tuple(new Vehicle(), new Amphibian(), "hi", 47);
  }
  static
  FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
    return tuple(new Vehicle(), new Amphibian(),
      "hi", 47, 11.1);
  }
  
  static
  SixTuple<Vehicle,Amphibian,String,Integer,Double,Integer> l() {
  	return tuple(new Vehicle(), new Amphibian(),
  			"hi", 47, 11.1,12);
  }
  public static void main(String[] args) {
    TwoTuple<String,Integer> ttsi = f();
    /*warning
     * Type safety: The expression of type TwoTuple needs unchecked
     *  conversion to conform to TwoTuple<String,Integer>
     */
//    TwoTuple<String, Integer> f2 = f2();
    System.out.println(ttsi);
    System.out.println(f2());
    System.out.println(g());
    System.out.println(h());
    System.out.println(k());
    System.out.println(l());
  }
} /* Output: (80% match)
(hi, 47)
(hi, 47)
(Amphibian@7d772e, hi, 47)
(Vehicle@757aef, Amphibian@d9f9c3, hi, 47)
(Vehicle@1a46e30, Amphibian@3e25a5, hi, 47, 11.1)
*///:~

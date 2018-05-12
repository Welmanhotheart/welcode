package testcase.generics;

import java.util.ArrayList;
import java.util.List;

//: generics/ArrayOfGeneric.java

public class ArrayOfGeneric {
  static final int SIZE = 100;
  static Generic<Integer>[] gia;
//  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    // Compiles; produces ClassCastException:
    //! gia = (Generic<Integer>[])new Object[SIZE];
    // Runtime type is the raw (erased) type:
  	/*
  	 * But you can never create an array of that exact type
  	 * (including the type parameters), why ?
  	 */
//    gia = new Generic<Integer>[SIZE];
  	
    gia = new Generic[SIZE]; //no compile error
    System.out.println(gia.getClass().getSimpleName());
    gia[0] = new Generic<Integer>();
    //! gia[1] = new Object(); // Compile-time error
    // Discovers type mismatch at compile time:
    //! gia[2] = new Generic<Double>();
  }
} /* Output:
Generic[]
*///:~

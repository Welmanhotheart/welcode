package testcase.generics;

//: generics/ListMaker.java
import java.util.*;

public class ListMaker<T> {
  List<T> create() { 
  	/*
  	 * even though erasure removes the information about the actual type
		 * inside a method or class, the compiler can still ensure internal 
		 * consistency in the way that the type is used within the method or class.
  	 */
//  	return new ArrayList();
  	return new ArrayList<T>();
  }
  public static void main(String[] args) {
    ListMaker<String> stringMaker= new ListMaker<String>();
    List<String> stringList = stringMaker.create();
  }
} ///:~

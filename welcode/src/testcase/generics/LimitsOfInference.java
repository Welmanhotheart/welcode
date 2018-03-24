package testcase.generics;

//: generics/LimitsOfInference.java
import testcase.net.mindview.util.New;
import testcase.typeinfo.pets.*;

import java.util.*;

public class LimitsOfInference {
  static void
  f(Map<Person, List<? extends Pet>> petPeople) {}
  public static void main(String[] args) {
     //f(New.map()); // Does not compile, type can be inferred when do assignment,but there is a solution
  	f(New.<Person, List<? extends Pet>>map());//Explicit type specification.Exercise 12
  }
} ///:~

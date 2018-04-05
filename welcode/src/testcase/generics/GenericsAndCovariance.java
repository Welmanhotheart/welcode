package testcase.generics;

//: generics/GenericsAndCovariance.java
import java.util.*;

public class GenericsAndCovariance {
  public static void main(String[] args) {
    // Wildcards allow covariance:
    List<? extends Fruit> flist = new ArrayList<Apple>();
    // Compile Error: can't add any type of object:
    // flist.add(new Apple()); It still cant figure out that flist hold type Apple? yeah, because flist doesnt actually care type
    // flist.add(new Fruit());
    // flist.add(new Object());
    flist.add(null); // Legal but uninteresting
    // We know that it returns at least Fruit:
    List<? extends Number> nlst = new ArrayList<Integer>();
    nlst.addAll(null);
    String a = (String) new Object();
    
  }
} ///:~

/**
 * The explanation about compile error when adding 'new Apple'、
 * the instance specify the type, but the reference which receive it doesn't specify the type
 * but in order to upcast to the reference ,that type is a 'don't actually care'
 */

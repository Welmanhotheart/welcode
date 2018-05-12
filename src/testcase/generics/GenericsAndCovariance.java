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
        flist.indexOf(new Apple());
    }
} ///:~

/**
 * The explanation about compile error when adding 'new Apple'、
 * the instance specify the type, but the reference which receive it doesn't specify the type
 * but in order to upcast to the reference ,that type is a 'don't actually care'
 * And also the compiler is not very smart:
 * By looking at the documentation for ArrayList, we find that the compiler is not that smart.
 * While add( ) takes an argument of the generic parameter type, contains( ) and indexOf( )
 * take arguments of type Object. So when you specify an ArrayList <? extends Fruit >, the
 * argument for add( ) becomes’? extends Fruit’. From that description, the compiler cannot
 * know which specific subtype of Fruit is required there, so it won’t accept any type of Fruit.
 * It doesn’t matter if you upcast the Apple to a Fruit first—the compiler simply refuses to call
 * a method (such as add( )) if a wildcard is involved in the argument list.
 */

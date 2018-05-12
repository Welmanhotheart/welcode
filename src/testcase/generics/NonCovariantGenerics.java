package testcase.generics;

//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
import java.util.*;

public class NonCovariantGenerics {
  // Compile Error: incompatible types:
  List<Fruit> flist = new ArrayList<Apple>();
} ///:~

/**
 * The explanation about compile error:
 * Unlike arrays, generic has no built-in covariance. This is because arrays are completely
 * defined in the language and can thus have both compile-time and runtime checks built in,
 * but with generics, the compiler and runtime system cannot know what you want to do with your
 * types and what the rule should be
 */

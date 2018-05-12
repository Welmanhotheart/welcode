
package exercise.generics;

//: generics/Generators.java
//A utility to use with Generators.
import testcase.generics.Fibonacci;
import testcase.generics.coffee.*;

import java.util.*;

import testcase.net.mindview.util.*;

class Generators {
public static <T> Collection<T>
fill(Collection<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++)
    coll.add(gen.next());
  return coll;
}	
public static <T> List<T>
fill(List<T> coll, Generator<T> gen, int n) {
	for(int i = 0; i < n; i++)
		coll.add(gen.next());
	return coll;
}	

public static <T> Queue<T>
fill(Queue<T> coll, Generator<T> gen, int n) {
	for(int i = 0; i < n; i++)
		coll.add(gen.next());
	return coll;
}	
public static <T> Set<T>
fill(Set<T> coll, Generator<T> gen, int n) {
	for(int i = 0; i < n; i++)
		coll.add(gen.next());
	return coll;
}	
public static void main(String[] args) {
	//The method fill(Collection<Coffee>, Generator<Coffee>, int) is ambiguous for the type Generators
   fill(
    new LinkedList<Coffee>(), new CoffeeGenerator(), 4);
  
}
} /* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
*///:~

public class Exercise13 {
	public static void main(String[] args) {
	
	}
}

/**
 * output:
 *java.lang.String
	java.lang.String
	java.lang.Float
	
	java.lang.Character
	java.lang.Long
	java.lang.Double
	
	java.lang.Integer
	java.lang.Byte
	exercise.generics.GenericMethods 
 */

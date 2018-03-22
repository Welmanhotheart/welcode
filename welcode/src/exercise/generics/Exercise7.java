package exercise.generics;


//: generics/IterableFibonacci.java
//Adapt the Fibonacci class to make it Iterable.
import java.util.*;

import testcase.generics.Fibonacci;

class IterableFibonacci implements Iterable<Integer> {
	private int n;
	Fibonacci fibonacci;
	public IterableFibonacci(int count) { n = count;fibonacci = new Fibonacci(); }
	public Iterator<Integer> iterator() {
	  return new Iterator<Integer>() {
	    public boolean hasNext() { return n > 0; }
	    public Integer next() {
	      n--;
	      return fibonacci.next();
	    }
	    public void remove() { // Not implemented
	      throw new UnsupportedOperationException();
	    }
	  };
	}	
	public static void main(String[] args) {
	  for(int i : new IterableFibonacci(18))
	    System.out.print(i + " ");
	}
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~


public class Exercise7 {
	public static void main(String[] args) {
		IterableFibonacci.main(null);
	}
}

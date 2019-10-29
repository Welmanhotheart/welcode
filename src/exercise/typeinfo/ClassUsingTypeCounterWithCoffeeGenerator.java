package exercise.typeinfo;

//: generics/coffee/CoffeeGenerator.java
//Generate different types of Coffee:
//Exercise12
import java.util.*;

import generics.coffee.*;
import net.mindview.util.*;

class ClassUsingTypeCounterWithCoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class[] types = { Latte.class, Mocha.class, Cappuccino.class,
			Americano.class, Breve.class, };
	private static Random rand = new Random(47);

	public ClassUsingTypeCounterWithCoffeeGenerator() {
	}

	// For iteration:
	private int size = 0;

	public ClassUsingTypeCounterWithCoffeeGenerator(int sz) {
		size = sz;
	}

	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
			// Report programmer errors at run time:
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class CoffeeIterator implements Iterator<Coffee> {
		/**
		 * can access the outside member
		 */
		int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public Coffee next() {
			count--;
			return ClassUsingTypeCounterWithCoffeeGenerator.this.next();// superclass.this
		}

		public void remove() { // Not implemented
			throw new UnsupportedOperationException();
		}
	}

	;

	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	private static TypeCounter typeCounter = new TypeCounter(Coffee.class);
	public static void main(String[] args) {
		for (Coffee c : new CoffeeGenerator(5)) {
			typeCounter.count(c);
		}
		
		System.out.println(typeCounter);
	}
} /*
 * Output: Americano 0 Latte 1 Americano 2 Mocha 3 Mocha 4 Breve 5 Americano 6
 * Latte 7 Cappuccino 8 Cappuccino 9
 */// :~

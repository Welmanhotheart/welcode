package exercise.arrays;


import java.util.Arrays;

import testcase.net.mindview.util.CountingGenerator;
import testcase.net.mindview.util.ConvertTo;
import testcase.net.mindview.util.Generated;
import testcase.net.mindview.util.Generator;

class SkipGenerator<T> implements Generator<T> {
	private Generator<T> gen;//Adapt design pattern
	private int increment;
	
	public SkipGenerator(Generator<T> gen,int increment) {
		this.gen = gen;
		this.increment = increment;
	}

	@Override
	public T next() {
		if (this.increment == 1) return gen.next();
		for (int i = 0; i < this.increment - 1; i++) {
			gen.next();
		}
		return gen.next();
	}
}


public class Exercise16 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ConvertTo.primitive(Generated.array(Double.class, new SkipGenerator<Double>(new CountingGenerator.Double(), 2), 6))));
	}
}

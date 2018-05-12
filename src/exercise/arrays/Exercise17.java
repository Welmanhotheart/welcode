package exercise.arrays;


import java.math.BigDecimal;
import java.util.Arrays;

import testcase.net.mindview.util.CountingGenerator;
import testcase.net.mindview.util.ConvertTo;
import testcase.net.mindview.util.Generated;
import testcase.net.mindview.util.Generator;

class BigDecimalGenerator implements Generator<BigDecimal> {

	@Override
	public BigDecimal next() {
		return new BigDecimal(12);
	}
}


public class Exercise17 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Generated.array(BigDecimal.class, new BigDecimalGenerator(), 6)));
	}
}

/*
 * Actually,I dont think this exercise is so easy
 */

package exercise.arrays;


import java.util.Arrays;

import testcase.net.mindview.util.CountingGenerator;
import testcase.net.mindview.util.ConvertTo;
import testcase.net.mindview.util.Generated;




public class Exercise12 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ConvertTo.primitive(Generated.array(Double.class, new CountingGenerator.Double(), 6))));
	}
}

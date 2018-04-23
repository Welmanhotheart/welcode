package exercise.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;



public class Exercise23 {
	public static void main(String[] args) {
		Random r = new Random();
		Integer[] arr1 = new Integer[r.nextInt(100)];
		for (int i = 0, len = arr1.length; i < len; i++) {
			arr1[i] = r.nextInt();
		}
		System.out.println("before sorting:" + Arrays.toString(arr1));
		Arrays.sort(arr1, Collections.reverseOrder());
		System.out.println("after sorting:" + Arrays.toString(arr1));
	}
}
/*
 * output:
 * -15, actually amazing, and unpredictable
 */

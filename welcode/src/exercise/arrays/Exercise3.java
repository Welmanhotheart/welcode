package exercise.arrays;

import java.util.Arrays;

public class Exercise3 {
	public static void main(String[] args) {
		print(intitializeDoubleArr(6, 1, 2));
	}

	public static double[][][] intitializeDoubleArr(int size1, int size2,
			int size3) {
		double[][][] arr = new double[size1][size2][size3];
		for (int i = 0, len = arr.length; i < len; i++) {
			double[][] ds = arr[i];
			for (int j = 0, lenj = ds.length; j < lenj; j++) {
				double[] dsj = ds[j];
				for (int k = 0, lenk = dsj.length; k < lenk; k++) {
					dsj[k] = k;
				}
			}
		}
		return arr;
	}

	public static void print(Object[] arr) {
		if (null == arr) {
			System.out.println("null");
		}
		if (arr.length == 0) {
			System.out.println("[]");
		} else {
			System.out.print("[");
			for (int i = 0, len = arr.length; i < len; i++) {
				if (i != 0) {
					System.out.print(",");
				}
				Object element = arr[i];
				if (element == null) {
					System.out.print("null");
				}
				Class eClass = element.getClass();
				if (eClass.isArray()) {
					if (eClass == byte[].class)
						System.out.print(Arrays.toString((byte[]) element));
					else if (eClass == short[].class)
						System.out.print(Arrays.toString((short[]) element));
					else if (eClass == int[].class)
						System.out.print(Arrays.toString((int[]) element));
					else if (eClass == long[].class)
						System.out.print(Arrays.toString((long[]) element));
					else if (eClass == char[].class)
						System.out.print(Arrays.toString((char[]) element));
					else if (eClass == float[].class)
						System.out.print(Arrays.toString((float[]) element));
					else if (eClass == double[].class)
						System.out.print(Arrays.toString((double[]) element));
					else if (eClass == boolean[].class)
						System.out.print(Arrays.toString((boolean[]) element));
					else { // element is an array of object references
						print((Object[]) element);
					}
				}
			}
			System.out.print("]");
		}
	}
}

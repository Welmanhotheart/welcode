package exercise.arrays;

import java.util.Arrays;
import java.util.Random;


class Exer19 {
	private int filed;
	
	public Exer19(int field) {
		this.filed = field;
	}
	public int getField() {
		return this.filed;
	}
	@Override
	public boolean equals(Object obj) {
		if(null != obj && obj instanceof Exer19) {
			return this.filed == ((Exer19) obj).filed;
		}
		return false;
	}
	
}

public class Exercise19 {
	public static void main(String[] args) {
		Random r = new Random();
		Exer19[] arr1 = new Exer19[12];
		for (int i = 0, len = arr1.length; i < len; i++) {
			arr1[i] = new Exer19(r.nextInt(len));
		}
		Exer19[] arr2 = new Exer19[12];
		for (int i = 0, len = arr2.length; i < len; i++) {
			arr2[i] = new Exer19(arr1[i].getField());
		}
		System.out.println(Arrays.equals(arr1, arr2));
		System.out.println(null == null); // null == null
	}
}

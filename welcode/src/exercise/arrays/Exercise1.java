package exercise.arrays;

import exercise.arrays.BerylliumSphere;



class BerylliumSphere {
  private static long counter;
  private final long id = counter++;
  public String toString() { return "Sphere " + id; }
}


public class Exercise1 {
	public static void main(String[] args) {
//		BerylliumSphere[] arr = { new BerylliumSphere(), new BerylliumSphere(),
//			new BerylliumSphere() };
//		f1(arr); compile valid
		
//		passing aggregate initialization failed
//		f1({new BerylliumSphere(), new BerylliumSphere(),
//			new BerylliumSphere()}); compile error:{ new BerylliumSphere(), new BerylliumSphere(),
		                            //new BerylliumSphere() }
		f1(new BerylliumSphere[]{null,null,null,null});
		
//		f3(4,{new BerylliumSphere(), new BerylliumSphere(),
//		                     new BerylliumSphere()},5);compile error:Syntax error on token "{", delete this token
	}
	
	public static void f1(BerylliumSphere arr[]) {
		
	}
	
	public static void f2(BerylliumSphere arr[],Object...args) {
		
	}
	
	public static void f3(int a,BerylliumSphere arr[],Object...args) {
		
	}
}

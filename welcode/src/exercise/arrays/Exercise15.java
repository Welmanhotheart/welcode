package exercise.arrays;

import testcase.net.mindview.util.Generated;
import testcase.net.mindview.util.Generator;
import exercise.arrays.BerylliumSphere;



class BerylliumSphere {
  private static long counter;
  private final long id = counter++;
  public String toString() { return "Sphere " + id; }
}

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
	@Override
	public BerylliumSphere next() {
		// TODO Auto-generated method stub
		return new BerylliumSphere();
	}
}


public class Exercise15 {
	public static void main(String[] args) {
		Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator(), 6);
	}
}

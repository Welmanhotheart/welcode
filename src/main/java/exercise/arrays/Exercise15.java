package exercise.arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;


class BerylliumSphere1 {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
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

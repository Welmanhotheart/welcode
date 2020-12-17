package exercise.generics;


class GenericMethods {
    public <V, T, E> void f(T x, V y, E z) {
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", "", 1f);
        gm.f('c', 1L, 1.0);
        gm.f(1, (byte) 1, gm);
    }
}

public class Exercise9 {
    public static void main(String[] args) {
        GenericMethods.main(null);
    }
}

/**
 * output:
 * java.lang.String
 * java.lang.String
 * java.lang.Float
 * <p>
 * java.lang.Character
 * java.lang.Long
 * java.lang.Double
 * <p>
 * java.lang.Integer
 * java.lang.Byte
 * exercise.generics.GenericMethods
 */

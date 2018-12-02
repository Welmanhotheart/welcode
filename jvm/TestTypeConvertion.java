public class TestTypeConvertion {
    public static void main(String[] args) {
        double a = -0.12344;
        double number = 0.0;
//        System.out.println((int)a);
        double nan = a/number;
        double doubleNumber = -Double.MAX_VALUE/2;
        System.out.println((int)doubleNumber);

        double d1 = 0.000000000000000000000000000000000000000000000000000000000000000001;
        System.out.println((float)d1);
        System.out.println((float)doubleNumber);
        System.out.println((float)nan);
    }
}

/**
 * -Infinity
 */
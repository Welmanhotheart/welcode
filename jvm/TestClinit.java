public class TestClinit {
    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
        System.out.println(getInt(3, 5));
    }

    public static int getInt(int a, int b) {
        return a + b;
    }
}

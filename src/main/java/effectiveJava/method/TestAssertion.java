package effectiveJava.method;

public class TestAssertion {
    public static void main(String[] args) {
               testingMethod(10);
        //testingMethod(-1);
    }
    private static void testingMethod(int age) {
        assert age >= 0;
        assert age >= 20;
    }
}

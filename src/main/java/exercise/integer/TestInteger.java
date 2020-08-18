package exercise.integer;

import org.junit.Test;

import java.util.Properties;

public class TestInteger {
    private static final int RADIX_TEN = 10;
    private static final int RADIX_EIGHT = 8;
    private static final int RADIX_SIXTEEN = 16;


    public static void main(String[] args) {
        Integer integer = Integer.getInteger("435345", RADIX_TEN);
        System.out.println(integer);

        Properties properties = System.getProperties();
        for (Object o : properties.keySet()) {
            System.out.println(o + "=" + properties.get(o));
        }

    }

    @Test
    public void testParseInt() {
        int anInt = Integer.parseInt("23423", RADIX_TEN);
        System.out.println("anInt:" + anInt);
    }
}

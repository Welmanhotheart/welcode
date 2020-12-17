package java8.functionalInterface;

import java.util.function.Function;

public class ArrayReference {
    public static void main(String[] args) {
        Function<Integer, String[]> function = (x) -> new String[x];

        function = String[]::new;
    }
}

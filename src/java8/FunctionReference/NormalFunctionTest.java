package java8.FunctionReference;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class NormalFunctionTest {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        System.out.println(comparator.compare(3, 5));
        Comparator<Integer> comparatorNew = Integer::compare; //static methods
        System.out.println(comparatorNew.compare(5,6));


        Consumer<Integer> consumer = (x)-> System.out.println(x); //instance method.
        consumer.accept(45);
        Consumer<Integer> consumerNew = System.out::println;
        consumerNew.accept(67);


        Supplier<Double> supplier = ()-> 100.0;
        System.out.println(supplier.get());
        Double d = new Double(18.6);
        Supplier<Double> supplierNew = d::doubleValue;
        System.out.println(supplierNew.get());


        Function<Integer, Integer> function = (x)-> Integer.compare(x, 200);
        System.out.println(function.apply(100));

        Function<Integer, Integer> functionNew = Integer::valueOf;
        System.out.println(functionNew.apply(34));


        BiFunction<Integer, Integer, Integer> biFunction = (x, y)-> Integer.compare(x,y);

        System.out.println(biFunction.apply(100, 100));
    }
}

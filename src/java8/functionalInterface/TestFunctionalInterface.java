package java8.functionalInterface;



import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunctionalInterface {

    static class Consumertest  {

         public static void test(){
             changeStr("hello",(str) -> System.out.println(str));
         }

        public static void changeStr(String str, Consumer<String> con){
            con.accept(str);
        }

        public static void main(String[] args) {
          test();
        }
    }


    static class SupplierTest  {

        public static void test(){
            System.out.println(getValue(() -> "hello"));
        }

        public static String getValue( Supplier<String> con){
            return con.get();
        }

        public static void main(String[] args) {
            test();
        }
    }

    static class FunctionTest  {

        public static void test(){
            System.out.println(changeNum(100L,(x) -> x + 200L));
        }

        public static  Long changeNum(Long num, Function<Long, Long> fun){
            return fun.apply(num);
        }

        public static void main(String[] args) {
            test();
        }
    }

    static class PredicateTest  {

        public static void test(){
            System.out.println(changeBoolean("red",(x) -> x.startsWith("R")));
        }

        public static boolean changeBoolean(String str, Predicate<String> pre){
            return pre.test(str);
        }

        public static void main(String[] args) {
            test();
        }
    }

}

/**
 * 记录四种函数式接口
 */
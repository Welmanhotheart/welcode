package java8.lambda;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LambdaTestInnerClass {


    public static void testComparator() {
        Comparator<Integer> cpt = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> set = new TreeSet<Integer>(cpt);

        System.out.println("=========================");

        //使用lambda表达式
        Comparator<Integer> cpt2 = (x, y) -> Integer.compare(x,y);
        TreeSet<Integer> set2 = new TreeSet<Integer>(cpt2);
    }

    public static void test2() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    static interface Substraction {
        int subtractVersion(int a, int b);
        public String toString();
    }

    public static int testSubtract(Substraction substraction, int a, int b) {
        return substraction.subtractVersion(a, b);
    }

    public static String testTostring(Substraction substraction, int a, int b) {
        return substraction.subtractVersion(a, b) + substraction.toString();
    }

    public static void main(String[] args) {
//        int result = testSubtract((a, b)-> a- b, 4, 5);
//        System.out.println(result);


        //这里lambda表达式必须是实现了non-overriding method
        String s = testTostring((a, b) -> a-b, 4, 5);
        System.out.println(s);
    }
}

/**
 *  记录 这里lambda表达式必须是实现了non-overriding method，
 *  方法体里面调用了overriding方法会自行调用祖先基类的方法，
 *  关于输出内容为 java8.lambda.LambdaTestInnerClass$$Lambda$1/1828972342@5fd0d5ae有待探讨
 */

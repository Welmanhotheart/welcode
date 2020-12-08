package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // 1，校验通过Collection 系列集合提供的stream()或者paralleStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2.通过Arrays的静态方法stream()获取数组流
        String[] str = new String[10];
        Stream<String> stream2 = Arrays.stream(str);

        // 3.通过Stream类中的静态方法of
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        // 4.创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0,(x) -> x+2);

        //生成
        Stream.generate(() ->Math.random());
    }
}

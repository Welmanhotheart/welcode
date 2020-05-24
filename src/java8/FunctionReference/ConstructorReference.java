package java8.FunctionReference;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {
    static class Emp {
        private int x;
        Emp() {

        }

        public Emp(int x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return super.toString() + x;
        }
    }
    public static void main(String[] args) {
        Supplier<Emp> supplier = ()->new Emp();
        System.out.println(supplier.get());

        Supplier<Emp> supplierNew = Emp::new;//调用默认构造函数，没有默认构造函数，调用唯一的构造函数，但这个时候也得看参数
        System.out.println(supplier.get());

        Function<Integer, Emp> function = (x)->new Emp(x);
        System.out.println(function.apply(4));

    }
}

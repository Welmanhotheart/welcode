package concurrency;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class TestUnsafe {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(5);
        int i = integer.addAndGet(3);
        System.out.println(integer);
//        Unsafe unsafe = Unsafe.getUnsafe();
//        TestObject object = new TestObject();
//        boolean b = unsafe.compareAndSwapInt(object, 2, 3, 4);
//        System.out.println(b);
    }

//    private static final Unsafe unsafe = Unsafe.getUnsafe();
}

class TestObject{
    private volatile int value;

    public int getValue() {
        return value;
    }
}



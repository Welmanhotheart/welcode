package bytecode;

public class SynchronizedByteCode {
    private static Object lock = new Object();
    public void sayHello() {
        synchronized (lock) {
            System.out.println("hello, SynchronizedByteCode");
        }
    }
}

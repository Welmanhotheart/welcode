package exercise.concurrency;

public class Exercise1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new YieldHintClass());
            t.start();
        }
    }
}


class YieldHintClass implements Runnable{

    public YieldHintClass( ) {
        System.out.println("yieldHintClass。。。，");
    }
    public void run() {
        System.out.println("yieldHintClass run");
        Thread.yield();
        Thread.yield();
        Thread.yield();
        System.out.println("yieldHintClass terminated");
        return;
    }

}
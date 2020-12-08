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
    private static int counter = 0;
    private final int id = counter++;

    public YieldHintClass( ) {
        System.out.println("yieldHintClass。。。，");
    }
    public void run() {
        System.out.println("yieldHintClass " + id + " run");
        Thread.yield();
        Thread.yield();
        Thread.yield();
        System.out.println("yieldHintClass " + id + " terminated");
        return;
    }

}
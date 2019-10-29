package exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
//        service = Executors.newFixedThreadPool(10);
//        service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            service.execute(new YieldHintClassExecutor());
        }
        service.shutdown();
    }
}


class YieldHintClassExecutor implements Runnable{
    private static int count;
    private int mark = count++;
    public YieldHintClassExecutor( ) {
        System.out.println((mark) + " yieldHintClass。。。，");
    }
    public void run() {
        System.out.println((mark) + " yieldHintClass run");
        Thread.yield();
        Thread.yield();
        Thread.yield();
        System.out.println((mark) + " yieldHintClass terminated");
        return;
    }

}
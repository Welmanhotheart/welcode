package exercise.concurrency;

import net.mindview.util.Generator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise4 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        service = Executors.newFixedThreadPool(10);
//        service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            service.execute(new FibonacciTaskExecutor(10,"thread" + (i+1)));
        }
        service.shutdown();
    }
}


class FibonacciTaskExecutor implements Runnable ,Generator<Integer> {
    private final int count;
    private int time;
    private String name;
    public FibonacciTaskExecutor(int n, String name) {
        this.count = n;
        this.name = name;
    }
    public void run() {
        for (int i = 0; i < count; i++)
            System.out.println(this.name +":"+ next() + " ");
    }

    public Integer next() {
        return fib(time++);
    }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

}
package exercise.concurrency;

import net.mindview.util.Generator;

public class Exercise2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new FibonacciTask(10,"thread" + (i+1))).start();
        }
        Thread.sleep(10000);
    }
}



class FibonacciTask implements Runnable ,Generator<Integer> {
    private final int count;
    private int time;
    private String name;
    public FibonacciTask(int n, String name) {
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
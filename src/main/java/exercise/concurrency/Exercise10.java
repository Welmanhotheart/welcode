package exercise.concurrency;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;

public class Exercise10 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        Exercise10 ex = new Exercise10();
        ArrayList<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 10; i++) {
            list.add(ex.runTask((i+1), "thread" + (i+1),service));
        }
        for(Future<Integer> e: list) {
            if (e.isDone()) {
                System.out.println(e.get());
            }
        }
        service.shutdown();
    }


    private Future<Integer> runTask(int number,String name, ExecutorService service) {
        return service.submit(new FibonacciTaskCallable(number,name));
    }
}




class FibonacciTaskCallable10 implements Callable<Integer>,Generator<Integer> {
    private final int count;
    private int time;
    private String name;
    public FibonacciTaskCallable10(int n, String name) {
        this.count = n;
        this.name = name;
    }

    public Integer next() {
        return fib(time++);
    }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    //获取所有的和
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0;i < count; i++) {
            sum += next();
        }
        return sum;
    }
}
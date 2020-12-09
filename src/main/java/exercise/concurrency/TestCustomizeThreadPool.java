package exercise.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCustomizeThreadPool {
    public static void main(String[] args) {
        f1();
        f2();
        f3();
        f4();
    }


    public static void f1() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i ++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                }
            });
        }
        poolExecutor.shutdown();
    }

    public static void f2() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i ++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                }
            });
        }
        poolExecutor.shutdown();
    }
    public static void f3() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 10; i ++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                }
            });
        }
        poolExecutor.shutdown();
    }

    public static void f4() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i ++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                }
            });
        }
        poolExecutor.shutdown();
    }
}

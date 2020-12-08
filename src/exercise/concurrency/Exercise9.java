package exercise.concurrency;

import concurrency.SimplePriorities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Exercise9 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(CustomPriorityThreadFactory.getInstance());
        for (int i = 0; i < 5; i++)
            exec.execute(
                    new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(
                new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}

class CustomPriorityThreadFactory  implements ThreadFactory {
    private static volatile ThreadFactory instance;
    private int priority = Thread.MIN_PRIORITY;
    private CustomPriorityThreadFactory() {

    }
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(this.priority);
        return t;
    }

    public static final ThreadFactory getInstance() {
        if (instance == null) {
            synchronized (CustomPriorityThreadFactory.class) {
                if (instance == null) {
                    instance = new CustomPriorityThreadFactory();
                }
            }
        }
        return instance;
    }

}

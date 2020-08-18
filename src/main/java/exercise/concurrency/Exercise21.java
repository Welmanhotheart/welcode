package exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise21 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor =  Executors.newCachedThreadPool();
        AssistRunnable21 t1 = new AssistRunnable21();
        AssistRunnable211 t2 = new AssistRunnable211(t1);
        executor.execute(t1);
        executor.execute(t2);
        TimeUnit.SECONDS.sleep(6);
        executor.shutdownNow();
    }
}


class AssistRunnable21 implements Runnable {

    public void run() {
        try {
            waitFor();
            System.out.println("pass wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  void waitFor() throws InterruptedException {
        wait();
    }

    public synchronized  void notifyFor() throws InterruptedException {
        notifyAll();
    }
}


class AssistRunnable211 implements Runnable {
    private AssistRunnable21 runnable;

    public AssistRunnable211(AssistRunnable21 runnable) {
        this.runnable = runnable;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            runnable.notifyFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package exercise.concurrency;

import java.util.concurrent.TimeUnit;

public class Exercise18 {
    public static void main(String[] args) {
        Thread thread = new Thread(new TaskEx_18());
        thread.start();
        thread.interrupt();
    }
}

class NotTask_18 {
    public void method_f() {
        try {
            TimeUnit.SECONDS.sleep(10);
            while(true) {
                Thread.yield();
                System.out.println("Thread.yield()");
            }
        } catch (/*Interrupted*/Exception e) {
            System.out.println("be interrupted");
        }
    }
}

class TaskEx_18 implements Runnable {

    public void run() {
        new NotTask_18().method_f();
    }
}

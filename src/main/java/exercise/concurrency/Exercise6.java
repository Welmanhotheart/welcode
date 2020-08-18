package exercise.concurrency;

import concurrency.LiftOff;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise6 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            exec.execute(new SleepingTaskT());
        }
        exec.shutdown();
    }
}


class SleepingTaskT extends LiftOff {
    public void run() {
        Random r = new Random();
        try {
            int num = r.nextInt(10);
            System.out.println("即将沉睡" + num + "秒");

            TimeUnit.SECONDS.sleep(num);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

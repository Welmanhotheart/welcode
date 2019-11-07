package exercise.concurrency;

import concurrency.LiftOff;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise20 {
    public static void main(String[] args) {
        ArrayList<Thread> ths = new ArrayList<Thread>(6);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.start();
            ths.add(t);
        }
        for (Thread th : ths) {
            th.interrupt();
        }
    }
}

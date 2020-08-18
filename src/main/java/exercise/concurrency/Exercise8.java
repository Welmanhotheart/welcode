package exercise.concurrency;

import concurrency.LiftOff;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("Waiting for LiftOff");
        Scanner s = new Scanner(System.in);
        s.next();
    }
}

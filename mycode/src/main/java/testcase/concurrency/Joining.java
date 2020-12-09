package testcase.concurrency;

//: concurrency/Joining.java
// Understanding join().

import static testcase.net.mindview.util.Print.*;

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            for (int i = 0; i < 100000; i++) {
                double d = 3.145926 * 3.1415926;
                System.out.println(this.getName() + "sleep is excuting");
            }
            System.out.println("thread" + this.getName() + "is over");
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName() + " was interrupted. " +
                    "isInterrupted(): " + isInterrupted());
            return;
        }
        print(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + " join completed");
    }
}

public class Joining {
    public static void main(String[] args) throws InterruptedException {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        sleepy.join();
        System.out.println("sleepy.join has been called");
        grumpy.join();
        System.out.println("grumpy.join has been called");
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
//    grumpy.interrupt();
        System.out.println("main over");
    }
} /* Output:
Grumpy was interrupted. isInterrupted(): false
Doc join completed
Sleepy has awakened
Dopey join completed
*///:~
/**
 * join means wait for the execution to be finished, and then execute the code after the
 * join();
 * it can still insure concurrency
 */

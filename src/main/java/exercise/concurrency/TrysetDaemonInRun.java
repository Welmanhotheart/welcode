package exercise.concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class TrysetDaemonInRun {
}

class SimpleDaemonsR extends Thread {
    public void run() {
        this.setDaemon(true);
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new SimpleDaemonsR();
            // Must call before start()
            daemon.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
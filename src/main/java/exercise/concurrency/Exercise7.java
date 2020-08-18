package exercise.concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.*;

public class Exercise7 {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new DaemonEx7());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        // Allow the daemon threads to
        // finish their startup processes:
        TimeUnit.SECONDS.sleep(2);
    }
}



class DaemonEx7 implements Runnable {
    private Thread[] t = new Thread[10];

    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawnEx7());
            t[i].start();
            print("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < t.length; i++)
            print("t[" + i + "].isDaemon() = " +
                    t[i].isDaemon() + ", ");
        while (true)
            Thread.yield();
    }
}

class DaemonSpawnEx7 implements Runnable {
    public void run() {
        while (true)
            Thread.yield();
    }
}
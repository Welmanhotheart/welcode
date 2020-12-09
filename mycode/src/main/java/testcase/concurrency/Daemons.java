package testcase.concurrency;

//: concurrency/Daemons.java
// Daemon threads spawn other daemon threads.

import java.util.concurrent.*;

import static testcase.net.mindview.util.Print.*;

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    /*
     * daemons created by daemons are always daemon,
     * I modify this segment of code by moving "t[i].start"
     * into the second 'for-loop' behind 'printnb(..)' to eliminated
     * the presume-preempted effect of 't[i].start()',which I guess is the
     * reason that  DaemonSpawn created in Daemon is 'daemon'
     * above all it's conclude that 'daemons created by daemons are always daemon'
     */
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
//      t[i].start();
            printnb("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < t.length; i++) {
            printnb("t[" + i + "].isDaemon() = " +
                    t[i].isDaemon() + ", ");
            t[i].start();
        }
        while (true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable {
    public void run() {
        while (true)
            Thread.yield();
    }
}

public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        // Allow the daemon threads to
        // finish their startup processes:
        TimeUnit.SECONDS.sleep(1);
    }
} /* Output: (Sample)
d.isDaemon() = true, DaemonSpawn 0 started, DaemonSpawn 1 started, DaemonSpawn 2 started, DaemonSpawn 3 started, DaemonSpawn 4 started, DaemonSpawn 5 started, DaemonSpawn 6 started, DaemonSpawn 7 started, DaemonSpawn 8 started, DaemonSpawn 9 started, t[0].isDaemon() = true, t[1].isDaemon() = true, t[2].isDaemon() = true, t[3].isDaemon() = true, t[4].isDaemon() = true, t[5].isDaemon() = true, t[6].isDaemon() = true, t[7].isDaemon() = true, t[8].isDaemon() = true, t[9].isDaemon() = true,
*///:~

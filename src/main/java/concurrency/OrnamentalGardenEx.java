package concurrency;//: concurrency/OrnamentalGarden.java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;


class EntranceCountLatch implements Runnable {
    private static Count count = new Count();
    private static List<EntranceCountLatch> entrances =
            new ArrayList<EntranceCountLatch>();
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;
    private static volatile boolean canceled = false;

    private CountDownLatch latch;
    // Atomic operation on a volatile field:
    public static void cancel() {
        canceled = true;
    }

    public EntranceCountLatch(int id, CountDownLatch latch) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        entrances.add(this);
        this.latch = latch;
    }

    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                print("sleep interrupted");
//                return;
            }
        }
        latch.countDown();
        print("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (EntranceCountLatch entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}

public class OrnamentalGardenEx {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new EntranceCountLatch(i,latch));
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(3);
        EntranceCountLatch.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            print("Some tasks were not terminated!");

        latch.await();
        print("Total: " + EntranceCountLatch.getTotalCount());

        print("Sum of Entrances: " + EntranceCountLatch.sumEntrances());
    }

} /* Output: (Sample)
Entrance 0: 1 Total: 1
Entrance 2: 1 Total: 3
Entrance 1: 1 Total: 2
Entrance 4: 1 Total: 5
Entrance 3: 1 Total: 4
Entrance 2: 2 Total: 6
Entrance 4: 2 Total: 7
Entrance 0: 2 Total: 8
...
Entrance 3: 29 Total: 143
Entrance 0: 29 Total: 144
Entrance 4: 29 Total: 145
Entrance 2: 30 Total: 147
Entrance 1: 30 Total: 146
Entrance 0: 30 Total: 149
Entrance 3: 30 Total: 148
Entrance 4: 30 Total: 150
Stopping Entrance 2: 30
Stopping Entrance 1: 30
Stopping Entrance 0: 30
Stopping Entrance 3: 30
Stopping Entrance 4: 30
Total: 150
Sum of Entrances: 150
*///:~

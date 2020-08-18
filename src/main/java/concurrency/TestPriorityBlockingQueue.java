package concurrency;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.*;

public class TestPriorityBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Runnable> queue =
                new PriorityBlockingQueue<Runnable>();
        Random rand = new Random(47);
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
        }

        print("normally traverse");
        for (Runnable runnable : queue) {
            System.out.println(runnable);
        }

        print("blocking traverse");
        while(!queue.isEmpty()) {
            Runnable take = queue.take();
            System.out.println(take);
        }


    }
}

class PrioritizedTaskSPL implements
        Runnable, Comparable<PrioritizedTaskSPL> {
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTaskSPL> sequence =
            new ArrayList<PrioritizedTaskSPL>();

    public PrioritizedTaskSPL(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    public int compareTo(PrioritizedTaskSPL arg) {
        return priority < arg.priority ? 1 :
                (priority > arg.priority ? -1 : 0);
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        print(this);
    }

    public String toString() {
        return String.format("[%1$-3d]", priority) +
                " Task " + id;
    }


}

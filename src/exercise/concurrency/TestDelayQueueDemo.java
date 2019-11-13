package exercise.concurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;


class DelayTaskL implements Runnable, Delayed {

    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayTaskL> sequence =
            new ArrayList<DelayTaskL>();

    public DelayTaskL(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() +
                NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    public long getDelay(TimeUnit unit) {
        long delay =  unit.convert(
                trigger - System.nanoTime(), NANOSECONDS);
//        System.out.println(" " + this + "delay:" + delay);
        return delay;
    }

    public int compareTo(Delayed arg) {
        DelayTaskL that = (DelayTaskL) arg;
        if (trigger < that.trigger) return -1;
        if (trigger > that.trigger) return 1;
        return 0;
    }


    public String toString() {
        return String.format("[%1$-4d]", delta) +
                " Task " + id;
    }

    @Override
    public void run() {

    }
}

public class TestDelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random(47);
        DelayQueue<DelayTaskL> queue =
                new DelayQueue<DelayTaskL>();
        for (int i = 20; i > 0; i--) {
            queue.put(new DelayTaskL(i*1000));
        }

        // normally traverse the queue,to see the order of each element

//        Iterator<DelayTaskL> iterator = queue.iterator();
//        while (iterator.hasNext()) {
//            DelayTaskL next = iterator.next();
//            System.out.println(next);
//        }
//        for (DelayTaskL delayTaskL : queue) {
//            System.out.println(delayTaskL);
//        }

        //get an element out by calling take() method, but it has to block unit the delay of the element becomes zero
        long start = System.currentTimeMillis();
        while(!queue.isEmpty()) {
            DelayTaskL take = queue.take();
            System.out.println(take + ";耗时：" + (System.currentTimeMillis() - start));
        }
    }
}

//output, shown as following:
/**
 * [1000] Task 19;耗时：1031
 [2000] Task 18;耗时：2007
 [3000] Task 17;耗时：3003
 [4000] Task 16;耗时：4004
 [5000] Task 15;耗时：5007
 [6000] Task 14;耗时：6007
 [7000] Task 13;耗时：7009
 [8000] Task 12;耗时：8011
 [9000] Task 11;耗时：9009
 */

class TestTimeUnitFuncSeries {
    public static void main(String[] args) {
        // conversion between different Time Unit
        for (int i = 20; i > 0; i--) {
            int delta = 1000*i;
            long nanoTime = System.nanoTime();
            long convert = NANOSECONDS.convert(delta, MILLISECONDS);
            System.out.println("System.nanoTime:" + nanoTime + ";convert:" + convert);
            long trigger = nanoTime +
                    convert;
        }
    }
}
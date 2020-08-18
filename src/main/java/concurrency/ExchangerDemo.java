package concurrency;//: concurrency/ExchangerDemo.java

import java.util.concurrent.*;
import java.util.*;

import net.mindview.util.*;

import static net.mindview.util.Print.print;

class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchg,
                      Generator<T> gen, List<T> holder) {
        exchanger = exchg;
        generator = gen;
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++)
                    holder.add(generator.next());
                // Exchange full for empty:
                print("waiting for exchange");
                holder = exchanger.exchange(holder, 1, TimeUnit.SECONDS);
                print("finished exchanging");
                System.out.println("in ExchangerProducer:" + holder);
            }
        } catch (InterruptedException e) {
            // OK to terminate this way.
        } catch (TimeoutException e) {
//            e.printStackTrace();
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
        exchanger = ex;
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                System.out.println("in ExchangerConsumer:" + holder);
                for (T x : holder) {
                    value = x; // Fetch out value
                    holder.remove(x); // OK for CopyOnWriteArrayList
                }
            }
        } catch (InterruptedException e) {
            // OK to terminate this way.
        }
        System.out.println("Final value: " + value);
    }
}

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5; // Seconds

    public static void main(String[] args) throws Exception {
        if (args.length > 0)
            size = new Integer(args[0]);
        if (args.length > 1)
            delay = new Integer(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        List<Fat>
                producerList = new MyCopyOnWriteArrayList<Fat>(),
                consumerList = new MyCopyOnWriteArrayList<Fat>();
        System.out.println("producerList,in main:" + producerList);
        System.out.println("consumerList,in main:" + consumerList);
        print();
        print();
        exec.execute(new ExchangerProducer<Fat>(xc,
                BasicGenerator.create(Fat.class), producerList));
        exec.execute(
                new ExchangerConsumer<Fat>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}


class MyCopyOnWriteArrayList<E> extends CopyOnWriteArrayList<E> {
    private String hashCode;
    public MyCopyOnWriteArrayList() {
        super();
        this.hashCode = RandomCharacterGenerizor.generize(12);
    }

    @Override
    public String toString() {
        return hashCode;
    }

}

//class MyExchanger extends Exchanger {
//    private int sleepTime;
//    private MyExchanger(int sleepTime) {
//        this.sleepTime = sleepTime;
//    }
//
//    @Override
//    public Object exchange(Object x, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
//        return super.exchange(x, timeout, unit);
//    }
//}

class RandomCharacterGenerizor {
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String generize(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
        }
        return sb.toString();
    }
}

/* Output: (Sample)
Final value: Fat id: 29999
*///:~

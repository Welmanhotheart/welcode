package exercise.concurrency;

import concurrency.Chopstick;
import concurrency.Philosopher;

import java.util.concurrent.*;

import static net.mindview.util.Print.print;

public class Exercise31 {
    public static void main(String[] args) {

        try {
            DeadlockingDiningPhilosophers.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);
        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        BlockingQueue<Chopstick> bin = new LinkedBlockingQueue<Chopstick>();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();
        for (int i = 0; i < size; i++)
            exec.execute(new PhilosopherEx31(i, ponder, bin));
        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}


class PhilosopherEx31 extends Philosopher{
    private BlockingQueue<Chopstick> bin;
    public PhilosopherEx31(int ident, int ponder,BlockingQueue<Chopstick> bin) {
        super(null, null, ident,ponder);
        this.bin = bin;
    }


    public void run() {
        try {
            while (!Thread.interrupted()) {
                print(this + " " + "thinking");
                pause();
                // Philosopher becomes hungry
                print(this + " " + "grabbing right");
                Chopstick right = bin.take();

                print(this + " " + "grabbing left");
                Chopstick left = bin.take();
                print(this + " " + "eating");
                pause();
                bin.put(right);
                bin.put(left);
            }
        } catch (InterruptedException e) {
            print(this + " " + "exiting via interrupt");
        }
    }

}
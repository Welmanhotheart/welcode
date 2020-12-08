package exercise.concurrency;

import static net.mindview.util.Print.*;

import java.util.concurrent.SynchronousQueue;


class PutTaskL implements Runnable {
    private SynchronousQueue<String> queue;

    public PutTaskL(SynchronousQueue<String> queue) {
        this.queue = queue;
    }



    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                print("put into " + i);
                queue.put(String.valueOf(i));
                print("finished putting into " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class TakeTaskL implements Runnable {
    private SynchronousQueue<String> queue;

    public TakeTaskL(SynchronousQueue<String> queue) {
        this.queue = queue;
    }



    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                String take = queue.take();
                print("fetched " + take);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class TestSynchronousQueue {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<String>();
        Thread t = new Thread(new PutTaskL(queue));
        Thread t1 = new Thread(new TakeTaskL(queue));
//        t.start();
        t1.start();
    }
}

package exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SelfSpinLock {
    private AtomicReference<Thread> reference = new AtomicReference<Thread>(null);

    public void lock() {
        Thread t = Thread.currentThread();
        do {

        } while (!reference.compareAndSet(null, t));
    }

    public void unLock() {
        Thread t = Thread.currentThread();
        reference.compareAndSet(t, null);
    }

    public static void main(String[] args) {
        final SelfSpinLock lock = new SelfSpinLock();

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + "\t办理业务");
                        for(int i = 0; i < 10; i++) {
                            System.out.println(Thread.currentThread().getName() + "\t办理业务" + i);
                            TimeUnit.MILLISECONDS.sleep(100L);
                        }
                        TimeUnit.MILLISECONDS.sleep(100L);
                        System.out.println("====================" + Thread.currentThread().getName() + "\t办理业务结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unLock();
                    }
                }
            });
        }

        threadPool.shutdown();

    }
}

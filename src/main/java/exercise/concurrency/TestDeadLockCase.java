package exercise.concurrency;

public class TestDeadLockCase {
    public static void main(String[] args) {
        String lock1 = "abc";
        String lock2 = "cde";
        Thread t1 = new Thread(new LockGrabber(lock1, lock2));
        Thread t2 = new Thread(new LockGrabber(lock2, lock1));
        t1.start();
        t2.start();
    }
}

class LockGrabber implements Runnable {

    private String lockA;
    private String lockB;
    public LockGrabber(String selfLock, String otherLock) {
        this.lockA = selfLock;
        this.lockB = otherLock;
    }
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+ "获得锁" + lockA);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+ "获得锁" + lockB);
            }
        }
    }
}


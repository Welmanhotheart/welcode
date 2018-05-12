package testcase.concurrency;

//: concurrency/Interrupting2.java
// Interrupting a task blocked with a ReentrantLock.
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import static testcase.net.mindview.util.Print.*;

class BlockedMutex {
  private Lock lock = new ReentrantLock();
  public BlockedMutex() {
    // Acquire it right away, to demonstrate interruption
    // of a task blocked on a ReentrantLock:
    lock.lock();
  }
  public void f() {
    try {
      /*
       *  This will never be available to a second task
       *  try to acquire the lock, if the lock has already been
       *  acquired, then the it will stop here in run method
       *  but when t.interrupt() is issued in the main thread
       *  then it will be break out and throw an interruptedException
       *  (once catch block be added, then the code can be executed formally)
       */
  
      lock.lockInterruptibly(); // Special call
      print("lock acquired in f()");
    } catch(InterruptedException e) {
      print("Interrupted from lock acquisition in f()");
    }
  }
}

class Blocked2 implements Runnable {
  BlockedMutex blocked = new BlockedMutex();
  public void run() {
    print("Waiting for f() in BlockedMutex");
    blocked.f();
    print("Broken out of blocked call");
  }
}

public class Interrupting2 {
  public static void main(String[] args) throws Exception {
    Thread t = new Thread(new Blocked2());
    t.start();
    TimeUnit.SECONDS.sleep(1);
    System.out.println("Issuing t.interrupt()");
    t.interrupt();
  }
} /* Output:
Waiting for f() in BlockedMutex
Issuing t.interrupt()
Interrupted from lock acquisition in f()
Broken out of blocked call
*///:~

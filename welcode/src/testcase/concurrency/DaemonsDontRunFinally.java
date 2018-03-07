package testcase.concurrency;

//: concurrency/DaemonsDontRunFinally.java
// Daemon threads don't run the finally clause
import java.util.concurrent.*;
import static testcase.net.mindview.util.Print.*;

class ADaemon implements Runnable {
  public void run() {
    try {
      print("Starting ADaemon");
      TimeUnit.SECONDS.sleep(10);
    } catch(InterruptedException e) {
      print("Exiting via InterruptedException");
    } finally {
      print("This should always run?");
    }
  }
}

public class DaemonsDontRunFinally {
  public static void main(String[] args) throws Exception {
    Thread t = new Thread(new ADaemon());
    t.setDaemon(true);
    t.start();
    TimeUnit.SECONDS.sleep(1);
  }
} /* Output:
Starting ADaemon
*///:~

/**
 * in main threads that's not daemon,I add a line 'TimeUnit.SECONDS.sleep(1);'
 * to make some time for the execution of the 'ADaemon',but in the ADaemon.run
 * I set its sleeping time longer than the main thread, when the main thread is
 * finished, the ADaemon is still sleeping, then I didn't saw 'This should always run?'
 * was printed in the console
 *  above all ,I conclude that daemon has no necessity to run 'finally code block'
 */

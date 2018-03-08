package testcase.concurrency;

//: concurrency/SynchronizedEvenGenerator.java
// Simplifying mutexes with the synchronized keyword.
// {RunByHand}

public class
SynchronizedEvenGenerator extends IntGenerator {
  private int currentEvenValue = 0;
  public synchronized int next() {
    ++currentEvenValue;
    /**
     *  yeah it really can't cause failure here, 
     *  calling Thread.yield() can promote context switch, but the current
     *  task is still holding the lock so other task can't enter the 
     *  'next' code block of scheduling mechanism, so its much more likely that
     *  currentEvenValue can be at odd status
     */
    Thread.yield(); // Cause failure faster
    ++currentEvenValue;
    return currentEvenValue;
  }
  public static void main(String[] args) {
    EvenChecker.test(new SynchronizedEvenGenerator());
  }
} ///:~


package testcase.concurrency;

//: concurrency/LiftOff.java
// Demonstration of the Runnable interface.

public class LiftOff implements Runnable {
  protected int countDown = 10; // Default
  private static int taskCount = 0;
  private final int id = taskCount++;
  public LiftOff() {}
  public LiftOff(int countDown) {
    this.countDown = countDown;
  }
  public String status() {
    return "#" + id + "(" +
      (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }
  public void run() {
  	/**
  	 * when I add this segment of code in which float number calculation is on,
  	 * then I saw the effect of 'ExecutorService # shutdownNow()'
  	 */
//  	for (int i = 0; i < 10000; i++) {
//  		System.out.println(3.1415926789 * 0.12345);
//  	}
    while(countDown-- > 0) {
      System.out.print(status());
      Thread.yield();
    }
  }
} ///:~

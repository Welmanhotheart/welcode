package testcase.concurrency;

//: concurrency/EvenGenerator.java
// When threads collide.

public class EvenGenerator extends IntGenerator {
  private int currentEvenValue = 0;
  public int next() {
    ++currentEvenValue; // Danger point here!
 /**
  *  yeah it really can cause failure here, 
  *  calling Thread.yield() can promote context switch
  *  of scheduling mechanism, so its much more likely that
  *  currentEvenValue can be at odd status
  */
    Thread.yield();
    ++currentEvenValue;
    return currentEvenValue;
  }
  public static void main(String[] args) {
    EvenChecker.test(new EvenGenerator());
  }
} /* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~

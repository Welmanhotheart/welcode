package testcase.concurrency;

//: concurrency/Joining.java
// Understanding join().
import static testcase.net.mindview.util.Print.*;


class FJoiner extends Thread {
  public FJoiner(String name, Sleeper sleeper) {
    super(name);
  }
  public void run() {
  	for (int i = 0; i < 100; i++) {
			 
		 }
  }
}

class SubJoiner extends Thread {
	 public void run() {
		 
	 }
}

public class JoiningTest {
  public static void main(String[] args) throws InterruptedException {
    Sleeper
      sleepy = new Sleeper("Sleepy", 1500),
      grumpy = new Sleeper("Grumpy", 1500);
    sleepy.join();
    grumpy.join();
    Joiner
      dopey = new Joiner("Dopey", sleepy),
      doc = new Joiner("Doc", grumpy);
//    grumpy.interrupt();
    	System.out.println("main over");
  }
} /* Output:
Grumpy was interrupted. isInterrupted(): false
Doc join completed
Sleepy has awakened
Dopey join completed
*///:~
/**
 * join means wait for the execution to be finished, and then execute the code after the
 * join();
 * it can still insure concurrency
 */

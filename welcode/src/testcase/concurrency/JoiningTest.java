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
			Thread r = new SubJoiner("thread" + i);
			r.start();
			try {
				r.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  }
}

class SubJoiner extends Thread {
	public  SubJoiner(String name) {
		super(name);
	}
	 public void run() {
		 for (int i = 0; i< 1000; i++) {
			 double d = 3.133131* 3.1234* 3.12233 * 3.2324234324232;
			 System.out.println("I am thread" + this.getName());
		 }
		 System.out.println("I am over");
 	 }
}

public class JoiningTest {
  public static void main(String[] args) throws InterruptedException {
  	FJoiner f = new FJoiner("sdfa", null);
  	f.start();
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

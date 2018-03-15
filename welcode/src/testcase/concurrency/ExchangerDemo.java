package testcase.concurrency;

//: concurrency/ExchangerDemo.java
import java.util.concurrent.*;
import java.util.*;

import testcase.net.mindview.util.*;

class ExchangerProducer<T> implements Runnable {
  private Generator<T> generator;
  private Exchanger<List<T>> exchanger;
  private List<T> holder;
  ExchangerProducer(Exchanger<List<T>> exchg,
  Generator<T> gen, List<T> holder) {
    exchanger = exchg;
    generator = gen;
    this.holder = holder;
    System.out.println("ExchangerProducer " + this.holder);

  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        for(int i = 0; i < ExchangerDemo.size; i++)
        	System.out.println("before exchange ExchangerProducer" + " for " + holder);
        	holder.add(generator.next());
        // Exchange full for empty:
        holder = exchanger.exchange(holder);
      }
    } catch(InterruptedException e) {
      // OK to terminate this way.
    }
  }
}

class ExchangerConsumer<T> implements Runnable {
  private Exchanger<List<T>> exchanger;
  private List<T> holder;
  private volatile T value;
  ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder){
    exchanger = ex;
    this.holder = holder;
    System.out.println("ExchangerConsumer " + this.holder);
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        holder = exchanger.exchange(holder);
        for(T x : holder) {
        	System.out.println("ExchangerConsumer" + " for " + holder);
          value = x; // Fetch out value
          holder.remove(x); // OK for CopyOnWriteArrayList
        }
      }
    } catch(InterruptedException e) {
      // OK to terminate this way.
    }
    System.out.println("Final value: " + value);
  }
}
class CopyOnWriteArrayListsub<T> extends  CopyOnWriteArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getName() + "@" + Integer.toHexString(hashCode());
	}
	
}
/**
 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
 * @author Administrator
 *
 */
public class ExchangerDemo {
  static int size = 5;
  static int delay = 100; // Seconds
  public static void main(String[] args) throws Exception {
    if(args.length > 0)
      size = new Integer(args[0]);
    if(args.length > 1)
      delay = new Integer(args[1]);
    ExecutorService exec = Executors.newCachedThreadPool();
    //'xc' is shared by ExchangerProducer and ExchangerConsumer
    Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
    List<Fat>
      producerList = new CopyOnWriteArrayListsub<Fat>(),
      consumerList = new CopyOnWriteArrayListsub<Fat>();
    exec.execute(new ExchangerProducer<Fat>(xc,
      BasicGenerator.create(Fat.class), producerList));
    exec.execute(
      new ExchangerConsumer<Fat>(xc,consumerList));
    TimeUnit.MILLISECONDS.sleep(delay);
    exec.shutdownNow();
  }
} /* Output: (Sample)
Final value: Fat id: 29999
*///:~
/**
 * exchanger it means the exchange happens between two tasks , 
 * if just one call "exchanger.exchange()" it will wait util 
 * the other calls "exchanger.exchange()"
 */

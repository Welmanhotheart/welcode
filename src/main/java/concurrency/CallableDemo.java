package concurrency;//: concurrency/CallableDemo.java

import java.util.concurrent.*;
import java.util.*;

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws InterruptedException {
        Thread.sleep(2000);
//        if (id % 2 == 0) {
//            int count = 0;
//            while(count < 1000000000) {
//                double result = 3.00004* Math.PI * 2.1234242352345234 * 3.2542353453456345;
//                result = 3.00004* Math.PI * 2.1234242352345234 * 3.2542353453456345*2;
//                count++;
//            }
//        }
        return  "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results)
            try {
                // get() blocks until completion:
//                if (fs.isDone()) {
                    System.out.println(fs.get(200,TimeUnit.MILLISECONDS));
//                }
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
    }
} /* Output:
result of TaskWithResult 0
result of TaskWithResult 1
result of TaskWithResult 2
result of TaskWithResult 3
result of TaskWithResult 4
result of TaskWithResult 5
result of TaskWithResult 6
result of TaskWithResult 7
result of TaskWithResult 8
result of TaskWithResult 9
*///:~

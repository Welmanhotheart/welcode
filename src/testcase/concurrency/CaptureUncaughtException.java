package testcase.concurrency;

//: concurrency/CaptureUncaughtException.java

import java.util.concurrent.*;

class ExceptionThreadSub2 implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("ExceptionThreadSub2");
    }

}

class ExceptionThread2 implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
//    new Thread(new ExceptionThreadSub2()).start();
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements
        Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught ");
        e.printStackTrace();
    }
}

class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
                /*new HandlerThreadFactory()*/);
        exec.execute(new ExceptionThread2());

    }
} /* Output: (90% match)
HandlerThreadFactory@de6ced creating new Thread
created Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
run() by Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
caught java.lang.RuntimeException
*///:~

/**
 * I dont know what does parent mean, the thread that create this task?
 * public void uncaughtException(Thread t, Throwable e) {
 * if (parent != null) {
 * parent.uncaughtException(t, e);
 * } else {
 * Thread.UncaughtExceptionHandler ueh =
 * Thread.getDefaultUncaughtExceptionHandler();
 * if (ueh != null) {
 * ueh.uncaughtException(t, e);
 * } else if (!(e instanceof ThreadDeath)) {
 * System.err.print("Exception in thread \""
 * + t.getName() + "\" ");
 * e.printStackTrace(System.err);
 * }
 * }
 * }
 */

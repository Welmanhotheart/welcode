package exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise22 {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        AssistantFlag22 flag = new AssistantFlag22();

        ex.execute(new Assistant22(flag));
        ex.execute(new Assistant221(flag));

        ex.shutdown();
    }
}


class AssistantFlag22 {
    private boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public synchronized boolean isFlag() {
        return flag;
    }

    public synchronized  void  waitFlag() throws InterruptedException {
        wait();
    }

    public synchronized  void  notifys() throws InterruptedException {
      notifyAll();
    }
}

class Assistant22 implements Runnable{
    private AssistantFlag22 flag;
    public Assistant22(AssistantFlag22 flag) {
        this.flag = flag;
    }
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(6);
            flag.setFlag(true);
            flag.notifys();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Assistant221 implements Runnable {
    private AssistantFlag22 flag;

    public Assistant221(AssistantFlag22 flag) {
        this.flag = flag;
    }
    public void run() {
        if (!flag.isFlag()) {
            try {
                flag.waitFlag();
                if (flag.isFlag()) {
                    flag.setFlag(false);
                    System.out.println("sets flag from true to false");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
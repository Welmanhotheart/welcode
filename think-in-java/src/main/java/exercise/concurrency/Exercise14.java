package exercise.concurrency;

import java.util.Timer;
import java.util.TimerTask;

public class Exercise14 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Timer().schedule(new TimerTaskExt(),
                    5000); // Terminate after 5 seconds，时间的交集，都是5秒之后
        }
    }
}


class TimerTaskExt extends  TimerTask {
    private static int count;
    private int mark = count++;

    public void run() {
        System.err.println("thread " + mark + " Aborting");
    }
}



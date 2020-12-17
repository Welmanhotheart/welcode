package com.wei.java.concurrency;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2020-11-2020/11/20-上午9:49
 */
public class SchedulerExecutorTest {
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) throws IOException {
        SchedulerExecutorTest executorTest = new SchedulerExecutorTest();
        executorTest.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

                                                         public void run() {
                                                             System.out.println("saljdfs");
                                                         }
                                                     },
                3, 3, TimeUnit.SECONDS);
        System.in.read();
    }
}
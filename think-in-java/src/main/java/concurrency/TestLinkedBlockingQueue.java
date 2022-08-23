package concurrency;

import java.util.concurrent.*;

public class TestLinkedBlockingQueue {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(50);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() / 3);
        ForkJoinTask<Integer> producer = forkJoinPool.submit(new TestLinkedBlockingQueueTaskProducer(queue));
//        ForkJoinTask<Integer> consumer = forkJoinPool.submit(new TestLinkedBlockingQueueTaskConsumer(queue));
        producer.get();
//        consumer.get();
        forkJoinPool.shutdown();
    }

}


class TestLinkedBlockingQueueTaskProducer extends RecursiveTask<Integer> {
    private LinkedBlockingQueue<Integer> queue;

    public TestLinkedBlockingQueueTaskProducer(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    protected Integer compute() {
        while (!Thread.interrupted()) {
            Integer take = null;
            try {
                for (int i = 0; i < 100; i++) {
                     queue.put(i);
                    System.out.println("add: " + (i+1));
                }
            } catch (InterruptedException e) {


            }
            System.out.println("take:" + take);
        }
        try {
            queue.put(-1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}


class TestLinkedBlockingQueueTaskConsumer extends RecursiveTask<Integer> {
    private LinkedBlockingQueue<Integer> queue;

    public TestLinkedBlockingQueueTaskConsumer(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    protected Integer compute() {
        while (!Thread.interrupted()) {
            Integer take = null;
            try {
                take = queue.take();
                if (take < 0) {
                    break;
                }
                System.out.println("take:" + take);
            } catch (InterruptedException e) {

            }
        }
        return null;
    }
}
package exercise.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;

class House {

    private static int count = 0;
    private final int id = count++;
    private boolean watered;
    private boolean electricted;
    private boolean decorated;

    public synchronized void wateredOn() {
        watered = true;
    }

    public synchronized void electricOn() {
        electricted = true;
    }

    public synchronized void decorateOn() {
        decorated = true;
    }

    public int getId() {
        return id;
    }

    public boolean isWatered() {
        return watered;
    }

    public boolean isElectricted() {
        return electricted;
    }

    public boolean isDecorated() {
        return decorated;
    }

    @Override
    public String toString() {
        return "house:[id: " + getId() + "; watered:" + watered + ";"
                + " electricted:" + electricted + "; decorated:" + decorated + "]";
    }

}

/**
 * worker
 *
 * @author Administrator
 */
abstract class Worker implements Runnable {
    private boolean engaged = false;
    private WorkerCompany company;
    protected Agent agent;

    Worker(WorkerCompany company) {
        this.company = company;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    abstract void performService();

    public synchronized void engage() {
        engaged = true;
        notifyAll();
    }

    /**
     * waiting to be command
     *
     * @throws InterruptedException
     */
    public synchronized void powerDown() throws InterruptedException {
        this.agent = null;
        company.release(this);
        engaged = false;
        wait();
    }

    public void run() {
        try {
            powerDown();
            while (!Thread.currentThread().isInterrupted()) {
                performService();
                agent.getBarrier().await();
                powerDown();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

/**
 * water equipment worker
 *
 * @author Administrator
 */
class WaterWorker extends Worker {

    WaterWorker(WorkerCompany company) {
        super(company);
        // TODO Auto-generated constructor stub
    }

    @Override
    void performService() {
        agent.getHouse().wateredOn();
    }
}

/**
 * electric equipment worker
 *
 * @author Administrator
 */
class ElectricWorker extends Worker {

    ElectricWorker(WorkerCompany company) {
        super(company);
        // TODO Auto-generated constructor stub
    }

    @Override
    void performService() {
        agent.getHouse().electricOn();
    }

}

/**
 * decoration worker
 *
 * @author Administrator
 */
class DecorateWorker extends Worker {

    DecorateWorker(WorkerCompany company) {
        super(company);
        // TODO Auto-generated constructor stub
    }

    @Override
    void performService() {
        agent.getHouse().decorateOn();
    }
}

class WorkerCompany {
    private List<Worker> workers;

    {
        workers = new LinkedList<Worker>();
    }

    public synchronized void hire(Class<? extends Worker> clss, Agent agent) throws InterruptedException {
        for (Worker worker : workers) {
            if (worker.getClass().equals(clss)) {
                workers.remove(worker);
                worker.setAgent(agent);
                worker.engage();
                return;
            }
        }
        wait();
        hire(clss, agent);
    }

    public synchronized void inform() {
        notify();
    }

    public synchronized void release(Worker worker) {
        workers.add(worker);
        notifyAll();
    }
}

class HouseGenerater implements Runnable {
    private LinkedBlockingQueue<House> houseQueue;

    public HouseGenerater(LinkedBlockingQueue<House> queue) {
        houseQueue = queue;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                houseQueue.put(new House());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

/**
 * houser agent
 *
 * @author Administrator
 */
class Agent implements Runnable {
    private House house;
    private BlockingQueue<House> queue;
    private CyclicBarrier barier;
    private WorkerCompany company;
    private List<House> finishedQueue;

    public Agent() {
        finishedQueue = new LinkedList<House>();
    }

    public Agent(BlockingQueue<House> queue, CyclicBarrier barrier, WorkerCompany company) {
        this();
        this.queue = queue;
        this.barier = barrier;
        this.company = company;
    }

    public synchronized House getHouse() {
        return house;
    }

    public synchronized CyclicBarrier getBarrier() {
        return barier;
    }


    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                house = queue.take();
                /**
                 * 开始招工去工作
                 */
                company.hire(WaterWorker.class, this);
                company.hire(ElectricWorker.class, this);
                company.hire(DecorateWorker.class, this);
                /**
                 * actually only when waterWorker, ElectricWorker and DecorateWorker all
                 * have finished their work can here the calling of barier.await() make
                 * the count of CyclicBarrier be zero thus go to the next circulation
                 * what if we use blockingQueue
                 */
                barier.await();

                print(house);
                finishedQueue.add(house);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


public class Exercise38 {
    public static void main(String[] args) throws Exception {
        WorkerCompany company = new WorkerCompany();
        ExecutorService executer = Executors.newCachedThreadPool(new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

                    public void uncaughtException(Thread t, Throwable e) {
                        e.printStackTrace();
                    }
                });
                return t;
            }
        });
        LinkedBlockingQueue<House> houseQueue = new LinkedBlockingQueue<House>();
        executer.execute(new Agent(houseQueue, new CyclicBarrier(4), company));
        executer.execute(new HouseGenerater(houseQueue));

        executer.execute(new WaterWorker(company));
        executer.execute(new ElectricWorker(company));
        executer.execute(new DecorateWorker(company));
        TimeUnit.SECONDS.sleep(7);
        executer.shutdownNow();
    }
}

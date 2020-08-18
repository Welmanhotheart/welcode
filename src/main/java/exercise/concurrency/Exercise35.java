package exercise.concurrency;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Request {

    private static int count = 0;
    private final int id = count++;
    private int serviceTime;

    public Request(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }


    @Override
    public String toString() {
        return "[R" + getId() + "]";
    }

    public int getId() {
        return this.id;
    }

}


class RequestGenerater implements Runnable {
    private static Random r = new Random(100);
    private RequestLines requestQueue;

    public RequestGenerater(RequestLines requestQueue) {
        this.requestQueue = requestQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(r.nextInt(300));
                requestQueue.put(new Request(r.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(this + "is exiting caused by being interrupted");
        }
        System.out.println(this + "is exiting ");
    }

}

class RequestLines extends ArrayBlockingQueue<Request> {

    public RequestLines(int capacity) {
        super(capacity);
    }

    public String tosString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder builer = new StringBuilder(12);
        for (Request r : this) {
            builer.append(r);
        }
        return builer.toString();
    }
}

class Server implements Runnable {
    private RequestLines requests;
    private int servedRequesCount;
    private boolean dealingRequest = true;
    private static int count = 0;
    private final int id = count++;

    public Server(RequestLines requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "S" + id;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Request request = requests.take();
                TimeUnit.MILLISECONDS.sleep(request.getServiceTime());
                synchronized (this) {
                    servedRequesCount++;
                    while (!dealingRequest) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println(this + "is exiting caused by being interrupted");
        }
        System.out.println(this + "is exiting ");
    }


    /**
     * deal with the request
     */
    public synchronized void dealRequest() {
        dealingRequest = true;
        notifyAll();
    }

    /**
     * reset it to do other things
     */
    public synchronized void reassignOtherThings() {
        servedRequesCount = 0;
        dealingRequest = false;
    }

}

class ServerManager implements Runnable {
    private LinkedList<Server> workingSevers = new LinkedList<Server>();
    private LinkedList<Server> doOtherThingServers = new LinkedList<Server>();
    private RequestLines requests;
    private ExecutorService exec;

    public ServerManager(ExecutorService exec, RequestLines requests) {
        this.exec = exec;
        this.requests = requests;
        Server server = new Server(this.requests);
        workingSevers.add(server);
        this.exec.execute(server);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(1000);
                adjustServer();
                System.out.print(requests + " {");
                for (Server server : this.workingSevers) {
                    System.out.print(server + " ");
                }
                System.out.println("}");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println(this + "is exiting caused by being interrupted");
        }
        System.out.println(this + "is exiting");
    }

    /**
     * adjust thus balance the server
     */
    private void adjustServer() {
        //if request line if too long
        if (requests.size() > 0 && workingSevers.size() == 0) {
            Server server = new Server(requests);
            workingSevers.add(server);
            exec.execute(server);
        }
        if (requests.size() / workingSevers.size() > 2) {
            //fetch a server from 'doOtherThingSevers'
            if (doOtherThingServers.size() > 0) {
                Server server = doOtherThingServers.remove();
                server.dealRequest();
                workingSevers.add(server);
            } else {
                //if there is no server that do otherThings;
                Server server = new Server(requests);
                workingSevers.add(server);
                exec.execute(server);
            }
            return;
        }

        if (requests.size() == 0) {
            while (workingSevers.size() > 1) {
                reassignOneServer();
            }
        }
        if (workingSevers.size() > 1 && requests.size() / workingSevers.size() < 2) {
            reassignOneServer();
        }
    }

    private void reassignOneServer() {
        Server workingServer = workingSevers.remove();
        workingServer.reassignOtherThings();
        doOtherThingServers.add(workingServer);
    }
}

public class Exercise35 {
    public static void main(String[] args) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e);

            }
        });
        ExecutorService exec = Executors.newCachedThreadPool();
        RequestLines requests = new RequestLines(75);
        exec.execute(new ServerManager(exec, requests));
        exec.execute(new RequestGenerater(requests));
        System.in.read();
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}

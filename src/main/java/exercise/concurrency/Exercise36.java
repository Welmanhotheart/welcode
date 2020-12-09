package exercise.concurrency;

import enumerated.menu.Course;
import enumerated.menu.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;

//: concurrency/restaurant2/RestaurantWithQueues.java
// {Args: 5}

public class Exercise36 {
    public static void main(String[] args) {
        System.out.println();
    }
}





// This is given to the waiter, who gives it to the ChefExt:
class OrderExt { // (A data-transfer object)
    private static int counter = 0;
    private final int id = counter++;
    private final  CustomerExt CustomerExt;
    private final  WaitPersonExt waitPersonExt;
    private final Food food;

    public OrderExt( CustomerExt cust,  WaitPersonExt wp, Food f) {
        CustomerExt = cust;
        waitPersonExt = wp;
        food = f;
    }

    public Food item() {
        return food;
    }


    public  WaitPersonExt getWaitPerson() {
        return waitPersonExt;
    }

    public String toString() {
        return "OrderExt: " + id + " item: " + food +
                " for: " + CustomerExt +
                " served by: " + waitPersonExt;
    }
}


class OrderTicket extends OrderExt{
    private final Table table;
    public OrderTicket(WaitPersonExt waitPersonExt, Food food, Table table ) {
        super( null,  waitPersonExt, food);
        this.table = table;
    }

    public Table getTable() {
        return table;
    }
}


class Table implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private List<CustomerExt> customerExts;
    private WaitPersonExt waitPerson;
    private final int custNumber;
    // Only one course at a time can be received:
    private SynchronousQueue< Plate> placeSetting =
            new SynchronousQueue< Plate>();
    private RestaurantExt restaurant;
    public Table(int custNumber, RestaurantExt restaurant) {
        this.custNumber = custNumber;
        this.restaurant = restaurant;
        customerExts = new ArrayList<CustomerExt>(this.custNumber);
    }

    public void setWaitPerson(WaitPersonExt waitPerson) {
        this.waitPerson = waitPerson;
    }

    public void add(CustomerExt customer) {
        customerExts.add(customer);
    }

    public void
    deliver( Plate p) throws InterruptedException {
        // Only blocks if CustomerExt is still
        // eating the previous course:
        placeSetting.put(p);
    }
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waitPerson.placeOrder(this, food);
                // Blocks until course has been delivered:
                print(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                print(this + "waiting for " +
                        course + " interrupted");
                break;
            }
        }
        print(this + "finished meal, leaving");
        releaseSelf();
    }

    private void releaseSelf() {
        this.customerExts.clear();
        this.waitPerson = null;
        placeSetting.clear();
        this.restaurant.releaseTable(this);

    }

    @Override
    public String toString() {
//        return String.format("[%1$-3d]", priority) +
//                " Task " + id;
        return String.format("table %1$-3d, custNumber:%1$-3d", id, custNumber);
    }
}

// This is what comes back from the ChefExt:
class Plate {
    private final OrderTicket orderTicket;
    private final Food food;

    public Plate( OrderTicket ord, Food f) {
        orderTicket = ord;
        food = f;
    }

    public  OrderTicket getOrder() {
        return orderTicket;
    }

    public Food getFood() {
        return food;
    }

    public String toString() {
        return food.toString();
    }
}

class CustomerExt implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final  WaitPersonExt waitPersonExt;
    private Table table;
    // Only one course at a time can be received:
    private SynchronousQueue< Plate> placeSetting =
            new SynchronousQueue< Plate>();

    public CustomerExt( WaitPersonExt w, Table table) {
        waitPersonExt = w;
        this.table = table;

    }

    public void
    deliver( Plate p) throws InterruptedException {
        // Only blocks if CustomerExt is still
        // eating the previous course:
        placeSetting.put(p);
    }

    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waitPersonExt.placeOrder(table, food);
                // Blocks until course has been delivered:
                print(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                print(this + "waiting for " +
                        course + " interrupted");
                break;
            }
        }
        print(this + "finished meal, leaving");
    }

    public String toString() {
        return "CustomerExt " + id + " ";
    }
}

class WaitPersonExt implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final  RestaurantExt RestaurantExt;
    BlockingQueue<Plate> filledOrders =
            new LinkedBlockingQueue< Plate>();

    public WaitPersonExt( RestaurantExt rest) {
        RestaurantExt = rest;
    }

    public void placeOrder( Table table, Food food) {
        try {
            // Shouldn't actually block because this is
            // a LinkedBlockingQueue with no size limit:
            RestaurantExt.orders.put(new OrderTicket(this, food, table));
        } catch (InterruptedException e) {
            print(this + " placeOrder interrupted");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until a course is ready
                Plate plate = filledOrders.take();
                print(this + "received " + plate +
                        " delivering to " +
                        plate.getOrder().getTable());
                plate.getOrder().getTable().deliver(plate);
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }
        print(this + " off duty");
    }

    public String toString() {
        return "WaitPersonExt " + id + " ";
    }
}

class ChefExt implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final  RestaurantExt RestaurantExt;
    private static Random rand = new Random(47);

    public ChefExt( RestaurantExt rest) {
        RestaurantExt = rest;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until an OrderExt appears:
                OrderTicket orderTicket = RestaurantExt.orders.take();
                Food requestedItem = orderTicket.item();
                // Time to prepare OrderExt:
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                 Plate plate = new  Plate(orderTicket, requestedItem);
                orderTicket.getWaitPerson().filledOrders.put(plate);
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }
        print(this + " off duty");
    }

    public String toString() {
        return "ChefExt " + id + " ";
    }
}


class RestaurantExt implements Runnable {
    private final int custNumberPerTable;
    private List< WaitPersonExt> waitPersons =
            new ArrayList< WaitPersonExt>();
    private List< ChefExt> chefs = new ArrayList< ChefExt>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    BlockingQueue< OrderTicket>
            orders = new LinkedBlockingQueue< OrderTicket>();

    BlockingQueue<Table> tables = new LinkedBlockingQueue<Table>();
    public RestaurantExt(ExecutorService e, int nWaitPersons,
                      int nChefs, int nTables) {
        this.custNumberPerTable = nWaitPersons;
        exec = e;
        for (int i = 0; i < nWaitPersons; i++) {
             WaitPersonExt WaitPersonExt = new  WaitPersonExt(this);
            waitPersons.add(WaitPersonExt);
            exec.execute(WaitPersonExt);
        }
        for (int i = 0; i < nChefs; i++) {
             ChefExt ChefExt = new  ChefExt(this);
            chefs.add(ChefExt);
            exec.execute(ChefExt);
        }

        //添加桌子
        for (int i = 0; i < nTables; i++) {
            Table table = new Table(custNumberPerTable, this);
            tables.add(table);
        }
    }

    public void run() {
        Table table = null;
        try {
            //要改成多个顾客一桌，每一桌一个服务员
            while (!Thread.interrupted()) {
                // A new CustomerExt arrives; assign a WaitPersonExt:

                int custs = rand.nextInt(this.custNumberPerTable);
                table = tables.take();
                WaitPersonExt wp = waitPersons.get(
                        rand.nextInt(waitPersons.size()));
                table.setWaitPerson(wp);
                for (int i = 0; i < custs; i++) {
                    CustomerExt c = new CustomerExt(wp, table);
                    table.add(c);
                }
                exec.execute(table);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("RestaurantExt interrupted");
        }
        print("RestaurantExt closing");
    }

    public void releaseTable(Table table) {
        tables.add(table);
    }
}

class RestaurantWithQueues {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
         RestaurantExt RestaurantExt = new  RestaurantExt(exec, 5, 2, 10);
        exec.execute(RestaurantExt);
        if (args.length > 0) // Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        else {
            print("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
} /* Output: (Sample)
WaitPersonExt 0 received SPRING_ROLLS delivering to CustomerExt 1
CustomerExt 1 eating SPRING_ROLLS
WaitPersonExt 3 received SPRING_ROLLS delivering to CustomerExt 0
CustomerExt 0 eating SPRING_ROLLS
WaitPersonExt 0 received BURRITO delivering to CustomerExt 1
CustomerExt 1 eating BURRITO
WaitPersonExt 3 received SPRING_ROLLS delivering to CustomerExt 2
CustomerExt 2 eating SPRING_ROLLS
WaitPersonExt 1 received SOUP delivering to CustomerExt 3
CustomerExt 3 eating SOUP
WaitPersonExt 3 received VINDALOO delivering to CustomerExt 0
CustomerExt 0 eating VINDALOO
WaitPersonExt 0 received FRUIT delivering to CustomerExt 1
...
*///:~

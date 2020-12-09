package exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class Exercise27 {
}

class MealEx27 {
    private final int orderNum;

    public MealEx27(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPersonEx27 implements Runnable {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private RestaurantEx27 restaurant;

    public WaitPersonEx27(RestaurantEx27 r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {

                waitForMealMade();


                printnb(" Waitperson got " + restaurant.meal);
                readyForAnother();

            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }

    private void readyForAnother() {
        restaurant.chef.lock.lock();
        try {
            restaurant.meal = null;
            restaurant.chef.condition.signalAll(); // Ready for another
        } finally {
            restaurant.chef.lock.unlock();
        }
    }

    private void waitForMealMade() throws InterruptedException {
        lock.lock();
        try {
            while (restaurant.meal == null)
                condition.await(); // ... for the chef to produce a meal
        } finally {
            lock.unlock();
        }
    }
}

class ChefEx27 implements Runnable {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private RestaurantEx27 restaurant;
    private int count = 0;

    public ChefEx27(RestaurantEx27 r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                waitForMealTaken();

                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
//                    return; //after calling return；the thread here will not throw ‘InterruptedException’
                }
                printnb("Order up! ");

                makeMeal();

                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }

    private void makeMeal() {
        restaurant.waitPerson.lock.lock();
        try {
            restaurant.meal = new MealEx27(count);
            restaurant.waitPerson.condition.signalAll();
        } finally {
            restaurant.waitPerson.lock.unlock();
        }
    }

    private void waitForMealTaken() throws InterruptedException {

        lock.lock();
        try {
            while (restaurant.meal != null) {
                condition.await(); // ... for the meal to be taken
            }
        } finally {
            lock.unlock();
        }
    }

}

class RestaurantEx27 {
    MealEx27 meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPersonEx27 waitPerson = new WaitPersonEx27(this);
    ChefEx27 chef = new ChefEx27(this);

    BusBoyEx27 boy = new BusBoyEx27(this);
    public RestaurantEx27() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(boy);
    }

    public static void main(String[] args) {
        new RestaurantEx27();
    }
}

class BusBoyEx27 implements Runnable{
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    RestaurantEx27 restaurant;

    public BusBoyEx27(RestaurantEx27 restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                restaurant.waitPerson.lock.lock();
                try {
                    while(restaurant.meal == null) {
                        restaurant.waitPerson.condition.await();
                    }
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }

                restaurant.chef.lock.lock();
                try {
                    while(restaurant.meal != null) {
                        restaurant.chef.condition.await();
                    }
                } finally {
                    restaurant.chef.lock.unlock();
                }

                print(" cleanup");
            }
        } catch (InterruptedException e) {
            printnb("BusBoyEx27 broken form being interrupted");
        }
    }
}

/* Output:
Order up! Waitperson got Meal 1
Order up! Waitperson got Meal 2
Order up! Waitperson got Meal 3
Order up! Waitperson got Meal 4
Order up! Waitperson got Meal 5
Order up! Waitperson got Meal 6
Order up! Waitperson got Meal 7
Order up! Waitperson got Meal 8
Order up! Waitperson got Meal 9
Out of food, closing
WaitPerson interrupted
Order up! Chef interrupted
*///:~

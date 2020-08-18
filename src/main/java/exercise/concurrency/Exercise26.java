package exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class Exercise26 {
    public static void main(String[] args) {
        new RestaurantEx26();
    }
}


class MealEx26 {
    private final int orderNum;

    public MealEx26(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPersonEx26 implements Runnable {
    private RestaurantEx26 restaurant;

    public WaitPersonEx26(RestaurantEx26 r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                printnb("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }

                synchronized (this) {
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class ChefEx26 implements Runnable {
    private RestaurantEx26 restaurant;
    private int count = 0;

    public ChefEx26(RestaurantEx26 r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
//                    return; //after calling return；the thread here will not throw ‘InterruptedException’
                }
                printnb("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new MealEx26(count);
                    restaurant.waitPerson.notifyAll();
                }

                TimeUnit.MILLISECONDS.sleep(100);

            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

class RestaurantEx26 {
    MealEx26 meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPersonEx26 waitPerson = new WaitPersonEx26(this);
    ChefEx26 chef = new ChefEx26(this);
    BusBoy boy = new BusBoy(this);

    public RestaurantEx26() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(boy);
    }

    public static void main(String[] args) {
        new concurrency.Restaurant();
    }
}

class BusBoy implements Runnable{
    RestaurantEx26 restaurant;

    public BusBoy(RestaurantEx26 r) {
        restaurant = r;
    }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (restaurant.waitPerson) {
                    while (restaurant.meal == null) {
                        restaurant.waitPerson.wait();
                    }
                }
                synchronized (restaurant.chef) {
                    while(restaurant.meal != null) {
                        restaurant.chef.wait();
                    }
                }
                print(" cleanup ");
                TimeUnit.MILLISECONDS.sleep(100);

            }
        } catch (Exception ex) {

        }
    }
}
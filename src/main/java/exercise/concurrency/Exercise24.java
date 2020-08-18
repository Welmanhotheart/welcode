package exercise.concurrency;


import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise24 {
    public static void main(String[] args) throws InterruptedException {
        Restaurant restaurant = new Restaurant(4, 1, 37);
        TimeUnit.SECONDS.sleep(4);
        restaurant.shutdownNow();
    }
}


class Restaurant {
    private Chef chef;
    private WaitPerson waitPerson;
    ExecutorService exec = Executors.newCachedThreadPool();
    public Restaurant(int chefSpeed, int waitPersonSpeed, int waitPersonBuffer) {
        chef = new Chef(this,chefSpeed);
        waitPerson = new WaitPerson(this, waitPersonSpeed, waitPersonBuffer);
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public void shutdownNow() {
        exec.shutdownNow();
    }


    public Chef getChef() {
        return chef;
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }
}

abstract class RestaurantWorker implements Runnable{
    private Restaurant restaurant;
    private final int speed;

    public RestaurantWorker(Restaurant restaurant, int speed ) {
        this.restaurant = restaurant;
        this.speed = speed;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getSpeed() {
        return speed;
    }

    abstract public void run();
}

class WaitPerson extends RestaurantWorker {
    private final int bufferSize;
    private int used;
    public WaitPerson(Restaurant restaurant,int speed,int bufferSize) {
        super(restaurant, speed);
        this.bufferSize = bufferSize;
    }

    public void run() {
        int count = 0;
        try {
            int speed = getSpeed();
            while (!Thread.interrupted()) {
                /**
                 * 判断能否进行meal选取；
                 * 能就开始送餐
                 */
                synchronized (this) {
                    while (used == 0) {
                        wait();
                    }
                }
                int incre = speed;
                synchronized (this) {
                    int temp = used;
                    used -= speed;
                    if (used < 0) {
                        used = 0;
                        incre = temp;
                    }
                    notifyAll();
                }
                count += incre;
                System.out.println("已经送餐：" + count);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson broken from being interrupted");
        }
        System.out.println("总共送餐：" + count);
    }

    public boolean canReceive(int speed) {
        return used + speed <= bufferSize;
    }

    public void addMeal(int speed) {
        used += speed;
    }
}

class Chef extends RestaurantWorker  {
    public Chef(Restaurant restaurant,int speed) {
        super(restaurant, speed);
    }
    public void run() {

        int count = 0;
        try {
            while (!Thread.interrupted()) {
                Restaurant restaurant = getRestaurant();
                /**
                 * 这里判断能否向waitPerson里进行meal传送，不能就等待
                 */
                WaitPerson waitPerson = restaurant.getWaitPerson();
                int speed = this.getSpeed();
                synchronized (waitPerson) {
                    while (!waitPerson.canReceive(speed)) {
                            waitPerson.wait();
                    }
                }

                /**
                 * 这里再次获取
                 */
                synchronized (waitPerson) {
                    if (waitPerson.canReceive(speed)) {
                        waitPerson.addMeal(speed);
                        count += speed;
                        waitPerson.notifyAll();
                    }
                }
                System.out.println("已经做餐：" + count);
                TimeUnit.MILLISECONDS.sleep(600);

            }
        } catch (InterruptedException e) {
            System.out.println("Chef broken from being interrupted");
        }
        System.out.println("总共做餐：" + count);
    }
}

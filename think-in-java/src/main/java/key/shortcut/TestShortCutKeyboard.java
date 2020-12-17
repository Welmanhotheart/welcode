package key.shortcut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestShortCutKeyboard {
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
        List<String> list = new ArrayList<String>(3);


        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            String next = itr.next();
            System.out.println(next);
        }

        try {
            int i1 = 12, i2 = 34;

            String asf = "asf", asd = "";
            f(i1, i2, asd);
            f2(i1, i2, asd);
            lock.lock();
        } finally {
//            lock.lock().writeLock().unlock();
            lock.unlock();
        }


    }


    /**
     *
     * @param i1
     * @param i2
     * @param i3
     */
    public static void f(int i1, long i2, String i3){

    }

    /**
     *
     * @param i1
     * @param i2
     * @param i3
     */
    public static void f2(int i1, long i2, String i3){

    }

}

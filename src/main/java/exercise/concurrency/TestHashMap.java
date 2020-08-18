package exercise.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TestHashMap {
    public static void main(String[] args) {
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
class TestHashMapSingleThread {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        AtomicInteger ai = new AtomicInteger();
        Integer key = ai.get();
        while (key < 100000) {
            map.put(key, key);
            ai.incrementAndGet();
            key = ai.get();
        }
    }

}

class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map map = new HashMap();
    @Override
    public void run() {
        while (ai.get() < 100000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }
}
/**
 * Exception in thread "Thread-1" Exception in thread "Thread-3" java.lang.ArrayIndexOutOfBoundsException: 22143
 at java.util.HashMap.createEntry(HashMap.java:896)
 at java.util.HashMap.addEntry(HashMap.java:884)
 at java.util.HashMap.put(HashMap.java:505)
 at exercise.concurrency.HashMapThread.run(TestHashMap.java:30)
 java.lang.ArrayIndexOutOfBoundsException: 22143
 at java.util.HashMap.createEntry(HashMap.java:897)
 at java.util.HashMap.addEntry(HashMap.java:884)
 at java.util.HashMap.put(HashMap.java:505)
 at exercise.concurrency.HashMapThread.run(TestHashMap.java:30)



 "Thread-1" prio=6 tid=0x000000000dbc5000 nid=0x578 runnable [0x000000000e75f000]
 java.lang.Thread.State: RUNNABLE
 at java.util.HashMap.transfer(HashMap.java:601)
 at java.util.HashMap.resize(HashMap.java:581)
 at java.util.HashMap.addEntry(HashMap.java:879)
 at java.util.HashMap.put(HashMap.java:505)
 at exercise.concurrency.HashMapThread.run(TestHashMap.java:30)

 **/
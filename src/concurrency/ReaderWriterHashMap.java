package concurrency;

import net.mindview.util.Generator;
import net.mindview.util.MapData;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterHashMap<K,V> extends HashMap<K,V> {

    private ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock(true);

    public ReaderWriterHashMap(int size, Generator<K> genK, V initialValue) {
        super(MapData.map(genK, initialValue, size));
    }

    public V put(K key, V value) {
        Lock wlock = lock.writeLock();
        wlock.lock();
        Lock rlock = lock.readLock();
//        print("in write 获取锁的读者:" + lock.getReadLockCount());
        try {
            return super.put(key, value);
        } finally {
            wlock.unlock();
        }
    }

    public V get(Object key) {
        Lock rlock = lock.readLock();
        rlock.lock();
        try {
            // Show that multiple readers
            // may acquire the read lock:
//            if (lock.getReadLockCount() > 1)
//                print("获取锁的读者:" + lock.getReadLockCount());
            return super.get(key);
        } finally {
            rlock.unlock();
        }
    }

}

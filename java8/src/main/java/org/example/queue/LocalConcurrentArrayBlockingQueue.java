package org.example.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class block and wait for the data to be available
 */
public class LocalConcurrentArrayBlockingQueue {

    private final Lock lock = new ReentrantLock();
    private Condition full ;
    private Condition empty;

    private Object [] storage;
    private int capacity;
    private int load;

    public LocalConcurrentArrayBlockingQueue(int load) {
        this.storage = new Object [load];
        this.load = load;
        this.full = lock.newCondition();
        this.empty = lock.newCondition();
    }

    /**
     * Only allow one item at the time to be read
     * @param key
     * @return null if interrupted
     */
    public Object pull(int key) {
        try {
            lock.lockInterruptibly();
            while (capacity == 0) {
                empty.await();
            }
            capacity--;
            full.signalAll();
            return  storage[key] ;
        } catch(InterruptedException ex) {
            return null;
        }  finally {
            lock.unlock();
        }
    }

    public void offer(Object data) {
        try {
            lock.lockInterruptibly();
            while (capacity == load) {
                full.await();
            }
            storage[capacity++] = data;
            empty.signalAll();
        }catch(InterruptedException ex) {
            // do nothing
        }  finally {
            lock.unlock();
        }
    }


}

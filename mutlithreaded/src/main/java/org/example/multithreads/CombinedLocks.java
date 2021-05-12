package org.example.multithreads;


import java.util.concurrent.locks.*;

public class CombinedLocks {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void build(){
        try {
            lock.tryLock();
            // make a release



        }catch(Exception ex){
            lock.unlock();
        }
    }

    public void read() {
        try {
            readLock.lock();
        }finally {
            readLock.unlock();
        }
    }

    public void write(){
        try {
            writeLock.lock();
        }finally {
            writeLock.unlock();
        }
    }
}

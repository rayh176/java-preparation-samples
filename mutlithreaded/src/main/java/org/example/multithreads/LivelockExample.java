package org.example.multithreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LivelockExample {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LivelockExample livelock = new LivelockExample();
        new Thread(livelock::operation1, "T1").start();
        new Thread(livelock::operation2, "T2").start();
    }

    public void operation1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                       System.out.println("lock1 acquired, trying to acquire lock2.");
                sleep(50);

                if (lock2.tryLock()) {
                    System.out.println("lock2 acquired.");
                } else {
                    System.out.println("cannot acquire lock2, releasing lock1.");
                    lock1.unlock();
                    continue;
                }

                System.out.println("executing first operation.");
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock2.unlock();
        lock1.unlock();
    }

    private boolean tryLock(Lock lock1, int i) {
        return false;
    }

    public void operation2()  {
        while (true) {
            tryLock(lock2, 50);
            System.out.println("lock2 acquired, trying to acquire lock1.");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (lock1.tryLock()) {
                System.out.println("lock1 acquired.");
            } else {
                System.out.println("cannot acquire lock1, releasing lock2.");
                lock2.unlock();
                continue;
            }

            System.out.println("executing second operation.");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    // helper methods

}

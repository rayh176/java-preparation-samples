package org.example.multithreads;

import java.util.concurrent.CountDownLatch;

public class CombinedCountDownnLatch {

    private CountDownLatch countDownLatch = new CountDownLatch(3);

    private Runnable runData(){
        return () -> {
            System.out.println("I got here");
            countDownLatch.countDown();
        };
    }

    public final static void main (String args []) throws InterruptedException {

        CombinedCountDownnLatch countDownnLatch = new CombinedCountDownnLatch();
        new Thread(countDownnLatch.runData()).start();
        new Thread(countDownnLatch.runData()).start();
        new Thread(countDownnLatch.runData()).start();
        countDownnLatch.countDownLatch.await();
        System.out.println("I finished my Job ***");
    }
}

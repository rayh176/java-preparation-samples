package org.example.multithreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CombinedCyclicBarrier {
    // load the data
    private CyclicBarrier  cyclicBarrier;
    private int N=5;

    CombinedCyclicBarrier(){
        cyclicBarrier = new CyclicBarrier(N, () -> {
            System.out.println("Barrier triped");
        });
    }

    private Runnable runTheData() {
        return () -> {
            System.out.println("Hello World");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
    }

    public final static void main(String args []){
        CombinedCyclicBarrier combinedCyclicBarrier = new CombinedCyclicBarrier();
        new Thread(combinedCyclicBarrier.runTheData()).start();
        new Thread(combinedCyclicBarrier.runTheData()).start();
        new Thread(combinedCyclicBarrier.runTheData()).start();
        new Thread(combinedCyclicBarrier.runTheData()).start();
        new Thread(combinedCyclicBarrier.runTheData()).start();
    }
}

package org.example.multithreads;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

public class CycleBarrierInvoker {

    static class Runner implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Runner (CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @SneakyThrows
        public void run() {
            System.out.println("Receive the signal");
            this.cyclicBarrier.await();
        }
    }

    public static void main(String args []) {

        CyclicBarrier cycleBarrier = new CyclicBarrier(5);

        new Thread(new Runner(cycleBarrier)).start();
        new Thread(new Runner(cycleBarrier)).start();
        new Thread(new Runner(cycleBarrier)).start();
        new Thread(new Runner(cycleBarrier)).start();
        new Thread(new Runner(cycleBarrier)).start();

        System.out.println("Got here"+cycleBarrier.getNumberWaiting());
        //cycleBarrier.reset();
    }
}


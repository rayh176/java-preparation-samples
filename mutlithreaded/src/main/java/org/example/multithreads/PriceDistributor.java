package org.example.multithreads;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.*;

public class PriceDistributor {

    private AtomicBoolean validator = new AtomicBoolean(true);

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    interface Subscriber {
        public void onPrice(Price price);
    }

    public static class Price {
        public final String ccyPair;
        public final double rate;
        public Price(String c, double r){
            ccyPair = c;
            rate = r;
        }
    }

    Map<String, List<Subscriber>> subscriber = new ConcurrentHashMap<>();
    Map<String, Price> latestPrice = new HashMap<>();

    public void onExchangePrice(Price price){
        List<Subscriber> sub = subscriber.get(price.ccyPair);
        if (sub != null){
            // TODO ERROR due to ILLEGAL MONITOR as list may change
            for (Subscriber s : sub){
                s.onPrice(price);
            }
        }

        latestPrice.put(price.ccyPair, price);
    }

    //register for listening with this class
    public Price subscribe(String ccyPair, Subscriber sub){

        // while(!validator.get()) {
        //     Thread.sleep(1000);
        // }
        try{
            // TODO make sure its thread safe
            //if (validator.getAndSet(false)) {
            List<Subscriber> subList = subscriber.get(ccyPair);
            if (subList == null){
                subscriber.put(ccyPair, new LinkedList<>());
                subList = subscriber.get(ccyPair);
            }
            subList.add(sub);
            validator.set(true);


            return latestPrice.get(ccyPair);
        } finally {

        }
    }
}

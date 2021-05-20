package org.example.multithreads;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompleteQueueExecution {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private static Map<String, Value> ccyStorageForLatestValues = new HashMap<>();

    public static void populateMap(String ccyPair, Value newValue) {

        // populate the latest value
        ccyStorageForLatestValues.compute( ccyPair, (key, oldValue) -> {
            if (oldValue == null) {
                return newValue;
            }

            if (newValue.dateTime.compareTo(oldValue.dateTime) > 0) {
                return newValue;
            }
            return oldValue;
        });
    }

    @ToString
    @RequiredArgsConstructor
    @AllArgsConstructor
    private static class Value {
        private LocalDateTime dateTime;
        private double rate;
    }

    public static void main(String args []) {
        populateMap("eur/usd", new Value(LocalDateTime.now(), 1.0));
        populateMap("gbp/usd", new Value(LocalDateTime.now(), 2.0));
        populateMap("cad/usd", new Value(LocalDateTime.now(), 3.0));
        populateMap("chf/usd", new Value(LocalDateTime.now(), 4.0));
        populateMap("eur/usd", new Value(LocalDateTime.now(), 4.0));
        System.out.println("ccyStorageForLatestValues="+ccyStorageForLatestValues);
    }

}

package org.example.prices;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PublishLatestPrices {

    private static ConcurrentHashMap<String, Rate> storage = new ConcurrentHashMap<>();

    public  static void receivePrice(Rate newRate) {

        // workout if a rate exists
        // If not store the rate and publish it
        // If exists validate if the new rate is better, store  and send out
        storage.compute(newRate.inst, (key, oldRate) -> {
            if (Objects.isNull(oldRate) ) {
                return newRate;
            }

            // B value is the one that exists in the map
            if (newRate.price > oldRate.price) {
                publishPrice(newRate);
                return newRate;
            }

            publishPrice(oldRate);

            return oldRate;
        });
    }

    public static void publishPrice(Rate latestRate){
        System.out.println("latest Rate="+latestRate);
    }

    @ToString
    static public class Rate {
        private int price;
        private String inst;

        public Rate(int price, String inst) {
            this.price = price;
            this.inst = inst;
        }
    }
}

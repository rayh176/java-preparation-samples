package org.example.prices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PublishLatestPricesTest {


    @Test
    public void testLatestPrices(){
        // Have multiple threads calling it
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(1, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(2, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(6, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(6, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(5, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(4, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(3, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(7, "EUR/USD"))).start();
        new Thread( () -> PublishLatestPrices.receivePrice(new PublishLatestPrices.Rate(8, "EUR/USD"))).start();
    }

}

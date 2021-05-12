package org.example.orderbook.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "orderBook")
public class OrderBook {

    long getOrderBookId;

    public long getGetOrderBookId() {
        return getOrderBookId;
    }

    public void setGetOrderBookId(long getOrderBookId) {
        this.getOrderBookId = getOrderBookId;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "getOrderBookId=" + getOrderBookId +
                '}';
    }
}
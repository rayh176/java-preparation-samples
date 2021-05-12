package marketdepth.market;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BidAskPricer {

    public static final double BID = 1.2332d;
    public static final double ASK = 1.2349d;
    public static final double BID_QUANTITY = 1000000d;
    public static final double ASK_QUANTITY = 1000000d;

    private final double bid;
    private final double bidQuantity;
    private final double ask;
    private final double askQuantity;

    public BidAskPricer(double bid, double bidQuantity, double ask, double askQuantity) {
        this.bid = bid;
        this.bidQuantity = bidQuantity;
        this.ask = ask;
        this.askQuantity = askQuantity;
    }

    public double getBid() {
        return bid;
    }

    public double getBidQuantity() {
        return bidQuantity;
    }

    public double getAsk() {
        return ask;
    }

    public double getAskQuantity() {
        return askQuantity;
    }

    public static double getRoundedPricer(double min, double max){

        return roundPrice(ThreadLocalRandom.current().nextDouble(min, max), 4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BidAskPricer that = (BidAskPricer) o;
        return Double.compare(that.bid, bid) == 0 &&
                Double.compare(that.bidQuantity, bidQuantity) == 0 &&
                Double.compare(that.ask, ask) == 0 &&
                Double.compare(that.askQuantity, askQuantity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, bidQuantity, ask, askQuantity);
    }

    @Override
    public String toString() {
        return "BidAskPricer{" +
                "bid=" + bid +
                ", bidQuantity=" + bidQuantity +
                ", ask=" + ask +
                ", askQuantity=" + askQuantity +
                '}';
    }

    private static double roundPrice(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}

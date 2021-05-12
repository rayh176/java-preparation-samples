package marketdepth.listener;


import marketdepth.MarketListener;
import marketdepth.simulator.MarketDepthService;

import java.util.Arrays;

public class MarketListenerImpl implements MarketListener<MarketDepthService> {

    @Override
    public void onUpdate(MarketDepthService marketDepthService) {
        // handle data
        double bid = roundToMarket(handleBidData(marketDepthService) / handleBidQuantityData(marketDepthService));
        double ask = roundToMarket(handleAskData(marketDepthService) / handleAskQuantityData(marketDepthService));
        publishMarketDepth(marketDepthService, bid, ask);
    }

    private double handleAskData(MarketDepthService marketDepthService) {
        return Arrays.stream(marketDepthService.getBidAskPricer()).parallel().mapToDouble(
                                    bidAskPricer -> (bidAskPricer.getAsk() * bidAskPricer.getAskQuantity())
                            ).sum();
    }

    private double handleBidData(MarketDepthService marketDepthService) {
        return Arrays.stream(marketDepthService.getBidAskPricer()).parallel().mapToDouble(
                bidAskPricer -> (bidAskPricer.getBid() * bidAskPricer.getBidQuantity())
        ).sum();
    }

    private double handleBidQuantityData(MarketDepthService marketDepthService) {
        return Arrays.stream(marketDepthService.getBidAskPricer()).parallel().mapToDouble(
                bidAskPricer -> (bidAskPricer.getAskQuantity())
        ).sum();
    }

    private double handleAskQuantityData(MarketDepthService marketDepthService) {
        return Arrays.stream(marketDepthService.getBidAskPricer()).parallel().mapToDouble(
                bidAskPricer -> (bidAskPricer.getAskQuantity())
        ).sum();
    }

    private static double roundToMarket(double price){
        return (double)Math.round(price * 10000000) / 10000000;
    }

    private void publishMarketDepth(MarketDepthService marketDepthService, double bid, double ask){
        StringBuilder builder = new StringBuilder();
                builder.append("Thread Name {")
                .append(Thread.currentThread().getName())
                .append("}, TimeStamp {")
                .append(System.currentTimeMillis())
                .append("}, Instrument {")
                .append(marketDepthService.getMarketDepth().getInstrument())
                .append("}, venue {")
                .append(marketDepthService.getMarketDepth().getMarketVenueName())
                .append("}, VWAP Bid {")
                .append(bid)
                .append("}, VWAP Ask {")
                .append(ask)
                .append("}");
        System.out.println(builder.toString());
    }
}

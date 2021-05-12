package marketdepth.simulator;


import marketdepth.market.BidAskPricer;
import marketdepth.market.MarketDepth;

import static marketdepth.market.BidAskPricer.*;

public class MarketDepthService {
    private final MarketDepth marketDepth;

    public MarketDepthService(MarketDepth marketDepth) {
        this.marketDepth = marketDepth;
    }

    public MarketDepth getMarketDepth() {
        return marketDepth;
    }

    public BidAskPricer[] getBidAskPricer() {
        BidAskPricer[] bidAskPricers = new BidAskPricer[marketDepth.getMarketDepthLevel().ordinal() +1];
        for (int i = 0; i< marketDepth.getMarketDepthLevel().ordinal() +1; i++) {
            bidAskPricers[i] = new BidAskPricer(getRoundedPricer(BID, ASK), BID_QUANTITY, getRoundedPricer(BID, ASK), ASK_QUANTITY);
        }
        return bidAskPricers;
    }
}

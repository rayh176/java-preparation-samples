package marketdepth.market;


import marketdepth.MarketListener;
import marketdepth.simulator.MarketDepthService;

import java.util.Optional;

public class MarketDepth {

    private final MARKET_DEPTH_LEVEL marketDepthLevel;
    private final String marketVenueName;
    private final Instrument instrument;
    private Optional<MarketListener> optionalMarketListener;

    public enum MARKET_DEPTH_LEVEL{DEPTH_ONE, DEPTH_TWO, DEPTH_THREE, DEPTH_FOUR};

    public MarketDepth(final String marketVenueName,
                       final Instrument instrument,
                       final MARKET_DEPTH_LEVEL marketDepthLevel){
        this.marketVenueName = marketVenueName;
        this.instrument = instrument;
        this.marketDepthLevel = marketDepthLevel;
    }

    public void registerListener(MarketListener<MarketDepthService> marketListener){
        optionalMarketListener = Optional.of(marketListener);
    }

    public MARKET_DEPTH_LEVEL getMarketDepthLevel() {
        return marketDepthLevel;
    }

    public String getMarketVenueName() {
        return marketVenueName;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void publishPrices() {
        if (optionalMarketListener.isPresent())
            optionalMarketListener.get().onUpdate(new MarketDepthService(this));
    }

}

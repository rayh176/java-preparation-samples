package marketdepth.simulator;

import marketdepth.market.Instrument;
import marketdepth.market.MarketDepth;
import marketdepth.market.MarketVenue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MarketVenueService {

    private List<MarketVenue> marketVenues;
    private ScheduledExecutorService scheduledExecutorService;
    private long initialDelay;
    private long period;

    public MarketVenueService(final int noOfMarket, final long initialDelay, final long period){
        this.marketVenues = new ArrayList<>(noOfMarket);
        this.scheduledExecutorService = Executors.newScheduledThreadPool(noOfMarket);
        this.initialDelay = initialDelay;
        this.period = period;
    }

    public void registerMarketVenueWithInstruments(final MarketVenue marketVenue,
                                                   final List<Instrument> instruments,
                                                   final MarketDepth.MARKET_DEPTH_LEVEL marketDepthLevel){
        marketVenue.registerInstrument(instruments, marketDepthLevel);
        marketVenues.add(marketVenue);
    }

    public void lunchMarketVenues(){
        for (MarketVenue mkVenue : marketVenues){
            scheduledExecutorService.scheduleAtFixedRate( () -> mkVenue.sendMarketDepthPrices() ,
                    initialDelay,
                    period,
                    TimeUnit.MILLISECONDS);
        }
    }

    public void destroy() {
        scheduledExecutorService.shutdown();
    }
}

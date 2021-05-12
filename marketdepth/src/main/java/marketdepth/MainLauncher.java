package marketdepth;

import marketdepth.market.Instrument;
import marketdepth.market.MarketDepth;
import marketdepth.market.MarketVenue;
import marketdepth.simulator.MarketVenueService;

import java.util.ArrayList;
import java.util.List;

import static marketdepth.market.Instrument.*;

public class MainLauncher {


    MarketVenueService marketVenueService;

    MainLauncher(final int noOfMarket, final long initialDelay, final long period){
        marketVenueService = new MarketVenueService(noOfMarket,initialDelay, period);
    }

    public static final void main(String args []) {
        MainLauncher mainLuncher = null;
        try {
            mainLuncher = new MainLauncher(4, 0, 1);
            mainLuncher.loadMarketVenues("EBS", MarketDepth.MARKET_DEPTH_LEVEL.DEPTH_FOUR);
            mainLuncher.loadMarketVenues("FXALL", MarketDepth.MARKET_DEPTH_LEVEL.DEPTH_ONE);
            mainLuncher.loadMarketVenues("EURONEX", MarketDepth.MARKET_DEPTH_LEVEL.DEPTH_THREE);
            mainLuncher.loadMarketVenues("REUTERS", MarketDepth.MARKET_DEPTH_LEVEL.DEPTH_TWO);
            mainLuncher.lunchMarketVenues();
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.out.print("Shutdown the application");
            if (mainLuncher != null)
                mainLuncher.destroy();
        } finally {
            System.exit(1);
        }
    }

    private List<Instrument> getInstrumentsList(String ...instrumentNames){
        List<Instrument> instruments = new ArrayList<>();
        for (String instrumentName : instrumentNames)
            instruments.add (new Instrument(instrumentName));
        return instruments;
    }

    private void loadMarketVenues(String marketVenueName, MarketDepth.MARKET_DEPTH_LEVEL marketDepthLevel){
        marketVenueService.registerMarketVenueWithInstruments(new MarketVenue(marketVenueName),
                getInstrumentsList(EURUSD, GBPUSD, USDJPY, USDCAD, AUDUSD),
                marketDepthLevel);
    }

    private void lunchMarketVenues(){
        marketVenueService.lunchMarketVenues();
    }

    private void destroy() {
        marketVenueService.destroy();
    }
}

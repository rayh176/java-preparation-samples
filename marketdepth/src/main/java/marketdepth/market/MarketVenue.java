package marketdepth.market;

import marketdepth.listener.MarketListenerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

public class MarketVenue {

    private final String marketVenueName;
    private Optional<List<MarketDepth>> marketDepths = Optional.empty();

    public MarketVenue(final String marketVenueName){
        requireNonNull(marketVenueName, "MarkerVenue can't be NULL");
        this.marketVenueName = marketVenueName;
    }

    public void registerInstrument(final List<Instrument> instruments, MarketDepth.MARKET_DEPTH_LEVEL marketDepthLevel){
        final List<MarketDepth> marketDepthsList = new ArrayList<>(instruments.size());
        for(Instrument instrument: instruments){
            MarketDepth markertDepth = new MarketDepth(marketVenueName, instrument, marketDepthLevel);
            markertDepth.registerListener(new MarketListenerImpl());
            marketDepthsList.add(markertDepth);
       }
        marketDepths = Optional.of(marketDepthsList);
    }

    public void sendMarketDepthPrices() {
        if (marketDepths.isPresent()) {
            marketDepths.get().stream().parallel().forEach(
                    MarketDepth::publishPrices);

        } else
            out.println("No MarketDepth available for MarketVenue=" + marketVenueName);
    }
}

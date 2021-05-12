package marketdepth.market;

public class Instrument {

    public static final String EURUSD = "EURUSD";
    public static final String GBPUSD = "GBPUSD";
    public static final String USDJPY = "USDJPY";
    public static final String USDCAD = "USDCAD";
    public static final String AUDUSD = "AUDUSD";

    private final String ccyInstrument;

    public Instrument(String ccyInstrument) {
        this.ccyInstrument = ccyInstrument;
    }

    //This method can be expanded to do a proper checks on the instruments
    public boolean allowToPublish() {
        return true;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "ccyInstrument='" + ccyInstrument + '\'' +
                '}';
    }
}

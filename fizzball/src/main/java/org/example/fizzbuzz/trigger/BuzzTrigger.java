package org.example.fizzbuzz.trigger;

public class BuzzTrigger extends DefaultTrigger {

    private static final String BUZZ_TRIGGER = "BUZZ";

    public BuzzTrigger(int nominator){
        super(nominator);
    }

    @Override
    public String isTriggeredBy(int nominator) {
        return getFizzBuzz().divideNominatorDenominator(nominator, getDenominator()) ?
                BUZZ_TRIGGER : (getNextTrigger() != null) ?
                                    getNextTrigger().isTriggeredBy(nominator) : getDefaultValueNumber(nominator);
    }
}

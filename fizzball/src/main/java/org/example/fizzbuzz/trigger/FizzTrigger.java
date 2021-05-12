package org.example.fizzbuzz.trigger;

public class FizzTrigger extends DefaultTrigger {

    private static final String FIZZ_TRIGGER = "FIZZ";

    public FizzTrigger( int nominator){
        super( nominator);
    }

    @Override
    public String isTriggeredBy(int nominator) {
        return getFizzBuzz().divideNominatorDenominator(nominator, getDenominator()) ?
                    FIZZ_TRIGGER : (getNextTrigger() != null) ?
                getNextTrigger().isTriggeredBy(nominator) : getDefaultValueNumber(nominator);
    }
}

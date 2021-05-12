package org.example.fizzbuzz.trigger;

public class FizzBuzzTrigger extends DefaultTrigger {

    private static final String FIZZBUZZ_TRIGGER = "FIZZBUZZ";

    public FizzBuzzTrigger(int nominator){
        super(nominator);
    }

    @Override
    public String isTriggeredBy(int nominator) {
        return getFizzBuzz().divideNominatorDenominator(nominator, getDenominator()) ?
                FIZZBUZZ_TRIGGER : (getNextTrigger() != null) ?
                getNextTrigger().isTriggeredBy(nominator) : getDefaultValueNumber(nominator);
    }
}

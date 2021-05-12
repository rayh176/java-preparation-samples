package org.example.fizzbuzz.trigger;

public class NumberTrigger extends DefaultTrigger {


    public NumberTrigger(int nominator) {
        super(nominator);
    }

    @Override
    public String isTriggeredBy(int nominator) {
        return  getDefaultValueNumber(nominator);
    }
}
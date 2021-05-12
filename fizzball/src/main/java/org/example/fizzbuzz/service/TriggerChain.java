package org.example.fizzbuzz.service;


import org.example.fizzbuzz.trigger.*;

public class TriggerChain {

    public static final String NEW_LINE = "\n";
    private static final String EMPTY_STRING = "";
    private final int capacity;

    DefaultTrigger defaultTrigger;

    public TriggerChain(int capacity){
        this.capacity = capacity;
    }

    public void registerChain(int firstDeNominator, int secondDeNominator){
        defaultTrigger = new FizzBuzzTrigger( firstDeNominator * secondDeNominator);
        defaultTrigger.registerNext(new FizzTrigger(firstDeNominator)).
                                    registerNext(new BuzzTrigger(secondDeNominator)).
                                            registerNext(new NumberTrigger(0));
    }

    public String calculate(int number) {
        // default capacity
        StringBuilder fizzBuzzResults = new StringBuilder(capacity);

        if ( number <= 0)
            return EMPTY_STRING;

        for (int i=1; i<= number; i++) {
            fizzBuzzResults.append(
                    defaultTrigger.isTriggeredBy(i)).append(NEW_LINE);
        }

        return fizzBuzzResults.toString();
    }
}

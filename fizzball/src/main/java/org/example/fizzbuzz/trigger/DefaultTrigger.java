package org.example.fizzbuzz.trigger;


import org.example.fizzbuzz.calc.FizzBuzz;
import org.example.fizzbuzz.calc.impl.FizzBuzzImpl;

public abstract class DefaultTrigger {

    private int denominator;
    private DefaultTrigger next;
    private FizzBuzz fizzBuzz;

    protected DefaultTrigger( int denominator) {
        this.denominator = denominator;
        this.fizzBuzz = new FizzBuzzImpl();
    }

    public DefaultTrigger registerNext(DefaultTrigger next) {
        this.next = next;
        return next;
    }

    public abstract String isTriggeredBy(int number);

    public FizzBuzz getFizzBuzz() {
        return fizzBuzz;
    }

    public DefaultTrigger getNextTrigger() {
        return next;
    }

    public int getDenominator() {
        return denominator;
    }

    public String getDefaultValueNumber(int number){
        return String.valueOf(number);
    }
}

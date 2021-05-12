package org.example.fizzbuzz.calc.impl;

import org.example.fizzbuzz.calc.FizzBuzz;

public class FizzBuzzImpl implements FizzBuzz {

    @Override
    public boolean divideNominatorDenominator(int numerator, int denominator) {
        return numerator % denominator == 0;
    }


}

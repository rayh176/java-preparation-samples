package org.example.fizzbuzz;

import java.util.Optional;

/**
 * If the number provided can divide 3 or 5 then return FizzBall
 */
public class Java8FizzBall {
    public String java8Style(int number){
        return Optional.of(number).map(i -> (i % 3 ==0 ?"fizz" : "") + (i % 5 ==0 ?"ball" : "")).get();
    }
}

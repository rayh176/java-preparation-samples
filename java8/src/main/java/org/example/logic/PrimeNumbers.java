package org.example.logic;

import java.util.Optional;
import java.util.stream.IntStream;

public class PrimeNumbers {
    /**
     * @param args
     */
    public static void main(String args []){
        // identify if a number is a prime or not using a loop
        int n = 50;
        boolean isPrime = false;

        for (int i=2; i< n / 2; i++){
            // check if divide two
            if (n % 2 ==0) {
                isPrime = true;
                break;
            }
            isPrime = true;
        }
        System.out.println("Is number="+n+", is prime="+isPrime);

        // Using Java 8 as alternative
        Optional<Integer> value = IntStream.range(2,n %2).mapToObj(v -> v).filter(s -> n % s == 0).findFirst();
        System.out.println("Value===="+(value.isPresent() ? "NOT PRIME" : "PRIME"));
    }
}

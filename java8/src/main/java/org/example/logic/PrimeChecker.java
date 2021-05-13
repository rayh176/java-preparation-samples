package org.example.logic;
import java.util.stream.IntStream;

public class PrimeChecker {

    public static boolean isPrime(int n) {
        if (n ==1)
            return false;
        // We only need to check half of the numbers
        int m = n / 2;

        for (int c=2; c < m; c++) {
            int i = n % c;
            System.out.println("value ="+c +", test result="+i);
        }

        Long primeCount = IntStream.range(2, m).filter(i -> {
            if ( n % i == 0) {
                return true;
            }
            return false;
            }
        ).count();

        return primeCount == 0L;
    }

    public static void main(String args []) {
        int v = 17;
        System.out.println("n="+ v +", isPrime="+isPrime(v));
    }
}

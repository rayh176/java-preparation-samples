package org.example.logic;

import java.util.stream.IntStream;

public class FactorialProgram {

    public int createFactorial(int n) {
        if (n ==1 )
            return 1;
        return IntStream.range(1, n).reduce(1, (a,b) -> a*b);
    }

}

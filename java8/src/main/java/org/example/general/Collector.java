package org.example.general;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collector {
    public static List<Integer> oddNumbers(int l, int r) {
        // Write your code here
        return  IntStream.rangeClosed(l, r).filter(i -> i % 2 !=0 ).
                mapToObj(v -> (Integer)v).collect(Collectors.toList());
    }
}

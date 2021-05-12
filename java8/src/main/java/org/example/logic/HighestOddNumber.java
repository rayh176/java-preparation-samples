package org.example.logic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array, find the int that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */
public class HighestOddNumber {
    ////20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5

    public int findHighestOddNumber(int [] numbers){
        Map<Integer, Long> results = Arrays.stream(numbers).mapToObj(x -> x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Identify the highest number
        Optional<Integer> rr = results.entrySet().stream().filter(a -> (a.getValue() % 2 !=0)).max(Comparator.comparing(Map.Entry::getValue)).map(m -> m.getKey());
        if (rr.isPresent()) {
            return rr.get();
        }
        return 0;
    }
}

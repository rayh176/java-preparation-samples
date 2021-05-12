package org.example.general;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
// valid string are
// 1) empty
// 2) equal occurences of chars
// 3) when occurence of ONE char can be reduced by ONE for it to become valid
public class StreamString {
    public boolean isValid(String s) {
        if (s == null)
            return false;

        IntStream charStream = s.chars();

        // Create a list of characters from the data
        Map<Character, Long> results = charStream.mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (results == null || results.size() == 0)
            return true;
        // equal occurrences of characters
        Long min = results.values().stream().min(Long::compareTo).get();
        Long count = results.values().stream().filter( value -> (value !=  min) ).peek(ss -> System.out.println("s="+ss)).count();
        if (count > 1 ) {
            return false;
        }
        Long max = results.values().stream().max(Long::compareTo).get();
        Long count1 = results.values().stream().filter( value -> (value !=  max) ).filter(vv -> vv != max-1).count();
        if (count1 > 0 ) {
            return false;
        }
        return true;
    }
}

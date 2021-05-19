package org.example.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class KeyNumberPositions {

    public static final List<Integer> numsValues(int [] array, int value) {
        return IntStream.range(0, array.length).filter(i -> array[i] == value).
                mapToObj(s -> s).
                collect(Collectors.toList());
    }

    public static void main(String [] args) {
        int [] array = {5,7,7,8,8,10};
        List<Integer> results = numsValues( array, 8);
        results.forEach(System.out::println);
    }
}

package org.example.logic;

import java.util.Arrays;

public class PairLargestsSums {
    public int pairElements(int [] array1, int [] array2) {
        int max1 = Arrays.stream(array1).boxed().max(Integer::compareTo).get();
        int max2 = Arrays.stream(array2).boxed().max(Integer::compareTo).get();
        return max1 + max2;
    }
}

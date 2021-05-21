package org.example.logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You have an array of integers nums and an array queries, where queries[i] is a pair of indices (0-based).
 * Find the sum of the elements in nums from the indices at queries[i][0] to queries[i][1] (inclusive) for each
 * query, then add all of the sums for all the queries together. Return that number modulo 10^9 + 7.
 *
 * Example
 *
 * For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the output should be
 *           results = [ 0, 1, 2 ] = 3 + 0 -2 = 1
 *           results = [ 2, 3, 4, 5] = -2 + 6 - 3 +2=  3
 *           results = [ 0,1,2,3,4,5 ] = 3 + 0 -2 + 6 -3 +2 = 6
 *
 * sumInRange(nums, queries) = 10.
 *
 * The array of results for queries is [1, 3, 6], so the answer is 1 + 3 + 6 = 10.
 */

class MyCode {

    static int sumInRange(int[] nums, int[][] queries) {
        // queries
        List<int[]> results = Arrays.stream(queries).collect(Collectors.toList());

        int r = results.stream().map(i -> {

            int rr = IntStream.rangeClosed(i[0], i[1]).map(v -> nums[v] ).peek(
                    p -> System.out.println("pppp="+p)
            ).sum();
            return rr;
        }).reduce((a,b) -> a + b).orElse(0);

        return r;
    }

    public static void main(String[] args) {
        int [] nums =  {3, 0, -2, 6, -3, 2};
        int [][] queries = {{0, 2}, {2, 5}, {0, 5}};
        System.out.println("results="+sumInRange(nums, queries));
    }
}

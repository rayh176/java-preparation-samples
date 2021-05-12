package org.example.logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Array Rotation

 This problem is to rotate a given array to the right by n steps.

 For example:

 Given [1, 2, 3] and n = 1, you should return [3, 1, 2]

 Each step, the last element in the array is moved to the front of the array, and the rest are shifted right.

 Another example:

 Given [1, 2, 3, 4, 5] and n = 3, you should return [3, 4, 5, 1, 2]
 */
public class ArrayRotation {
    public static int[] rotateArray(int [] array, int number){
        if (number ==0)
            return array;
        int [] swaps = new int[array.length];
        if (number ==1) {
            int last = array[array.length -1];
            for (int i=1; i< array.length ; i++) {
                swaps[array.length -i] = array[array.length -1 -i];
            }
            swaps[0] = last;
        } else {
            int [] temArray = new int [number];
            for (int i=0; i< number; i++) {
                temArray[i] = array[array.length -1-i];
            }
            for (int i=1; i<= array.length - number ; i++) {
                swaps[array.length -i] = array[array.length -number -i];
            }
            for (int i=0; i<= number-1; i++) {
                swaps[i] = temArray[number -i -1];
            }
        }
        return swaps;
    }

    //Given [1, 2, 3, 4, 5] and n = 3, you should return [3, 4, 5, 1, 2]
    public int [] java8Rotation(int [] array, int k){
        // how do we do that !!!!
        List<Integer> kLimits = Arrays.stream(array).limit(k).mapToObj(i -> (int)i).collect(Collectors.toList());
        List<Integer> toCollect = Arrays.stream(array).skip(k).mapToObj(i -> (int)i).collect(Collectors.toList());
        toCollect.addAll(kLimits);
        return toCollect.stream().mapToInt(c -> (int)c).toArray();
    }

    public static void main(String args[]){
        int[] data = new int[] {1, 2, 3, 4, 5};
        int[] swaps = rotateArray(data, 2);
        Arrays.stream(swaps).forEach(System.out::print);
        System.out.println("-----------------------------");
        int[] swaps1 = rotateArray(data, 2);
        Arrays.stream(swaps1).forEach(System.out::print);
    }
}

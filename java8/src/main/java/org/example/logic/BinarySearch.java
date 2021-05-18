package org.example.logic;

import java.util.Arrays;

public class BinarySearch {
    // binary Search

    public static int search(int [] array, int start, int end, int value) {
        // order the array
        Arrays.sort(array);
        // devide the search
        // find the mean
        if (start <= end) {
            if (array == null) {
                return 0;
            }

            int mean = start + (end - start) / 2;

            if (array[mean] == value)
                return mean;

            if (array[mean] < value) {
                return search(array, mean + 1, end, value);
            }
            return search(array, start,mean - 1, value);
        }
        // Zero not considered
        return 0;
    }

    public static void main(String [] args ) {
        int aa [] = new int [] {3,4,5,6,7,8,9,10} ;
        int size = aa.length -1;
        int v = 7;
        int results = search(aa, 0,size, v);
        System.out.println("results="+results);
    }

}

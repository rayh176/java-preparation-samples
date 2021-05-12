package org.example.general;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int [] removeDuplicates(int [] array){
        return Arrays.stream(array).distinct().toArray();
    }

    public static void main(String [] args){
        int [] array = new int[] {1,1,2,3,4,5,6,6,7,8,9};
        array = removeDuplicates(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}

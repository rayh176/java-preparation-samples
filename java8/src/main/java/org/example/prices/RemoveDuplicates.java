package org.example.prices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {

    static void removeDuplicateNumbers(int [] array){
        // remove duplicate
        Arrays.stream(array);

        for (int i=0; i< array.length; i++){
            int value = array[i];
            for(int j= i+ 1; j < array.length; j++){
                if(value == array[j]) {
                    array[j] = 0;
                }
            }
        }
        System.out.print("New array"+array.toString());
    }

    static int [] removeDuplicateWithJava8(int [] array){

        List<Integer> ints =  Arrays.stream(array).boxed().distinct().collect(Collectors.toList());
        return ints.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int [] data = new int [] {4,5,6,78,9,7, 6,4,9};
        //Arrays.binarySearch()
	    // write your code here
        Arrays.sort(data);
        System.out.println(data[0]);

        removeDuplicateNumbers(data);
    }
}

package org.example.general;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveElementsInArray {

    //private static int [] data = new int [] {1,2,3,4,5,6,7,8,9};

    @ParameterizedTest
    @MethodSource("arrayInfo")
    public void testMoveElements(int n, int [] data){
        // create temp array
        List<Integer> tnpList = Arrays.stream(data).limit(n).boxed().collect(Collectors.toList());
        List<Integer> newList = Arrays.stream(data).boxed().skip(n).collect(Collectors.toList());
        newList.addAll(tnpList);
        Object[] rr = newList.toArray();
        Arrays.stream(rr).forEach(r -> System.out.println("rr="+r));

    }

    private static Stream<Arguments> arrayInfo(){
        return Stream.of(Arguments.of(3, new int [] {1,2,3,4,5,6,7,8,9}));
    }
}

package org.example.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneralLogic {
    /*
     * Complete the 'rodOffcut' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY lengths as parameter.
     */

    public static List<Integer> rodOffcut(List<Integer> lengths) {
        // Write your code here

        List<Integer> results = new ArrayList<>();

        // find the first length
        int low = lengths.size();
        results.add(low);
        List<Integer> newLengths = lengths;

        while (low > 1) {
            int min = findMin(newLengths);
            newLengths = newLengths.stream().map(v -> v - min).filter( i -> i >0).collect(Collectors.toList());
            int ll = newLengths.size();
            if (ll == 0){
                break;
            }

            results.add(ll);
            low = ll;
        }

        return results;

    }


    private static int findMin(List<Integer> lengths) {
        return lengths.stream().sorted().min(Integer::compareTo).get();
    }

    public static int addNumbers(float a, float b) {
        // Write your code here
        BigDecimal aBig = BigDecimal.valueOf(a).setScale(2, RoundingMode.FLOOR);
        BigDecimal bBig = BigDecimal.valueOf(b).setScale(2, RoundingMode.FLOOR);

        return aBig.add(bBig).intValue();
    }

    public static void print(int n){
        List<Object> dd = IntStream.rangeClosed(1, n).
                mapToObj(i -> (i % 3 == 0 && i % 5 ==0 ? "FizzBuzz" :  (i % 3 == 0 ? "Fizz" :  (i % 5 ==0 ?"Buzz" : i+"") ))).collect(Collectors.toList());
        dd.forEach(System.out::println);
    }

    private static void addNumber(int num) {
        num++;
    }

    private static void addString(String v) {
        v = v + "vvvvvv";
    }

    public static void main(String [] args ) {

        print(15);

        int v = addNumbers(2.3f, 1.9f);

        System.out.println("res-"+v);

        List<Integer> vv= new ArrayList<>();
        vv.add(6);
        vv.add(5);
        vv.add(4);
        vv.add(4);
        vv.add(2);
        vv.add(2);
        vv.add(8);

        List<Integer> rr = rodOffcut(vv);
        rr.stream().forEach(System.out::println);

        // check value
        int a = 1;
        addNumber(a);
        System.out.println(a);
        String d = "delta";
        addString(d);
        System.out.println(d);
        String b = "viva" + " la" + " Roda";
        String c = "viva la Roda";
        if (b == c ) {
            System.out.println("Same references");
        }
        if (b.equals(c)){
            System.out.println("same equals");
        }

        boolean bb = true;

        if (bb = false) {
            System.out.println("BB received a new value");
        }

        boolean cc = false;

        if (cc = true) {
            System.out.println("CC received a new value");
        }
    }
}

package org.example.logic;
import javax.xml.stream.events.Characters;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
    public static int makeAnagram(String a, String b) {
        // Write your code here
        // Change the two strings to array of characters
        char[] charsA = a.toCharArray();

        Long vv = a.chars().mapToObj( c1-> (char)c1).map(d1 -> {
            return b.chars().mapToObj( c2-> (char)c2).filter(d2 -> (d1 == d2)).count();
        }).filter(f -> f != 0).count();

        return charsA.length - vv.intValue();
    }

}

public class AnagramStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        System.out.println("RESULTS======"+res);

        bufferedReader.close();
    }
}

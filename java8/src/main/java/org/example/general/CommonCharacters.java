package org.example.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Sample Input 3
 *
 * ABCDEF
 * FBDAMN
 * Sample Output 3
 *
 * 2
 * Explanation 3
 * BD is the longest child of the given strings.
 */
public class CommonCharacters {

    public static String compare(String a, String b) {
        if (a == null || b == null)
            return null;
        IntStream streama = a.chars();
        IntStream streamb = b.chars();

        Iterator<Character> iA = streama.mapToObj(c -> (char)c).iterator();
        Iterator<Character> iB = streamb.mapToObj(c -> (char)c).iterator();
        List<Character> rr = new ArrayList<>();
        while (iA.hasNext()) {
            final Character value = iA.next();
            List<Character>  tmprr =    b.chars().mapToObj(c -> (char)c).
                                        filter(dd ->  dd.compareTo(value) == 0
                                        ).
                                        collect(Collectors.toList());
            rr.addAll(tmprr);
        }
        rr.forEach(System.out::println);
        return String.valueOf(rr.stream().mapToInt(c -> (char)c).toArray());
    }

    public static void main(String args []){
        compare("ABCDEF", "FBDAMN");
    }
}

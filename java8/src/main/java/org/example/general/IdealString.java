package org.example.general;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Sample Input
 * 5
 * BEECCCC
 * CIOOIO
 * FEDEED
 * DIFFFI
 * BUHUHH
 * Sample output
 * Yes, BEECCCC is an ideal string.
 * Yes, CIOOIO is an ideal string.
 * No, FEDEED is not an ideal string.
 * Yes, DIFFFI is an ideal string.
 * Yes, BUHUHH is an ideal string.
 */
public class IdealString {

    public boolean checkValue(String data){
        // Get the first three characters
        char[] cc = data.toCharArray();

        long r1 = data.chars().mapToObj(c -> (char)c).filter(d -> d.charValue() == cc[0]).count();
        if (r1 != 1) {
            return false;
        }
        long r2 = data.chars().mapToObj(c -> (char)c).filter(d -> d.charValue() == cc[1]).count();
        if (r2 != 2) {
            return false;
        }

//        Map<Character, Long> results = data.chars().mapToObj(a -> (char)a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Optional<Long> rr = results.values().stream().limit(1).findFirst();
//        if (rr.isPresent()) {
//            if (rr.get().intValue() == 1) {
//                Optional<Long> rr1 = results.values().stream().skip(1).limit(1).findFirst();
//                if (rr1.isPresent()) {
//                    return rr1.get().intValue() == 2;
//                }
//            }
//        }
        return true;
    }
}

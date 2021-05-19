package org.example.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * Sample Case 1:
 * The binary representation of  is , so the maximum number of consecutive 's is .
 *
 * Sample Case 2:
 * The binary representation of  is , so the maximum number of consecutive 's is .
 */
public class BinaryRepresentation {
    static final int ONE = 1;
    static final int ZERO = 0;

    public static Map.Entry<Integer, Integer>  countNumbers(int number) {
        // convert to binary
        String values = Integer.toBinaryString(number);

        char[] cc =values.toCharArray();
        int v = (int) cc[0];

        System.out.println("v value="+v);

        Map<Integer, Integer> highestResults = new HashMap<>();
        Map<Integer, Integer> tmpResults = new HashMap<>();

        int previous = -1;
        for (int i=0; i< cc.length; i++) {
            if ( cc[i] == '1' ) {
                if (previous == 1) {
                    tmpResults.put(1, tmpResults.get(1) + 1);
                } else {
                    // when switch value then restart the count
                    // compare value with internal value
                    if ((tmpResults.get(0) != null ? tmpResults.get(0) : 0) > (highestResults.get(0) != null ? highestResults.get(0) :0)) {
                        highestResults.put(0, tmpResults.get(0));
                    }
                    tmpResults.put(1,1);
                }
                previous = 1;
            } else if (  cc[i] == '0' ) {

                if (previous == 0) {
                    tmpResults.put(0, tmpResults.get(0) + 1);
                } else {
                    // when switch value then restart the count
                    // compare value with internal value
                    if ((tmpResults.get(1) != null ? tmpResults.get(1) : 0) > (highestResults.get(1) != null ? highestResults.get(1) : 0)) {
                        highestResults.put(1, tmpResults.get(1));
                    }
                    //reset the counter
                    tmpResults.put(0, 1);
                }
                previous = 0;
            }
        }
        // TODO replace with Comparator.comparing
        return highestResults.entrySet().stream().max( (e1, e2) -> e1.getValue().compareTo(e2.getValue())).get();

    }

    public static void main(String args []) {
        Map.Entry<Integer, Integer> rr = countNumbers(5);
        System.out.println("5 value has, key="+ rr.getKey() + ", value="+rr.getValue());
        Map.Entry<Integer, Integer> rr1 = countNumbers(125);
        System.out.println("125 value has, key="+ rr1.getKey() + ", value="+rr1.getValue());
    }
}

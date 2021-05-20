package org.example.general;

import java.util.Scanner;
import java.util.Stack;

/**
 * Input Format
 *
 * There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.
 *
 * The part of the code that handles input operation is already provided in the editor.
 *
 * Output Format
 *
 * For each case, print 'true' if the string is balanced, 'false' otherwise.
 *
 * Sample Input
 *
 * {}()
 * ({()})
 * {}(
 * []
 * Sample Output
 *
 * true
 * true
 * false
 * true
 */
public class BalancedString {

    public boolean checkValueMatchAfterAnother(String entry){
        return false;
    }

    public boolean checkEndValuesMatch(String entry){
        return false;
    }

    private static boolean matchParenthisis(String str) {
        Stack<Character> st = new Stack<Character>();
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
            } else {
                if (c == ']' && !st.isEmpty() && st.pop() == '[') {
                    continue;
                } else if (c == '}' && !st.isEmpty() && st.pop() == '{') {
                    continue;
                } else if (c == ')' && !st.isEmpty() && st.pop() == '(') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            System.out.println(matchParenthisis(s));
        }
        in.close();
    }
}

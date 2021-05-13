package org.example.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class MainRunner {
    static class MyMath {
        public static boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        public void isPrimeOrOddEvenOrPalindrome(int noOfCases, final int[][] cases) {

            for (int counter = 0; counter < noOfCases; counter++) {

                switch (cases[counter][0]) {
                    case 1:
                        isOdd(cases[counter][1]);
                        break;
                    case 2:
                        isPrime(cases[counter][1]);
                        break;
                    case 3:
                        palindromes(cases[counter][1]);
                        break;
                    default:
                        throw new IllegalArgumentException("Operation not supported");
                }

            }
        }

        private boolean isPrime(int value) {
            int m = value / 2;
            if (value == 1) {
                return false;
            }
            Long r = IntStream.range(2, m).filter(v -> v % 2 != 0).count();
            if (r == 0) {
                return true;
            }
            return false;
        }

        private boolean isOdd(int value) {
            Long r = IntStream.of(value).filter(v -> v % 2 != 0).count();
            if (r == 0) {
                return false;
            }
            return true;
        }

        private boolean palindromes(int value) {
            final String ss = Integer.toString(value);
            final char[] cc = ss.toCharArray();
            int length = cc.length;

            //find mean
            int mean = length / 2;
            int lo = 0;
            int high = length - 1;
            boolean isPal = true;
            for (int i = 0; i < mean; i++) {

                if (cc[lo++] != cc[high--]) {
                    isPal = false;
                    break;
                }
            }
            return isPal;
        }

        public PerformOperation isPalindrome() {
            return PerformOperation.PALINDROME;
        }

        public PerformOperation isPrime() {
            return PerformOperation.PRIME;
        }

        public PerformOperation isOdd() {
            return PerformOperation.ODD;
        }


    }
//    public static void main(String args []) {
//        int [][] cases = new int [][] {{1,4}, {2,5}, {3, 89598}, {1,3}, {2,12}};
//        isPrimeOrOddEvenOrPalindrome(5, cases);
//
//    }

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }

    public enum PerformOperation {
        ODD,
        PRIME,
        PALINDROME;

        public boolean check(int num) {
            switch(this) {
                case ODD:
                    return isOdd(num);
                case PRIME:
                    return isPrime (num);
                case PALINDROME:
                    return palindromes(num);
                default:
                    throw new IllegalArgumentException();
            }
        }

        private boolean isPrime(int value) {
            int m = value / 2;
            if (value == 1) {
                return false;
            }
            Long r = IntStream.range(2, m).filter(v -> v % 2 != 0).count();
            if (r == 0) {
                return true;
            }
            return false;
        }

        private boolean isOdd(int value) {
            Long r = IntStream.of(value).filter(v -> v % 2 != 0).count();
            if (r == 0) {
                return false;
            }
            return true;
        }

        private boolean palindromes(int value) {
            final String ss = Integer.toString(value);
            final char[] cc = ss.toCharArray();
            int length = cc.length;

            //find mean
            int mean = length / 2;
            int lo = 0;
            int high = length - 1;
            boolean isPal = true;
            for (int i = 0; i < mean; i++) {

                if (cc[lo++] != cc[high--]) {
                    isPal = false;
                    break;
                }
            }
            return isPal;
        }
    };
}
package org.example.logic;

import java.util.Scanner;

/**
 * Sample Input
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 *
 * 19
 *
 * Explanation
 *
 *  contains the following hourglasses:
 *
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   1       0       0       0
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *
 * 0 1 0   1 0 0   0 0 0   0 0 0
 *   1       1       0       0
 * 0 0 2   0 2 4   2 4 4   4 4 0
 *
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   0       2       4       4
 * 0 0 0   0 0 2   0 2 0   2 0 0
 *
 * 0 0 2   0 2 4   2 4 4   4 4 0
 *   0       0       2       0
 * 0 0 1   0 1 2   1 2 4   2 4 0
 * The hourglass with the maximum sum () is:
 *
 * 2 4 4
 *   2
 * 1 2 4
 */
public class TwoDGraphDesign {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i + 2) < 6 && (j + 2) < 6) {
                    sum =  arr[i][j] + arr[i][j + 1] +
                           arr[i][j + 2] + arr[i + 1][j + 1] +
                           arr[i + 2][j] + arr[i + 2][j + 1] +
                           arr[i + 2][j + 2];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }

        }
        System.out.println(maxSum);
    }
}

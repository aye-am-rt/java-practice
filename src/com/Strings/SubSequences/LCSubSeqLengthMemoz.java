package com.Strings.SubSequences;
//
//A common point of observation to use memoization in the recursive code will be the two non-constant
// arguments
// M and N in every function call. The function has 4 arguments, but 2 arguments are constant which do not
// affect the Memoization. The repetitive calls occur for N and M which have been called previously.
// Following the
// below steps will help us to write the DP solution using memoization.
//
//        Use a 2-D array to store the computed FindLCSLengthRecursive(m, n) value at arr[m-1][n-1] as the
//        string index starts
//        from 0.
//        Whenever the function with the same argument m and n are called again, do not perform any further
//        recursive call and return arr[m-1][n-1] as the previous computation of the
//        FindLCSLengthRecursive(m, n) has already been
//        stored in arr[m-1][n-1], hence reducing the recursive calls that happen more then once.

import java.util.Arrays;

public class LCSubSeqLengthMemoz {
//
//    Time Complexity: O(N * M), where N and M is length of the first and second string respectively.
//    Auxiliary Space: (N * M)
    static final int maximum = 1000;

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m][maximum];
        // assign -1 to all positions
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("Length of LCS: " + FindLCSLengthRecursive(X, Y, m, n, dp));
    }

    // Returns length of LCS for X[0..m-1], Y[0..n-1] */
    // memoization applied in recursive solution
    static int FindLCSLengthRecursive(String X, String Y, int m, int n, int[][] dp) {
        // base case
        if (m == 0 || n == 0) {
            return 0;
        }
        // if the same state has already been computed
        if (dp[m - 1][n - 1] != -1) {
            return dp[m - 1][n - 1];
        }
        // if equal, then we store the value of the function call
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // store it in arr to avoid further repetitive work in future function calls
            dp[m - 1][n - 1] = 1 + FindLCSLengthRecursive(X, Y, m - 1, n - 1, dp);

        }
        else
        {
            // store it in arr to avoid further repetitive work in future function calls
            dp[m - 1][n - 1] = Math.max( FindLCSLengthRecursive(X, Y, m, n - 1, dp),
                    FindLCSLengthRecursive(X, Y, m - 1, n, dp));
        }

        return dp[m - 1][n - 1];
    }
}

package com.DPS;
/*
Number of ways to write N as a sum of K non-negative integers
Given two positive integers N and K, the task is to count the number of ways to write N as a sum of
 K non-negative integers.

Examples:

Input: N = 2, K = 3
Output: 6
Explanation:
The total ways in which 2 can be split into K non-negative integers are:
1. (0, 0, 2)
2. (0, 2, 0)
3. (2, 0, 1)
4. (0, 1, 1)
5. (1, 0, 1)
6. (1, 1, 0)*/

public class NumAsSumOfK_ways {
    public static void main(String[] args)
    {
        int n = 2;
        int k=3;

        System.out.print(countWaysNAsSumOfK(n, k));
    }

    private static int countWaysNAsSumOfK(int n, int k) {
// dp[K+1][N+1] where rows corresponds to the number of element we pick and columns
// corresponds to the corresponding sum.
        int[][] dp=new int[k+1][n+1];
        // Only 1 way to choose the value with sum K
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
            if(i!=0)
                dp[1][i]+=dp[1][i-1];
        }
        int sum;
        for (int i = 2; i < (k+1); i++) {
            for (int j = 0; j < (n+1); j++) {
                // Condition for first column
                if (j == 0)
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                    // If reach the end, then return the value
                    if (i == k && j == n) {
                        return dp[i][j];
                    }
                    // Update at current index
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[k][n];
    }
}

package com.Arrays;

import java.util.Deque;
import java.util.LinkedList;

/**Printing Items in 0/1 Knapsack
 Given weights and values of n items, put these items in a knapsack of capacity W to get
 the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1]
 and wt[0..n-1] which represent values and weights associated with n items respectively. Also given
 an integer W which represents knapsack capacity, find out the items such that sum of the weights of
 those items of given subset is smaller than or equal to W. You cannot break an item, either pick the
 complete item, or don’t pick it (0-1 property).

 Prerequisite : 0/1 Knapsack

 Examples :
 Input : val[] = {60, 100, 120};
 wt[] = {10, 20, 30}; W = 50;
 Output : 220 //maximum value that can be obtained
 30 20 //weights 20 and 30 are included.

 Input : val[] = {40, 100, 50, 60};
 wt[] = {20, 10, 40, 30};
 W = 60;
 Output : 200
 30 20 10
 *
 * Start backtracking from K[n][W].Here K[n][W] is 9.

Since, this value comes from the top (shown by grey arrow), the item in this row is not included.
 Go vertically upward in the table without including this in the knapsack. Now, this
 value K[n-1][W] which is 9 doesn’t come from the top which means the item in this row is included
 and go vertically up and then left by the weight of the included item ( shown by black arrow).
 Continuing this process include weights 3 and 4 with total value 9 in the knapsack.*/

public class PrintingKnapsack01 {
    public static void main(String[] args)
    {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        printKnapsack01(W, wt, val, n);
    }

    private static void printKnapsack01(int wMax, int[] wtsArray, int[] valArray, int ln) {
        int[][] dp = new int[ln+1][wMax+1];
        for (int i = 0; i < (ln+1); i++) {
            for (int w = 0; w < (wMax + 1); w++) {
                if(i==0 || w==0)
                    dp[i][w]=0;
                else if(wtsArray[i-1]<= w)
                    dp[i][w] = Math.max( valArray[i-1]+dp[i-1][w-wtsArray[i-1]] , dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }

        int res = dp[ln][wMax];
        System.out.println("max profit possible = "+ res);
        System.out.print("picked up (weights,values) are =>>> ");
        int j = wMax;
        for (int i = ln; i>0 && res>0; i--) {
            // either the result comes from the top (K[i-1][w]) or from (val[i-1] + K[i-1]
            // [w-wt[i-1]]) as in Knapsack table. If it comes from the latter one/ it means
            // the item is included.
            if(res != dp[i-1][j] )
            {
                System.out.print("(wt= "+wtsArray[i-1]+", val= "+ valArray[i-1]+")  ");
                // Since this weight is included its value is deducted
                res = res - valArray[i-1];
                j = j - wtsArray[i-1];
            }
        }
    }
}

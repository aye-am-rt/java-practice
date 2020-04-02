package com.practiceTab2;

/*Convert N to M with given operations using dynamic programming
        Given two integers N and M and the task is to convert N to M with the following operations:

        Multiply N by 2 i.e. N = N * 2.
        Subtract 1 from N i.e. N = N – 1.*/

import java.util.Arrays;

/**
Approach: Create an array dp[] of size MAX = 105 + 5 to store the answer in order to prevent same
 computation again and again and initialize all the array elements with -1.

        If N ≤ 0 or N ≥ MAX means it can not be converted to M so return MAX.
        If N = M then return 0 as N got converted to M.
        Else find the value at dp[N] if it is not -1, it means it has been calculated
            earlier so return dp[N].
        If it is -1 then will call the recursive function as 2 * N and N – 1 and return the the
            minimum because if N is odd then it can be reached only by performing N – 1 operations
            and if N is even then 2 * N operations have to be performed so check both the possibilities
            and return the minimum.*/

public class NtoMDP {


    // Driver Code
    static final int N_MAX = 10000;
    static int n, m;
    static int[] dp = new int[N_MAX];
    public static void main(String[] args)
    {
        n = 4;
        m = 6;
        Arrays.fill(dp, -1);
        System.out.println(minOpsNtoMConversion(n));
    }

    private static int minOpsNtoMConversion(int k) {
        if(k <= 0 || k > N_MAX || k>m)
            return 1000000000;
        if(k==m)
            return 0;

        if(dp[k]!=-1)
            return dp[k];
        dp[k] = 1000000000;

        dp[k]=1+Math.min(minOpsNtoMConversion(2*k),minOpsNtoMConversion(k-1));

        return dp[k];
    }
}

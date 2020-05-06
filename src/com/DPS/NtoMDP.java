package com.DPS;

/*Convert N to M with given operations using dynamic programming
        Given two integers N and M and the task is to convert N to M with the following operations:

        Multiply N by 2 i.e. N = N * 2.
        Subtract 1 from N i.e. N = N – 1.*/

import java.util.Arrays;

/**
Approach: Create an array dp[] of size MAX = 10^5 + 5 to store the answer in order to prevent same
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
        System.out.println(minStepsToConvertGivenConditions(n,m));
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
/**   2nd method =================
The idea is to reverse the problem as follows: We should get the number N starting from M using the
 operations:

Divide the number by 2 if it is even.
Add 1 to the number.
Now, the minimum number of operations would be:

If N > M, return the difference between them, that is, number of steps will be adding 1 to M
 until it becomes equal to N.
Else if N < M.
Keep dividing M by 2 until it becomes less than N. If M is odd, add 1 to it first and then divide
 by 2. Once M is less than N, add the difference between them to the count along with the count
 of above operations.*/


    private static int minStepsToConvertGivenConditions(int first, int toSecond) {
        int ans= 0;
        while(toSecond>first)
        {
            if(toSecond % 2 == 1)  // sec num is odd or (toSecond & 1)==1  is also same.
            { toSecond++; }
            else
            { toSecond/=2; }

            ans++;
        }
        return (ans+ first - toSecond);
    }
}

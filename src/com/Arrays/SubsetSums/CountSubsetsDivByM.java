package com.Arrays.SubsetSums;

/*Number of subsets with sum divisible by M | Set 2
Given an array arr[] of N integers and an integer M, the task is to find the number of
non-empty subsequences such that the sum of the subsequence is divisible by M.

Examples:

Input: arr[] = {1, 2, 3}, M = 1
Output: 7
Number of non-empty subsets of this array are 7.
Since m = 1, m will divide all the possible subsets.

Approach: A dynamic programming based approach with O(N * SUM) time complexity where N is
 the length of the array and SUM is the sum of all the array elements has been discussed
 in this article.

In this article, an improvement over the previous approach will be discussed. Instead of the
sum as one of the states of DP, (sum % m) will be used as one of the states of the DP as
it is sufficient. Thus, the time complexity boils down to O(m * N).
Recurrence relation:

dp[i][curr] = dp[i + 1][(curr + arr[i]) % m] + dp[i + 1][curr]

Let’s define the states now, dp[i][curr] simply means number of subsets of the
 sub-array arr[i…N-1] such that (sum of its element + curr) % m = 0.

*/

public class CountSubsetsDivByM {
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 3, 3, 3, 3 };
        int n = arr.length;
        int m = 6;
        System.out.println(findCntWhereSumDivByM(arr, 0, 0, n, m) - 1);
    }
    static int maxN = 20;
    static int maxM = 10;
    // To store the states of DP
    static int [][]dp = new int[maxN][maxM];
    static boolean [][]v = new boolean[maxN][maxM];
    private static int findCntWhereSumDivByM(int[] arr, int currI, int currM, int ln, int m) {
        if(currI==ln)
        {
            if(currM==0)
            { return 1; }
            else
            { return 0; }
        }
        // If the state has been solved before return the value of the state
        // MEMOIZATION
        if (v[currI][currM])
            return dp[currI][currM];

        // Setting the state as solved
        v[currI][currM] = true;

        dp[currI][currM] =  findCntWhereSumDivByM(arr, currI+1, currM, ln, m)
                +findCntWhereSumDivByM(arr, currI+1, (currM+arr[currI])%m, ln, m);
        return dp[currI][currM];
    }
}

package com.Arrays.SubsetSums;
/*
Count of subsets with sum equal to X
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with
sum equal to X.
Examples:
Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3}, {1, 2, 3} and {3, 3}
Input: arr[] = {1, 1, 1, 1}, X = 1
Output: 4*/

/**
Approach: A simple approach is to solve this problem by generating all the possible subsets and then
 checking whether the subset has the required sum. This approach will have exponential time
 complexity. However, for smaller values of X and array elements, this problem can be solved using
 dynamic programming.
        Let’s look at the recurrence relation first.

        dp[i][C] = dp[i + 1][C – arr[i]] + dp[i + 1][C]

        Let’s understand the states of the DP now. Here, dp[i][C] stores the number of subsets of
 the sub-array arr[i…N-1] such that their sum is equal to C.
        Thus, the recurrence is very trivial as there are only two choices i.e. either consider the
 ith element in the subset or don’t.*/

public class CountSubSetsGivenSumDP {
    public static void main(String []args)
    {
        int[] arr = { 3, 3, 3, 3 };
        int n = arr.length;
        int x = 6;
        System.out.println(findCountOfSubsetsWithSum(arr, 0, x, n));
    }

    static int maxN = 20;
    static int maxSum = 50;
    static int minSum = 50;
    static int base = 50;

    // To store the states of DP
    static int [][]dp = new int[maxN][maxSum + minSum];
    static boolean [][]v = new boolean[maxN][maxSum + minSum];

    // Function to return the required count
    private static int findCountOfSubsetsWithSum(int []arr, int i, int required_sum, int n)
    {
        if (i == n)
        {
            if (required_sum == 0)
                return 1;
            else
                return 0;
        }

        // If the state has been solved before
        // return the value of the state
        if (v[i][required_sum + base])
            return dp[i][required_sum + base];

        // Setting the state as solved
        v[i][required_sum + base] = true;

        // Recurrence relation
        dp[i][required_sum + base] =
                findCountOfSubsetsWithSum(arr, i + 1, required_sum, n) +
                        findCountOfSubsetsWithSum(arr, i + 1, required_sum - arr[i], n);
        return dp[i][required_sum + base];
    }
}

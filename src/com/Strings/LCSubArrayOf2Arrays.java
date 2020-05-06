package com.Strings;

import java.util.Arrays;

/**
Longest common subArray in the given two arrays
Given two arrays A[] and B[] of N and M integers respectively, the task is to find the maximum
 length of equal subArray or the longest common subArray between the two given array.

Examples:

Input: A[] = {1, 2, 8, 2, 1}, B[] = {8, 2, 1, 4, 7}
Output: 3
Explanation:
The subArray that is common to both arrays are {8, 2, 1} and the length of the subArray is 3.

Input: A[] = {1, 2, 3, 2, 1}, B[] = {8, 7, 6, 4, 7}
Output: 0
Explanation:
There is no such subArrays which are equal in the array A[] and B[].

Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Naive Approach: The idea is to generate all the subArrays of the two given array A[] and B[] and
 find the longest matching subArray. This solution is exponential in terms of time complexity.

Time Complexity: O(2N+M), where N is the length of the array A[] and N is the length of the array B[].

Efficient Approach:
The efficient approach is to use Dynamic Programming(DP). This problem is the variation of the
 Longest Common Subsequence(LCS).
Let the input sequences are A[0..n-1] and B[0..m-1] of lengths m & n respectively. Following is the
 recursive implementation of the equal subArrays:

Since common subArray of A[] and B[] must start at some index i and j such that A[i] is equals to
 B[j]. Let dp[i][j] be the longest common subArray of A[i…] and B[j…].
Therefore, for any index i and j, if A[i] is equals to B[j], then dp[i][j] = dp[i+1][j+1] + 1.
The maximum of all the element in the array dp[][] will give the maximum length of equal subArrays.
For Example:
If the given array A[] = {1, 2, 8, 2, 1} and B[] = {8, 2, 1, 4, 7}. If the characters match at
 index i and j for the array A[] and B[] respectively, then dp[i][j] will be updated as
 1 + dp[i+1][j+1].
Below is the updated dp[][] table for the given array A[] and B[].
*/


public class LCSubArrayOf2Arrays {
    // Driver's Code
    public static void main(String[] args)
    {
        int[] A ={1, 2, 8, 2, 1};
        int[] B ={8, 2, 1, 4, 7};
        int n = A.length;
        int m = B.length;
        System.out.print(FindMaxLengthCommonSubArray(A, B, n, m));
        System.out.println("\n"+(1<<10)); // just checking something left sfift.
        // Time Complexity: O(N*M), where N is the length of array A[] and M is the length of
        // array B[]
    }

    private static int FindMaxLengthCommonSubArray(int[] ar1, int[] ar2, int ln1, int ln2) {
        int[][] dp = new int[ln1+1][ln2+1];
        for (int i = 0; i < ln1; i++) {
            Arrays.fill(dp[i],0);
        }
        int maxLen=0;
        // Updating the dp[][] table in Bottom Up approach
        for (int i = (ln1-1); i > -1; i--) {
            for (int j = (ln2-1); j > -1; j--) {
                if(ar1[i]==ar2[j])
                    dp[i][j] = 1 + dp[i+1][j+1];
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }// Time Complexity: O(N*M), where N is the length of array A[] and M is the
        // length of array B[]
        return maxLen;
    }

}

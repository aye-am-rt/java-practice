package com.Arrays.AmazonSubSeq;

import java.util.Arrays;

/**

Longest subsequence such that adjacent elements have at least one common digit
Given an array arr[] of N integers, the task is to find the length of the longest sub-sequence such
 that adjacent elements of the sub-sequence have at least one digit in common.

Examples:

Input: arr[] = {1, 12, 44, 29, 33, 96, 89}
Output: 5
The longest sub-sequence is {1 12 29 96 89}

Input: arr[] = {12, 23, 45, 43, 36, 97}
Output: 4
The longest sub-sequence is {12 23 43 36}

Approach: The idea is to store the length of longest sub-sequence for each digit present in an
 element of the array.

dp[i][d] represents the length of the longest sub-sequence up to ith element if digit d is the common
 digit.
Declare a cnt array and set cnt[d] = 1 for each digit present in current element.
Consider each digit d as common digit and find maximum length sub-sequence ending at arr[i] as
 dp[i][d] = max(dp[j][d]+1) (0<=j<i).
Also find a local maximum max(dp[i][d]) for current element.
After finding local maximum update dp[i][d] for all digits present in the current element to a local
 maximum.
This is required as local maximum represents maximum length sub-sequence for an element having digit
 d.
E.g. Consider arr[] = {24, 49, 96}.
The local maximum for 49 is 2 obtain from digit 4.
This local maximum will be used in finding the local maximum for 96 with common digit 9.
For that it is required for all digits in 49, dp[i][d] should be set to local maximum.

*/
//
//The auxiliary space required for above solution can be further reduced. Observe that for each
// digit d present in arr[i], it is required to find maximum length sub-sequence upto that digit
// irrespective of the fact that at which element the sub-sequence end. This reduces auxiliary space
// required to O(1). For each arr[i], find local maximum and update dig[d] for each digit d in arr[i]
// to local maximum.


//Time Complexity: O(n)
//Auxiliary Space: O(1)
public class LongestSubSeqAdjacent1ComDigit {
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 1, 12, 44, 29, 33, 96, 89 };
        int n = arr.length;
        System.out.print(findSubsequenceLongComAdjacent(arr, n));
    }

    private static int findSubsequenceLongComAdjacent(int[] arr, int n) {
        // To store length of maximum length subsequence
        int len = 1;
        // To store current element arr[i]
        int tmp;
        int i, d;
        // To store length of subsequence
        // having common digit d
        int[] dp = new int[10];
        // To store digits present in current element
        int[] cnt = new int[10];

        // To store local maximum for current element
        int locMax;
        // For first element maximum length is 1 for
        // each digit
        tmp = arr[0];
        while (tmp > 0)
        {
            dp[tmp % 10] = 1;
            tmp /= 10;
        }
        // Find digits of each element, then find length
        // of subsequence for each digit and then find
        // local maximum
        for (i = 1; i < n; i++)
        {
            tmp = arr[i];
            locMax = 1;
            Arrays.fill(cnt, 0);
            // Find digits in current element
            while (tmp > 0)
            {
                cnt[tmp % 10] = 1;
                tmp /= 10;
            }
            // For each digit present find length of
            // subsequence and find local maximum
            for (d = 0; d <= 9; d++)
            {
                if (cnt[d] == 1)
                {
                    dp[d]++;
                    locMax = Math.max(locMax, dp[d]);
                }
            }
            // Update value of dp[d] for each digit
            // present in current element to local maximum
            // found
            for (d = 0; d <= 9; d++)
            {
                if (cnt[d] == 1)
                {
                    dp[d] = locMax;
                }
            }
            // Update maximum length with local maximum
            len = Math.max(len, locMax);
        }
        return len;
    }
}

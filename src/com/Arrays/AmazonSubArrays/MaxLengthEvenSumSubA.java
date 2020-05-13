package com.Arrays.AmazonSubArrays;
/*
Maximum length of subarray such that sum of the subarray is even
Given an array of N elements. The task is to find the length of the longest subarray such that sum
 of the subarray is even.
Examples:
Input : N = 6, arr[] = {1, 2, 3, 2, 1, 4}
Output : 5
Explanation: In the example the subarray
in range [2, 6] has sum 12 which is even,
so the length is 5.

Input : N = 4, arr[] = {1, 2, 3, 2}
Output : 4*/

import java.util.Arrays;

/**
Approach: First check if the total sum of the array is even. If the total sum of the array is
 even then the answer will be N.
If the total sum of the array is not even, means it is ODD. So, the idea is to find an odd element
 from the array such that excluding that element and comparing the length of both parts of the array
 we can obtain the max length of the subarray with even sum.
It is obvious that the subarray with even sum will exist in range [1, x) or (x, N],
where 1 <= x <= N, and arr[x] is ODD.*/

public class MaxLengthEvenSumSubA {
    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 2};
        int n = a.length;
        System.out.println(maxLengthEvenSumAubArray(a, n));

    }

    private static int maxLengthEvenSumAubArray(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        int sum;
        int maxLen=0;
        sum = Arrays.stream(arr).sum();
        //System.out.println(sum);
        if(sum%2 == 0)
            return n;

        for (int i = 0; i < n; i++) {
            if(arr[i]%2 != 0)
                maxLen = Math.max(maxLen,Math.max(n-i-1,i));
        }
        return maxLen;
    }
}

package com.Arrays.AmazonSubArrays;
/*
Longest subarray in which all elements are greater than K
Given an array of N integers and a number K, the task is to find the length of the longest
 subarray in which all the elements are greater than K.

Examples:

Input: a[] = {3, 4, 5, 6, 7, 2, 10, 11}, K = 5
Output: 2
There are two possible longest subarrays of length 2.
They are {6, 7} and {10, 11}.

Input: a[] = {8, 25, 10, 19, 19, 18, 20, 11, 18}, K = 13
Output: 4
The longest subarray is {19, 19, 18, 20}.


The idea is to start traversing the array using a counter. If the current element is greater than
the given value X, increment the counter otherwise replace the previous length with the maximum of
 the previous length and current counter and reset the counter.*/

public class LongestSubArrayAllMoreK {
    public static void main (String[] args) {
        int[]a = { 8, 25, 10, 19, 19, 18, 20, 11, 18 };
        int n = a.length;
        int k = 13;

        System.out.println(longestSubArrayAllElementsBigK(a, n, k));
    }

    private static String longestSubArrayAllElementsBigK(int[] a, int n, int k) {
        if(n<1)
            throw new IllegalArgumentException();
        int maxLenSeen=0;
        int currCount=0;
        for (int i = 0; i < n; i++) {
            if(a[i]>k)
            {   currCount+=1;   }
            else
            {
                maxLenSeen = Math.max( maxLenSeen , currCount );
                currCount=0;
            }
        }
        if (currCount>0)
            maxLenSeen = Math.max(maxLenSeen, currCount);
        return String.valueOf(maxLenSeen);
    }
//    Time Complexity: O(N)
//    Auxiliary Space: O(1)
}

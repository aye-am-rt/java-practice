package com.Arrays.AmazonSubArrays;
/*
Number of sub-arrays having sum exactly equal to k
Given an unsorted array of integers, find the number of sub-arrays having sum exactly equal to a
 given number k.
Examples:
Input : arr[] = {10, 2, -2, -20, 10},
k = -10
Output : 3
Sub-arrays: arr[0...3], arr[1...4], arr[3..4] have sum exactly equal to -10.

Input : arr[] = {9, 4, 20, 3, 10, 5},
k = 33
Output : 2
Sub-arrays : arr[0...2], arr[2...4] have sum exactly equal to 33.*/

import java.util.HashMap;

/**An efficient solution is while traversing the array, store sum so far in currsum. Also maintain count of
 * different values of currsum in a map. If value of currsum is equal to desired sum at any instance
 * increment count of subarrays by one. The value of currsum exceeds desired sum by currsum – sum.
 * If this value is removed from currsum then desired sum can be obtained. From the map find number of
 * subarrays previously found having sum equal to currsum-sum. Excluding all those subarrays from current
 * subarray, gives new subarrays having desired sum. So increase count by the number of such subarrays.
 * Note that when currsum is equal to desired sum then also check number of subarrays previously having sum
 * equal to 0. Excluding those subarrays from current subarray gives new subarrays having desired sum.
 * Increase count by the number of subarrays having sum 0 in that case.*/

public class CountSub_SumEqualK {
    public static void main(String []args){

        int[] arr = { 10, 2, -2, -20, 10 };
        int sum = -10;
        int n = arr.length;
        System.out.print("Number of sub-arrays having sum exactly equal to k,where k is ("+sum+") =  ");
        System.out.println(findSubArraySum(arr, n, sum));
    }

    private static int findSubArraySum(int[] arr, int n, int sum) {
        // HashMap to store number of sub-arrays starting from index zero having particular value of sum.
        HashMap<Integer,Integer> prevSumMap= new HashMap<>();
        int res=0;
        int currSum=0; // Sum of elements so far.

        for (int i = 0; i < n; i++) {
            currSum+=arr[i];
            if(currSum==sum)
                res++;

            // currsum exceeds given sum by currsum - sum. Find number of sub-arrays having
            // this sum and exclude those sub-arrays from currsum by increasing count by same amount.
            if(prevSumMap.containsKey(currSum-sum))
            {
                res += prevSumMap.get(currSum-sum);
            }
            // Add currsum value to count of different values of sum.
            Integer count = prevSumMap.get(currSum);
            if(prevSumMap.get(currSum)!=null)
            {
                prevSumMap.put(currSum,count+1);
            }
            else
            {
                prevSumMap.put(currSum,1);
            }
        }

        return res;
    }
}

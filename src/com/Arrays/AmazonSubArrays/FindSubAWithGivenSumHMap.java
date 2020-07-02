package com.Arrays.AmazonSubArrays;

import java.util.HashMap;

/**
Find subarray with given sum | Set 2 (Handles Negative Numbers)
Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with the sum as the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Explantion: Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Output: Sum found between indexes 0 to 3
Explantion: Sum of elements between indices
0 and 3 is 10 + 2 - 2 - 20 = -10

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Output: No subarray with given sum exists
Explantion: There is no subarray with the given sum

 Approach: The idea is to store the sum of elements of every prefix of the array in a hashmap,
 i.e for every index store the sum of elements upto that index hashmap. So to check if there is a
 subarray with sum equal to s, check for every index i, and sum upto that index as x.
 If there is a prefix with sum equal to x – s, then the subarray with given sum is found.

 Algorithm:
 create a Hashmap (hm) to store key value pair, i.e, key = prefix sum and value = its index and a
 variable to store the current sum (sum = 0) and the sum of subarray as s

 Traverse through the array from start to end.
 For every element update the sum, i.e sum = sum + array[i]
 If sum is equal to s then print that the subarray with given sum is from 0 to i
 If there is any key in the HashMap which is equal to sum – s then print that the subarray with given
 sum is from hm[sum – s] to i
 Put the sum and index in the hashmap as key-value pair.

 */

public class FindSubAWithGivenSumHMap {
    // Driver code
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int n = arr.length;
        int sum = -10;
        PrintSubArrayGivenSum(arr, n, sum);

    }

    private static void PrintSubArrayGivenSum(int[] arr, int ln, int targetSum) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> sumAndIndexMap = new HashMap<>();

        for (int i = 0; i < ln; i++) {
            currSum += arr[i];

            if (currSum == targetSum) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already have sub-array with the sum - so stop
            if (sumAndIndexMap.containsKey(currSum - targetSum)) {
                start = sumAndIndexMap.get(currSum - targetSum) + 1;
                end = i;
                break;
            } else {
                sumAndIndexMap.put(currSum, i);
            }
        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1)
        { System.out.println("No subArray with given sum exists"); }

        else
        { System.out.println("Sum found between indexes " + start + " to " + end +" both including."); }
    }
}

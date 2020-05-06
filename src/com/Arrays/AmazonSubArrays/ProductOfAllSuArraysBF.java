package com.Arrays.AmazonSubArrays;
/**
Product of all Sub-arrays of an Array
Given an array of integers arr of size N, the task is to print products of
 all sub-arrays of the array.
Examples:

Input: arr[] = {2, 4}
Output: 64
Here, sub-arrays are [2], [2, 4], [4]
Products are 2, 8, 4
Product of all Sub-arrays = 64

Input : arr[] = {10, 3, 7}
Output : 30870
Here, sub-arrays are [10], [10, 3], [10, 3, 7], [3], [3, 7], [7]
Products are 10, 30, 210, 3, 21 and 7
Product of all Sub-arrays = 30870

Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Naive Approach: A simple solution is to generate all sub-array and compute their product.

Efficient Approach: An efficient approach is to use two loops and calculate the products while
 traversing for the sub-arrays.*/

public class ProductOfAllSuArraysBF {
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 10, 3, 7 };
        int n = arr.length;
        // Function call
        //product_subarrays(arr, n);
    }
}

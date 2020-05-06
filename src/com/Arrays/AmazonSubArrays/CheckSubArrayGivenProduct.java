package com.Arrays.AmazonSubArrays;
/*
Check if subarray with given product exists in an array
Given an array of both positive and negative integers and a number K. The task is to check if any
subarray with product K is present in the array or not.
Examples:
Input: arr[] = {-2, -1, 3, -4, 5}, K = 2
Output: YES
Input: arr[] = {3, -1, -1, -1, 5}, K = 3
Output: NO*/

public class CheckSubArrayGivenProduct {
    public static void main (String[] args)
    {
        int []arr = { 1, 2, -5, -4 };
        int product = -10;
        int n = arr.length;

        if (checkProductExistsSubArray(arr, n, product))
        {
            System.out.println( "YES");
        }
        else
            System.out.println( "NO");
    }

    private static boolean checkProductExistsSubArray(int[] arr, int n, int product) {
        // Variables to store maximum and minimum product till ith index.
        int minTill_IIndex = arr[0];
        int maxTill_IIndex = arr[0];

        int maxProduct=arr[0];

        for (int i = 1; i < n; i++) {
            if(arr[i]<0)
            {
                int temp=maxTill_IIndex;
                maxTill_IIndex=minTill_IIndex;
                minTill_IIndex=temp;
            }
            maxTill_IIndex=Math.max(arr[i] , maxTill_IIndex *arr[i]);
            minTill_IIndex=Math.min(arr[i] , minTill_IIndex *arr[i]);

            if (minTill_IIndex == product || maxTill_IIndex == product)
            { return true; }
            maxProduct=Math.max(maxProduct,maxTill_IIndex);
        }
        return false;
    }
}

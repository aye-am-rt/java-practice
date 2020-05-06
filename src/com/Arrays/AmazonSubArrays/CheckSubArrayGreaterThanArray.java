package com.Arrays.AmazonSubArrays;
/*
Check if a sub_array exists with sum greater than the given Array
Given an array of integers arr, the task is to check if there is a sub_array
(except the given array) such that the sum of its elements is greater than or equal to the sum of
elements of the given array. If no such sub_array is possible, print No, else print Yes.

Examples:
Input: arr = {5, 6, 7, 8}
Output: No
Explanation:
There isn’t any sub_array of the given array such that sum of its elements is greater than or equal
to the sum of elements of given array.
Input: arr = {-1, 7, 4}
Output: Yes
Explanation:
There exist a sub_array {7, 4} whose sum is greater than the sum of elements of given array.*/

public class CheckSubArrayGreaterThanArray {

    // Function to check whether there exists
    // a sub_array whose sum is greater than
    // or equal to sum of given array elements
    static boolean sub_arrayPossible(int[] arr, int n)
    {
        /*    // Initialize sum with 0
        int sum = 0;

        // Checking possible prefix sub_arrays.
        // If sum of them is less than or equal
        // to zero, then return 1
        for (int i = 0; i < n; i++)
            sum += arr[i];

            if (sum <= 0)
                return true;

        // again reset sum to zero
        sum = 0;

        // Checking possible suffix sub_arrays.
        // If sum of them is less than or equal
        // to zero, then return 1
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];

            if (sum <= 0)
                return true;
        }

        // Otherwise return 0
        return false;
        */

        int totalSum=0;
        int sumOfPos=0;
        for(int i=0;i<n;i++)
        {
            totalSum+=arr[i];
            if(arr[i]>0)
                sumOfPos+=arr[i];
        }
        return sumOfPos >= totalSum;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = {-5,-4,1,2};

        int size = arr.length;

        if (sub_arrayPossible(arr, size))
            System.out.print("Yes"+"\n");
        else
            System.out.print("No"+"\n");
    }
}

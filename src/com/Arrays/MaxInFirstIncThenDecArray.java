package com.Arrays;
/**
Find the maximum element in an array which is first increasing and then decreasing
Given an array of integers which is initially increasing and then decreasing, find the maximum value
 in the array.
Examples :

Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
Output: 500

Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50

Corner case (No decreasing part)
Input: arr[] = {10, 20, 30, 40, 50}
Output: 50

Corner case (No increasing part)
Input: arr[] = {120, 100, 80, 20, 0}
Output: 120

 Method 2 (Binary Search)
 We can modify the standard Binary Search algorithm for the given type of arrays.
 i) If the mid element is greater than both of its adjacent elements, then mid is the maximum.
 ii) If mid element is greater than its next element and smaller than the previous element then maximum
 lies on left side of mid. Example array: {3, 50, 10, 9, 7, 6}
 iii) If mid element is smaller than its next element and greater than the previous element then maximum
 lies on right side of mid. Example array: {2, 4, 6, 8, 10, 3, 1}

 */

public class MaxInFirstIncThenDecArray
{
    // Time Complexity : O(Logn)
    public static void main (String[] args)
    {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;
        System.out.println("The maximum element is "+ findMaximumFirstIncThenDec(arr, 0, n-1));
    }
    // Time Complexity : O(Logn)
    private static int findMaximumFirstIncThenDec(int[] arr, int low, int high)
    {
        /* Base Case: Only one element is  present in arr[low..high]*/
        if(low==high)
        { return arr[low]; }

        /* If there are two elements and first is greater.... then the first  element is maximum */
        if(high==low+1 && arr[low]>arr[high])
            return arr[low];

        /* If there are two elements and second is greater then the second element is maximum */
        if(high==low+1 && arr[low]<arr[high])
            return arr[high];

        int mid = (low+high)/2;

        if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
            return arr[mid];

        if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1])
            return findMaximumFirstIncThenDec(arr,low,mid-1);
        else
            return findMaximumFirstIncThenDec(arr,mid+1,high);
    }
    // Time Complexity : O(Logn)
}

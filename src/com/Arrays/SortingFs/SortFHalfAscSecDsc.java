package com.Arrays.SortingFs;

/*Sort first half in ascending and second half in descending order | 1
Given an array of integers, sort the first half of the array in ascending order
 and second half in descending order.
Examples:
Input : arr[] = {5, 2, 4, 7, 9, 3, 1, 6, 8}
Output : arr[] = {1, 2, 3, 4, 9, 8, 7, 6, 5}
Input : arr[] = {1, 2, 3, 4, 5, 6}
Output : arr[] = {1, 2, 3, 6, 5, 4}*/

import java.util.Arrays;

public class SortFHalfAscSecDsc {
    public static void main(String[] args)
    {
        int[] arr = { 5, 4, 6, 2, 1, 3, 8, 9, 7 };
        int n = arr.length;
        SortFHalfAscSecDscMethod1(arr, n);

    }
/**
Algorithm :
1. Sort the given array.
2. Run a loop upto half the length of the array and print the elements of the sorted array.
3. Run a loop from last index of the array to the middle of the array and print the
 elements in reverse order.*/
    private static void SortFHalfAscSecDscMethod1(int[] arr, int n) {
        Arrays.sort(arr);
        // printing first half in ascending order
        for (int i = 0; i < (n / 2); i++)
            System.out.print(arr[i]+" ");
        // printing second half in descending order
        for (int j = n - 1; j >=(n / 2); j--)
            System.out.print(arr[j]+" ");

    }
}

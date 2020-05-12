package com.Arrays.SortingFs;
/*
Sort first k values in ascending order and remaining n-k values in descending order
Given an array of size n, arrange the first k elements of the array in ascending order and the
remaining n-k elements in descending order.
Examples:
Input: arr[] = {5, 4, 6, 2, 1, 3, 8, 9, -1}, k = 4
Output: 2 4 5 6 9 8 3 1 -1
Input: arr[] = {5, 4, 6}, k = 2
Output: 4 5 6

normal idea
Algorithm:
Store the first k elements in an array and sort that in ascending order.
Store the remaining n-k elements in an array and sort that in decending order.
Merge the two arrays by adding the elements from second array in reverse order.
*/

import java.util.Arrays;
import java.util.Collections;

/**Efficient Approach: The idea is simple, sort the first k elements in increasing order and
 * remaining n-k elements in decreasing using library function.*/

public class SortFirstKAscRestDesc {

    public static void main(String[] args)
    {
        // Our arr contains 8 elements
        Integer[] arr = { 5, 4, 6, 2, 1, 3, 8, 9, -1 };
        int k = 4;
        printOrder(arr, k);
        System.out.printf("%s", Arrays.toString(arr));
    }
    static void printOrder(Integer[] arr, int k)
    {
        int n = arr.length;
        // Sort first k elements in ascending order
        Arrays.sort(arr, 0, k);
        // Sort remaining n-k elements in descending order
        Arrays.sort(arr, k, n, Collections.reverseOrder());
    }
}

package com.Arrays.GST;
/*
Find the minimum element in a sorted and rotated array
A sorted array is rotated at some unknown point, find the minimum element in it.

Following solution assumes that all elements are distinct.
Examples:

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1

A simple solution is to traverse the complete array and find minimum. This solution requires O(n) time.
We can do it in O(Logn) using Binary Search. If we take a closer look at above examples, we can
easily figure out following pattern:
*/

public class MinInSortedRotated {
    // Driver Program
    public static void main (String[] args)
    {
        int[] arr1 =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr1, 0, n1-1));

        int[] arr2 =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr2, 0, n2-1));

        int[] arr3 =  {1};
        int n3 = arr3.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr3, 0, n3-1));

        int[] arr4 =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr4, 0, n4-1));

        int[] arr5 =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr5, 0, n5-1));

        int[] arr6 =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr6, 0, n6-1));

        int[] arr7 =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr7, 0, n7-1));

        int[] arr8 =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr8, 0, n8-1));

        int[] arr9 =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ findMinInSortedRotated(arr9, 0, n9-1));
    }

    private static int findMinInSortedRotated(int[] arr, int low, int high) {
        while (low<high)
        {
            int mid = low+ (high-low)/2 ;
            if(arr[mid] == arr[high])
            {
                high--;
            }
            else if(arr[mid] > arr[high])
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        return arr[high];
    }
}

package com.Arrays.GST;

import java.util.Arrays;

/**
Search an element in a sorted and rotated array with duplicates
Given an array arr[] which is sorted and rotated, the task is to find an element in the rotated
 array (with duplicates) in O(log n) time.
Note: Print the index where the key exists. In case of multiple answer print any of them

Examples:
Input: arr[] = {3, 3, 3, 1, 2, 3}, key = 3
Output: 0
arr[0] = 3

Input: arr[] = {3, 3, 3, 1, 2, 3}, key = 11
Output: -1
11 is not present in the given array.


Approach: The idea is the same as the previous one without duplicates. The only difference is that due
 to the existence of duplicates, arr[low] == arr[mid] could be possible, the first half could be out
 of order (i.e. not in the ascending order, e.g. {3, 1, 2, 3, 3, 3, 3}) and we have to deal this case
 separately.

In that case, it is guaranteed that arr[high] also equal to arr[mid], so the condition
 arr[mid] == arr[low] == arr[high] can be checked before the original logic, and if so then move
 left and right both towards the middle by 1 and repeat.*/

public class SearchInSortedRotated {

    // Function to return the index of the key in arr[l..h] if the key is present otherwise return -1
    static int search(int[] arr, int l, int h, int key)
    {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;

        if (arr[mid] == key)
            return mid;

        // The tricky case, just update left and right
        if ((arr[l] == arr[mid]) && (arr[h] == arr[mid]))
        {
            ++l;
            --h;
        }

        // If arr[l...mid] is sorted
        if (arr[l] <= arr[mid])
        {
            // As this sub-array is sorted, we can quickly check if key lies in any of the halves
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);

            // If key does not lie in the first half sub-array then divide the other half
            // into two sub-arrays such that we can quickly check if key lies in the other half
            return search(arr, mid + 1, h, key);
        }
        // If arr[l..mid] first sub-array is not sorted then arr[mid... h] must be sorted sub-array
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }

    public static void main (String[] args)
    {
        int[] arr = { 3, 3, 1, 2, 3, 3 };
        int n = arr.length;
        int key = 3;
        System.out.print("key(target = "+key+") is present in array at index = ");
        System.out.println(search(arr, 0, n - 1, key));

        // Find the maximum and minimum element   ....... not required here but good technique
        int maxm = Arrays.stream(arr).max().getAsInt();
        int minm = Arrays.stream(arr).min().getAsInt();
        System.out.println(maxm +"     "+ minm);
    }
}

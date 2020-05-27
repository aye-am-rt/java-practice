package com.SegregateThings;

import java.util.Arrays;

/**
Rearrange an array in maximum minimum form | Set 2 (O(1) extra space)
Given a sorted array of positive integers, rearrange the array alternately i.e first element
 should be the maximum value, second minimum value, third-second max, fourth-second min and so on.
Examples:
Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
Output: arr[] = {7, 1, 6, 2, 5, 3, 4}

Input: arr[] = {1, 2, 3, 4, 5, 6}
Output: arr[] = {6, 1, 5, 2, 4, 3}

 Another Approach: A simpler approach will be to observe indexing positioning of maximum elements
 and minimum elements. The even index stores maximum elements and the odd index stores the minimum
 elements. With every increasing index, the maximum element decreases by one and the minimum element
 increases by one. A simple traversal can be done and arr[] can be filled in again.

 Note: This approach is only valid when elements of given sorted array are consecutive i.e.,
 vary by one unit.
 */

public class RearrangeMaxMinAlternate {
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int n = arr.length;
        System.out.println("Original Array");
        for (int value : arr) System.out.print(value + " ");
        System.out.print("\nModified Array\n");
        rearrangeMaxMinAlternate(arr, n);
        //for (int value : arr) System.out.print(value + " ");
    }

    private static void rearrangeMaxMinAlternate(int[] arr, int ln) {
        int[] tempArray = new int[ln];
        int minLeftIndex=0;
        int maxRightIndex=ln-1;
        // To indicate whether we need to copy rmaining largest or remaining smallest at next position
        boolean flag =true;
        for (int i = 0; i < ln; i++) {
            if(flag)
            {
                tempArray[i] = arr[maxRightIndex];
                maxRightIndex -= 1;
            }
            else
            {
                tempArray[i] = arr[minLeftIndex];
                minLeftIndex += 1;
            }
            flag = !flag;
        }
        arr = tempArray.clone();
        System.out.println(Arrays.toString(tempArray));
    }
}

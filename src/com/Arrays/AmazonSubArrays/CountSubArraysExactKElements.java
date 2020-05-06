package com.Arrays.AmazonSubArrays;

import java.util.HashMap;

/**
Count of sub-arrays having exactly K distinct elements
Given an array arr[] of size N and an integer K. The task is to find the count of sub-arrays such that
 each sub-array has exactly K distinct elements.

Examples:

Input: arr[] = {2, 1, 2, 1, 6}, K = 2
Output: 7
{2, 1}, {1, 2}, {2, 1}, {1, 6}, {2, 1, 2},
{1, 2, 1} and {2, 1, 2, 1} are the only valid sub-arrays.

Input: arr[] = {1, 2, 3, 4, 5}, K = 1
Output: 5

Approach: To directly count the sub-arrays with exactly K different integers is hard but to find the
 count of
 sub-arrays with at most K different integers is easy. So the idea is to find the count of sub-arrays
 with at most K
 different integers, let it be C(K), and the count of sub-arrays with at most (K – 1) different
 integers, let it be C
 (K – 1) and finally take their difference, C(K) – C(K – 1) which is the required answer.
Count of sub-arrays with at most K different elements can be easily calculated through the sliding
 window technique.
 The idea is to keep expanding the right boundary of the window till the count of distinct elements
 in the window is
 less than or equal to K and when the count of distinct elements inside the window becomes more than
 K, start shrinking the window from the left till the count becomes less than or equal to K. Also
 for every expansion, keep counting the sub-arrays as right – left + 1 where right and left are the
 boundaries of the current window.*/

public class CountSubArraysExactKElements {

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 2, 1, 2, 1, 6 };
        int n = arr.length;
        int k = 2;
        System.out.print(exactlyK(arr, n, k));
    }
    // Function to return the count of sub-arrays with exactly K distinct elements
    private static int exactlyK(int[] arr, int n, int k)
    {

        // Count of sub-arrays with exactly k distinct
        // elements is equal to the difference of the
        // count of sub-arrays with at most K distinct
        // elements and the count of sub-arrays with
        // at most (K - 1) distinct elements
        return (atMostKDistinctSlidingWin(arr, n, k) - atMostKDistinctSlidingWin(arr, n, k - 1));
    }

    private static int atMostKDistinctSlidingWin(int[] arr, int n, int kDistinct) {
        int count=0; int left=0; int right=0;
        // Map to keep track of number of distinct elements in the current window
        HashMap<Integer, Integer> DistElementsInCurrWindow = new HashMap<>();

        while(right<n)
        {
            // Calculating the frequency of each element in the current window
            DistElementsInCurrWindow.put( arr[right],
                    DistElementsInCurrWindow.getOrDefault(arr[right],0)+1);

            while(DistElementsInCurrWindow.size()>kDistinct)
            {
                DistElementsInCurrWindow.put( arr[left],
                        DistElementsInCurrWindow.get(arr[left])-1);
                if(DistElementsInCurrWindow.get(arr[left])==0)
                {
                    DistElementsInCurrWindow.remove(arr[left]);
                }
                left+=1;
            }
            // Adding the count of sub-arrays with at most K distinct elements in the current window
            count += (right - left + 1);
            right++;

        }  // while right < n ===== ends
        return count;
    }
}

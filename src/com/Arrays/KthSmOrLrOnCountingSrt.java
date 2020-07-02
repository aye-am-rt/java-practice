package com.Arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
Kth smallest or largest element in unsorted Array | Set 4
Given an array arr[] and a number K, where K is smaller than the size of the array, we need to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3
Output: 7

Input: arr[] = {7, 1, 5, 4, 20, 15, 8}, K = 5
Output: 8

 Approach: The idea is to use the concept of Counting Sort. Below are the steps:

 Find the maximum element(say maxE) in the array and create an array(say freq[]) of length maxE + 1
 and initialize it to zero.
 Loop through all the element in the given array and store the frequency of the element in freq[].
 Iterate over the array freq[] until we reach the Kth element.
 Print the Kth element reached in the above step.
 */
//    Time complexity: O(N) where, N is the number of element in the given array.
//    Auxiliary Space: O(M) where, M is the maximum element in the given array.

public class KthSmOrLrOnCountingSrt {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 4, 4, 20, 15, 8 };
        int N = arr.length;
        int K = 5;
        // Function Call
        System.out.println(findKthSmallest(arr, N, K));
    }
//    Time complexity: O(N) where, N is the number of element in the given array.
//    Auxiliary Space: O(M) where, M is the maximum element in the given array.
    private static int findKthSmallest(int[] arr, int ln, int kth) {
        int max = Arrays.stream(arr).max().getAsInt();

        HashMap<Integer,Integer> freqMap = new HashMap<>(max);

        int smallest = 0;
        for (int i = 0; i < ln; i++)
        {
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }
//    Time complexity: O(N) where, N is the number of element in the given array.
//    Auxiliary Space: O(M) where, M is the maximum element in the given array.
        for (int i = 1; i <= max; i++) {
            if(freqMap.containsKey(i) && freqMap.get(i)>0)
            {
                smallest += freqMap.get(i);
            }
            if(smallest >= kth)
            {
                return i;
            }
        }
        System.out.println("****** not possible ********");
        return -1;
    }
}
//    Time complexity: O(N) where, N is the number of element in the given array.
//    Auxiliary Space: O(M) where, M is the maximum element in the given array.

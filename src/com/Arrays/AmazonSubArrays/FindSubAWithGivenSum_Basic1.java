package com.Arrays.AmazonSubArrays;
/*
Find subarray with given sum | Set 1 (Nonnegative Numbers)
Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
Examples :
Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4
Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4
Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There is no subarray with 0 sum*/

//Time Complexity : O(n).
//Only one traversal of the array is required. So the time complexity is O(n).
//Space Complexity: O(1).
//As constant extra space is required.

/**Efficient Approach: There is an idea if all the elements of the array are positive. If a subarray
 *  has sum
 * greater than the given sum then there is no possibility that adding elements to the current
 * subarray the sum will be x (given sum). Idea is to use a similar approach to a sliding window.
 * Start with an empty subarray, add elements to the subarray until the sum is less than x.
 * If the sum is greater than x, remove elements from the start of the current subarray.

Algorithm:
Create three variables, l=0, sum = 0
Traverse the array from start to end.
Update the variable sum by adding current element, sum = sum + array[i]
If the sum is greater than the given sum, update the variable sum as sum = sum – array[l], and
 update l as, l++.
If the sum is equal to given sum, print the subarray and break the loop.*/

//Time Complexity : O(n).
//Only one traversal of the array is required. So the time complexity is O(n).
//Space Complexity: O(1).
//As constant extra space is required.

public class FindSubAWithGivenSum_Basic1 {
    public static void main(String[] args)
    {
        int[] arr = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 23;
        FindSubArrayGivenSum_SWindow(arr, n, sum);
    }

//Time Complexity : O(n).
//Only one traversal of the array is required. So the time complexity is O(n).
//Space Complexity: O(1).
//As constant extra space is required.

    private static int FindSubArrayGivenSum_SWindow(int[] arr, int ln, int targetSum) {
        int currSum = arr[0];
        int start = 0;

        for (int i = 1; i < ln; i++)
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while(targetSum < currSum && start < (i-1))
            {
                currSum = currSum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if(currSum==targetSum)
            {
                System.out.println("sum "+targetSum+ " is found between indexes "+start+
                        " and "+(i-1)+" both including");
                return 1;
            }

            // Add this element to curr_sum
            currSum = currSum + arr[i];
        }
        System.out.println("No sub-array found");
        return 0;
    }
}

//Time Complexity : O(n).
//Only one traversal of the array is required. So the time complexity is O(n).
//Space Complexity: O(1).
//As constant extra space is required.

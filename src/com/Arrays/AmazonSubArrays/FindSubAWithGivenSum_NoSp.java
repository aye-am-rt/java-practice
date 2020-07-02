package com.Arrays.AmazonSubArrays;
/*
Find subarray with given sum with negatives allowed in constant space
Given an unsorted array of integers, find a subarray which adds to a given number. If there are more
than one subarrays with the sum as the given number, print any of them.

Examples:
Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Output: Sum found between indexes 0 to 3

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Output: No subarray with given sum exists.*/

/**
The idea is to modify the array to contain only positive elements:

Find the smallest negative element in the array and increment every value in the array by the absolute
 value of the smallest negative element found.

We may notice that after doing the above modification, the sum of every subarray will also increase by:
(number of elements in the subarray) * (absolute value of min element)

After, doing the above modification in the input array, the task reduces to find if there is any subarray
 in the given array of only positive numbers with the new target sum. This can be done using the sliding
 window technique in O(N) time and constant space.

Every time while adding elements to the window, increment the target sum by the absolute value of the
 minimum element and similarily while removing elements from the current window, decrement the target
 sum by the absolute value of the minimum element so that for every subarray of length say K, the updated
 target sum will be:

targetSum = sum + K*abs(minimum element)


Below is the approach for the same:
Initialize a variable curr_sum as the first element.
The variable curr_sum indicates the sum of the current subarray.

Start from the second element and add all elements one by one to the curr_sum, and keep incrementing
 target sum by abs(minimum element).

If curr_sum becomes equal to the target sum, then print the solution.

If curr_sum exceeds the sum, then remove trailing elements while curr_sum is greater than the sum and
 keep decrementing target sum by abs(minimum element).*/

public class FindSubAWithGivenSum_NoSp
{

// Function to check if subarray with sum  exists when negative elements are also present
static void subArraySum(int[] arr, int n, int sum)
{
int minEle = Integer.MAX_VALUE;

// Find minimum element in the array
for (int i = 0; i < n; i++)
    minEle = Math.min(arr[i], minEle);

// Initialize curr_sum as value of first element and starting point as 0
int curr_sum = arr[0] + Math.abs(minEle);
int start = 0, i;

// Starting window length will be 1, For generating new target sum, add abs(minEle) to sum only 1 time

// Add elements one by one to curr_sum and if the curr_sum exceeds the updated sum, then remove
// starting element
for (i = 1; i <= n; i++)
{
    // If curr_sum exceeds the sum, then remove the starting elements
    while (curr_sum - (i - start) * Math.abs(minEle) > sum && start < i - 1)
    {
        curr_sum = curr_sum - arr[start] - Math.abs(minEle);
        start++;
    }

    // If curr_sum becomes equal to sum, then return true
    if (curr_sum - (i - start) * Math.abs(minEle) == sum)
    {
        System.out.println("Sum found between indexes " + start + " and " + (i - 1));
        return;
    }
    // Add this element to curr_sum
    if (i < n)
    {
        curr_sum = curr_sum + arr[i] + Math.abs(minEle);
    }
}
// If we reach here, then no subarray
System.out.println("No subarray found");
}

// Driver Code
public static void main (String[] args)
{
int[] arr = { 10, -12, 2, -2, -20, 10 };
int n = arr.length;

int sum = -10;

subArraySum(arr, n, sum);
}
}

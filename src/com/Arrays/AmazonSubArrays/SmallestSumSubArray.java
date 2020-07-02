package com.Arrays.AmazonSubArrays;
/*
Smallest sum contiguous subarray
Given an array containing n integers. The problem is to find the sum of the elements of the contiguous
 subarray having the smallest(minimum) sum.

Examples:
Input : arr[] = {3, -4, 2, -3, -1, 7, -5}
Output : -6
Subarray is {-4, 2, -3, -1} = -6

Input : arr = {2, 6, 8, 1, 4}
Output : 1

Naive Approach: Consider all the contiguous subarrays of diiferent sizes and find their sum.
The subarray having the smallest(minimum) sum is the required answer.

Efficient Approach: It is a variation to the problem of finding the largest sum contiguous
subarray based on the idea of Kadane’s algorithm.

Algorithm:

smallestSumSubarr(arr, n)
Initialize min_ending_here = INT_MAX
Initialize min_so_far = INT_MAX

for i = 0 to n-1
if min_ending_here > 0
min_ending_here = arr[i]
else
min_ending_here += arr[i]
min_so_far = min(min_so_far, min_ending_here)

return min_so_far*/

public class SmallestSumSubArray {
    // Driver method
    public static void main(String[] args)
    {
        int[] arr = {3, -4, 2, -3, -1, 7, -5};
        int n = arr.length;

        System.out.print("Smallest sum: " + smallestSumSubarrRevKadane(arr, n));
    }

    private static int smallestSumSubarrRevKadane(int[] arr, int ln) {
        //to store the minimum value that is ending up to the current index
        int sumEndingHere = Integer.MAX_VALUE;

        int minSoFar = Integer.MAX_VALUE;  // to store the minimum value encountered so far

        for (int i = 0; i < ln; i++)
        {
            // if min_ending_here > 0, then it could not possibly contribute to the minimum sum further
            if(sumEndingHere > 0)
            { sumEndingHere = arr[i]; }

            // else add the value arr[i] to min_ending_here
            else
            { sumEndingHere += arr[i]; }

            minSoFar = Math.min( minSoFar , sumEndingHere );
        }
        return minSoFar;
    }
}

/**    set -2  same question ,  new logic negate all elements then use kadane Algo to find max , then
 *   again negate everything that will be min subArray sum , contagious.
 *
 * In this post, a solution using the approach of
 *  Largest Sum Contiguous Subarray is discussed. This is based on the fact that in order to find
 *  the minimum contiguous sum we can first make the elements of the original array negative ie.
 *  Replace each ar[i] by -ar[i] and then apply Kadane Algorithm. Clearly, if this is the max sum
 *  formed then the minimum sum would be the negative of this sum.

     // function to find the smallest sum contiguous subarray
     static int smallestSumSubarr(int arr[], int n)
     {
     // First invert the sign of the elements
     for (int i = 0; i < n; i++)
         arr[i] = -arr[i];

     // Apply the normal Kadane algorithm But on the elements Of the array having inverted sign

     int sum_here = arr[0], max_sum = arr[0];

     for (int i = 1; i < n; i++)
     {
         sum_here = Math.max(sum_here + arr[i], arr[i]);
         max_sum = Math.max(max_sum, sum_here);
     }
    // Invert the answer to get minimum val
        return (-1) * max_sum;
     }
 */

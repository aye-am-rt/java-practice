package com.Arrays.practiceTab1;

import java.util.Arrays;

/**
Chocolate Distribution Problem
Given an array of n integers where each value represents number of chocolates in a packet. Each
 packet can have variable number of chocolates. There are m students, the task is to distribute
 chocolate packets such that:

Each student gets one packet.
The difference between the number of chocolates in packet with maximum chocolates and
 packet with minimum chocolates given to the students is minimum.
Examples:

Input : arr[] = {7, 3, 2, 4, 9, 12, 56}
m = 3
Output: Minimum Difference is 2
We have seven packets of chocolates and
we need to pick three packets for 3 students
If we pick 2, 3 and 4, we get the minimum
difference between maximum and minimum packet
sizes.

Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12}
m = 5
Output: Minimum Difference is 6
The set goes like 3,4,7,9,9 and the output
is 9-3 = 6

Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50}
m = 7
Output: Minimum Difference is 10
We need to pick 7 packets. We pick 40, 41, 42, 44, 48, 43 and 50 to minimize difference
between maximum and minimum.

 An efficient solution is based on the observation that to minimize the difference, we must choose
 consecutive elements from a sorted packet. We first sort the array arr[0..n-1], then find the
 subarray of size m with the minimum difference between last and first elements.
 */
// Time Complexity : O(n Log n) as we apply sorting before subarray search.
public class ChocolateDistributionProb {
    public static void main(String[] args)
    {
        int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;  // Number of students
        int n = arr.length;
        System.out.println("Minimum difference is " + findMinDiffAfterDist(arr, n, m));

    }
// Time Complexity : O(n Log n) as we apply sorting before subarray search.
    private static int findMinDiffAfterDist(int[] arrChocs, int ln, int numStuds) {
        if( ln==0 || numStuds==0)
            return 0;

        if(ln<numStuds)
            return -1;

        Arrays.sort(arrChocs);

        int minDiff = Integer.MAX_VALUE;

        // Find the sub-array of size m such that difference between last (maximum in case of sorted)
        // and first (minimum in case of sorted) elements of sub-array is minimum.
        for (int i = 0; (i+numStuds-1) < ln; i++) {
            int currDiff = arrChocs[i+numStuds-1] - arrChocs[i];
            if(currDiff<minDiff)
                minDiff=currDiff;
        }
        return minDiff;
    }
}
//Time Complexity : O(n Log n) as we apply sorting before sub-array search.

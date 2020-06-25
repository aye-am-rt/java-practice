package com.Arrays.SubsetSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Print equal sum sets of array (Partition Problem) | Set 2
Given an array arr[]. Determine whether it is possible to split the array into two sets
such that the sum of elements in both the sets is equal. If it is possible, then print both
the sets. If it is not possible then output -1.
Examples :
Input : arr = {5, 5, 1, 11}
Output : Set 1 = {5, 5, 1}, Set 2 = {11}
Sum of both the sets is 11 and equal.

Input : arr = {1, 5, 3}
Output : -1
No partitioning results in equal sum sets.

 Approach: In the previous post, a solution using recursion is discussed. In this post,
 a solution using Dynamic Programming is explained.
 The idea is to declare two sets set 1 and set 2. To recover the solution, traverse the boolean
 dp table backwards starting from the final result dp[n][k], where n = number of elements
 and k = sum/2. Set 1 will consists of elements that contribute to sum k
 and other elements that do not contribute are added to set 2.
 Follow these steps at each position to recover the solution.
 Check if dp[i-1][sum] is true or not. If it is true, then current element does not contribute
 to sum k. Add this element to set 2. Update index i by i-1 and sum remains unchanged.
 If dp[i-1][sum] is false, then current element contribute to sum k.
 Add current element to set 1. Update index i by i-1 and sum by sum-arr[i-1].
 */

public class PartEqualSumSets {
    public static void main(String[] args)
    {
        int[] arr = new int[]{ 5, 5, 1, 11 };
        int n = arr.length;
        printEqualSumSets(arr, n);
    }

//    Time Complexity: O(n*k), where k = sum(arr) / 2
//    Auxiliary Space: O(n*k)
    private static void printEqualSumSets(int[] arr, int n) {
        int sum =0;
        for (int i : arr) { sum += i; }
        // Check sum, If odd then array cannot be partitioned. Print -1 and return.
        if((sum&1)!=0)
        {
            System.out.println("-1 because total sum is odd ");
            return;
        }
        // Divide sum by 2 to find sum of two possible subsets.
        int k = sum>>1; // right shift 1 means divide by 2.
        // dp[i,j] = true if there is a subset of elements in first i elements of array that
        // has sum equal to j.
        boolean[][] dpSumsJ = new boolean[n + 1][k + 1];
        // If number of elements are zero, then no sum can be obtained.
        Arrays.fill(dpSumsJ[0],false);

        // Sum 0 can be obtained by not selecting any element.
        for (int i = 0; i <= n; i++)
            dpSumsJ[i][0] = true;

        // Fill the DP table in bottom up manner.
        for (int i = 1; i <(n+1); i++) {
            for (int j = 1; j <(k+1) ; j++) {
                // Excluding current element.
                dpSumsJ[i][j] =  dpSumsJ[i-1][j];
                // Including current element if can be whole picked.
                if(arr[i-1]<=j)
                {
                    dpSumsJ[i][j]=dpSumsJ[i][j] ||  dpSumsJ[i-1][j-arr[i-1]];
                }
            }
        }
        // Required sets set1 and set2.
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        if (!dpSumsJ[n][k]) {
            System.out.println("-1 equal sum sets are not present");
            return;
        }
        int i =n;
        int currSum = k;
        while (i > 0 && currSum >= 0)
        {
            // If it is true, then current element does not contribute to sum k.
            if(dpSumsJ[i-1][currSum])
            {
                i--;
                set2.add(arr[i]);
            }
            else if(dpSumsJ[i-1][currSum-arr[i-1]])
            {
                // If current element contribute to k then it belongs to set 1.
                i--;
                currSum -= arr[i];
                set1.add(arr[i]);
            }
        }
        System.out.println(" subsets having equal sum are = ");
        System.out.println(set1);
        System.out.println(set2);
    }
}
//    Time Complexity: O(n*k), where k = sum(arr) / 2
//        Auxiliary Space: O(n*k)

package com.Arrays.AmazonSubSeq;
/*
Longest alternating subsequence in terms of positive and negative integers
Given an array arr[] of positive and negative numbers only. The task is to find the
length of the longest alternating (means negative-positive-negative or positive-negative-positive)
subsequence present in the array.
Examples:
Input: arr[] = {-4, 3, -5, 9, 10, 12, 2, -1}
Output: 5
Explanation:
The longest sequence is {-4, 3, -5, 9, -1} which of length 5. There can be many more subsequence of
 this length.*/

// means negative-positive-negative or positive-negative-positive
// big-small-big-small

/**
Approach:
This problem can be solved using Dynamic Programming. It is a variation Longest Increasing
 Subsequence(LIS). Following are the steps:

For including and excluding an element in the given array arr[] for LAS(Longest Alternative
 Subsequence), a variable pos is used, when pos = true means current element needs to be positive and
 if pos = false then current element needs to be negative.
If we include the current element, change the value of pos and recurr for the next element because we
 need the next element of opposite sign than the previous included element.
Now LAS[i][pos] can be recursively written as:
Base case: If the index called recursively is greater than the last element, then return 0, as there
 is no such element left to form LAS and if LAS[i][pos] is calculated then return the value.
if(i == N) {
return 0;
}
if(LAS[i][pos]) {
return LAS[i][pos];
}

Recursive call: If the base case is not met, then recursively call when current element is included
 and excluded, then find the maximum of those to find LAS at that index.
LAS[i][pos] = Longest Alternating Subsequence at index i by including or excluding that element
 for the value of pos,
LAS[i][pos] = max(1 + recursive_function(i+1, pos), recursive_function(i+1, pos));

Return statement: At each recursive call(except the base case), return the value of LAS[i][pos].
return LAS[i][pos];

The LAS for the given array arr[] is the maximum of LAS[0][0] and LAS[0][1].
*/

public class LongestAltSeqOfPosNeg {
    public static void main (String[] args)
    { // Time Complexity: O(N) where N is the length of array.
        int[] arr = { -1, 2, 3, 4, 5, -6, 8, -99 };
        int n = arr.length;
        System.out.println(Math.max(solve(arr, n, 0, 0),solve(arr, n, 0, 1)));
    }

    // LAS[i][pos] array to find  the length of LAS till  index i by including or
    // excluding element arr[i]   on the basis of value of pos
    static int[][] LAS = new int[1000][2];

    private static int solve(int[] arr, int ln, int i, int posNegPos) {
        if(i==ln)
            return 0;
        if(LAS[i][posNegPos]==1)
            return LAS[i][posNegPos];

        int isIncluded=0;
        int isExcluded;

        //pos = true means current element needs to be positive and
        // if pos = false then current element needs to be negative.
        if(arr[i]>0 && posNegPos==1) // this is what we want if posNegPos is 1.
        { // that is why we are including this number in our sequence
            // If current element is positive and pos is 1 Include the current element
            // and change pos to 0
            posNegPos=0;
            isIncluded=1+solve(arr,ln,i+1,posNegPos);
        }
        // If current element is negative and pos is 0 Include the current element
        // and change pos to 1
        else if(arr[i]<0 && posNegPos==0) // this is also what we want if posNegPos is 0.
        {// that is why we are including this number in our sequence
            posNegPos=1;
            isIncluded=1+solve(arr,ln,i+1,posNegPos);
        }

        // If current element is excluded, recur for next iteration
        isExcluded=solve(arr,ln,i+1,posNegPos);

        LAS[i][posNegPos]=Math.max(isExcluded,isIncluded);

        return LAS[i][posNegPos];  // Time Complexity: O(N) where N is the length of array.
    }
}

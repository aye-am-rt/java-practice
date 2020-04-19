package com.Arrays;

/*
Maximum length sub-array which satisfies the given conditions
Given a binary array arr[], the task is to find the length of the longest sub-array of the given
array such that if the sub-array is divided into two equal-sized sub-arrays then both the sub-arrays
either contain all 0s or all 1s. For example, the two sub-arrays must be of the form {0, 0, 0, 0}
and {1, 1, 1, 1} or {1, 1, 1} and {0, 0, 0} and not {0, 0, 0} and {0, 0, 0}

Examples:

Input: arr[] = {1, 1, 1, 0, 0, 1, 1}
Output: 4
{1, 1, 0, 0} and {0, 0, 1, 1} are the maximum length valid sub-arrays.
*/

//Approach: For every two consecutive elements of the array say arr[i] and arr[j] where j = i + 1, treat
// them as the middle two elements of the required sub-array. In order for this sub-array to be a valid
// sub-array arr[i] must not be equal to arr[j]. If it can be a valid sub-array then its size is 2. Now,
// try to extend this sub-array to a bigger size by decrementing i and incrementing j at the same time
// and all the elements before index i and after index j must be equal to arr[i] and arr[j] respectively.
// Print the size of the longest such sub-array found so far.

public class MaxLenArrayCond1 {
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 1, 1, 1, 0, 0, 1, 1 };
        int n = arr.length;

        System.out.println(maxLengthArrayDivide(arr, n));
    }

    private static int maxLengthArrayDivide(int[] arr, int n) {
        if(n<2)
            return -1;
        if(n==2 && arr[0]!=arr[1])
            return 2;
        int maxLen=0;
        int i=0;
        int j=i+1;
        while(j<n)
        {
            if(arr[i]!=arr[j])
                maxLen=Math.max(maxLen,2);
            int l=i-1;
            int r=j+1;

            while(l>=0 && r<n && arr[l]==arr[i] && arr[r]==arr[j])
            { l--; r++; }
            maxLen=Math.max(maxLen,2*(r-j));
            i++;
            j=i+1;
        }
        return maxLen;
    }
}

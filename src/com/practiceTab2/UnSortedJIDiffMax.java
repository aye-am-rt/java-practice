package com.practiceTab2;
/**
//1. Given an unsorted array, find the max j-i such that j > i and a[j] > a[i] in O(N).
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
Examples :

Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 6  (j = 7, i = 1)

Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
Output: 8 ( j = 8, i = 0)*/

public class UnSortedJIDiffMax {
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 3, 2};
        int[] arr2= {7,6,5,4};
        int[] arr3= {1,2,3,4,5};
        int n=arr.length;
        System.out.print(FindMaxDiffGivenCondition(arr, n));
    }
    /* For a given array arr[], returns the maximum j-i such that  arr[j] > arr[i] /////
       inefficient 2 loops and oN^2  time taken. */
    private static int maxIndexDiff(int[] arr, int n)
    { // inefficient 2 loops and oN^2  time taken.
        int maxDiff = -1;
        int i, j;
        for (i = 0; i < n; ++i) // inefficient 2 loops and oN^2  time taken.
        {
            for (j = n - 1; j > i; --j) // inefficient 2 loops and oN^2  time taken.
            {
                if (arr[j] > arr[i] && maxDiff < (j - i))
                    maxDiff = j - i;
            }
        }
        return maxDiff;  // inefficient 2 loops and oN^2  time taken.
    }

    private static int FindMaxDiffGivenCondition(int[] arr, int n) {
        if(n<2)
            throw new IllegalArgumentException();

        int[] maxInRight=new int[n];
        maxInRight[n-1]=arr[n-1];
        int[] minInLeft = new int[n];
        minInLeft[0]=arr[0];
        /* Construct LMin[] such that LMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i]) */
        for (int i = 1; i <n ; i++) {
            minInLeft[i]=Math.min(arr[i],minInLeft[i-1]);
        }
        /* Construct RMax[] such that RMax[j] stores the maximum value from (arr[j], arr[j+1], ..arr[n-1]) */
        for (int i = n-2; i > -1; i--) {
            maxInRight[i]=Math.max(arr[i],maxInRight[i+1]);
        }
        int i=0;
        int j=0;
        int maxDiff=-1;
        while (i<n && j<n)
        {
            if(maxInRight[j]>minInLeft[i])
            {
                maxDiff = Math.max( maxDiff, (maxInRight[j] - minInLeft[i]) );
                j+=1;
            }
            i+=1;
        }
        return maxDiff;
    }
}

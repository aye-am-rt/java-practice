package com.Arrays.TripletQues;

// find maximum sum of triplet in an array such that i<j<k and a[i]<a[j]<a[k]

// better approach use 2 nested loops and for each element at index i find maximum  element left to it and
// find maximum element right to it , at the same time find sum of these three and if its is greater than previous
// maxSum then update maxSum.

// time o(n^2)  space o(1)
public class MaxSumTripletIncreasing {
    public static void main(String[] args)
    {
        int[] arr = {2,5,3,1,4,9};
        int n=arr.length;
        System.out.print(PrintMaxSumTripletIncreasing(arr, n));
    }

    private static int PrintMaxSumTripletIncreasing(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        int maxSum=0;
        for (int i = 1; i < (n-1); i++) {
            int maxLeft=Integer.MIN_VALUE;
            int maxRight=Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i])
                    maxLeft=Math.max(maxLeft,arr[j]);
            }
            for (int j = n-1; j > -1; j--) {
                if(arr[j]>arr[i])
                    maxRight=Math.max(maxRight,arr[j]);
            }
            maxSum=Math.max(maxSum,(arr[i]+maxRight+maxLeft));
        }
        return maxSum;
    }
}

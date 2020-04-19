package com.Arrays;
//Find triplet with minimum sum
//Given an array of distinct integers arr[].
// The task is to find a triplet(a group of 3 elements) that has the minimum sum.
//Note: The size of the array is always greater than two.
//Examples:
//Input : arr[] = {1, 2, 3, 4, -1, 5, -2}
//Output : -2
//1 - 1 - 2 = -2
/**
Efficient approach: The idea is to traverse the array and compute minimum, second minimum and third
 minimum element present in the array and print the sum of these three elements.*/
public class MinSumTriplet {
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5, -1, 5, -2 };
        int n = arr.length;
        System.out.print(getMinimumSumTriplet(arr, n) +"\n");
    }

    private static int getMinimumSumTriplet(int[] arr, int n) {
        int fMin=Integer.MAX_VALUE;
        int sMin=Integer.MAX_VALUE;
        int tMin=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i]<fMin)
            {
                tMin=sMin;
                sMin=fMin;
                fMin=arr[i];
            }
            else if(arr[i]<sMin)
            {
                tMin=sMin;
                sMin=arr[i];
            }
            else if(arr[i]<tMin)
            {
                tMin=arr[i];
            }
        }
        System.out.println(" min sum triplet is = "+fMin+" "+sMin+" "+tMin);
        return (fMin+sMin+tMin);
    }
}

package com.Arrays.MergingArrays;
// given 2 sorted arrays ,a and b. a is long enough to hold b's all elements .
// write a function to copy b elements in a and keep it sorted , no extra space allowed.

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args)
    {
        int[] arr1 = {1,2,3,4,5,6,0,0,0,0};
        int[] arr2 = {7,8,9,10};

        System.out.println("Sorted and merged array 1  = "+MergeSortedArraysNOSP(arr1,arr2));
    }
    // output
    // Sorted and merged array 1  = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    private static String MergeSortedArraysNOSP(int[] arr1, int[] arr2) {
        int l1=arr1.length;
        int l2=arr2.length;
        if(l1==0 && l2 != 0)
            return Arrays.toString(arr2);
        if(l2==0 && l1 != 0)
            return Arrays.toString(arr1);
        int aEnd=l1-1;
        int bEnd=l2-1;
        int mergeIndex=l1-l2-1;
        while (mergeIndex> -1 && bEnd> -1)
        {
            if(arr1[mergeIndex]>arr2[bEnd])
            {
                arr1[aEnd]=arr1[mergeIndex];
                mergeIndex--;
            }
            else
            {
                arr1[aEnd]=arr2[bEnd];
                bEnd--;
            }
            aEnd--;
        }
        while(bEnd>=0)
        {
            arr1[aEnd]=arr2[bEnd];
            bEnd--;
            aEnd--;
        }
        return Arrays.toString(arr1);
    }
}

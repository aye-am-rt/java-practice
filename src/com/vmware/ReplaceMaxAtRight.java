package com.vmware;
//Replace array elements with maximum element on the right.
//        Objective: Given an array of integers, write a program to replace its elements with the
//        maximum element on the right side from their respective positions.
//        Note: If the element is equal to the maximum element on the right, replace it with 0.
//        Example:
//        Original Array: [2, 5, 1, 6, 3, 4]
//        Output: [6, 6, 6, 0, 4, 0]

import java.util.Arrays;

public class ReplaceMaxAtRight {
    public static void main(String[] args) {
        int [] arrA = {5, 4, 3, 2, 1};
        int[] arr2= {4, 5, 6, 7, 8};
        replaceMaxAtRight(arrA,arrA.length);
        replaceMaxAtRight(arr2,arr2.length);
    }

    private static void replaceMaxAtRight(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        System.out.println("given Array: " + Arrays.toString(arr));
        int maxSoFar=arr[ln-1];
        for (int i = ln-1; i >-1 ; i--) {
            if(arr[i]<maxSoFar)
                arr[i]=maxSoFar;
            else if(arr[i]>maxSoFar)
            {
                maxSoFar=arr[i];
                arr[i]=0;
            }
            else
                arr[i]=0;
        }

        System.out.println("Modified Array: " + Arrays.toString(arr));
    }
}

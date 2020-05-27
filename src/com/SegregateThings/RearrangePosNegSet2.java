package com.SegregateThings;
/**
Rearrange array in alternating positive & negative items with O(1) extra space | Set 2
Given an array of positive and negative numbers, arrange them in an alternate fashion such
 that every positive number is followed by negative and vice-versa. Order of elements in output
 doesn’t matter. Extra positive or negative elements should be moved to end.

Examples:

Input :
arr[] = {-2, 3, 4, -1}
Output :
arr[] = {-2, 3, -1, 4} OR {-1, 3, -2, 4} OR ..

Input :
arr[] = {-2, 3, 1}
Output :
arr[] = {-2, 3, 1} OR {-2, 1, 3}

Input :
arr[] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4}
Output :
arr[] = {-5, 3, -2, 5, -6, 4, -4, 9, -1, 8}
OR ..*/
//
//The idea is to process the array and shift all negative values to the end in O(n) time. After all
// negative values are shifted to the end, we can easily rearrange array in alternating positive &
// negative items. We basically swap next positive element at even position from next negative element
// in this step.

public class RearrangePosNegSet2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, -4, -1, 6, -9};
        int n = arr.length;
        System.out.println("Given array is ");
        printArray(arr, n);
        rearrange(arr, n);
        System.out.println("Rearranged array is ");
        printArray(arr, n);
    }

    private static void rearrange(int[] arr, int n) {
        int left = 0;
        int right = n-1;
        while (left<right)
        {
            while(arr[left]>0)
                left++;
            while (arr[right]<0)
                right--;
            if(left<right)
                swap(arr,left,right);
        }
        if(left==0 || left==n)
            return;
        // start with first positive element at index 0
        // Rearrange array in alternating positive & negative items
        int k = 0;
        while (k<n && left<n)
        {
            // swap next positive element at even position from next negative element.
            swap(arr,k,left);
            left+=1;
            k+=2;
        }
    }

    static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }


    static void swap(int[] arr, int index1, int index2){
        int c = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=c;
    }
}

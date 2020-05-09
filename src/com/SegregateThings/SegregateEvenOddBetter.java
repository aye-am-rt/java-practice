package com.SegregateThings;
/*
Segregate even and odd numbers | Set 3
Given an array of integers, segregate even and odd numbers in the array. All the even numbers
 should be present first, and then the odd numbers.
Examples:
Input : 1 9 5 3 2 6 7 11
Output : 2 6 5 3 1 9 7 11

Input : 1 3 2 4 7 6 9 10
Output : 2 4 6 10 7 1 9 3*/

import java.util.Arrays;

public class SegregateEvenOddBetter {
    public static void main(String[] args)
    {
        int[] arr = { 1, 3, 2, 4, 7, 6, 9, 10 };
        int n = arr.length;
        SegregateArrayEven_Odd(arr, n);
    }

    private static void SegregateArrayEven_Odd(int[] arr, int n) {
        int j=-1;
        for (int i = 0; i < n; i++) {
            if(arr[i]%2==0)
            {
                j++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

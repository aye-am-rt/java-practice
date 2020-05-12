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

        int[] arr2 = { 1, 3, 2, 4, 7, 6, 9, 10 };
        int n2 = arr2.length;
        SegregateArrayEven_Odd_LeftRightMethod(arr2, n2);
    }

    private static void SegregateArrayEven_Odd_LeftRightMethod(int[] arr2, int n2) {
        if(n2<1)
            throw new IndexOutOfBoundsException();
        int left=0;
        int right=n2-1;
        while(left<right)
        {
            if(arr2[left]%2 != 0 && arr2[right]%2 == 0)
            {
                int temp=arr2[left];
                arr2[left]=arr2[right];
                arr2[right]=temp;
                left++;
                right--;
            }
            else
            {
                if(arr2[left]%2 == 0)
                    left++;

                if(arr2[right]%2 != 0)
                    right--;

            }
        }
        System.out.println("arrays 2 == after even left and odd right === ");
        System.out.println(Arrays.toString(arr2));
    }

    private static void SegregateArrayEven_Odd(int[] arr, int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i]%2==0)  // if arr[i] is even then swap with last seen odd which will be
            {               // pointed by j . then update j.
                j ++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

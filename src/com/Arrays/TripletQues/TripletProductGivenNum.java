package com.Arrays.TripletQues;
/*
Count number of triplets with product equal to given number | Set 2
        Given an array of distinct integers(considering only positive numbers) and a number ‘m’,
        find the number of triplets with the product equal to ‘m’.
        Examples:
        Input: arr[] = { 1, 4, 6, 2, 3, 8}
        m = 24
        Output: 3

        Input: arr[] = { 0, 4, 6, 2, 3, 8}
        m = 18
        Output: 0*/

import java.util.Arrays;

/**
Approach: The idea is to use Three-pointer technique:

Sort the input array.
Fix the first element as A[i] where i is from 0 to array size – 2.
After fixing the first element of triplet, find the other two elements using 2 pointer technique.*/

public class TripletProductGivenNum {
    public static void main (String[] args)
    {
        int []arr = { 1, 1, 1, 1, 1, 1 };
        int [] arr2= {1, 4, 6, 2, 3, 8}; // 1, 4, 6, 2, 3, 8    m = 24   ans == 3
        int n = arr.length;
        int m = 1;
        System.out.println(countTripletsWithGivenProduct(arr, n, m));
        System.out.println(countTripletsWithGivenProduct(arr2, arr2.length, 24));

    }

    private static int countTripletsWithGivenProduct(int[] arr, int n, int m) {
        if(n<3)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int count=0;
        int start, end;
        for (int i = 0; i < n - 2; i++) {
            start=i+1;
            end=n-1;
            while(start<end)
            {
                long prod = (long)arr[start]*arr[i]*arr[end];
                if(prod>m)
                    end-=1;
                else if (prod<m)
                    start+=1;
                else
                {count++; end--; start++;}
            }
        }
        System.out.print(" Count number of triplets with product equal to given number == ");
        return count;
    }
}

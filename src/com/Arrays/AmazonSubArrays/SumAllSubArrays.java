package com.Arrays.AmazonSubArrays;
/*
Sum of all sub arrays in O(n) Time
Objective:  Given an array write an algorithm to find the sum of all the possible sub arrays.
Example:
int [] a = {1, 2, 3};
Output: Possible subarrays –
{1}, {2}, {3}, {1, 2} , {2, 3}, {1, 2, 3}
So sum = 1+ 2+ 3 + 3 + 5 + 6 = 20*/
/**
Total number of occurrences for ith index element in array will be = (n-i) + (n-i)*I => (n-i)*(i+1)
        So for array {1,2,3,4}
        1*(4-0)*(0+1) +
        2*(4-1)*(1+1) +
        3*(4-2)*(2+1) +
        4*(4-3)*(3+1) = 1*4 + 2*6 + 3*6 + 4*4 = 50
        Time Complexity: O(n)*/

public class SumAllSubArrays {
    public static void main(String[] args) {
        int [] arr = {6,7,5,9};  // 1,2,3,4
        int sum = findSumOfAllSubArrays(arr,arr.length);
        System.out.println("Sum of elements of All sub arrays is: " +  sum);
    }

    private static int findSumOfAllSubArrays(int[] arr, int n) {
        if(n<=0)
            throw new IllegalArgumentException();
        int allSubArraysSum=0;
        double prodAllSubArrays=1.0;
        for (int i = 0; i < n; i++) {
            allSubArraysSum += arr[i] * (n-i) * (i+1);
            prodAllSubArrays = prodAllSubArrays * Math.pow(arr[i], (double)(n-i)*(i+1));
            // this number of times should go in power of that element== arr[i]^((n-i)*(i+1))
        }
        System.out.println("product of all sub arrays = "+prodAllSubArrays);
        return allSubArraysSum;
    }
}

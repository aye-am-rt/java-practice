package com.Arrays.AmazonSubArrays;

/*
Maximum Product Subarray | Set 3
Given an array A[] that contains both positive and negative integers, find the maximum product
subarray.
Examples :
Input: A[] = { 6, -3, -10, 0, 2 }
Output: 180  // The subarray is {6, -3, -10}

Input: A[] = {-1, -3, -10, 0, 60 }
Output: 60  // The subarray is {60}

Input: A[] = { -2, -3, 0, -2, -40 }
Output: 80  // The subarray is {-2, -40}

The idea is to traverse array from left to right keeping two variables minVal and maxVal which
represents the minimum and maximum product value till the ith index of the array. Now, if the ith
element of the array is negative that means now the values of minVal and maxVal will be swapped as
value of maxVal will become minimum by multiplying it with a negative number. Now, compare the minVal
 and maxVal.
The value of minVal and maxVal depends on the current index element or the product of the current
index element and the previous minVal and maxVal respectively.

*/
//
//Time Complexity: O( n )
//        Auxiliary Space: O( 1 )

public class MaxProductSubArray {

    public static void main (String[] args)
    {
        int[] arr = { -1, -3, -10, 0, 60 };
        int n = arr.length;
        System.out.println( "Maximum SubArray product is " + FindMaxProductOfAnySubArray(arr, n));
    }

    private static int FindMaxProductOfAnySubArray(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        int minProdTillIIndex=arr[0];
        int maxProdTillIIndex=arr[0];

        int maxProduct=arr[0];

        for (int i = 0; i < n; i++) {
            if(arr[i]<0)
            {
                int temp=minProdTillIIndex;
                minProdTillIIndex=maxProdTillIIndex;
                maxProdTillIIndex=temp;
            }
            // maxVal and minVal stores the product of subArray ending at arr[i].
            maxProdTillIIndex = Math.max(arr[i] , maxProdTillIIndex*arr[i]);
            minProdTillIIndex = Math.min(arr[i], minProdTillIIndex*arr[i]);

            maxProduct = Math.max(maxProdTillIIndex,minProdTillIIndex);
        }
        return maxProduct;
    }
}

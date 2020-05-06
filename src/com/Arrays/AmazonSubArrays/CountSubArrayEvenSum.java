package com.Arrays.AmazonSubArrays;
/**
Find number of sub-arrays with even sum
Given an array, find the number of sub-arrays whose sum is even.
Example :
Input : arr[] = {1, 2, 2, 3, 4, 1}
Output : 9
There are possible sub-arrays with even
sum. The sub-arrays are
1) {1, 2, 2, 3}  Sum = 8
2) {1, 2, 2, 3, 4}  Sum = 12
3) {2}  Sum = 2 (At index 1)
4) {2, 2}  Sum = 4
5) {2, 2, 3, 4, 1}  Sum = 12
6) {2}  Sum = 2 (At index 2)
7) {2, 3, 4, 1} Sum = 10
8) {3, 4, 1}  Sum = 8
9) {4}  Sum = 4*/

//O(n2) time and O(1) space method [Brute Force]
//        We can simply generate all the possible sub-arrays and find whether the sum of all the
//        elements in them is an even or not. If it is even then we will count that sub-array otherwise
//        neglect it.

public class CountSubArrayEvenSum {
    public static void main (String[] args)
    {
        int[] arr = {5,9,11}; //1, 2, 2, 3, 4, 1
        int n = arr.length;
        //System.out.print("The Number of Sub-arrays"+ " with even sum is ");
        System.out.println(countEvenSumBruteForce(arr, n));
       // System.out.println(countEvenSumEfficientMod2(arr, n));
    }

    private static int countEvenSumBruteForce(int[] arr, int n) {
        if (n <=0)
            throw new IllegalArgumentException();
        int result=0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++) // Now A[i..j] is the sub-array
            {
                int sum=0;
                for (int k = i; k <=j ; k++)
                {
                    sum=sum+arr[k];
                    System.out.print(arr[k]+"  ");
                }
                if(sum%2==0)
                    result+=1;
                System.out.println("-- and sum of this SubArray == "+ sum +" -- ");
            }
            System.out.println("********");
        }
        System.out.print("The Number of Sub-arrays"+ " with even sum are ==  ");
        return result;
    }

}

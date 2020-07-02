package com.Arrays.PairQues;
/**
Count pairs with Odd XOR
Given an array of n integers. Find out number of pairs in array whose XOR is odd.

Examples :
Input : arr[] = { 1, 2, 3 }
Output : 2
All pairs of array
1 ^ 2 = 3
1 ^ 3 = 2
2 ^ 3 = 1

Input : arr[] = { 1, 2, 3, 4 }
Output : 4

Naive Approach: We can find pairs whose XOR is odd by running two loops. If XOR of two number is
 odd increase count of pairs.

 *********************************************************
 Efficient Approach: We can observe that:

 odd ^ odd = even
 odd ^ even = odd
 even ^ odd = odd
 even ^ even = even

 Therefore total pairs in array whose XOR is odd will be equal to count of odd numbers multiplied by
 count of even numbers.

 */

public class CountPairsWithOddXOR {
    // A function will return number of pair whose XOR is odd
    static int countXorPair(int[] arr, int n)
    {
        // To store count of odd and even numbers
        int odd = 0, even = 0;

        for (int i = 0; i < n; i++) {
            // Increase even if number is even otherwise increase odd
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        // Return number of pairs
        return odd * even;
    }

    // Driver program to test countXorPair()
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3 };
        System.out.println(countXorPair(arr, arr.length));
    }
}

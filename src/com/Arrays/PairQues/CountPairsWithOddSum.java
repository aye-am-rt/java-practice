package com.Arrays.PairQues;
//
//Given an array, find the number of all pairs with odd sum.
//        Objective: Given an array of integers, write a program to find the number of pairs with
//        even odd.
//        Example:
//        Given Input: [1, 2, 3, 4]
//        Number of odd pairs: 4
//        Note: (1, 2), (1, 4), (2, 3) and (3, 4)

import java.util.Arrays;

/**
Better approach:
        Iterate through the array and count the number of odd elements and even elements.
        We know the odd + even = odd, we will use this property.
        Number of pairs with odd sums = evenCount*oddCount.
        Time Complexity: O(N)*/

public class CountPairsWithOddSum {
    public static void countPairs(int [] input){
        System.out.println("Given Input: " + Arrays.toString(input));
        int evenCount=0;
        int oddCount=0;
        for (int value : input) {
            if (value % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        int pairsWithOddSum = evenCount*oddCount;
        System.out.println("Number of pairs having odd sum : " + pairsWithOddSum);
        // we can also find number of pairs with even sums just have to do -
        // total Possible Pairs - num of Pairs with odd Sum
        // total possible pairs = nC2 = n!/((2!)*(n-2)!) == n * (n-1) / 2 ;
        int totalPossiblePairs = (input.length * (input.length-1)) / 2;
        System.out.println("Number of pairs having even sum : " +(totalPossiblePairs-pairsWithOddSum));

    }

    public static void main(String[] args) {
        int [] input = {6, 7, 1, 3, 2, 5, 4};
        countPairs(input);
    }
}

package com.Arrays.SubsetSums;
/*Given an array, Print sum of all subsets
        Objective: Given an array of numbers, write an algorithm to print all the subsets sum
        individually.
        Example:
        Given Input: [1, 2]
        Output: 3 1 2 0
        Explanation: subsets are [0], [1], [2], [1, 2]

        subsets are == [0], [1], [2], [1, 2]    subsets and subArrays are different
        sub-arrays ==  [1]  [1 ,2]   [2]
        */

//Approach: Recursion  Time Complexity: O(2^N)

//Every element of the array has two choices, whether to include that element in the subset or
//exclude that element from the subset. So initialize sum = 0, now for each element in the
//array – add it to sum and make a recursive call, do not add it to sum and make a recursive
//call. Print the sum at the base case when the current element is the last element of an array.

import java.util.Arrays;

public class SumsOfEachSubset {
    public static void main(String[] args) {
        int [] input = {2, 4, 6};
        sumOfEachSubsetIndividually(input);
//         Given Input: [1, 2]
//         Output: 3 1 2 0
//        subsets are == [0], [1], [2], [1, 2]    subsets and subArrays are different
//        sub-arrays ==  [1]  [1 ,2]   [2]   // also subArrays are continuous and not empty.
    }

    private static void sumOfEachSubsetIndividually(int[] arr) {
            System.out.println("Given Input: " + Arrays.toString(arr));
            subsetSumUtil(arr, 0, 0);
    }

    private static void subsetSumUtil(int[] arr, int currIndex, int sum) {
        if(currIndex==arr.length)
        {
            System.out.print(sum+"  ");
            return;
        }
        //include the element at current index
        subsetSumUtil(arr, currIndex+1, sum+ arr[currIndex]);

        //does not include the element at current index
        subsetSumUtil(arr, currIndex+1, sum);
    }

}

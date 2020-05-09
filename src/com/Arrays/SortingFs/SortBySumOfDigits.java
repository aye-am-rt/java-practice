package com.Arrays.SortingFs;

/*Sort the numbers according to their sum of digits
Given an array arr[] of N non-negative integers, the task is to sort these
integers according to sum of their digits.
Examples:
Input: arr[] = {12, 10, 102, 31, 15}
Output: 10 12 102 31 15
10 => 1 + 0 = 1
12 => 1 + 2 = 3
102 => 1 + 0 + 2 = 3
31 => 3 + 1= 4
15 => 1 + 5 = 6

Approach: The idea is to store each element with its sum of digits in a vector
 pair and then sort all the elements of the vector according to the digit sums
 stored. Finally, print the elements in order.
*/

import javafx.util.Pair;

import java.util.ArrayList;

public class SortBySumOfDigits {
    public static void main(String[] args)
    {
        int[] arr = {14, 1101, 10, 35, 0 };
        int n=arr.length;
        SortBySumDigits(arr, n);
    }
    static int FindSumOfDigits(int n)
    {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
    private static void SortBySumDigits(int[] arr, int n) {
        ArrayList<Pair<Integer, Integer>> pairList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int sumOfDigits = FindSumOfDigits(arr[i]);
            pairList.add(new Pair<>(sumOfDigits, arr[i]));
        }
        pairList.sort((p1, p2) -> {
            if (p1.equals(p2))
                return 0;
            else if (p1.getKey() > p2.getKey())
                return 1;
            else
                return -1;
        });
        System.out.println("sorted pair list acc to first Element which is sum of element digits");
        System.out.println(pairList);
        System.out.println("array elements sorted acc to sum of digits");
        for (Pair<Integer, Integer> p : pairList) {
            System.out.print(p.getValue() + "  ");
        }
    }
}

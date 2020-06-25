package com.Mathematical;
/*
Construct the largest number from the given array.
Objective: Given an array of integers, write an algorithm to construct the largest number possible by
 appending the array elements.
Example:
Given Input: [7, 78]
Largest Number Possible: 787
Explanation: two possibilities are 778 and 787. 787 is larger than 778.
*/

import java.util.Arrays;
import java.util.Comparator;

/**We will sort according to the digits. Let’s say two elements are [A, B], We will override the
 * comparator and in comparison, compare AB and BA and if AB>BA then return -1 else return 1.
 Once the input array is sorted according to the above statement, iterate the input and
 append all the elements. This will be our largest number.*/

public class MakeBiggestNumber {
    //1, 34, 3, 98, 9, 76, 45, 4, 12, 121
    public static void main(String[] args) {
        Integer[] input = {1, 34, 3, 98, 9, 76, 45, 4, 12, 121};
        constructLargestNumber(input);
    }

    private static void constructLargestNumber(Integer[] arr) {
        System.out.println("Given Input: " + Arrays.toString(arr));
        StringBuilder resultSBld = new StringBuilder();
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Integer A, Integer B) {
                String AB = A + String.valueOf(B) + "";
                String BA = B + String.valueOf(A) + "";
                return AB.compareTo(BA) > 0 ? -1 : 1;
            }
        });
//        Arrays.sort(arr, (A, B) -> {
//            String AB= A +String.valueOf(B)+"";
//            String BA= B +String.valueOf(A)+"";
//            return AB.compareTo(BA)>0?-1:1;
//        });
        for (Integer integer : arr) {
            resultSBld.append("_").append(integer);  // remove the _ to see original number
        }
        System.out.println("Largest Number Possible: " + resultSBld.toString().substring(1));
    }
}

package com.Arrays.SortingFs;

import java.util.*;
import java.util.stream.Collectors;

/**
Sort all even numbers in ascending order and then sort all odd numbers in descending order
Given an array of integers (both odd and even), sort them in such a way that the
 first part of the array contains odd numbers sorted in descending order, rest portion
 contains even numbers sorted in ascending order.
Examples:
Input  : arr[] = {1, 2, 3, 5, 4, 7, 10}
Output : arr[] = {7, 5, 3, 1, 2, 4, 10}

Input  : arr[] = {0, 4, 5, 3, 7, 2, 1}
Output : arr[] = {7, 5, 3, 1, 0, 2, 4}
 */

public class SortEvenAscOddDsc {
    public static void main(String[] args)
    {
        System.out.println("***** sorting acc to condition  by left right swap collection N_logN **********");
        Integer[] arr = { 1, 3, 2, 7, 5, 4 };
        twoWaySortEvenOdd(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        System.out.println("***** doing same by -1 multiplication **********");

        int[] arr2= {1,2,3,4,5,6,7,8,9,10,11};
        int n2=arr2.length;
        SortByNegMultiplication(arr2,n2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("***** doing same by Comparator custom made **********");
        int[] arr3= {19,18,17,16,15,14,13,12,11,10};
        int n3=arr3.length;
        // both ways of printing works either return in array and print it or just print the original arr.
        System.out.println(Arrays.toString(SortByComparatorUse(arr3,n3)));
        System.out.println(Arrays.toString(arr3));
    }

    //    Time complexity: O(n log n)
    //     space complexity: O(1)
    private static void twoWaySortEvenOdd(Integer[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        int left=0;
        int right=ln-1;
        int countOdds=0;
        // here basically what we are doing that counting all odd numbers and rest of them will be even.
        // and while counting we are collecting odd nums to left by swapping technique.
        // and after that just sorting the odd part of array in reverse order and even part in normal
        // increasing order.using the count of odd nums we know till where to sort for odd and even nums.
        while(left<right)
        {
            // Find first even number from left side
            while(arr[left]%2 != 0)
            { left++; countOdds++; }

            // Find first odd number from right side.
            while(arr[right]%2 == 0 && left<right)
            { right--; }

            if(left<right)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        //    Time complexity: O(n log n)
        //    space complexity: O(1)
        Arrays.sort(arr,0, countOdds, Collections.reverseOrder());
        Arrays.sort(arr,countOdds, ln);
    }

/** Method 2 (Using negative multiplication) :
    Make all odd numbers negative.
    Sort all numbers.
    Revert the changes made in step 1 to get original elements back.

 // Java program sort array in even and odd manner.
 // The odd numbers are to be sorted in descending
 // order and the even numbers in ascending order
 */

    private static void SortByNegMultiplication(int[] arr2, int n2) {
        // Make all odd numbers negative
        for (int i = 0; i < n2; i++) {
            if((arr2[i]&1)!=0)   // this means number is odd coz bitwise and will be equal to 1.
            {
                arr2[i] *= -1;
            }
        }
        Arrays.sort(arr2);
        // Make all odd numbers positive again as was in original condition
        for (int i = 0; i < n2; i++) {
            if((arr2[i]&1)!=0)   // this means number is odd coz bitwise and will be equal to 1.
            {
                arr2[i] *= -1;
            }
        }
    }

/**    Method 3 (Using comparator):
    This problem can be easily solved by using the inbuilt sort function with a custom
    compare method.
    On comparing any two elements there will be three cases:
    ....When both the elements are even: In this case, the smaller element must appear in the left
        of the larger element in the sorted array.
    ''''When both the elements are odd: The larger element must appear on left of the
        smaller element.
    ....One is odd and the other is even: The element which is odd must appear on the
    left of the even element.*/


private static int[] SortByComparatorUse(int[] arr3, int n3) {
    ArrayList<Integer> al = Arrays.stream(arr3).boxed().sorted((a, b) -> {
        // If both numbers are even, smaller number should be placed at lower index
        if (a % 2 == 0 && b % 2 == 0)
            return a < b ? 1 : -1;
        // If both numbers are odd larger number should be placed at lower index
        else if (a % 2 != 0 && b % 2 != 0)
            return b < a ? 1 : -1;
        // If a is odd and b is even, a should be placed before b
        else if (a % 2 != 0)
            return 1;
            // If b is odd and a is even, b should be placed before a
        else
            return 0;
    }).collect(Collectors.toCollection(ArrayList::new));

    System.out.println(al);
//     al.stream().mapToInt(Integer::intValue).toArray(); this line also works same.
//        It's also worth mentioning that you could get a NullPointerException if you
//        have any null reference in the list. This could be easily avoided by adding a
//        filtering condition to the stream pipeline like this:
//                                 .filter(Objects::nonNull) also works
//        int[] arr = list.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    return al.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();
}
}

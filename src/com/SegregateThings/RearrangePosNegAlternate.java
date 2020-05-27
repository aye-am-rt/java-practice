package com.SegregateThings;

import java.util.Arrays;

/**
Rearrange positive and negative numbers in O(n) time and O(1) extra space
An array contains both positive and negative numbers in random order. Rearrange the array elements so
 that positive and negative numbers are placed alternatively. Number of positive and negative numbers
 need not be equal.
 **********************************   /////////////////////////////////////////
 If there are more positive numbers they appear at the end of the array. If there
 are more negative numbers, they too appear in the end of the array.
 *************************************  /////////////////////////////////////

For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7,
 8, -3, 5, -1, 2, 4, 6]

Note: The partition process changes relative order of elements. I.e. the order of the appearance of
 elements is not maintained with this approach. See this for maintaining order of appearance of
 elements in this problem.
The solution is to first separate positive and negative numbers using partition process of QuickSort.
 In the partition process, consider 0 as value of pivot element so that all negative numbers are placed
 before positive numbers. Once negative and positive numbers are separated, we start from the first
 negative number and first positive number, and swap every alternate negative number with next positive
 number.*/

public class RearrangePosNegAlternate {

    // A utility function to print an array
    static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "   ");
    }

    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};  // -5, -2, 5, 2, 4, 7, 1, 8, 0, -8
        int n = arr.length;
        rearrangePosNeg(arr,n);
        System.out.println("Array after rearranging Alternate Pos And Neg : ");
        printArray(arr,n);
    }

    private static void rearrangePosNeg(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        int j=-1;
        for (int i = 0; i < ln; i++) {
            if(arr[i]<0)
            {
                j++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            } // after this all neg collected to left and pos to right
        }
        System.out.println("after Normal segregation "+ Arrays.toString(arr));
        int posStartIndex = j+1, negStartIndex = 0;
        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (posStartIndex<ln && negStartIndex<posStartIndex && arr[negStartIndex]<0)
        {
            int temp = arr[negStartIndex];
            arr[negStartIndex] = arr[posStartIndex];
            arr[posStartIndex]=temp;
            posStartIndex+=1;
            negStartIndex+=2;
        }
//        Time Complexity: O(n) where n is number of elements in given array.
//        Auxiliary Space: O(1)

    }
}

package com.Arrays.TripletQues;
/*
Count the triplets such that A[i] < B[j] < C[k]
Given three array A[], B[] and C[] of N integers each. The task is to find the count of triplets
(A[i], B[j], C[k]) such that A[i] < B[j] < C[k].

Input: A[] = {1, 5}, B[] = {2, 4}, C[] = {3, 6}
Output: 3
Triplets are (1, 2, 3), (1, 4, 6) and (1, 2, 6)

Input: A[] = {1, 1, 1}, B[] = {2, 2, 2}, C[] = {3, 3, 3}
Output: 27

Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Approach: Sort all the given arrays. Now fix an element say X in array B[] and for each X,
the answer will be the product of the count of elements in array A[] which are less than X and
the count of elements in array C[] which are greater than X. We can compute both of these counts
using modified binary search.*/

import java.util.Arrays;

public class ThreeArrayIncreasingFind {
    public static void main(String[] args)
    {
        int[] a = { 1, 5 };
        int[] b = { 2, 4 };
        int[] c = { 3, 6 };
        int size = a.length;
        System.out.println(countTripletsIJKIncreasing(size, a, b, c));
    }

    private static int countTripletsIJKIncreasing(int size, int[] a, int[] b, int[] c) {
        if(size<1)
            throw new IllegalArgumentException();
        int totalTripletCount=0;
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        for (int value : b) {
            int countLessInA = countLesserInA(value, a);
            int countHighInC = countGreaterInC(value, c);
            totalTripletCount += (countHighInC * countLessInA);
        }
        return totalTripletCount;
    }

    private static int countGreaterInC(int elem, int[] sortedArr) {
        int left=0;
        int right=sortedArr.length-1;
        int numOfElementsGreater=-1;
        while(left<=right)
        {
            int mid = left + (right-left) /2;
            if(sortedArr[mid]<=elem)
            { left = mid+1; }
            else
            {
                right = mid - 1;
                numOfElementsGreater = mid;
            }
        }
        return (numOfElementsGreater== -1 ) ? 0: sortedArr.length-numOfElementsGreater;
    }

    private static int countLesserInA(int elem, int[] sortedArr) {
        int left=0;
        int right=sortedArr.length-1;
        int numOfElementsSmaller=-1;
        while(left<=right)
        {
            int mid = left + (right-left) /2;
            if(sortedArr[mid]<=elem)
            {
                left=mid+1;
                numOfElementsSmaller = mid;
            }
            else
                right = mid-1;
        }
        return numOfElementsSmaller+1;
    }
}

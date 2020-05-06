package com.Arrays.PairQues;
//Maximum Difference between two elements in array – Largest Gap Problem
//        Objective: Given an array of numbers, write an algorithm to find the maximum difference
//        between any two elements in the array.
//        Example:
//        Int [] a = {2, 8, 1, 6, 10, 4}
//        Output: Maximum difference= 9 (elements are 1 and 10)

public class MaxDiffBtwTwoElements {
    public static void main(String[] args) {
        int [] a = {2, 8, 1, 6, 10, 4};
        findGap(a);
        int [] b = {10, 30, 5, 16, 19};
        findGap(b);
    }

    private static void findGap(int[] arr) {
        if(arr.length<2)
            throw new IllegalArgumentException();
        int maxSeen=arr[0];
        int minSeen=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>maxSeen)
                maxSeen=arr[i];
            if(arr[i]<minSeen)
                minSeen=arr[i];
        }
       int  max_diff = maxSeen-minSeen;
        System.out.println("Largest Gap between any two elements is: " +  max_diff);
    }
}

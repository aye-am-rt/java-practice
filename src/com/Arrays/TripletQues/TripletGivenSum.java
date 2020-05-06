package com.Arrays.TripletQues;
//Approach: Use Hashing
//
//        Use the other loop to fix the one element at a time.
//        Now required_sum is (with two elements) = k-fixed element.
//        Create a HashSet, Iterate through rest of the array.
//        For current_element, remain_value = required_sum – current_element.
//        Check if remain_value in the HashSet, we have found our triplets else add current_element to
//        the hashSet.
//        Time Complexity: O(n^2)

import java.util.HashSet;

public class TripletGivenSum {
    public static void main(String[] args) {
        int[] arr = { 3,1,7,7,5,9,10};
        int findSum = 15;
        findTripletWithGivenSum(arr,findSum);
    }

    private static void findTripletWithGivenSum(int[] arr, int findSum) {
        if(arr.length<3)
            throw new IllegalArgumentException();

        for (int i = 0; i < arr.length; i++) {
            int currSecPart = findSum-arr[i];
            int start=i+1;
            int end= arr.length-1;
            HashSet<Integer> hSet=new HashSet<>();
            for (int j = start; j <= end; j++) {
                int currThirdPart = currSecPart - arr[j];
                if(hSet.contains(currThirdPart))
                {
                    System.out.println("Found 3 elements whose sum is = " +findSum);
                    System.out.println("Elements are " + arr[i] + " " + arr[j]+ " " + currThirdPart);
                    //return;  removing this return it will print all triplets with given sum.
                }
                else
                    hSet.add(arr[j]);
            }
        }
    }
}

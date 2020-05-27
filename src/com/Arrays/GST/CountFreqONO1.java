package com.Arrays.GST;

import java.util.HashMap;

/**
Count frequencies of all elements in array in O(1) extra space and O(n) time
Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be
 repeated multiple times and some other elements can be absent from the array. Count frequency of
 all elements that are present and print the missing elements.
Examples:
Input: arr[] = {2, 3, 3, 2, 5}
Output: Below are frequencies of all elements
1 -> 0
2 -> 2
3 -> 2
4 -> 0
5 -> 1
Explanation: Frequency of elements 1 is
0, 2 is 2, 3 is 2, 4 is 0 and 5 is 1.

Input: arr[] = {4, 4, 4, 4}
Output: Below are frequencies of all elements
1 -> 0
2 -> 0
3 -> 0
4 -> 4
Explanation: Frequency of elements 1 is
0, 2 is 0, 3 is 0 and 4 is 4.*/

public class CountFreqONO1 {
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 3, 2, 5};
        PrintCountsUsingHashMap(arr, arr.length);
        PrintCountsUsingAddNCount(arr, arr.length);
        System.out.println(" \n************* ");

        int[] arr1 = {1};
        PrintCountsUsingHashMap(arr1, arr1.length);
        PrintCountsUsingAddNCount(arr1, arr1.length);
        System.out.println(" \n************* ");



        int[] arr3 = {4, 4, 4, 4};
        PrintCountsUsingHashMap(arr3, arr3.length);
        PrintCountsUsingAddNCount(arr3, arr3.length);
        System.out.println(" \n************* ");



        int[] arr2 = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
        PrintCountsUsingHashMap(arr2, arr2.length);
        PrintCountsUsingAddNCount(arr2, arr2.length);
        System.out.println(" \n************* ");



        int[] arr4 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        PrintCountsUsingHashMap(arr4, arr4.length);
        PrintCountsUsingAddNCount(arr4, arr4.length);
        System.out.println(" \n************* ");


        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        PrintCountsUsingHashMap(arr5, arr5.length);
        PrintCountsUsingAddNCount(arr5, arr5.length);
        System.out.println(" \n************* ");

        int[] arr6 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        PrintCountsUsingHashMap(arr6, arr6.length);
        PrintCountsUsingAddNCount(arr6, arr6.length);

    }

/**
 Method 3: By adding ‘n’ to keep track of counts.
 Approach: All the array elements are from 1 to n. Reduce every element by 1. The array elements now are
 in range 0 to n-1 so it can be said that for every index i, floor(array[i]/n) = 0.
 So as previously said that the idea is to traverse the given array, use elements as an index and store
 their counts at the index. Consider the basic approach, a Hashmap of size n is needed and the array
 is also of size n. So the array can be used as a hashmap but the difference is that instead of replacing
 elements add n to the array[i]th index.
 So after the updadation the array[i]%n will give the ith element and array[i]/n will give the frequency
 of i+1.*/

    private static void PrintCountsUsingAddNCount(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();

        for (int i = 0; i < ln; i++) {
            arr[i] = arr[i]-1;// Subtract 1 from every element so that the elements
            // become in range from 0 to n-1
        }
        // Use every element arr[i] as index and add 'n' to
        // element present at arr[i]%n to keep track of count of
        // occurrences of arr[i]
        for (int i = 0; i < ln; i++) {
            arr[arr[i]%ln] = arr[arr[i]%ln]+ln;
        }
        // To print counts, simply print the number of times n
        // was added at index corresponding to every element
        for (int i = 0; i < ln; i++) {
            System.out.print(i+1+"->"+(arr[i]/ln)+" , ");
        }

    }

    private static void PrintCountsUsingHashMap(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        HashMap<Integer,Integer> countMap=new HashMap<>(ln);
        for (int i = 0; i < ln; i++) {
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }
        countMap.forEach((K,V)-> System.out.print(K+"->"+V+" , "));
        System.out.println(" END EXCLUSIVE ");
/*
        int hash[n]={0};   // another way use a new array as hash map
        // Traverse all array elements
        int i = 0;
        while (i<n)
        {
            //update the frequency of array[i]
            hash[arr[i]-1]++;
            //increase the index
            i++;
        }*/
    }

}

//Algorithm:   Method 2: By making elements negative
//        Traverse the array from start to end.
//        For each element check if the element is less than or equal to zero or not. If negative or
//        zero skip the element as it is freqeuncy.
//        If element (e = array[i] – 1 ) is positive then check if array[e] is positive or not. If
//        positive then that means it is the first occurance of e in the array and replace array[i]
//        with array[e], i.earray[i] = array[e] and assign array[e] = -1. If array[e] is negative then
//        it is not the first occurance, the update array[e] as array[e]– and update array[i] as
//        array[i] = 0.
//        Again traverse the array and print i+1 as value and array[i] as frequency.

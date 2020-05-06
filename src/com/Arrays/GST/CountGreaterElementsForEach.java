package com.Arrays.GST;
/*
Count of greater elements for each element in the Array
Given an array arr of integers of size N, the task is to find, for every element, the number of
elements that are greater than it.
Examples:
Input: arr[] = {4, 6, 2, 1, 8, 7}
Output: {3, 2, 4, 5, 0, 1}
Input: arr[] = {2, 3, 4, 5, 6, 7, 8}
Output: {6, 5, 4, 3, 2, 1, 0}*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class CountGreaterElementsForEach {
    public static void main(String[] args)
    {
        int[] arr = {1,1,3,3,2,2};   // 7, 9, 5, 2, 1, 3, 4, 8, 6
        int n = arr.length;
        countOfGreaterElementsForEachOne(arr, n);
        countOfGreaterElementsForEachOneHashMap(arr, n);
    }

    private static void countOfGreaterElementsForEachOneHashMap(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        HashMap<Integer,Integer> freqMap=new HashMap<>(n);
        TreeSet<Integer> ts=new TreeSet<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
            ts.add(arr[i]);
        }
        // Store the sum of frequency of elements greater than the current element
        //int x=0;
        //int[] ansArray=new int[n];
        for (int i = n-1; i > -1; i--) {
            int indexInTs= ts.contains(arr[i])?ts.headSet(arr[i]).size():-1;
            System.out.print("index of element "+arr[i]+" in treeSet == "+indexInTs);
            System.out.println(" and Freq of element "+arr[i]+" " +
                    "in HashMap == "+freqMap.getOrDefault(arr[i],-1));
        }
    }

    private static void countOfGreaterElementsForEachOne(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();

        System.out.println("given  array = "+Arrays.toString(arr));
        int[] ansCountArray=new int[n];
        Arrays.sort(arr);
        System.out.println("sorted array = "+Arrays.toString(arr));
        int end=n-2;
        ansCountArray[n-1]=0;
        while (end > -1) {
            int i=end;
            if(arr[i]==arr[i+1])
            { ansCountArray[i]=ansCountArray[i+1];}
            else
            {ansCountArray[i]=n-end-1;}
            end-=1;
        }
        System.out.println("answer Array = "+Arrays.toString(ansCountArray));
    }

}

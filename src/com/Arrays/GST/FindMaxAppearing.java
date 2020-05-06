package com.Arrays.GST;
//
//Find the element which appears maximum number of times in the array.
//        Objective: Given an array of integers, write a algorithm to
//        find the element which appears maximum number of times in the array.
//        Example:
//        int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
//        Output: Element repeating maximum no of times: 5, maximum count: 3
/****************
Naive approach: Use 2 loops. Check each element in the array with all other elements in the array and
keep track of its count and also maintain the max counter which track the element repeats the
maximum number of time.
Time Complexity : O(n^2) Space Complexity: O(1)
**************/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/************
Sorting approach: Sort the array, this will bring all the duplicates together if present. Now
navigate the array and keep track of its count and also maintain the max counter which track the
element repeats the maximum number of time.
Time Complexity : O(nlogn) Space Complexity: O(n) by using merge sort.
 ****************/
/*
Better Solution : Use Hashmap. Store the count of each element of array in a hash table and later
 check in Hash map which element has the maximum count – Find duplicates in an given array
Time Complexity : O(n) and Space Complexity: O(n).*/

public class FindMaxAppearing {
    public static void main(String[] args) {
        int [] arr = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
        maxRepeatingElementUsingSorting(arr,arr.length);
        maxRepeatingElementUsingHashMap(arr,arr.length);

    }

    private static void maxRepeatingElementUsingHashMap(int[] arr, int ln) {
        if(ln<1){
            System.out.println("Invalid Array");
            return;
        }
        HashMap<Integer,Integer> fhMap=new HashMap<>();
        for (int i : arr) {
            fhMap.put(arr[i],fhMap.getOrDefault(arr[i],0)+1);
        }
        // now we can traverse array again check each element freq in hMap and return MaxFreq and index.
        // new way to traverse HMap using entrySet() and iterator.
        Iterator itr=fhMap.entrySet().iterator();
        int maxCount = 0;
        int maxRepElem =arr[0];
        while (itr.hasNext())
        {
            Map.Entry ent=(Map.Entry) itr.next();
            int count= (Integer) ent.getValue();
            if(count>maxCount)
            {
                maxCount=count;
                maxRepElem=(Integer) ent.getKey();

            }
        }
        System.out.println("Element repeating maximum no of times: "
                + maxRepElem + ", maximum count: " + maxCount);
    }

    private static void maxRepeatingElementUsingSorting(int[] arrA, int ln) {
        if(ln<1){
            System.out.println("Invalid Array");
            return;
        }
        Arrays.sort(arrA);
        int count=1;
        int maxCount=1;
        int currentElement = arrA[0];
        int maxCountElement =arrA[0];
        for (int i = 1; i <arrA.length ; i++)
        {
            if(currentElement==arrA[i])
            { count++; }
            else
            {
                if(count>maxCount)
                {
                    maxCount = count;
                    maxCountElement = currentElement;
                }
                currentElement = arrA[i];
                count = 1;
            }
        }
        System.out.println("Element repeating maximum no of times: "
                + maxCountElement + ", maximum count: " + maxCount);
    }
}
/**
 Better Solution (Conditional) : O(n) time and O(1) extra space.
 This solution works only if array has positive integers and all the elements in the array
 are in range from 0 to n-1 where n is the size of the array.
 Nav­i­gate the array.
 Update the array as for ith index :- arrA[arrA[i]% n] = arrA[arrA[i]% n] + n;
 Now navigate the updated array and check which index has the maximum value, that index number
 is the element which has the maximum occurrence in the array.
 */

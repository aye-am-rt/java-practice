package com.Arrays.PairQues;
/*
Find pair with greatest product in array
Given an array of n elements, the task is to find the greatest number such that it is product of
two elements of given array. If no such element exists, print -1.
Elements are within the range of 1 to 10^5.

Examples :
Input :  arr[] = {10, 3, 5, 30, 35}
Output:  30
Explanation: 30 is the product of 10 and 3.

Input :  arr[] = {2, 5, 7, 8}
Output:  -1
Explanation: Since, no such element exists.

Input :  arr[] = {10, 2, 4, 30, 35}
Output:  -1

Input :  arr[] = {10, 2, 2, 4, 30, 35}
Output:  4

Input  : arr[] = {17, 2, 1, 35, 30}
Output : 35*/

import java.util.Arrays;
import java.util.HashMap;

/**
An efficient method follows below implementation:-

Create an empty hash table and store all array elements in it.
Sort the array in ascending order.
Pick elements one by one from end of the array.
And check if there exists a pair whose product is equal to that number. In this efficiency can
 be achieved. The idea is to reach till sqrt of that number. If we don’t get the pair till sqrt that
 means no such pair exists. We use hash table to make sure that we can find other element of pair
 in O(1) time.
Repeat steps 2 to 3 until we get the element or whole array gets traversed.*/

public class IfPairAndProductAllPresent {
    public static void main(String[] args)
    {
        int[] arr = {17, 2, 1, 15, 30};
        int n = arr.length;
        System.out.println(findGreatestProduct_andPair(arr, n));
    }

    private static int findGreatestProduct_andPair(int[] arr, int n) {
        HashMap<Integer,Integer> hMap = new HashMap<>();
        // Store occurrences of all elements in hash array
        for (int i = 0; i < n; i++)
        {
            hMap.put(arr[i],hMap.getOrDefault(arr[i],0)+1);
        }
        Arrays.sort(arr);
        for (int i = n-1; i > 1; i--) {
            // For every element getting from end, check if there is another element which divides it.
            for (int j = 0; j < i && arr[j]<= Math.sqrt(arr[i]); j++)
            {
                if(arr[i]%arr[j]==0)
                {
                    int toCheckExists = arr[i]/arr[j];
                    if(hMap.containsKey(toCheckExists) && hMap.get(toCheckExists)>0)
                    {
                        return arr[i];
                    }
                }
            }
        }
        return -1;
    }
}

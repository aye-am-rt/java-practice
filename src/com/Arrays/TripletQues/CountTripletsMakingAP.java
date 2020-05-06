package com.Arrays.TripletQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
Count triplets in an array such that i<j<k and a[j] – a[i] = a[k] – a[j] = D
Given an array arr and an integer D, the task is to count the number of triplets(arr[i], arr[j],
 arr[k]) in the array such that:
 i < j < k
arr[j] – arr[i] = arr[k] – arr[j] = D

 Examples:
Input: arr = {1, 6, 7, 7, 8, 10, 12, 13, 14}, D = 3
Output: 2
Explanation:
There are two triplets in the array that satisfies the given criteria.
-> 1st triplet(7, 10, 13) such that i = 3, j = 6 and k = 8, such that (i < j < k) and
 (10 – 7 = 13 – 10 = D (=3))
-> 2nd triplet(7, 10, 13) such that i = 4, j = 6 and k = 8, such that (i < j < k) and
 (10 – 7 = 13 – 10 = D (=3))

Input: arr = {6, 3, 4, 5}, D = 1
Output: 0*/
/*Efficient Approach:

An efficient approach for this problem is to use a map to store (key, values) pair where value
will be count of key.
The idea is to traverse the array from 0 to N and do following:
check that A[i] – D and A[i] – 2*D are present in the map or not.
If it’s in the map then we will simply multiply their respective values and increase answer by that.
Now, we just have to put A[i] into the map and update the map.
Below is the implementation of the above approach.*/
public class CountTripletsMakingAP {
    public static void main(String[] args)
    {

        // Test Case 1:
        int[] a1 = { 1, 6, 7, 7, 8, 10, 12, 13, 14 };
        int d1 = 3;
        System.out.println(countTripletsFormingAP(a1, d1));

//        // Test Case 2:
//        int[] a2 = { 6, 3, 4, 5 };
//        int d2 = 1;
//        System.out.println(countTripletsFormingAP(a2, d2));

//        // Test Case 3:
//        int[] a3 = { 1, 2, 4, 5, 7, 8, 10 };
//        int d3 = 3;
//        System.out.println(countTripletsFormingAP(a3, d3));
    }

    private static int countTripletsFormingAP(int[] arr, int dist) {
        if(arr.length<3)
            throw new IllegalArgumentException();

        HashMap<Integer,Integer> freqMap=new HashMap<>(arr.length);
        ArrayList<Integer> al= Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        //TreeSet<Integer> ts=new TreeSet<>();
        for (int value : arr) {
            freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
        }
        int count=0;
        for (int intElem : arr) {
            if (freqMap.containsKey(intElem + dist) && freqMap.containsKey(intElem - dist)) {

                if(al.lastIndexOf(intElem - dist)<al.lastIndexOf(intElem) &&
                al.lastIndexOf(intElem)<al.lastIndexOf(intElem+dist)) {

                    if (freqMap.get(intElem + dist) > 0 && freqMap.get(intElem - dist) > 0
                            && freqMap.get(intElem)>0) {
                        count += 1;
                        System.out.println((intElem-dist)+ "--"+ intElem +"--"+(intElem+dist)+"->");
                        freqMap.put(intElem + dist, freqMap.get(intElem + dist) - 1);
                        freqMap.put(intElem - dist, freqMap.get(intElem - dist) - 1);
                        freqMap.put(intElem, freqMap.get(intElem) - 1);
                        if(al.contains(intElem))
                            al.remove(al.lastIndexOf(intElem));
                        if(al.contains(intElem+dist))
                            al.remove(al.lastIndexOf(intElem+dist));
                        if(al.contains(intElem-dist))
                            al.remove(al.lastIndexOf(intElem-dist));
                    }
                }
            }
        }
        return count;
    }
}

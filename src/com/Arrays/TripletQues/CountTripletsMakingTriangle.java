package com.Arrays.TripletQues;

import java.util.HashMap;

/**
Count triplets such that sum of any two number is equal to third | Set 2
Given an array of distinct positive integers arr[] of length N, the task is to count all the triplets
 such that sum of two elements equals the third element.
Examples:
Input: arr[] = {1, 5, 3, 2}
Output: 2
Explanation:
In the given array, there are two such triplets such that sum of the two numbers is equal to the
 third number, those are –
(1, 2, 3), (3, 2, 5)

Input: arr[] = {3, 2, 7}
Output: 0
Explanation:
In the given array there are no such triplets such that sum of two numbers is equal to the third
 number.

Approach: The idea is to create a frequency array of the numbers which are present in the array
 and then check for each pair of the element that sum of the pair elements is present in the array
 or not with the help of frequency array in O(1) time.

Algorithm:

Declare a frequency array to store the frequency of the numbers.
Iterate over the elements of the array and increment the count of that number in the frequency array.
Run two loops to choose two different indexes of the matrix and check that if the sum of the elements
 at those indexes is having frequency more than 0 in the frequency array.
If frequency of the sum is greater than 0:
Increment the count of the triplets.*/

public class CountTripletsMakingTriangle {
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 3, 2};
        int n=arr.length;
        System.out.print(countTripletsMakingSidesOfTriangle(arr, n));
    }

    private static int countTripletsMakingSidesOfTriangle(int[] arr, int n) {
        if(n<3)
            throw new IllegalArgumentException();
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(freqMap.get(arr[i]+arr[j])!=null)  // checkWith freqMap.containsKey(arr[i]+arr[j])
                    count++;
            }
        }
        return count;
    }
}

// if not hashMap or HashSet sometimes we can work with arrays
// like    boolean character[] = new boolean[26];
// this array can be used to check presence of a particular char in string and number of times also.

// then in above problem assume a max number like 1000 etc to make array and traverse through
// original array and increase the number on index equal to number in array by 1 ..by that we can
// work like hash map ... same O(1) time access also.

//  int []freq = new int[100];
// Loop to count the frequency
//    for (int i = 0; i < n; i++){
//        freq[arr[i]]++;
//        }

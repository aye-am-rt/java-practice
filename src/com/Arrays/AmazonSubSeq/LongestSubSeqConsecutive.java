package com.Arrays.AmazonSubSeq;

import java.util.HashSet;

/**
Longest Consecutive Subsequence
Given an array of integers, find the length of the longest sub-sequence such that elements in
 the subsequence are consecutive integers, the consecutive numbers can be in any order.
Examples:

Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence
of consecutive elements
Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
The subsequence 36, 35, 33, 34, 32 is the longest subsequence
of consecutive elements.

 We can solve this problem in O(n) time using an Efficient Solution. The idea is to use Hashing.
 We first insert all elements in a Set. Then check all the possible starts of consecutive subsequences.
 Below is the complete algorithm.

 Create an empty hash.
 Insert all array elements to hash.
 Do following for every element arr[i]
 Check if this element is the starting point of a subsequence. To check this, we simply look for
 arr[i] – 1 in the hash, if not found, then this is the first element a subsequence.
 If this element is the first element, then count number of elements in the consecutive starting
 with this element. Iterate from arr[i] + 1 till the last element that can be found.
 If the count is more than the previous longest subsequence found, then update this.

 */
// Time Complexity: O(n)
    // Time Complexity: O(n)
public class LongestSubSeqConsecutive {
    // Testing program Time Complexity: O(n)
    public static void main(String[] args)
    {
        int[] arr =  {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " +
                findLongestConseqSubseq(arr,n));
    }

    private static int findLongestConseqSubseq(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        // We first insert all elements in a Set. Then check all the possible starts of
        // consecutive subsequences.
        HashSet<Integer>  hSet =  new HashSet<>();
        int ansLength=0;
        for (int i : arr)
        { hSet.add(i);}
        for (int i = 0; i < arr.length; i++) {
            if(!hSet.contains(arr[i]-1))
            {
                // Then check for next elements in the sequence
                int newElem = arr[i];
                while (hSet.contains(newElem))
                {
                    newElem++;
                }
                // because elements are consecutive we can subtract and get length of sequence
                // Eg:> 4 to 9 ==> consecutive elements will be of length 9 - 4 = 5 length
                if((newElem-arr[i])>ansLength)
                    ansLength = newElem-arr[i];
            }
        }
        return ansLength;
    }

}
/**
 * Time Complexity: O(n)
Time Complexity: At first look, time complexity looks more than O(n). If we take a closer look, we
 can notice that it is O(n) under the assumption that hash insert and search take O(1) time. The
 function S.find() inside the while loop is called at most twice for every element. For example,
 consider the case when all array elements are consecutive. In this case, the outer find is called
 for every element, but we go inside the if condition only for the smallest element. Once we are
 inside the if condition, we call find() one more time for every other element.*/

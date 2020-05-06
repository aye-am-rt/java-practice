package com.Arrays.PairQues;
/*
Number of pairs in an array with the sum greater than 0
Given an array arr[] of size N, the task is to find the number of distinct pairs in the array
whose sum is > 0.
Examples:
Input: arr[] = { 3, -2, 1 }
Output: 2
Explanation:
There are two pairs of elements in the array whose sum is positive. They are:
{3, -2} = 1
{3, 1} = 4
Input: arr[] = { -1, -1, -1, 0 }
Output: 0
Explanation:
There are no pairs of elements in the array whose sum is positive.*/

import java.util.Arrays;

/**Efficient Approach:

        The idea is to use the concept of sorting and two pointer technique.
        For this problem, sorting is used because for the sum arr[i] + arr[j] > 0 where i, j are some
 random indices in the array, either arr[i] > 0 or arr[j] > 0 or both arr[i] and arr[j] > 0.
        Therefore, once the array is sorted, since we need to find the unique pairs. For every ‘i’
 such that arr[i] > 0, we need to find the number of j’s such that arr[j] + arr[j] > 0.
        Here, it is easy to find the count of pairs by using two pointer technique because the array
 is sorted. We just need to find the leftmost position of ‘j’ for which the condition holds true. This is found using the lower_bound of -arr[i] + 1.
        For example, let the array arr[] = {-4, 4, -5, 5, 3, -2, -3, -1, 2, 1}. This array is sorted.
 Therefore, the array becomes, {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5}. For some random i, lets assume
 arr[i] = 4. Therefore, the index of -3 is found in the array which is 2. Now, we can be sure that for
 all the values between the indices 2 and 8, the value of arr[i] + arr[j] > 0.*/

public class CountPairsSumMoreZero {
    public static void main(String[] args)
    {
        int[] a = {-2,-1,1,4}; // -4, 4, -5, 5, 3, -2, -3, -1, 2, 1
        int n = a.length;
        int ans = findNumOfPairHavingSumMoreThanZero(a, n);
        System.out.println(ans);
    }

    private static int findNumOfPairHavingSumMoreThanZero(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        Arrays.sort(arr);
        System.out.println("sorted array = "+Arrays.toString(arr));
        int count=0;
        for (int i = 0; i < ln; i++) {
            if(arr[i]>0)
            {
                int j=0;
                while(arr[j]+arr[i]<=0)
                { j+=1; }

                if(j<ln) {
                    count += i-j; // done this i-j thing so that element doesn't get used twice.
                }
            }
        }
        return count;
    }
}

package com.Arrays.PairQues;
//
//Given a list of positive integers nums and an int target, return indices of the two numbers such that
// they add up to a target - 30.
//        Conditions:
//        You will pick exactly 2 numbers.
//        You cannot pick the same element twice.
//        If you have multiple pairs, select the pair with the largest number.

/**
Method 1: The first method uses the technique of Sortings and Two pointers to arrive at the
 solution
        Approach: A tricky approach to solve this problem can be to use the two-pointer technique.
 But for using two pointer technique, the array must be sorted. Once the array is sorted the two
 pointers can be taken which mark the beginning and end of the array respectively. If the sum is
 greater than the sum of those two elements, shift the left pointer to increase the value of required
 sum and if the sum is lesser than the required value, shift the right pointer to decrease the value.
 Let’s understand this using an example.
        Let an array be {1, 4, 45, 6, 10, -8} and sum to find be 16
        After sorting the array
        A = {-8, 1, 4, 6, 10, 45}
        Now, increment ‘l’ when the sum of the pair is less than the required sum and decrement ‘r’
 when the sum of the pair is more than the required sum.
        This is because when the sum is less than the required sum then to get the number which could
 increase the sum of pair, start moving from left to right(also sort the array) thus “l++” and vice
 versa.
        Initialize l = 0, r = 5
        A[l] + A[r] ( -8 + 45) > 16 => decrement r. Now r = 4
        A[l] + A[r] ( -8 + 10) increment l. Now l = 1
        A[l] + A[r] ( 1 + 10) increment l. Now l = 2
        A[l] + A[r] ( 4 + 10) increment l. Now l = 3
        A[l] + A[r] ( 6 + 10) == 16 => Found candidates (return 1)
        Note: If there are more than one pair having the given sum then this algorithm reports
 only one. Can be easily extended for this though.
        Algorithm :
        hasArrayTwoCandidates (A[], ar_size, sum)
        Sort the array in non-decreasing order.
        Initialize two index variables to find the candidate
        elements in the sorted array.
        Initialize first to the leftmost index: l = 0
        Initialize second the rightmost index: r = ar_size-1
        Loop while l < r.
        If (A[l] + A[r] == sum) then return 1
        Else if( A[l] + A[r] < sum ) then l++
        Else r–
        No candidates in whole array – return 0
*/


import java.util.Arrays;
import java.util.LinkedHashMap;

public class PairWithGivenSum {
    public static void main(String[] args)
    {
        int[] arr={20,50,40,25,30,10};
        int target=90;
        PrintPairWithBestSum(arr,target,arr.length);


        int[] A = { 1, 4, 45, 6, 10, -8 };
        int findSum = 16;
        int arr_size = A.length;

        if (hasArrayTwoCandidates(A, arr_size, findSum))
            System.out.println("Array has two " + "elements with given sum");
        else
            System.out.println("Array doesn't have " + "two elements with given sum");
    }

    private static boolean hasArrayTwoCandidates(int[] arr, int size, int findSum) {
        int l, r;
        Arrays.sort(arr);
        l = 0;
        r = size - 1;
        while (l < r)
        {
            if (arr[l] + arr[r] == findSum)
                return true;

            else if (arr[l] + arr[r] < findSum)
                l++;

            else // arr[i] + arr[j] > findSum
                r--;
        }
        return false;
    }

    private static void PrintPairWithBestSum(int[] arr, int target, int length) {
        if(length<2)
            return;
        LinkedHashMap<Integer,Integer> lhm=new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            lhm.put(arr[i],i);
        }
        int fNum=-10; // any random number which could not be in array take as start point
        int sNum=-20;  // both of them could have been Integer.MIN_Value also.
        for (int i = 0; i < length; i++) {
            if(lhm.containsKey(target-30-arr[i]))
            {
                if(arr[i]>fNum && arr[i]>sNum) {
                    fNum = arr[i];
                    int secIndex = lhm.get(target - 30 - arr[i]);
                    sNum = arr[secIndex];
                }
            }
        }
        System.out.println("best pair which is equal to target-30 = "+(target-30)+" are ==");
        System.out.println("firstNum = "+fNum+ " secNum = "+sNum);
        System.out.println("indices are = "+lhm.get(fNum)+ " and "+lhm.get(sNum));
    }

}

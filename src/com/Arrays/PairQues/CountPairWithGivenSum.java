package com.Arrays.PairQues;

import java.util.HashMap;

/**
Count pairs with given sum
Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array
 whose sum is equal to ‘sum’.

Examples:
Input  :  arr[] = {1, 5, 7, -1},
sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)

Input  :  arr[] = {1, 5, 7, -1, 5},
sum = 6
Output :  3
Pairs with sum 6 are (1, 5), (7, -1) &
(1, 5)

Input  :  arr[] = {1, 1, 1, 1},
sum = 2
Output :  6
There are 3! pairs with sum 2.

Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1},
sum = 11
Output :  9

 public static void main(String args[])
 {
 int[] arr = { 1, 5, 7, -1, 5 };
 int sum = 6;
 getPairsCount(arr, sum);
 }

 // Prints number of pairs in arr[0..n-1] with sum equal
 // to 'sum'
 public static void getPairsCount(int[] arr, int sum)
 {

 int count = 0;// Initialize result

 // Consider all possible pairs and check their sums
 for (int i = 0; i < arr.length; i++)
 for (int j = i + 1; j < arr.length; j++)
 if ((arr[i] + arr[j]) == sum)
 count++;

 System.out.printf("Count of pairs is %d",count);
 }
 this o(n2) time O(1) space
 *************************************************************************
 A better solution is possible in O(n) time.

 Create a map to store frequency of each number in the array. (Single traversal is required)

 In the next traversal, for every element check if it can be combined with any other element
 (other than itself!) to give the desired sum. Increment the counter accordingly.

 After completion of second traversal, we’d have twice the required value stored in counter because
 every pair is counted two times. Hence divide count by 2 and return.
 */

public class CountPairWithGivenSum {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 7, -1, 5} ;
        int sum = 6;
        System.out.println("Count of pairs is " + getPairsCount(arr, arr.length,sum));

        int[] arr2 = {11, 15, 6, 8, 9, 10};
        int sum2 = 16;
        System.out.println("Count of pairs is " + getPairsCount(arr2, arr2.length,sum2));
    }

    private static int getPairsCount(int[] arr, int ln, int targetSum)
    {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < ln; i++)
        {
            countMap.put(arr[i], countMap.getOrDefault(arr[i],0)+1);
        }
        int twiceCount = 0;
        for (int i = 0; i < ln; i++)
        {
            if(countMap.get(targetSum-arr[i]) != null)
            {
                twiceCount += countMap.get(targetSum-arr[i]);
            }
            // if (arr[i], arr[i]) pair satisfies the condition, then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i]) // pair is not considered
            if(targetSum-arr[i] ==  arr[i])
                twiceCount--;
        }
        // return the half of twice_count
        return twiceCount/2;
    }

}
/**    3rd approach is sorting then 2 pointer technique.
Approach: Two Different methods have already been discussed here. Here, a method based on sorting
 will be discussed.

Sort the array and take two pointers i and j, one pointer pointing to the start of the array
 i.e. i = 0 and another pointer pointing to the end of the array i.e. j = n – 1.
If arr[i] + arr[j] is
Greater than the sum then decrement j.
Lesser than the sum then increment i.
Equals to the sum then count such pairs.*/
/*
// Function to return the count of pairs  from arr[] with the given sum
static int pairs_count(int arr[], int n, int sum)
{
    // To store the count of pairs
    int ans = 0;

    // Sort the given array
    Arrays.sort(arr);

    // Take two pointers
    int i = 0, j = n - 1;

    while (i < j)
    {

        // If sum is greater
        if (arr[i] + arr[j] < sum)
            i++;

            // If sum is lesser
        else if (arr[i] + arr[j] > sum)
            j--;

            // If sum is equal
        else
        {

            // Find the frequency of arr[i]
            int x = arr[i], xx = i;
            while ((i < j ) && (arr[i] == x))
                i++;

            // Find the frequency of arr[j]
            int y = arr[j], yy = j;
            while ((j >= i )&& (arr[j] == y))
                j--;

            // If arr[i] and arr[j] are same
            // then remove the extra number counted
            if (x == y)
            {
                int temp = i - xx + yy - j - 1;
                ans += (temp * (temp + 1)) / 2;
            }
            else
                ans += (i - xx) * (yy - j);
        }
    }
    // Return the required answer
    return ans;
}*/

package com.Arrays.AmazonSubSeq;
/**

Longest subarray such that adjacent elements have at least one common digit | Set – 2
Given an array of N integers, the task is to find the length of the longest subarray such that
 adjacent elements of the subarray have at least one digit in common.

Examples:

Input : arr[] = {12, 23, 45, 43, 36, 97}
Output : 3
Explanation: The subarray is 45 43 36 which has
4 common in 45, 43 and 3 common in 43, 36.

Input : arr[] = {11, 22, 33, 44, 54, 56, 63}
Output : 4
Explanation: Subarray is 44, 54, 56, 63


The solution discussed in previous post uses O(N) extra space. The problem can be solved using
 constant space. A hashmap of constant size is used to store whether a digit is present in a given
 array element or not. To check if adjacent elements have a common digit, only count of digits for
 two adjacent elements is required. So the number of rows required in hashmap can be reduced to 2.
 The variable currRow represents current row and 1 – currRow represents previous row in hashmap.
 If adjacent elements have common digit then increase current length by 1 and compare it with maximum
 length. Otherwise set current length to 1.

*/


public class LongestSubAdjacentElement {
    public static void main(String[] args)
    {
        int[] arr = { 11, 22, 33, 44, 54, 56, 63 };
        int n = arr.length;

        System.out.println( longestSubArrayAdjacentElementCommon(arr, n));
    }
//
//    An efficient approach will be to create a hash[n][10] array which marks the occurrence of
//    digits in the i-th index number. We iterate for every element and check if adjacent elements
//    have a digit common in between. If they have a common digit, we keep the count of the length.
//    If the adjacent elements do not have a digit in common, we initialize the count to zero and
//    start counting again for a subarray. Print the maximum count which is obtained while iteration.
//    We use a hash array to minimize the time complexity as the number can be of range 10^18 which
//    will take 18 iterations in worst case.

    private static int longestSubArrayAdjacentElementCommon(int[] arr, int n) {
        // remembers the occurrence of digits in i-th index number
        int[][] hash = new int[n][10];
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while(num!=0)
            { hash[i][num%10]=1; num/=10;}
        }
        int countLongestSubA= Integer.MIN_VALUE;
        int countCurrSubA= 0;
        for (int i = 0; i < n-1; i++) {
            int j;
            for (j = 0; j < 10; j++) {
                // if adjacent elements have digit j in them count and break as we have
                // got at-least one digit
                if(hash[i][j] == 1 && hash[i+1][j] == 1)
                {
                    countCurrSubA++;
                    break;
                }
            }
            // if no digits are common otherwise loop would have broke before 10;
            if(j==10)
            {
                countLongestSubA = Math.max(countLongestSubA, countCurrSubA + 1);
                countCurrSubA = 0;
            }
        }
        countLongestSubA = Math.max(countLongestSubA, countCurrSubA + 1);
        // // returns the length of the longest subArray
        return countLongestSubA;
    }
}

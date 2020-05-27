package com.Arrays;
/**

Longest Mountain Subarray
Given an array arr[] with N elements, the task is to find out the longest sub-array which
 has the shape of a mountain.

A mountain sub-array consists of elements that are initially in ascending order until a peak
 element is reached and beyond the peak element all other elements of the sub-array are in
 decreasing order.
Examples:
Input: arr = [2, 2, 2]
Output: 0
Explanation:
No sub-array exists that shows the behavior of a mountain sub-array.
Input: arr = [1, 3, 1, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5]
Output: 11
Explanation:
There are two sub-arrays that can be considered as mountain sub-arrays. The first one is from index
 0 – 2 (3 elements) and next one is from index 2 – 12 (11 elements).  As 11 > 2, our answer is 11.

 Efficient Approach:

 If the length of the given array is less than 3, print 0 as it is not possible to have a mountain
 sub-array in such case.
 Set the maximum length to 0 initially.
 Use the two-pointer technique (‘begin’ pointer and ‘end’ pointer) to find out the longest mountain
 sub-array in the given array.
 When an increasing sub-array is encountered, mark the beginning index of that increasing sub-array in
 the ‘begin’ pointer.
 If any index value is found in the ‘end’ pointer then reset the values in both the pointers as it
 marks the beginning of a new mountain sub-array.
 When a decreasing sub-array us encountered, mark the ending index of the mountain sub-array in the
 ‘end’ pointer.
 Calculate the length of the current mountain sub-array, compare it with the current maximum length
 of all mountain sub-arrays traversed until now and keep updating the current maximum length.

 */

//    Time Complexity: O(N)
//    Auxillary Space Complexity: O(1)

public class LongestMountainSubA {
    public static void main (String[] args)
    {
        int []arr = { 1, 3, 1, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5 };  //13 elements in array 0 to 12 index
        int n = arr.length;
        System.out.println( "longest length = "+LengthLongestMountainSubArray(arr, n));

    }
//    Time Complexity: O(N)
//    Auxillary Space Complexity: O(1)

    private static int LengthLongestMountainSubArray(int[] arr, int n) {
        if(n<3)
            throw new IllegalArgumentException();

        int k=-1,j=-1,longestLength=0;

        for (int i = 0; i < (n-1); i++) {
            if(arr[i+1]>arr[i])
            {
                // When a new mountain sub-array is found, there is a need to set the variables
                // k, j to -1 in order to help calculate the length of new mountain sub-array
                if(k!=-1)
                {
                    k=-1;
                    j=-1;
                }
                // j marks the starting index of a new mountain sub-array. So set the value of j
                // to current index i.
                if(j==-1)
                {
                    j=i;
                }
            }
            else
            {
                if (arr[i + 1] < arr[i])
                {
                    // Checks if starting element exists or not, if the starting element of the
                    // mountain sub-array exists then the index of ending element is stored in k
                    if(j!=-1)
                        k=i+1;
                    // This condition checks if both starting index and ending index
                    // exists or not, if yes, the length is calculated.
                    if(k!=-1 && j!=-1)
                    {
                        if(longestLength < k-j+1)
                            longestLength = k-j+1;
                    }
                }
                else
                {
                    // ignore if there is no increase or decrease in the value of the next element
                    k=-1;
                    j=-1;
                }
            }
        }
        // Checks and calculates the length if last element of the array is the last
        // element of a mountain sub-array
        if (k != -1 && j != -1) {
            if (longestLength < k - j + 1) {
                longestLength = k - j + 1;
            }
        System.out.println("start of mountain is index j= "+j+" end of mountain is index k= "+ k);
        }

        return longestLength;
    }
}
//    Time Complexity: O(N)
//    Auxillary Space Complexity: O(1)

package com.SegregateThings;

import java.util.Arrays;

/**Minimum number of swaps required to sort an array of first N number
Given an array arr[] of distinct integers from 1 to N. The task is to find the
 minimum number of swaps required to sort the array.
Example:

Input: arr[] = { 7, 1, 3, 2, 4, 5, 6 }
Output: 5
Explanation:
i           arr             swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0, 3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0, 1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3, 4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4, 5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5, 6)
5   [1, 2, 3, 4, 5, 6, 7]
Therefore, total number of swaps = 5

 For each index in arr[].
 Check if the current element is in it’s right position or not. Since the array contains
 distinct elements from 1 to N, we can simply compare the element with it’s index in array to
 check if it is at its right position.
 If current element is not at it’s right position then swap the element with the element
 which has occupied its place.
 Else check for next index.
 */

//Time Complexity: O(N) where N is the size of array.
//        Auxiliary Space: O(1)
public class MinSwapSortFirstN {
    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 4, 1, 5 };
        System.out.println(minimumSwaps(arr));
        System.out.println("after sorting first n number array");
        System.out.println(Arrays.toString(arr));
    }

    private static int minimumSwaps(int[] arr) {
        int countSwaps=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=(i+1))
            {
                while(arr[i]!=(i+1))
                {
                    // Swap current element with correct position of that element
                    int temp=arr[arr[i]-1];
                    arr[arr[i]-1]=arr[i];
                    arr[i]=temp;
                    countSwaps+=1;
                }
            }
        }
        return countSwaps;
    }

}

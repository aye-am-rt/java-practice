package com.SegregateThings;
/**Minimum adjacent swaps required to Sort Binary array
Given a binary array, task is to sort this binary array using minimum swaps. We are allowed
 to swap only adjacent elements
Examples:
Input : [0, 0, 1, 0, 1, 0, 1, 1]
Output : 3
1st swap : [0, 0, 1, 0, 0, 1, 1, 1]
2nd swap : [0, 0, 0, 1, 0, 1, 1, 1]
3rd swap : [0, 0, 0, 0, 1, 1, 1, 1]
 Approach :
 This can be done by finding number of zeroes to the right side of every 1 and add them.
 In order to sort the array every one always has to perform a swap operation with every zero
 on its right side. So the total number of swap operations for a particular 1 in array is
 the number of zeroes on its right hand side. Find the number of zeroes on right side for
 every one i.e. the number of swaps and add them all to obtain the total number of swaps.
 */

public class MinSwapsSortBinArray {
    public static void main(String[] args)
    {
        int[] ar = { 0, 0, 1, 0, 1, 0, 1, 1 };
        System.out.println(findMinSwaps(ar, ar.length));
    }

    private static int findMinSwaps(int[] ar, int ln) {
        int count=0;
        int num_unplaced_zeros=0;
        for (int i = ln-1; i > -1; i--) {
            if(ar[i]==0)
                num_unplaced_zeros+=1;
            else
                count+=num_unplaced_zeros;
        }
        return count;
    }

}

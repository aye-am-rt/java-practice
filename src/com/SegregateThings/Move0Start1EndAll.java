package com.SegregateThings;

import java.util.Arrays;

/**Move all zeros to start and ones to end in an Array of random integers
Given an array arr[] of random integers, the task is to push all the zero’s in the array
to the start and all the one’s to the end of the array. Note that the order of all the other
elements should be the same.
Example:
Input: arr[] = {1, 2, 0, 4, 3, 0, 5, 0}
Output: 0 0 0 2 4 3 5 1
Input: arr[] = {1, 2, 0, 0, 0, 3, 6};
Output: 0 0 0 2 3 6 1

Approach: Traverse the array from left to right and move all the elements which are not equal to
1 at the beginning and then put 1’s in the rest of the indices at the end of the array. Now, find
the index of the last element which is not equal to 1 say lastInd and then starting from this
index to the beginning of the array push all the elements which are not equal to 0 in the end
till lastInd and then put 0’s in the beginning.
 */

public class Move0Start1EndAll {
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 0, 0, 0, 3, 6, 9, 8, 21, 1, 1, 1, 45, 0 };
        int n = arr.length;
        pushBinaryToBorder(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    private static void pushBinaryToBorder(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();

        int countNon1s=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]!=1)
            {
                arr[countNon1s]=arr[i];
                countNon1s += 1;
            }
        }
        // Now all non-ones elements have been shifted to
        // front and 'count1' is set as index of first 1.
        // Make all elements 1 from count to end.
        for (int i = countNon1s; i < n; i++) {
            arr[i]=1;
        }
        int lastNon1 = countNon1s-1;
        for (int i = countNon1s-1; i > -1; i--) {
            // Place non-zero element to their required indices
            if(arr[i]!=0) {
                arr[lastNon1] = arr[i];
                lastNon1 -= 1;
            }
            if(lastNon1==0)
                lastNon1=i;
        }
        // Put zeros to start of array
        while (lastNon1 >= 0)
            arr[lastNon1--] = 0;
    }
}

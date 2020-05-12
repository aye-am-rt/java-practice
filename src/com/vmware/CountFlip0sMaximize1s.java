package com.vmware;
/**Find zeroes to be flipped so that number of consecutive 1’s is maximized
Given a binary array and an integer m, find the position of zeroes flipping which creates maximum
 number of consecutive 1’s in array.

Examples :
Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
m = 2
Output:  5 7
We are allowed to flip maximum 2 zeroes. If we flip
arr[5] and arr[7], we get 8 consecutive 1's which is
maximum possible under given constraints

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
m = 1
Output:  7
We are allowed to flip maximum 1 zero. If we flip
arr[7], we get 5 consecutive 1's which is maximum
possible under given constraints.
******************************************************************************
 A Simple Solution is to consider every subarray by running two loops. For every subarray, count
 number of zeroes in it. Return the maximum size subarray with m or less zeroes. Time Complexity
 of this solution is O(n2).
*******************************************************************************
 A Better Solution is to use auxiliary space to solve the problem in O(n) time.

 For all positions of 0’s calculate left[] and right[] which defines the number of consecutive 1’s
 to the left of i and right of i respectively.

 For example, for arr[] = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1} and m = 1, left[2] = 2 and right[2] = 2,
 left[5] = 2 and right[5] = 0, left[6] = 0 and right[6] = 3.

 left[] and right[] can be filled in O(n) time by traversing array once and keeping track of last
 seen 1 and last seen 0. While filling left[] and right[], we also store indexes of all zeroes in
 a third array say zeroes[]. For above example, this third array stores {2, 5, 6}

 Now traverse zeroes[] and for all consecutive m entries in this array, compute the sum of 1s that
 can be produced. This step can be done in O(n) using left[] and right[].
****************************************************************************************
 //////////////////////////////////////////////////////////////////////////////////////

 An Efficient Solution can solve the problem in O(n) time and O(1) space. The idea is to use
 Sliding Window for the given array. The solution is taken from here.
 Let us use a window covering from index wL to index wR. Let the number of zeros inside the
 window be zeroCount. We maintain the window with at most m zeros inside.

 The main steps are:
 – While zeroCount is no more than m: expand the window to the right (wR++) and update the count
 zeroCount.
 – While zeroCount exceeds m, shrink the window from left (wL++), update zeroCount;
 – Update the widest window along the way. The positions of output zeros are inside the best window.
 */

public class CountFlip0sMaximize1s {
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int m = 2;
        System.out.println("\nIndexes of zeroes to be flipped are given max flips (m) ==  ");
        findZeroesToBeFlippedSlidingWindow(arr,m);
    }

    private static void findZeroesToBeFlippedSlidingWindow(int[] arr, int m) {
        if(arr.length<m)
            throw new IllegalArgumentException();

        int winLIndex=0;
        int winRIndex=0;
        int bestWindLIndex=0;
        int bestWindSize=0;
        int count0currWind=0;
        while (winRIndex < arr.length)
        {
            if(count0currWind <= m)
            {
                if(arr[winRIndex]==0)
                    count0currWind += 1;

                winRIndex++;
            }
            if(count0currWind > m)
            {
                if(arr[winLIndex]==0)
                    count0currWind -= 1;

                winLIndex += 1;
            }
            if( (winRIndex-winLIndex) > bestWindSize  &&  (count0currWind <= m))
            {
                bestWindSize = winRIndex - winLIndex;
                bestWindLIndex = winLIndex;
            }
        }

        for (int i = 0; i < bestWindSize; i++) {
            if(arr[bestWindLIndex + i] == 0)
                System.out.print(bestWindLIndex+i + "  ");
        }
    }
}

package com.Arrays.practiceTab2;

import javax.management.StandardEmitterMBean;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
Find m-th smallest value in k sorted arrays
Given k sorted arrays of possibly different sizes, find m-th smallest value in the merged array.
Examples:
Input: m = 5
arr[][] = { {1, 3},
{2, 4, 6},
{0, 9, 10, 11}} ;
Output: 4
Explanation The merged array would be {0 1 2 3 4 6 9 10 11}.  The 5-th smallest element in this merged
array is 4.

Input: m = 6
arr[][] = { {1, 3, 20}, {2, 4, 6}} ;
Output: 20
 An efficient solution is to use heap data structure. The time complexity of heap based
 solution is O(m Log k).

 1. Create a min heap of size k and insert 1st element in all the arrays into the heap
 2. Repeat following steps m times
 …..a) Remove minimum element from heap (minimum is always at root) and store it in output array.
 …..b) Insert next element from the array from which the element is extracted. If the array
 doesn’t have any more elements, then do nothing.
 3. Print the last removed item.

 */

public class MthSmallestInKArrays {
    public static void main(String[] args) {
        int m = 5;  // return the 5th smallest value after merging and sorting.
        int[][] arr = {{1, 3}, {2, 4, 6}, {0, 9, 10, 11}} ;  // sorted arrays already given
        System.out.print("mth smallest value in arrays sorted order = "+Find_Mth_smallestArrays(arr,m));
        System.out.println("\n");
        int [][] arr2 = {{ 2, 6, 12 }, { 1, 9 },{ 23, 34, 90, 2000 }};
        int m2 = 4;
        System.out.print("mth smallest value in arrays sorted order = "+Find_Mth_smallestArrays(arr2,m2));

    }

    private static int Find_Mth_smallestArrays(int[][] arr, int m) {
        if(arr.length<1)
            throw new IllegalArgumentException();

        PriorityQueue<Integer> pqI =  new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int currSize = arr[i].length;
            for (int j = 0; j < currSize; j++) {
                pqI.offer(arr[i][j]);
            }
        }
        System.out.print("priority queue min heap of all elements = ");
        System.out.println(Arrays.toString(pqI.toArray()));
        if(pqI.size()<m)
        {
            System.out.println("Not enough elements for mth value ");
            return Integer.MIN_VALUE;
        }
        int i = 0;
        int temp = pqI.peek();
        while(i < m-1)
        {
            pqI.remove();
            i++;
            temp = pqI.peek();
        }
//        int j = 0;
//        int ans = -1;
//        Iterator<Integer> it =  pqI.iterator();
//        System.out.println(" min heap ");
//        while (it.hasNext())
//        {
//            if(j==m) {
//                ans = it.next();
//                System.out.print(ans+"  ");
//            }
//            else
//            { System.out.print(it.next()+"  "); }
//            j++;
//        }
//        System.out.println(" ");
          return temp;
    }
}

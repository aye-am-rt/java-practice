package com.Arrays.ArrayInversions;

import java.util.Arrays;

/**
Count Inversions in an array | Set 1 (Using Merge Sort)
Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 If array is already sorted then inversion count is 0. If array is sorted in reverse order that
 inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

Example:

Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8,4), (4,2),(8,2), (8,1), (4,1), (2,1).

Input: arr[] = {3, 1, 2}
Output: 2

Explanation: Given array has two inversions:
(3, 1), (3, 2)

 Algorithm:
 The idea is similar to merge sort, divide the array into two equal or almost equal halves in
 each step until the base case is reached.
 Create a function merge that counts the number of inversions when two halves of the array
 are merged, create two indices i and j, i is the index for first half and j is an index of
 the second half. if a[i] is greater than a[j], then there are (mid – i) inversions. because
 left and right sub arrays are sorted, so all the remaining elements in left-sub array
 (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
 Create a recursive function to divide the array into halves and find the answer by
 summing the number of inversions is the first half, number of inversion in the
 second half and the number of inversions by merging the two.
 The base case of recursion is when there is only one element in the given half.
 Print the answer

 */

public class CountInversionsMergeSort {

    public static void main(String[] args)
    {
        int[] arr = { 1, 20, 6, 4, 5 };
        System.out.println("given array = "+Arrays.toString(arr));
        System.out.print("num of inversions required to make array sorted = ");
        System.out.println(mergeSortAndCountInversions(arr, 0, arr.length - 1));
        System.out.println("array after counting  = "+Arrays.toString(arr));
    }

    private static int mergeSortAndCountInversions(int[] arr, int left, int right) {
        int count = 0;
        if(left<right)
        {
            int mid = (right+left)/2;
            /** divide and calculate count like merge sort **/
            count+=mergeSortAndCountInversions(arr,left,mid);
            count+=mergeSortAndCountInversions(arr,mid+1,right);
            /** merging back **/
            count+=MergeBackAndCount(arr,left,mid,right);
        }
        return count;
    }

//    Complexity Analysis:
//    Time Complexity: O(n log n), The algorithm used is divide and conquer,
//    So in each level one full array traversal is needed and there are log n levels so
//    the time complexity is O(n log n).

//    Space Complexity:O(1), No extra space is required.

    private static int MergeBackAndCount(int[] arr, int left, int mid, int right) {
        int[] leftCopyArray = Arrays.copyOfRange(arr,left,mid+1);
        int[] rightCopyArray = Arrays.copyOfRange(arr,mid+1,right+1);

        int i=0; int j=0; int k = left, swaps =0;
        while(i<leftCopyArray.length && j <rightCopyArray.length)
        {
            if(leftCopyArray[i]<=rightCopyArray[j])
            {
                arr[k++] =  leftCopyArray[i++];
            }
            else
            {
                arr[k++] = rightCopyArray[j++];
                swaps += (mid+1) - (left+i);
            }
        }
        // Fill from the rest of the left sub-array
        while (i < leftCopyArray.length)
            arr[k++] = leftCopyArray[i++];

        // Fill from the rest of the right sub-array
        while (j < rightCopyArray.length)
            arr[k++] = rightCopyArray[j++];

        return swaps;
    }


}

/*
Time Complexity: O(n^2), Two nested loops are needed to traverse the array from start to
end so the Time complexity is O(n^2)

Space Compelxity:O(1), No extra space is required.


static int arr[] = new int[] { 1, 20, 6, 4, 5 };
static int getInvCount(int n)
{
    int inv_count = 0;
    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (arr[i] > arr[j])
                inv_count++;

    return inv_count;
}

// Driver method to test the above function
public static void main(String[] args)
{
    System.out.println("Number of inversions are "
            + getInvCount(arr.length));
} */

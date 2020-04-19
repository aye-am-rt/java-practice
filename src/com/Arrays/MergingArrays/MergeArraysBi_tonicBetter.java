package com.Arrays.MergingArrays;
//
//Approach: An approach has already been discussed in this article. In this article, an even efficient
// approach will be discussed.
//        Form two bi-tonic arrays by comparing the highest element from one array to the lowest element
//        of the second array such that both arrays contain only those elements which are to be there in
//        after the sorting of both the array.
//        Now, sort both the array separately.

import java.util.Arrays;

public class MergeArraysBi_tonicBetter {
    // Reducing the gap by a factor of 2
    static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    // Function to merge two sorted
    // arrays with O(1) extra space
    static void mergeTwoSortedArray(int []arr1, int []arr2, int n, int m)
    {
        int x = Math.min(n, m);

        // Form both arrays to be bi-tonic
        for (int i = 0; i < x; i++)
        {
            if (arr1[n - i - 1] > arr2[i])
            {
                // swap(arr1[n - i - 1], arr2[i]);
                int temp = arr1[n - i - 1];
                arr1[n - i - 1] = arr2[i];
                arr2[i] = temp;
            }
        }
        System.out.println("array 1 after bi tonic = "+ Arrays.toString(arr1));
        System.out.println("array 2 after bi tonic = "+ Arrays.toString(arr2));


        // Now both the arrays conatin the numbers
        // which should be there in the result
        // Sort the array individually by inplace algorithm
        for (int gap = nextGap(n); gap > 0; gap = nextGap(gap))
        {
            // Comparing elements in the first array
            for (int i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap])
                {
                    // swap(arr1[i], arr1[i + gap]);
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
        }

        // Sort the second array
        for (int gap = nextGap(m); gap > 0; gap = nextGap(gap))
        {
            // Comparing elements in the second array
            for (int i = 0; i + gap < m; i++)
                if (arr2[i] > arr2[i + gap])
                {
                    // swap(arr2[i], arr2[i + gap]);
                    int temp = arr2[i];
                    arr2[i] = arr2[i + gap];
                    arr2[i + gap] = temp;
                }
        }
        for (int i = 0; i < n; i++)
            System.out.print(arr1[i] + " ");
        for (int j = 0; j < m; j++)
            System.out.print(arr2[j] + " ");
    }
    public static void main (String[] args)
    {
        int[] arr1 = { 1, 5, 9, 10, 15, 20 };
        int n = arr1.length;
        int[] arr2 = { 2, 3, 8, 13 };
        int m = arr2.length;

        mergeTwoSortedArray(arr1, arr2, n, m);
    }
}

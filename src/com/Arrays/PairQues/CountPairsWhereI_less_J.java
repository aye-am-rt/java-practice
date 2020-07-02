package com.Arrays.PairQues;

import java.util.HashSet;

/**
Count of unique pairs (arr[i], arr[j]) such that i < j
Given an array arr[], the task is to print the count of unique pairs (arr[i], arr[j]) such that i < j.
Examples:
Input: arr[] = {1, 2, 1, 4, 5, 2}
Output: 11
The possible pairs are (1, 2), (1, 1), (1, 4), (1, 5), (2, 1), (2, 4), (2, 5), (2, 2), (4, 5),
 (4, 2), (5, 2)

Input: arr[] = {1, 2, 3, 4}
Output: 6
The possible pairs are (1, 2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4)


 Efficient Approach: Every element arr[i] can form a pair with the element arr[j] if i < j.
 But (arr[i], arr[j]) should be unique therefore for every unique arr[i], possible pairs will be equal to
 the number of distinct numbers in the sub-array arr[i + 1], arr[i + 2], …, arr[n – 1].
 So for every arr[i], we will find the unique elements from right to left. For this task, it is easy
 to keep track of the elements visited by using a Hash Tablle.
 In this way, we will have unique arr[i] for every unique arr[j]. Now, we will sum these values for
 every unique arr[i] which is the desired count of pairs.

 // Time Complexity: O(n)
 */
// Time Complexity: O(n)
public class CountPairsWhereI_less_J {
    // Driver code     // Time Complexity: O(n)
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 2, 4, 2, 5, 3, 5 };
        int n = a.length;
        // Print the count of unique pairs
        System.out.println(getPairsWhereILessJ(a, n));
    }

    // Time Complexity: O(n)
    private static int getPairsWhereILessJ(int[] arr, int ln) {
        HashSet<Integer> visited1 = new HashSet<>();

        // un[i] stores number of unique elements from un[i + 1] to un[n - 1]
        int[] uniQInRight = new int[ln];
        // Last element will have no unique elements after it
        uniQInRight[ln - 1] = 0;

        // To count unique elements after every a[i]
        int countUnqAfterEach = 0;
        for (int i = ln-1; i > 0; i--) {
            if(visited1.contains(arr[i]))
                uniQInRight[i-1] = countUnqAfterEach;
            else
                uniQInRight[i-1] = ++countUnqAfterEach;

            // Set to true if a[i] is visited
            visited1.add(arr[i]);
        }

        HashSet<Integer> visited2 = new HashSet<>();
        // To know which a[i] is already visited
        int AnsAlreadySeen = 0;
        for (int i = 0; i < ln - 1; i++) {
            // If visited, then the pair would not be unique
            if (visited2.contains(arr[i]))
                continue;

            // Calculating total unique pairs
            AnsAlreadySeen += uniQInRight[i];
            // Set to true if a[i] is visited
            visited2.add(arr[i]);
        }
        return AnsAlreadySeen;
        // Time Complexity: O(n)
    }
    // Time Complexity: O(n)
}

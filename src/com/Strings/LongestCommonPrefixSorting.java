package com.Strings;
/*In this post a new method based on sorting is discussed. The idea is to sort the array of
 strings and find the common prefix of the first and last string of the sorted array.*/

import java.util.Arrays;

public class LongestCommonPrefixSorting {
    public static String longestCommonPrefix(String[] a)
    {
        int size = a.length;

        /* if size is 0, return empty string */
        if (size == 0)
            return "";

        if (size == 1)
            return a[0];

        /* sort the array of strings */
        Arrays.parallelSort(a);

        /* find the minimum length from first and last string */
        int end = Math.min(a[0].length(), a[size-1].length());

        /* find the common prefix between the first and last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
            i++;

        System.out.println("i == "+i);
        return a[0].substring(0, i);  // this means last is excluded in substring method
    }
/**    Time Complexity: O(MAX * n * log n ) where n is the number of strings in the array and
 MAX is maximum number of characters in any string*/
    public static void main(String[] args)
    {
        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println( "The longest Common Prefix is : " + longestCommonPrefix(input));
    }
}

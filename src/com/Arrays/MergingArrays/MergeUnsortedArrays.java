package com.Arrays.MergingArrays;
//Merging two unsorted arrays in sorted order
//        Write a SortedMerge() function that takes two lists, each of which is unsorted, and merges the
//        two together into one new list which is in sorted (increasing) order. SortedMerge()
//        should return the new list.
//        Examples :
//        Input : a[] = {10, 5, 15}
//        b[] = {20, 3, 2}
//        Output : Merge List :
//        {2, 3, 5, 10, 15, 20}

import java.util.Arrays;

/**Method 2 (First Sort then Merge)
        We first sort both the given arrays separately. Then we simply merge two sorted arrays.*/
public class MergeUnsortedArrays {
    public static void main(String[] args)
    {
        int[] a = { 10, 5, 15 };
        int[] b = { 20, 3, 2, 12 };
        int n = a.length;
        int m = b.length;

        // Final merge list
        int[] res = new int[n + m];
        sortedMergeIntoNewArray(a, b, res, n, m);
        double dl=32.5678;
        String st = String.valueOf(dl);
        StringBuilder sb=new StringBuilder(st);
        st=sb.reverse().toString();
        System.out.println(st);

        System.out.print( "Sorted merged list :");
        for (int i = 0; i < n + m; i++)
            System.out.print(" " + res[i]);
    }

    private static void sortedMergeIntoNewArray(int[] a, int[] b, int[] res, int n, int m) {
        if(n==0 && m==0)
            throw new IllegalArgumentException();

        Arrays.sort(a);
        Arrays.sort(b);
        int i=0; int j=0 ;int k=0;
        while(i<n && j<m)
        {
            if(a[i]<=b[j])
            {
                res[k]=a[i];
                i++;
            }
            else
            {
                res[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<n)
        {
            res[k]=a[i];
            i++;
            k++;

        }
        while(j<m)
        {
            res[k]=b[j];
            j++;
            k++;
        }
        System.out.println("sorted then merged in res array= "+Arrays.toString(res));
    }
}

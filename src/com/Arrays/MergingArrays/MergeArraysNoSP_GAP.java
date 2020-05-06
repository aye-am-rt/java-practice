package com.Arrays.MergingArrays;
//Efficiently merging two sorted arrays with O(1) extra space
//        Given two sorted arrays, we need to merge them in O((n+m)*log(n+m)) time with O(1) extra
//        space into a sorted array, when n is the size of the first array, and m is the size of the
//        second array.
//        Example:
//        Input: ar1[] = {10};
//        ar2[] = {2, 3};
//        Output: ar1[] = {2}
//        ar2[] = {3, 10}
//
//        Input: ar1[] = {1, 5, 9, 10, 15, 20};
//        ar2[] = {2, 3, 8, 13};
//        Output: ar1[] = {1, 2, 3, 5, 8, 9}
//        ar2[] = {10, 13, 15, 20}

import java.security.spec.RSAOtherPrimeInfo;

/**
In this post a better solution is discussed.
 The idea: we start comparing elements that are far from each other rather than adjacent.
 For every pass, we calculate the gap and compare the elements towards the right of the gap.
 Every pass, the gap reduces to the ceiling value of dividing by 2.*/

public class MergeArraysNoSP_GAP {
    public static void main(String[] args) {
        int[] a1 = {10, 27, 38, 43, 82};
        int[] a2 = {3, 9};

        mergeSortedGap(a1, a2, a1.length, a2.length);
       // System.out.println("ceil gap check = "+FindNextCeilGap(7));

        System.out.print("First Array: ");
        for (int value : a1) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.print("Second Array: ");
        for (int value : a2) {
            System.out.print(value + " ");
        }
    }

    private static void mergeSortedGap(int[] a1, int[] a2, int l1, int l2) {
        if(l1==0 && l2==0)
            throw new IllegalArgumentException();
        if(l1==0 || l2==0)
            return;
        int gap=l1+l2;
        int i,j;
        for(gap=FindNextCeilGap(gap); gap>0; gap=FindNextCeilGap(gap))
        {
            for (i = 0; i + gap <l1 ; i++)
            {
                if(a1[i]>a1[i+gap])
                {
                    int temp=a1[i];
                    a1[i]=a1[i+gap];
                    a1[i+gap]=temp;
                }
            }
            for (j = gap > l1 ? (gap-l1) : 0;  j < l2 && i <l1;  j++,i++) {
                if(a1[i]>a2[j])
                {
                    int temp=a1[i];
                    a1[i]=a2[j];
                    a2[j]=temp;
                }
            }
            if(j<l2)
            {
                for (int k = 0; k+gap < l2 ; k++) {
                    if(a2[k]>a2[k+gap])
                    {
                        int temp=a2[k];
                        a2[k]=a2[k+gap];
                        a2[k+gap]=temp;
                    }
                }
            }
        }    
    }

    private static int FindNextCeilGap(int gap) {
        if(gap<=1)
            return 0;
        else
            return (gap/2)+(gap%2);
    }
}

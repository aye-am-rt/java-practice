package com.Arrays.TripletQues;

import java.util.Arrays;
import java.util.HashSet;

//Find all triplets with zero sum
//        Given an array of distinct elements. The task is to find triplets in the array whose
//        sum is zero.
//        Examples :
//        Input : arr[] = {0, -1, 2, -3, 1}
//        Output : (0 -1 1), (2 -3 1)
//
//        Explanation : The triplets with zero sum are
//        0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
//Method 1: This is a simple method that takes O(n3) time to arrive at the result.
public class AllTripletsWithZeroSum {
    public static void main(String[] args)
    {
        int[] arr = {0, -1, 2, -3, 1};
        int n =arr.length;
        System.out.println("****** naive o(n3) below *********");
        findTripletsWithZeroSumBF(arr, n);  // O(n3)
        System.out.println("****** now hashing o(n2) below *********");
        findTripletsWithZeroSumHashing(arr, n); // O(n2)
        System.out.println("****** now sorting o(n2) find both end pair for every element below *********");
        findTripletsWithZeroSumSorting(arr, n); // O(n2)
    }

    private static void findTripletsWithZeroSumSorting(int[] arr, int n) {
        boolean found=false;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int l=i+1;
            int r=n-1;
            int x=arr[i];
            while(l<r)
            {
                if(x+arr[l]+arr[r]==0)
                {
                    System.out.println("( "+arr[l]+", "+arr[r]+", "+x+" )");
                    l++;
                    r--;
                    found=true;
                }
                else if(x+arr[l]+arr[r]<0)
                    l++;
                else
                    r--;
            }
        }
        if(!found)
            System.out.println("no triplet with zero sum ");
    }

    private static void findTripletsWithZeroSumHashing(int[] arr, int n) {
        boolean found=false;
        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> hSet=new HashSet<>();
            for (int j = i+1; j < n ; j++) {  // if start with j=i then it prints three triplets
                // because it includes i and starts repetitively using elements.
                int x= -(arr[i]+arr[j]);
                if(hSet.contains(x))
                {
                    System.out.println("( "+arr[i]+", "+arr[j]+", "+x+" )");
                    found=true;
                }
                else
                    hSet.add(arr[j]);
            }
        }
        if(!found)
            System.out.println("no triplet with zero sum ");
    }

    private static void findTripletsWithZeroSumBF(int[] arr, int n) {
        boolean found=false;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k <n; k++) {
                    if(arr[i]+arr[j]+arr[k]==0)
                        System.out.println("( "+arr[i]+", "+arr[j]+", "+arr[k]+" )");
                    found=true;
                }
            }
        }
        if(!found)
            System.out.println("no triplet with zero sum ");
    }
}

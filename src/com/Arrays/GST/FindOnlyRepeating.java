package com.Arrays.GST;

// find the only repeating(appear twice among all elements once) element in sorted array of size n,
// which contains element in range 1 to n-1;
// efficient idea is use binary search coz array given is sorted.

public class FindOnlyRepeating {
    // int[] arr={1,2,3,4,4};  by default class members in java are default access type
    // in CPP is private
    public static void main(String[] args)
    {
        int[] arr={1,2,3,4,5,5};//sorted array of size n, which contains element in range 1 to n-1
        int n=arr.length;
        System.out.println(FindOnlyRepeatingNumber(arr,0,n-1));
    }

    private static int FindOnlyRepeatingNumber(int[] arr, int left, int right) {
        if(left>right)
            return -1;
        int mid=(left+right)/2;
        if(arr[mid]!=mid+1) //sorted array of size n, which contains element in range 1 to n-1
        {
            if(mid>0 && arr[mid]==arr[mid-1])  // {1,2,3,4,5,5}
                return mid;
            return FindOnlyRepeatingNumber(arr,left,mid-1);
        }
        return FindOnlyRepeatingNumber(arr,mid+1,right);
    }
}

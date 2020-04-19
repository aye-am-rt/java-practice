package com.Arrays.GST;

//Find the element that appears once in a sorted array
//        Given a sorted array in which all elements appear twice (one after one) and one element
//        appears only once. Find that element in O(log n) complexity.
//        Example:
//
//        Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
//        Output:  4
/**
An Efficient Solution can find the required element in O(Log n) time. The idea is to use Binary Search.
 Below is an observation in input array.
        All elements before the required have first occurrence at even index (0, 2, ..) and next
 occurrence at odd index (1, 3, …). And all elements after the required element have first occurrence at
 odd index and next occurrence at even index.

        1) Find the middle index, say ‘mid’.

        2) If ‘mid’ is even, then compare arr[mid] and arr[mid + 1]. If both are same, then the
 required element after ‘mid’ else before mid.

        3) If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are same, then the
 required element after ‘mid’ else before mid.*/

public class findOnceAmongTwiceSorted {
    public static void main(String[] args)
    {
        int[] arr={1, 1, 2, 2, 4, 4, 5, 6, 6};
        int n=arr.length;
        if(n<1)
            throw new IllegalArgumentException();
        else
            System.out.println(FindOnceAmongTwice(arr,0,n-1));
    }

    private static int FindOnceAmongTwice(int[] arr, int left, int right) {
        if(left>right)
            return 0;
        if(left==right)
            return arr[right];
        int mid=(left+right)/2;
        if(mid%2==0)
        {
            if(arr[mid]==arr[mid+1])  // If mid is even and element next to mid is
            // same as mid, then output element lies on
            // right side, else on left side
            { return FindOnceAmongTwice(arr,mid+2,right); }
            else
            { return FindOnceAmongTwice(arr,left,mid); }
        }
        else // mid%2==0 even failure means odd
        {
            if(arr[mid]==arr[mid-1])
            { return FindOnceAmongTwice(arr,mid+1,right); }
            else
            { return FindOnceAmongTwice(arr,left,mid-1); }
        }
    }
}

package com.Arrays.GST;
//
//Find first and last positions of an element in a sorted array
//        Given a sorted array with possibly duplicate elements, the task is to find indexes of first
//        and last occurrences of an element x in the given array.
//
//        Examples:
//
//        Input : arr[] = {1, 3, 5, 5, 5, 5 ,67, 123, 125}
//        x = 5
//        Output : First Occurrence = 2
//        Last Occurrence = 5
//
//The Naive Approach is to run a for loop and check given elements in array.
//
//        1. Run a for loop and for i = 0 to n-1
//        2. Take first = -1 and last = -1
//        3. When we find element first time then we update first = i
//        4. We always update last=i whenever we find the element.
//        5. We print first and last

public class FirstAndLastPos {
    public static void main(String[] args)
    {
       int[] arr = {1, 3, 5, 5, 5, 5 ,67, 123, 125};
        int x = 5;
        FindFirstLastPosition(arr,arr.length,x);
    }

    private static void FindFirstLastPosition(int[] arr, int length, int x) {
        if(length<1)
            throw new IllegalArgumentException();
        int left=0;
        int right=length-1;
        System.out.println(" first position of "+x+" is = "+FindFirstPos(arr,left,right,x,length));
        System.out.println(" Last position of "+x+" is = "+FindLastPos(arr,left,right,x,length));
    }

    private static int FindFirstPos(int[] arr, int left, int right, int x, int length) {
        if(right>= left)
        {
            int mid = left + (right- left)/2; //this is good technique to avoid integer Limit overflow
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return FindFirstPos(arr, (mid + 1), right, x, length);
            else
                return FindFirstPos(arr, left, (mid -1), x, length);
        }
        return -1;
    }

    private static int FindLastPos(int[] arr, int left, int right, int x, int length) {

        if (right >= left)
        {
            int mid = left + (right - left)/2;
            if (( mid == length-1 || x < arr[mid+1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return FindLastPos(arr, left, (mid -1), x, length);
            else
                return FindLastPos(arr, (mid + 1), right, x, length);
        }
        return -1;
    }
}

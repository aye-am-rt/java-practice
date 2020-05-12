package com.SegregateThings;

/*Approach: This concept is related to partition of quick sort . In quick sort’
partition, after one scan, the left of the array is smallest and right of the array is the
largest of selected pivot element.

Algorithm:
Create a variable index index = 0
Traverse the array from start to end
If the element is 0 then swap the current element with the element at index position and increment
the index by 1.
If the element is 1 keep the element as it is.*/

import java.util.Arrays;

public class SortBinaryArray {
    public static void main(String[] args)
    {

        int[] a = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
        int n = a.length;
        System.out.println("\n****** first Method geeks i , j = -1 **************");
        sortBinaryArray(a, n);
        for (int value : a) System.out.print(value + " ");

        System.out.println("\n****** Sec Method left and right movement **************");
        int[] a2 = {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
        int n2 = a2.length;
        CollectZeroOnesLeftRight(a2,n2);
    }

    private static void CollectZeroOnesLeftRight(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        int left=0;
        int right=ln-1;
        while(left<right)
        {
            if(arr[left]==1 && arr[right]==0)
            {
                int temp=arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
                left++;
                right--;
            }
            if(arr[right]==1)
                right--;
            if(arr[left]==0)
                left++;
        }
        System.out.println("collected zero ones left right can be used for pos and neg elements also");
        System.out.println(Arrays.toString(arr));

    }

    private static void sortBinaryArray(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        int j =- 1;
        for (int i = 0; i < ln; i++)
        {
            if(arr[i]<1)
            {    // if number is smaller than  then swap it with j-th number
                // int[] a = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
                j ++;
                int temp= arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
/**      when ever we are seeing a 0 at index i so we will swap that element at the
         leftmost seen 1 where
         j is sitting. then j will increase and it will again be at next index where
         1 is present and
         before that all elements will be zero.*/
    }
}

package com.SegregateThings;

import java.util.Arrays;

/**Segregate even and odd numbers | Set 2
        Given an array of integers, segregate even and odd numbers in the array. All the even
 numbers should be present first, and then the odd numbers.
        Examples:
        Input : 1 9 5 3 2 6 7 11
        Output : 6 2 3 5 2 9 11 1

 Approach :
 1. Start two pointers from left and right of the array.
 2. Create a new array of same size as given.
 3. If the element at left or right is even then put it in front of the array else at the end.

 */

public class SegregateEvenOdd {
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 2, 4, 7, 6, 9, 10};
        int n = arr.length;
        SegregateArrayEvenAndOdd(arr, n);
    }
    //    Time Complexity : O(n/2)
    //    Auxiliary Space : O(n)
    private static void SegregateArrayEvenAndOdd(int[] arr, int n) {
        int[] b = new int[n];
        int left=0; int right=n-1;
        int i,j;
        for (i = 0, j=n-1 ; i < j; i++, j--) {
            if(arr[i]%2==0)
            {
                b[left]=arr[i];
                left++;
            }
            else
            {
                b[right]=arr[i];
                right--;
            }
            if(arr[j]%2==0)
            {
                b[left]=arr[j];
                left++;
            }
            else
            {
                b[right]=arr[j];
                right--;
            }
        }
        // for i == j in case of odd length
        b[i] = arr[i];

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(b));
    }
//    Time Complexity : O(n/2)
//    Auxiliary Space : O(n)
}

package com.SegregateThings;

import java.util.Arrays;

public class Segregate01DiffWays {
    // driver function
    public static void main(String[] args)
    {
        int[] arr1 = { 0, 1, 0, 1, 1, 1 };
        int n1 = arr1.length;
        int[] a2 = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
        int n2 = a2.length;
        int[] a3={0,0,0,0,0};
        int n3=a3.length;
        int[] a4={1,1,1,1,1};
        int n4=a4.length;
        // ************* testing 1 ************************** //
        segregate0and1CountAndPut(arr1, n1);
        segregate0and1CountAndPut(a2,n2);
        segregate0and1CountAndPut(a3,n3);
        segregate0and1CountAndPut(a4,n4);
        // ************* testing 2 ************************** //
        System.out.println("/////////////////////////////////////////////////////////////////////////////");
        segregate0and1LeftRightMove(arr1,n1);
        segregate0and1LeftRightMove(a2,n2);
        segregate0and1LeftRightMove(a3,n3);
        segregate0and1LeftRightMove(a4,n4);


    }

    private static void segregate0and1CountAndPut(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        int countOfZeros=0;
        for (int i = 0; i < ln; i++) {
            if(arr[i]==0)
                countOfZeros+=1;
        }
        for (int i = 0; i < ln; i++) {
            if(i<countOfZeros)
                arr[i]=0;
            else
                arr[i]=1;
        }
        System.out.println("***** printing 0 left and 1 right segregated count zeros and place method *****");
        System.out.println("count of zeros in array == "+countOfZeros);
        System.out.println(Arrays.toString(arr));
    }


    /*Function to put all 0s on left and all 1s on right*/
    static void segregate0and1LeftRightMove(int[] arr, int size)
    {
        /* Initialize left and right indexes */
        int left = 0, right = size - 1;

        while (left < right)
        {
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
                left++;

            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;

            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right)
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        System.out.println("***** printing 0 left and 1 right segregated Left and right move Swap way *****");
        System.out.println(Arrays.toString(arr));
    }
}

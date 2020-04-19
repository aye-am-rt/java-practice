package com.Arrays;

/*Minimum Swaps required to group all 1’s together
        Given an array of 0’s and 1’s, we need to write a program to find the minimum number of swaps
        required to group all 1’s present in the array together.
        Examples:
        Input : arr[] = {1, 0, 1, 0, 1}
        Output : 1
        Explanation: Only 1 swap is required to
        group all 1's together. Swapping index 1
        and 4 will give arr[] = {1, 1, 1, 0, 0}

        Input : arr[] = {1, 0, 1, 0, 1, 1}
        Output : 1*/
/**
Another efficient approach :
        First count total number of 1’s in the array. Suppose this count is x, now find the sub array of
 length x of this array with maximum number of 1’s using the concept of window-sliding technique.
 Maintain a variable to find number of 1’s present in a sub array in O(1) extra space and for each
 sub array maintain maxOnes Variable and at last Return numberOfZeros (numberOfZeroes = x – maxOnes).
*/

public class MinSwapCollect1 {
    public static void main(String args[])
    {
        //int[] a = new int[]{0, 0, 1, 0, 1, 1, 0, 0, 1};
        int[] a = {1, 0, 1, 0, 1, 1};
        int n = a.length;

        System.out.println(minSwapsToCollectOnes(a, n));
    }

    private static int minSwapsToCollectOnes(int[] arr, int n) {
        if(n<=0)
            return -1;
        int left=0;
        int right=n-1;
        int totalOnes=0;
        while(left<=right)
        {
            if(arr[left]==1)
            { totalOnes+=1; }
            if(arr[right]==1)
            { totalOnes+=1; }
            left+=1;
            right-=1;
        }
        if(n%2!=0) {totalOnes-=1;}
        System.out.println("total ones in array "+totalOnes);
        int initialWinOnes=0;
        for (int i = 0; i < totalOnes; i++) {
            if(arr[i]==1)
                initialWinOnes+=1;
        }
        int maxOnesFound=initialWinOnes;
        System.out.println("max ones setting = "+maxOnesFound);
        for (int i = totalOnes; i < n; i++) {
            if(arr[i]==1 && arr[i-totalOnes]!=1)
            { initialWinOnes+=1; }
        }
        if(initialWinOnes>maxOnesFound)
            maxOnesFound=initialWinOnes;
        System.out.println("max ones found in any sub array of length totalOnes = "+maxOnesFound);
        System.out.print("ie min swaps required = (totalOnes - maxOnesFound) = ");
        return Math.abs(maxOnesFound-totalOnes);
    }

}

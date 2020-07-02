package com.Arrays.AmazonSubArrays;
/**
Smallest sub-array with sum greater than a given value
Given an array of integers and a number x, find the smallest sub-array with sum greater than the
 given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
x  =  51
Output: 3
Minimum length sub-array is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
x  = 9
Output: 1
Minimum length sub-array is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
x = 280
Output: 4
Minimum length sub-array is {100, 1, 0, 200}

arr[] = {1, 2, 4}
x = 8
Output : Not Possible
Whole array sum is smaller than 8.

 Efficient Solution: This problem can be solved in O(n) time using the idea used in this post.
 2 pointer technique */

public class SmallestSubASumGreaterThanK {
    // Driver program to test above functions
    public static void main(String[] args)
    {
        int[] arr1 = {1, 4, 45, 6, 10, 19};
        int x = 51;  // given k , to find Smallest subArray whose sum more than k
        int n1 = arr1.length;
        System.out.print("Smallest sub-array length with sum greater than a given value = ");
        int res1 = smallestSubWithSum_MoreK_2ptr(arr1, n1, x); //  2 pointer technique
        if (res1 == n1+1)
            System.out.println("Not Possible");
        else
            System.out.println(res1);

        int[] arr2 = {1, 10, 5, 2, 7};
        int n2 = arr2.length;
        x = 9; // given k , to find Smallest subArray whose sum more than k
        int res2 = smallestSubWithSum_MoreK_2ptr(arr2, n2, x);  //  2 pointer technique
        System.out.print("Smallest sub-array length with sum greater than a given value = ");
        if (res2 == n2+1)
            System.out.println("Not Possible");
        else
            System.out.println(res2);

        int[] arr3 = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int n3 = arr3.length;
        x = 280;  // given k , to find Smallest subArray whose sum more than k
        int res3 = smallestSubWithSum_MoreK_2ptr(arr3, n3, x);
        System.out.print("Smallest sub-array length with sum greater than a given value = ");
        if (res3 == n3+1)
            System.out.println("Not Possible");
        else
            System.out.println(res3);
    }

    private static int smallestSubWithSum_MoreK_2ptr(int[] arr, int ln, int kSumMore)
    {
        int currSum = 0, ansMinLen = ln+1;
        int fPtr = 0 , sPtr = 0;// both pointers start from zero,second will stop where Req. subArray Ends

        while(sPtr < ln)
        {
            while (currSum <= kSumMore && sPtr < ln )  // finding the right end of sub-array to stop
            {
                currSum += arr[sPtr];   // keep on adding the elements in subArray(Window)
                sPtr++;  // slide the right side of window while first is still at 0 index
            }
            while (currSum > kSumMore && fPtr < ln)
            {
                if(ansMinLen > (sPtr - fPtr))  // Update minimum length if needed
                {
                    // means if currWindow length is smaller than ansMinLen right now then update
                    // the ansMinLen to be minimum.
                    ansMinLen = sPtr-fPtr;
                }
                currSum -= arr[fPtr];  // remove starting elements  like sliding window
                fPtr++;
            }
        }  // secPtr while loop ends here

        return ansMinLen;
    }
}

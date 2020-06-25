package com.practiceTab1;
/**************  IN PYTHON SOLVED   ****************************/
//Sliding Window Maximum : Set 2
//        Set 1: Sliding Window Maximum (Maximum of all subarrays of size k).
//        Given an array arr of size N and an integer K, the task is to find the maximum for each and
//        every contiguous subarray of size K.
//        Examples-
//        Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
//        Output: 3 3 4 5 5 5 6
/**
Approach: To solve this in lesser space complexity we can use two pointer technique.========
First variable pointer iterates through the subArray and finds maximum element from given size K
Second variable pointer marks the ending index of the first variable pointer i.e., (i + K – 1)th index.
When the first variable pointer reaches the index of second variable pointer, maximum of that sub array
 has been computed and will be printed.
The process is repeated until second variable pointer reach last array index (i.e array_size – 1).*/

public class SlidingWMaxAllSubs {
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // {12, 1, 78, 90, 57, 89, 56}
        int n = a.length;
        int K = 3;
        printKMaxOfAllSubsTwoPointers(a, n, K);
    }

    private static void printKMaxOfAllSubsTwoPointers(int[] arr, int ln, int kSubs) {
        if(ln<=0)
            throw new IllegalArgumentException();
        if(kSubs==1)
        {
            for (int i = 0; i < ln; i++) {
                System.out.println(arr[i]+"  ");
            }
        }
        int startSubArr=0; int endSubArr=kSubs-1;
        int secPointer=startSubArr; int maxOfThisSubArr=arr[endSubArr];
        while(endSubArr<ln)
        {
            if(arr[startSubArr]>maxOfThisSubArr)
                maxOfThisSubArr=arr[startSubArr];

            startSubArr+=1;

            if(startSubArr == endSubArr)
            {
                System.out.print(maxOfThisSubArr+"  ");
                endSubArr+=1;
                startSubArr = ++secPointer;
                if(endSubArr<ln)
                {
                    maxOfThisSubArr=arr[endSubArr];
                }

            } // if(start==end) ending

        } // while loop ending

    } // function ending
}

package com.Arrays;


import java.util.Arrays;

public class KSmallestElementsO1 {
    static void printNSmallestBySorting(int[] arr, int ln, int n)
    {
        // Make copy of array
        int []copy_arr = Arrays.copyOf(arr,ln);
        // Sort copy array
        Arrays.sort(copy_arr);
        // For each arr[i] find whether it is a part of n-smallest with binary search
        for (int i = 0; i < ln; ++i)
        {
            if (Arrays.binarySearch(copy_arr,0,n, arr[i]) > -1)
                System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 };
        int size = arr.length;
        int k = 5;
        System.out.println("original array = "+Arrays.toString(arr));
        System.out.println("k smallest elements in array are == ");
        printNSmallestBySorting(arr, size, k);
/** To solve it without using any extra space we will use concept of insertion sort.
The idea is to move k minimum elements to beginning in same order. To do this, we start from (k+1)-th
 element and move till end. For every array element, we replace the largest element of first k elements
 with the current element if current element is smaller than the largest. To keep the order, we use
 insertion sort idea.*/
        System.out.println("\n***** second o1 way insertion sort like ********* ");
        printNSmallestByInsertionO1(arr, size, k);

    }

    private static void printNSmallestByInsertionO1(int[] arr, int ln, int kSmallest) {
        if(ln < kSmallest)
            throw new IllegalArgumentException();
        // For each arr[i] find whether it is a part of n-smallest with insertion sort concept
        for (int i = kSmallest; i < ln; ++i) {
            int maxTopVar=arr[kSmallest-1];  // Find largest from top n-element
            int pos = kSmallest-1;
            for (int j = (kSmallest-2); j >=0; j--) {
                if(arr[j]>maxTopVar)
                {
                    maxTopVar = arr[j];
                    pos=j;
                }
            }
            // If largest is greater than arr[i] shift all element one place left
            if (maxTopVar>arr[i])
            {
                int j = pos;
                while (j<kSmallest-1)
                {
                    arr[j] = arr[j+1];
                    j++;
                }
                arr[kSmallest-1]=arr[i];
            }
        }
        // print result
        for (int i = 0; i < kSmallest; i++)
            System.out.print(arr[i] + " ");
    }
}

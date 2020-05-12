package com.SegregateThings;
/**
Move all zeroes to end of array using Two-Pointers

Given an array of random numbers, Push all the zero’s of the given array to the end of the array.
 For example, if the given arrays is {1, 0, 2, 6, 0, 4}, it should be changed to {1, 2, 6, 4, 0, 0}.
 The order of all other elements should be the same.

Examples:
Input: arr[]={8, 9, 0, 1, 2, 0, 3}
Output: arr[]={8, 9, 1, 2, 3, 0, 0}
Explanation:
Swap {0 ,1} -> Resulting array {8, 9, 1, 0, 2, 0, 3}
Swap {0 ,2} -> Resulting array {8, 9, 1, 2, 0, 0, 3}
Swap {0 ,3} -> Final array {8, 9, 1, 2, 3, 0, 0}*/

public class MoveAllZeroToEndArray {
    // function to move all zeroes at
   // the end of array
    static void moveZerosToEnd(int[] arr, int n) {
        // Traverse the array. If arr[i] is non-zero, then swap the element at
        // index 'count' with the element at index 'i'
        // {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        // Count of non-zero elements
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] != 0)) {
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count = count + 1;
            }
        }
    }

    // function to print the array elements
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver program to test above
    public static void main(String[] args) {
        int[] arr = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;

        System.out.print("Original array: ");
        printArray(arr, n);

        moveZerosToEnd(arr, n);

        System.out.print("\nModified array: ");
        printArray(arr, n);

        int[] arr2 = {8, 9, 0, 1, 2, 0, 3};
        int l2=arr2.length;
        System.out.println("\n\n***** 2nd  method *********\n");
        System.out.print("Original array2: ");
        printArray(arr2, l2);
        moveZerosToEndUsingTwoPointers(arr2,l2);
        System.out.print("\nModified array2 : ");
        printArray(arr2, l2);
    }

    private static void moveZerosToEndUsingTwoPointers(int[] arr2, int l2) {
        int j=0;
        // Traverse the array. If arr[i] is non-zero and arr[j] is zero, then swap both the element
        for (int i = 0; i < l2; i++) {
            if(arr2[i] != 0 && arr2[j] == 0)
            {
                int temp=arr2[i];
                arr2[i]=arr2[j];
                arr2[j]=temp;
            }

            if(arr2[j] != 0)
                j+=1;
        }
    }
}

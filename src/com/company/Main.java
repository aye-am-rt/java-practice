package com.company;

public class Main {

    public static void main(String[] args) {
	int[] arr ={12, 11, 13, 5, 6};
	InsertionSort ob= new InsertionSort();
	ob.sort(arr);
	printArray(arr);
    }

    private static void printArray(int[] arr) {
        System.out.println("printing the array = \n");
        for (int value : arr) {
            System.out.println("\t" + value);
        }
        System.out.println();
    }

    private static class InsertionSort {
        void sort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }
    }
}

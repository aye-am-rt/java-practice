package com.practiceTab1;

// Java code for
// O(n) solution for finding
// maximum sum of a sub array
// of size k

public class slidingWMaxSum {
    // Returns maximum sum in
    // a sub array of size k.
    static int maxSum(int[] arr, int n, int k)
    {
        // n must be greater
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int endI=0;
        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            if(window_sum>max_sum) {
                //max_sum = Math.max(max_sum, window_sum);
                max_sum=window_sum;
                endI=i;
            }
        }
        System.out.println("end of sub array = "+endI);
        return max_sum;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 1, 4, 255, 10, 2, 30, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}

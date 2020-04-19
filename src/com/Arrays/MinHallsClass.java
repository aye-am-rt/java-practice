package com.Arrays;
/*Minimum halls required for class scheduling
Given N lecture timings, with their start time and end time (both inclusive), the task is to find the
minimum number of halls required to hold all the classes such that a single hall can be used for only one
 lecture at a given time. Note that the maximum end time can be 10^5.


Input: lectures[][] = {{0, 5}, {1, 2}, {1, 10}}
Output: 3
All lectures must be held in different halls because
at time instance 1 all lectures are ongoing.

Input: lectures[][] = {{0, 5}, {1, 2}, {6, 10}}
Output: 2

 */

public class MinHallsClass {

    private static final int MAX = 1000;
    public static void main(String[] args)
    {
        int[][] lectures = {{ 0, 5 }, { 1, 2 }, { 1, 10 }};
        int n = lectures.length;

        System.out.println(minHallsForLectures(lectures, n));
    }

    private static int minHallsForLectures(int[][] lecDurations, int totalLectures) {
        // Array to store the number of
        // lectures ongoing at time t
        int []prefix_sum = new int[MAX];
        for (int i = 0; i < totalLectures; i++) {
            System.out.println("before prefix sum "+i+" = "+prefix_sum[i]);
            prefix_sum[lecDurations[i][0]]++;
            prefix_sum[lecDurations[i][1]]--;
            System.out.println("after prefix sum "+i+" = "+prefix_sum[i]);
        }
        int ans=prefix_sum[0];
        System.out.println(ans);
        // Perform prefix sum and update
        // the ans to maximum
        for (int i = 1; i < MAX; i++) {
            prefix_sum[i]+=prefix_sum[i-1];
            ans=Math.max(ans,prefix_sum[i]);
        }
        return ans;
    }
}

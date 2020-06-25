package com.MixedNotSure;
/**

Count ways to reach the nth stair using step 1, 2 or 3
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 steps at a time. Implement a method to count how many possible ways the child can run up the
 stairs.

Examples:

Input : 4
Output : 7
Explantion:
Below are the four ways
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step

Input : 3
Output : 4
Explanation:
Below are the four ways
1 step + 1 step + 1 step
1 step + 2 step
2 step + 1 step
3 step

 Method 2: Dynamic Programming.

 The idea is similar, but it can be observed that there are n states but the recursive
 function is called 3 ^ n times. That means that some states are called repeatedly.
 So the idea is to store the value of states. This can be done in two ways.

 Top-Down Approach: The first way is to keep the recursive structure intact and just store
 the value in a HashMap and whenever the function is called again return the value store without
 computing ().
 Bottom-Up Approach: The second way is to take an extra space of size n and start computing
 values of states from 1, 2 .. to n, i.e. compute values of i, i+1, i+2 and then use them to
 calculate the value of i+3.
 Algorithm:

 Create an array of size n + 1 and initialize the first 3 variables with 1, 1, 2. The base cases.
 Run a loop from 3 to n.
 For each index i, computer value of ith position as dp[i] = dp[i-1] + dp[i-2] + dp[i-3].
 Print the value of dp[n], as the Count of the number of ways to reach n th step.

 Time Complexity: O(n).
 Only one traversal of the array is needed. So Time Complexity is O(n).
 Space Complexity: O(n).
 */

public class CountWaysStair1_2_3 {
    // A recursive function used by countWays
    public static int countWays(int n)
    {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];

        return res[n];
    }
//    Time Complexity: O(n).
//    Only one traversal of the array is needed. So Time Complexity is O(n).
//    Space Complexity: O(n).
    public static void main(String[] args)
    {
        int n = 4;
        System.out.println(countWays(n));
    }
}
/*
Working:
1 -> 1 -> 1 -> 1
1 -> 1 -> 2
1 -> 2 -> 1
1 -> 3
2 -> 1 -> 1
2 -> 2
3 -> 1

So Total ways: 7
Complexity Analysis:

Time Complexity: O(n).
Only one traversal of the array is needed. So Time Complexity is O(n).
Space Complexity: O(n).
To store the values in a DP, n extra space is needed.*/

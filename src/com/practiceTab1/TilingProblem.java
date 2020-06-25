package com.practiceTab1;
/**
Tiling Problem
Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board
 using the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically
 i.e., as 2 x 1 tile.
Examples:

Input n = 3
Output: 3
Explanation:
We need 3 tiles to tile the board of size  2 x 3.
We can tile the board using following ways
1) Place all 3 tiles vertically.
2) Place first tile vertically and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally and remaining tiles vertically

Input n = 4
Output: 5
Explanation:
For a 2 x 4 board, there are 5 ways
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining 2 horizontal
4) First 2 horizontal, remaining 2 vertical
5) Corner 2 vertical, middle 2 horizontal


 Let “count(n)” be the count of ways to place tiles on a “2 x n” grid, we have following two ways to
 place first tile.
 1) If we place first tile vertically, the problem reduces to “count(n-1)”
 2) If we place first tile horizontally, we have to place second tile also horizontally. So the problem
 reduces to “count(n-2)”

 Therefore, count(n) can be written as below.

 count(n) = n if n = 1 or n = 2
 count(n) = count(n-1) + count(n-2)
 The above recurrence is nothing but Fibonacci Number expression. We can find n’th Fibonacci number
 in O(Log n) time, see below for all method to find n’th Fibonacci Number.

 Different methods for n’th Fibonacci Number.
 Count the number of ways to tile the floor of size n x m using 1 x m size tiles

 */

public class TilingProblem {
//    Time Complexity: O(n)
//    Auxiliary Space: O(n)
    public static void main(String[] args)
    {
        int n = 7;  // floor is of size n X m total.
        int m = 2;  //  this means tiles will be of size 1 X m or m X 1
        System.out.println("Number of ways = "+ countWaysOfTiling(n, m));
    }

    private static int countWaysOfTiling(int n, int m) {
        int[] count = new int[n+1];
        count[0]= 0;
        for (int i = 1; i <= n; i++) {

            if(i>m)// recurrence relation
                count[i] = count[i-1]+count[i-m];

            else if(i<m || i==1) // base cases
                count[i]=1;

            else   // i = = m
                count[i]=2;

        }
        return count[n];
    }
//    Time Complexity: O(n)
//    Auxiliary Space: O(n)

}

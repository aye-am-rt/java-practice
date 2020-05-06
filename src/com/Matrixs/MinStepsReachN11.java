package com.Matrixs;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
Minimum number of moves to reach N starting from (1, 1)
Given an integer N and an infinite table where ith row and jth column contains the value i *j.
 The task is to find the minimum number of moves to reach the cell containing N starting from the
 cell (1, 1).

Note: From (i, j) only valid moves are (i + 1, j) and (i, j + 1)
Examples:
Input: N = 10
Output: 5
(1, 1) -> (2, 1) -> (2, 2) -> (2, 3) -> (2, 4) -> (2, 5)

Input: N = 7
Output: 6

 Approach: Note that any cell (i, j) can be reached in i + j – 2 steps. Thus, only the pair
 (i, j) is required with i * j = N that minimizes i + j. It can be found out by finding all the
 possible pairs (i, j) and check them in O(√N). To do this, without loss of generality, it can be
 assumed that i ≤ j and i ≤ √N since N = i * j ≥ i2. So √N ≥ i2 i.e. √N ≥ i.
 Thus, iterate over all the possible values of i from 1 to √N and, among all the possible pairs
 (i, j), pick the lowest value of i + j – 2 and that is the required answer.
 */

public class MinStepsReachN11 {
    static int min_moves(int n)
    {
        // To store the required answer
        int ans = Integer.MAX_VALUE;

        // For all possible values of divisors
        for (int i = 1; i * i <= n; i++)
        {

            // If i is a divisor of n
            if (n % i == 0)
            {

                // Get the moves to reach n
                ans = Math.min(ans, i + n / i - 2);
            }
        }

        // Return the required answer
        return ans;
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 10;
        System.out.println(min_moves(n));
        Polygon xy = new Polygon();
        xy.addPoint(1,1);
        xy.addPoint(4,1);
        xy.addPoint(1,4);
        xy.addPoint(4,4);

        if(xy.contains(2,2))
            System.out.println("true");
        if(xy.contains(1,4))
            System.out.println("false");

//   bekar hai rectangle not working  properly
//        Rectangle2D rect1 = new Rectangle2D.Double();
//        if(rect1.isEmpty())
//            System.out.println("empty rec1 ");
//
//        rect1.add(new Point(1,3)); rect1.add(new Point(4,3));
//        rect1.add(new Point(1,1)); rect1.add(new Point(4,1));
//
//        Rectangle2D rect2 = new Rectangle2D.Double();
//        if(rect2.isEmpty())
//            System.out.println("empty rect2");
//
//        rect2.add(6,6); rect2.add(10,6);
//        rect2.add(6,2); rect2.add(10,2);
//
//        Rectangle2D rect3 = new Rectangle2D.Double();
//        rect3.add(new Point(2,2)); rect3.add(new Point(5,2));
//        rect3.add(new Point(2,0)); rect3.add(new Point(5,0));
//
//        if(rect1.intersects(rect3))
//            System.out.println(rect1.toString() + " and "+rect3.toString());

    }
}

package com.Matrixs;
/**
Minimum steps required to reach the end of a matrix | Set 2
Given a 2d-matrix mat[][] consisting of positive integers, the task is to find the minimum
 number of steps required to reach the end of the matrix. If we are at cell (i, j) we can go
 to cells (i, j + arr[i][j]) or (i + arr[i][j], j). We cannot go out of bounds. If no path exists
 then print -1.

Examples:

Input: mat[][] = {
{2, 1, 2},
{1, 1, 1},
{1, 1, 1}}
Output: 2
The path will be {0, 0} -> {0, 2} -> {2, 2}
Thus, we are reaching there in two steps.*/

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
Approach: We have already discussed a dynamic programming based approach for this problem in this
 article. This problem can also be solved using breadth first search (BFS).

The algorithm is as follows:

Push (0, 0) in a queue.
Traverse (0, 0) i.e. push all the cells it can visit in queue.
Repeat the above steps, i.e. traverse all the elements in the queue individually again if they
 have not been visited/traversed before.
Repeat till we don’t reach the cell (N-1, N-1).
The depth of this traversal will give the minimum steps required to reach the end.
Remember to mark a cell visited after it has been traversed. For this, we will use a 2D boolean
 array.

Why BFS works?

This whole scenario can be considered equivalent to a directed-graph where each cell is connected
 to at-most two more cells({i, j+arr[i][j]} and {i+arr[i][j], j}).
The graph is un-weighted. BFS can find shortest path in such scenarios.*/

public class MinStepsReachEnd {
    public static void main(String[] args)
    {
        int[][] arr = { { 1, 1, 1 },
                        { 1, 1, 1 },
                        { 1, 1, 1 } };
        System.out.println(minStepsToReachEnd(arr));
    }
    static int n= 3 ;
    private static int minStepsToReachEnd(int[][] arr) {
        boolean[][] vis = new boolean[n][n];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(0,0));

        int depth=0;
        while(! q.isEmpty())
        {
            int currSize=q.size();

            while (currSize-- > 0)
            {
                Pair<Integer,Integer> p = q.poll();
                int i = p.getKey();
                int j = p.getValue();

                if(vis[i][j])
                    continue;

                if(i==n-1 && j==n-1) // this means end reached.
                    return depth;

                vis[i][j] = true;

                // Pushing the adjacent cells in the queue that can be visited
                // from the current cell

                if(i+arr[i][j]<n)
                    q.offer(new Pair<>(i+arr[i][j] , j));
                if(j+arr[i][j]<n)
                    q.offer(new Pair<>(i , j+arr[i][j]));
            }
            depth++;
        }
        return -1;
    }

}

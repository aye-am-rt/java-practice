package com.Matrixs;
/*
Count number of ways to reach destination in a Maze using BFS
Given a maze with obstacles, count number of paths to reach rightmost-bottom most cell from the
 topmost-leftmost cell. A cell in the given maze has value -1 if it is a blockage or dead-end,
 else 0.
From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.

Examples:

Input: mat[][] = {
{1, 0, 0, 1},
{1, 1, 1, 1},
{1, 0, 1, 1}}
Output: 2

Input: mat[][] = {
{1, 1, 1, 1},
{1, 0, 1, 1},
{0, 1, 1, 1},
{1, 1, 1, 1}}
Output: 4*/

import org.w3c.dom.html.HTMLLinkElement;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class WaysTopLtoBRight {
    static class mPairs
    {
        int first, second;
        public mPairs(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    // Driver code
    public static void main(String[] args)
    {
        // Matrix to represent maze
        int[][] matrix = {  { 1, 0, 0, 1 },
                            { 1, 1, 1, 1 },
                            { 1, 0, 1, 1 }};
        int r = matrix.length;
        int c = matrix[0].length;

        System.out.println(MazePathBFS(matrix,r,c));
    }

    private static int MazePathBFS(int[][] matrix,int r, int c) {
        Deque<mPairs> dq = new LinkedList<>();
        dq.offer(new mPairs(0,0));
        int countAns = 0;

        while (!dq.isEmpty())
        {
            mPairs p = dq.poll();
            // Increment the count of paths check if it is the destination
            if (p.first == r - 1 && p.second == c - 1)
                countAns++;

            if(p.first+1< r && matrix[p.first+1][p.second]==1)
            {
                dq.offer(new mPairs(p.first+1,p.second));
            }
            if(p.second+1< c && matrix[p.first][p.second+1]==1)
            {
                dq.offer(new mPairs(p.first,p.second+1));
            }
        }
        return countAns;
    }
}

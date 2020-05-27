package com.Matrixs;
/*
Rat in a Maze | Backtracking-2
We have discussed Backtracking and Knight’s tour problem in Set 1. Let us discuss Rat in a Maze as
another example problem that can be solved using Backtracking.
A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e.,
 maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from
 source and has to reach the destination. The rat can move only in two directions: forward and down.

In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path
 from source to destination. Note that this is a simple version of the typical Maze problem.
  For example, a more complex version can be that the rat can move in 4 directions and a more
  complex version can be with a limited number of moves.*/

/**Backtracking Algorithm: Backtracking is an algorithmic-technique for solving problems recursively
 * by trying
 *  to build a solution incrementally. Solving one piece at a time, and removing those solutions
 *  that fail to satisfy the constraints of the problem at any point of time (by time, here, is
 *  referred to the time elapsed till reaching any level of the search tree) is the process of
 *  backtracking.

Approach: Form a recursive function, which will follow a path and check if the path reaches the
 destination or not. If the path does not reach the destination then backtrack and try other paths.

Algorithm:
Create a solution matrix, initially filled with 0’s.
Create a recursive funtion, which takes initial matrix, output matrix and position of rat (i, j).
if the position is out of the matrix or the position is not valid then return.
Mark the position output[i][j] as 1 and check if the current position is destination or not.
 If destination is reached print the output matrix and return.
Recursively call for position (i+1, j) and (i, j+1).
Unmark position (i, j), i.e output[i][j] = 0.*/

public class RatInMazeBackT {
    // Size of the maze
    static int N;
    public static void main(String[] args)
    {
        int[][] maze = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        N = maze.length;
        solveMaze(maze);
    }
    /* This function solves the Maze problem using  Backtracking. It mainly uses solveMazeUtil()
    to solve the problem. It returns false if no path is possible, otherwise return true and
    prints the path in the form of 1s. Please note that there may be more than one solutions, this
    function prints one of the feasible solutions.*/
    static void solveMaze(int[][] maze)
    {
        int[][] sol = new int[N][N];
        if (! solveMazeUtil(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
            return;
        }
        printSolution(sol);
    }
    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol)
    {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // mark x, y as part of solution path
            sol[x][y] = 1;
            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;
            /* If moving in x direction doesn't give solution then Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
            /* If none of the above movements works then BACKTRACK: unmark x, y as part of solution
            path */
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
    /* A utility function to check  if x, y is valid index for N*N maze */
    static boolean isSafe(int[][] maze, int x, int y)
    {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }
    /* A utility function to print solution matrix sol[N][N] */
    static void printSolution(int[][] sol)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + sol[i][j] + " ");
            System.out.println();
        }
    }
}

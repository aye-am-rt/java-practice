package com.Matrixs;
/**This problem is an extension of below problem.
Backtracking | Set 2 (Rat in a Maze)
In this post a different solution is discussed that can be used to solve the above Rat in a Maze
 problem also.
The idea is to modify the given grid[][] so that grid[i][j] contains count of paths to reach
 (i, j) from (0, 0) if (i, j) is not a blockage, else grid[i][j] remains -1.

We can recursively compute grid[i][j] using below
formula and finally return grid[R-1][C-1]

// If current cell is a blockage
if (maze[i][j] == -1)
maze[i][j] = -1; //  Do not change

// If we can reach maze[i][j] from maze[i-1][j]
// then increment count.
else if (maze[i-1][j] > 0)
maze[i][j] = (maze[i][j] + maze[i-1][j]);

// If we can reach maze[i][j] from maze[i][j-1]
// then increment count.
else if (maze[i][j-1] > 0)
maze[i][j] = (maze[i][j] + maze[i][j-1]);


 Count number of ways to reach destination in a Maze
 Given a maze with obstacles, count number of paths to reach rightmost-bottommost cell from
 topmost-leftmost cell. A cell in given maze has value -1 if it is a blockage or dead end, else 0.

 From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.
 Examples:
 Input: maze[R][C] =  { {0,  0, 0, 0},
                        {0, -1, 0, 0},
                        {-1, 0, 0, 0},
                        {0,  0, 0, 0} };
 Output: 4

 */

public class NumWaysReachDestination {
    public static void main (String[] args)
    {
        int[][] maze = {{0, 0, 0, 0},
                        {0, -1, 0, 0},
                        {-1, 0, 0, 0},
                        {0, 0, 0, 0}};
        int r = maze.length;
        int c = maze[0].length;
        System.out.println (countPathsLCtoRC(maze,r,c));

    }

    private static int countPathsLCtoRC(int[][] maze, int r, int c) {
        if(maze[0][0]==-1)
            return 0;
        for (int i = 0; i < r; i++) {
            if(maze[i][0]==0)
                maze[i][0]=1;
            else
                break;
        }  // these both for loops are filling first row and first column as 1 else break.
        for (int j = 1; j < c; j++) {
            if(maze[0][j]==0)
                maze[0][j]=1;
            else
                break;
        }
        // The only difference is that if a cell is -1, simply ignore it else recursively
        // compute count value maze[i][j]
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if(maze[i][j]==-1)
                    continue;
                if(maze[i-1][j]>0)
                    maze[i][j]=(maze[i][j]+maze[i-1][j]);

                if(maze[i][j-1]>0)
                    maze[i][j]=(maze[i][j]+maze[i][j-1]);
            }
        }
        // If the final cell is blocked, output 0, otherwise the answer
        return Math.max(maze[r - 1][c - 1], 0);
    }
}

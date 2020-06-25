package com.Matrixs;

import java.util.Arrays;

/**
Find shortest safe route in a path with landmines
Given a path in the form of a rectangular matrix having few landmines arbitrarily placed
 (marked as 0), calculate length of the shortest safe route possible from any cell in the
 first column to any cell in the last column of the matrix. We have to avoid landmines and
 their four adjacent cells (left, right, above and below) as they are also unsafe. We are allowed
 to move to only adjacent cells which are not landmines. i.e. the route cannot contains any
 diagonal moves.
Examples:
Input:
A 12 x 10 matrix with landmines marked as 0

[ 1  1  1  1  1  1  1  1  1  1 ]
[ 1  0  1  1  1  1  1  1  1  1 ]
[ 1  1  1  0  1  1  1  1  1  1 ]
[ 1  1  1  1  0  1  1  1  1  1 ]
[ 1. 1. 1. 1.  1  1  1  1  1  1 ]
[ 1  1  1  1.  1  0  1  1  1  1 ]
[ 1  0  1  1.  1  1  1  1  0  1 ]
[ 1  1  1  1. 1. 1. 1. 1.  1  1 ]
[ 1  1  1  1  1  1  1  1. 1. 1. ]
[ 0  1  1  1  1  0  1  1  1  1 ]
[ 1  1  1  1  1  1  1  1  1  1 ]
[ 1  1  1  0  1  1  1  1  1  1 ]

Output:
Length of shortest safe route is 13 (Highlighted in Bold)


The idea is to use Backtracking. We first mark all adjacent cells of the landmines as unsafe.
Then for each safe cell of first column of the matrix, we move forward in all allowed directions
and recursively checks if they leads to the destination or not. If destination is found, we update
the value of shortest path else if none of the above solutions work we return false from our
function.*/
//Another method: It can be solved in polynomial time with the help of Breadth First Search.
// Enqueue the cells with 1 value in the queue with the distance as 0. As the BFS proceeds,
// shortest path to each cell from the first column is computed. Finally for the reachable
// cells in the last column, output the minimum distance.

public class ShortestSafePathLandMines {
    // These arrays are used to get row and column // numbers of 4 neighbours of a given cell
    static int[] rowNum = { -1, 0, 0, 1 };
    static int[] colNum = { 0, -1, 1, 0 };
    static int R = 12;
    static int C = 10;
    static int min_dist;

    public static void main(String[] args) {
        // input matrix with landmines shown with number 0
        int[][] mat ={
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };
        // find shortest path
        findShortestSafePathBFS(mat);
    }

    private static void findShortestSafePathBFS(int[][] mat) {
        // stores minimum cost of shortest path so far
        min_dist = Integer.MAX_VALUE;

        // create a boolean matrix to store info about cells already visited in current route
        boolean[][] visited =  new boolean[R][C];

        // mark adjacent cells of landmines as unsafe
        markAllUnSafeCells(mat);

        for (int i = 0; i < R; i++) {
            if(mat[i][0]==1)
            {
                Arrays.fill(visited[i],false);
                // find shortest route from (i, 0) to any cell of last column (x, C - 1) where
                // 0 <= x < R

                findShortestPathUtil(mat, visited, i, 0, min_dist, 0);

                // if min distance is already found
                if(min_dist == C - 1)
                    break;
            }
        }
        // if destination can be reached 
        if (min_dist != Integer.MAX_VALUE)
            System.out.println("Length of shortest safe route is "+ min_dist);
        else // if the destination is not reachable 
            System.out.println("Destination not reachable from given source");
    }

    private static void findShortestPathUtil(int[][] mat, boolean[][] visited,
                                             int i, int j, int min_dist, int dist) {
        // if destination is reached
        if (j == C-1)
        {
            // update shortest path found so far
            min_dist = Math.min(dist, min_dist);
            //System.out.println(" min dist = "+min_dist);
            return;
        }

        // if current path cost exceeds minimum so far
        if (dist > min_dist)
            return;

        // include (i, j) in current path
        visited[i][j] = true;

        // Recurse for all safe adjacent neighbours
        for (int k = 0; k < 4; k++)
        {
            if (isValidBoundary(i + rowNum[k], j + colNum[k]) &&
                    isSafe(mat, visited, i + rowNum[k], j + colNum[k]))
            {
                findShortestPathUtil(mat, visited, i + rowNum[k],
                        j + colNum[k], min_dist, dist + 1);
            }
        }
        // Backtrack
        visited[i][j] = false;

    }

    // A function to mark all adjacent cells of landmines as unsafe. Landmines are shown with
    // number 0
    private static void markAllUnSafeCells(int[][] mat) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(mat[i][j]==0) // land mine found
                {
                    for (int k = 0; k < 4; k++) {
                        if(isValidBoundary(i+rowNum[k], j+colNum[k]))
                        {
                            mat[i+rowNum[k]][j+colNum[k]]=-1;
                        }
                    }
                }
            }
        }// out from both for loops
        // mark all found adjacent cells as unsafe
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(mat[i][j]==-1)
                    mat[i][j]=0;
            }
        }
    // below lines to print the path
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            System.out.print("   "+mat[i][j]+" ");
        }
        System.out.println(" ");
    }
    }

    private static boolean isValidBoundary(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    // A function to check if a given cell (x, y) can be visited or not
    private static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y)
    {
        return mat[x][y] != 0 && ! visited[x][y];
    }
}

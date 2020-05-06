package com.Matrixs;
/**

Find the count of mountains in a given Matrix
Given a 2D square matrix of size N X N, the task is to count the number of mountains in the matrix.

An element in a matrix is said to be a mountain when all the surrounding elements
 (in all 8 directions) are smaller than the given element.

Examples:
Input: matrix =
{ { 4, 5, 6 },
{ 2, 1, 3 },
{ 7, 8, 9 } }
Output: 1
Explanation
Only mountain element = 9.
All the neighbouring elements
1, 3 and 8 are smaller than 9.*/

public class CountMountainElements {
    public static void main(String[] args)
    {
        int[][] a = {   { 1, 200, 3 },
                        { 4, 5, 6 },
                        { 7, 800, 9 } };
        int n = 3;

        System.out.print(countMountains(a, n));
    }

    private static int countMountains(int[][] mat, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        int countM=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0)
                {
                    if(j==0)
                    {
                        if(mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i+1][j+1])
                            countM+=1;
                    }
                    else if(j==n-1)
                    {
                        if(mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i-1][j-1])
                            countM+=1;
                    }
                    else
                    {
                        if(mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i][j+1]
                        && mat[i][j]>mat[i+1][j-1] && mat[i][j]>mat[i+1][j+1])
                            countM+=1;
                    }
                }
                if(i==n-1)
                {
                    if(j==0)
                    {
                        if(mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i-1][j+1])
                            countM+=1;
                    }
                    else if(j==n-1)
                    {
                        if(mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i-1][j-1])
                            countM+=1;
                    }
                    else
                    {
                        if(mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i-1][j-1]
                                && mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i-1][j+1])
                            countM+=1;
                    }
                }
                if(i>0 && i<n-1)
                {
                    if(j==0)
                    {
                        if(mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i-1][j+1]
                                && mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i+1][j+1])
                            countM+=1;
                    }
                    else if(j==n-1)
                    {
                        if(mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i-1][j-1]
                                && mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i+1][j-1])
                            countM+=1;
                    }
                    else
                    {
                        if(mat[i][j]>mat[i-1][j-1] && mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i-1][j+1]
                                && mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i][j-1]
                        && mat[i][j]>mat[i+1][j-1] && mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i+1][j+1])
                            countM+=1;
                    }
                }
            }
        }
        return countM;
    }
}

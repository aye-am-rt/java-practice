package com.Matrixs;

import java.util.Arrays;

/**Maximum sum path in a Matrix
Given an n*m matrix, the task is to find the maximum sum of elements of cell starting from the
 cell (0, 0) to cell (n-1, m-1).
However, the allowed moves are right, downwards or diagonally right, i.e, from location (i, j)
 next move can be (i+1, j), or, (i, j+1), or (i+1, j+1). Find the maximum sum of elements
 satisfying the allowed moves.

Examples:

Input:
mat[][] = { {100, -350, -200},
            {-100, -300, 700}}
Output: 500
Explanation:
Path followed is 100 -> -300 -> 700*/

public class MaxPathSumMatrix {
    public static void main(String[] args)
    {
        int[][] mat={{500,100,230},
                     {1000,300,100},
                     {200,1000,200}};
        int r=mat.length;
        int c=mat[0].length;
        System.out.println("original matrix == ");
        printMatrix(mat,r,c);
        System.out.println("\n ********************** \n");
        System.out.println("max matrix product ==> "+FindMaxSumPath(mat,r,c));
    }

    private static int FindMaxSumPath(int[][] mat, int r, int c) {
        int[][] sumMat=new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(sumMat[i],0);
        }
        sumMat[0][0]=mat[0][0];
        for (int i = 1; i < r; i++) {
            sumMat[i][0]=sumMat[i-1][0]+mat[i][0];
        }
        for (int i = 1; i < c; i++) {
            sumMat[0][i]=sumMat[0][i-1]+mat[0][i];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                int max3D=Math.max(Math.max(sumMat[i-1][j],sumMat[i][j-1]),sumMat[i-1][j-1]);
                sumMat[i][j]=mat[i][j]+max3D;
            }
        }
        printMatrix(sumMat,r,c);
        return sumMat[r-1][c-1];
    }
    private static void printMatrix(int[][] mat, int r, int c) {
        if(r==0 || c==0)
        {
            System.out.println("nothing to print");
            return;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j]+"  ");
            }
            System.out.println("  ");
        }
    }
}

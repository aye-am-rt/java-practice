package com.Matrixs;

import java.util.Arrays;

/**
A Boolean Matrix Question
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell
 mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
Example 1
The matrix
1 0
0 0
should be changed to following
1 1
1 0

Example 2
The matrix
0 0 0
0 0 1
should be changed to following
0 0 1
1 1 1

Example 3
The matrix
1 0 0 1
0 0 1 0
0 0 0 0
should be changed to following
1 1 1 1
1 1 1 1
1 0 1 1
*/


public class BoolMatrixModifyRC {
    // Driver function to test the above function 
    public static void main(String[] args){

        int[][] mat = { {1, 0, 0, 1},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0}};

        System.out.println("Input Matrix :");
        printMatrix(mat,3,4);
        modifyMatrix(mat);
        System.out.println("Matrix After Modification :");
        printMatrix(mat,3,4);
    }

    private static void modifyMatrix(int[][] mat) {
        boolean rFlag=false;
        boolean cFlag=false;
        // updating the first row and col if 1 is encountered
        for (int i = 0; i < mat.length; i++ )
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                if (i == 0 && mat[i][j] == 1)
                    rFlag = true;

                if (j == 0 && mat[i][j] == 1)
                    cFlag = true;

                if (mat[i][j] == 1){
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if(mat[i][0]==1 || mat[0][j]==1)
                    mat[i][j]=1;
            }
        }
        if(rFlag)
            Arrays.fill(mat[0], 1);
        if(cFlag)
            for (int i = 0; i < mat.length; i++) {
                mat[i][0]=1;
            }
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

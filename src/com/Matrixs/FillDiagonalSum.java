package com.Matrixs;
/*
Filling diagonal to make the sum of every row, column and diagonal equal of 3×3 matrix
Given 9 elements in a 3 x 3 matrix where the value of diagonals are 0. We need to find the
values in diagonal to make the sum of every row, column and diagonal equal.

Examples:

Input:
0 3 6
5 0 5
4 7 0
Output:
6 3 6
5 5 5
4 7 4
Explanation:
Now the value of the sum of
any row or column is 15*/
/**
Approach:
Let’s say the diagonal is x, y and z.
The value of x will be ( x2, 3 + x3, 2 ) / 2.
The value of z will be ( x1, 2 + x2, 1 ) / 2.
The value of y will be ( x0, 1 + z1, 0 ) / 2.*/

public class FillDiagonalSum {
    public static void main(String[] args)
    {
        // Initialize all the elements of a matrix
        int[][] arr = { { 0, 54, 48 },
                        { 36, 0, 78 },
                        { 66, 60, 0 } };

        System.out.print( "Matrix initially:\n");
        printMatrix(arr,arr.length,arr[0].length);

        fillDiagonalSum(arr);
    }

    private static void fillDiagonalSum(int[][] arr) {
        arr[0][0] = (arr[1][2] + arr[2][1])/2;
        arr[2][2] = (arr[0][1] + arr[1][0])/2;
        arr[1][1] = (arr[0][0] + arr[1][1])/2;

        System.out.print( "Matrix after diagonal filled = :\n");
        printMatrix(arr,arr.length,arr[0].length);
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

package com.Matrixs;
/**
Find sum of all Boundary and Diagonal element of a Matrix
Given a 2D array arr[][] of order NxN, the task is to find the sum of all the elements present
 in both the diagonals and boundary elements of the given arr[][].

Examples:
Input: arr[][] = { {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4} }
Output: 40
Explanation:
The Sum of elements on the boundary is 1 + 2 + 3 + 4 + 4 + 4 + 4 + 3 + 2 + 1 + 1 + 1 = 30.
The Sum of elements on the diagonals which do not intersect with the boundary
 elements is 2 + 3 + 2 + 3 = 10.
Therefore the required sum is 30 + 10 = 40*/
/*
Traverse the given 2D array with two loops, one for rows(say i) and another for columns(say j).
If i equals to j or (i + j) equals to (size of column – 1) then that element contributes to
diagonals of the given 2D array. first major diagonal and then minor diagonal respectively.
If (i or j equals to 0) or (i or j equals to size of column – 1) then that element
contributes to boundary elements of the given 2D array.
The sum of all the element satisfying above two conditions gives the required sum.*/

public class SumBoundaryDiagonal {
    public static void main(String[] args)
    {
        int[][] arr = { { 1, 2, 3, 4 },
                        { 1, 2, 3, 4 },
                        { 1, 2, 3, 4 },
                        { 1, 2, 3, 4 } };

        int row = arr.length;
        int col = arr[0].length;
        System.out.println(" given matrix is  == ");
        printMatrix(arr, row, col);

        diagonalBoundarySum(arr);

    }
    public static int N = 4;
    private static void diagonalBoundarySum(int[][] arr) {
        int reqSum=0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if(i==j || (i+j)==N-1) // // Condition for diagonal elements
                    reqSum+=arr[i][j];

                else if(i==0 || j==0 || i==N-1 || j==N-1)  // Condition for Boundary elements
                    reqSum+=arr[i][j];
            }
        }
        System.out.println("required sum == "+ reqSum);
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

package com.Matrixs;
// python matrix multiplications.
//result = [[sum(a * b for a, b in zip(A_row, B_col))
//        for B_col in zip(*B)]
//        for A_row in A]

public class MultiplyTwoMatrix {
    public static void main(String[] args)
    {

        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;

        int[][] A = { { 1, 1, 1 },
                      { 2, 2, 2 },
                      { 3, 3, 3 },
                      { 4, 4, 4 } };

        int[][] B = { { 1, 1, 1, 1 },
                      { 2, 2, 2, 2 },
                      { 3, 3, 3, 3 } };

        multiplyMatrixGivenSizes(row1, col1, A, row2, col2, B);
    }

    private static void multiplyMatrixGivenSizes(int row1, int col1, int[][] mat1,
                                                 int row2, int col2, int[][] mat2) {
        System.out.println("matrix 1 is == ");
        printMatrix(mat1, row1, col1);
        System.out.println("matrix 2 is == ");
        printMatrix(mat2, row2, col2);

        if(row2 != col1)
        {
            System.out.println("\nMultiplication Not Possible");
            return;
        }
        int[][] ans = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    ans[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        System.out.println("\nResultant Matrix:");
        printMatrix(ans, row1, col2);
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

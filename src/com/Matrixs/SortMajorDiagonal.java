package com.Matrixs;

//        Sort the major diagonal of the matrix
//        Given a matrix mat[][], the task is to sort the main diagonal elements of the matrix in
//        increasing order.
//
//        Main Diagonal: Main diagonal or major diagonal of a matrix is the collection of elements
//        mati, j, where i == j.
//        Examples:
//
//        Input: mat[][] = {{4, 2}, {3, 1}}
//        Output:
//        1 2
//        3 4
//        Explanation:
//        In the given matrix, the diagonal elements are -
//        => {mat[0][0], mat[1][1]}
//        => {4, 1}
//        => Sorted Order = {1, 4}
/**
Approach: The idea is modify the selection sort to sort the diagonal elements of the matrix.
 Count of the diangonal elements of matrix M*N will be min(M, N). As we know the major diagonal
 elements of the matrix are mati, j where i == j. Therefore, the ith element of the major diagonal
 of the matrix will be mat[i][i]. Hence, repeatadely find the minimum element from the major diagonal
 of the matrix and put it at the begining*/

public class SortMajorDiagonal {
    public static void main(String[] args)
    {
        int[][] a = {   { 5, 4, 7 },
                        { 1, 3, 8 },
                        { 2, 9, 6 } };
        int r = a.length;
        int c = a[0].length;
        System.out.println(" originally given  matrix is == ");
        printMatrix(a,r,c);

        sortMajorDiagonal(a, r, c);
    }

    private static void sortMajorDiagonal(int[][] mat, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            int sm = mat[i][i];
            int pos = i;
            for (int j = i+1; j < cols; j++)
            {
                if(sm > mat[j][j])
                {
                    sm  = mat[j][j];
                    pos = j;
                }
            }
            swapElementsGivenPosition(mat, i,i, pos, pos);
        }
        System.out.println(" sorted major diagonal matrix is == ");
        printMatrix(mat,rows,cols);
    }

    private static void swapElementsGivenPosition(int[][] mat, int firstI, int firstJ,
                                                  int secI, int secJ) {
        int temp  = mat[firstI][firstJ];
        mat[firstI][firstJ] = mat[secI][secJ];
        mat[secI][secJ] = temp;
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

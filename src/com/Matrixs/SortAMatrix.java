package com.Matrixs;

/*
Sort the given Matrix | Memory Efficient Approach
Given a matrix of N rows and M columns, the task is to sort the matrix in the strict order that is
every row is sorted in increasing order and the first element of every row is greater than the
first element of the previous row.
Examples:
Input: M[][] = { {5, 4, 7},
{1, 3, 8},
{2, 9, 6} }
Output: 1 2 3
4 5 6
7 8 9

Input: M[][] = { {5, 4, 7},
{1, 3, 8} }
Output: 1 3 4
5 7 8
Approach: The idea is to treat the 2D-Array as a 1D-Array to sort the matrix without using
 extra space. This can also be explained with the help of the following example
For Example:
There is a 2*2 Matrix with 4 elements,
The idea is to treat the elements of the matrix
as 1D Array of 4 elements.

1 2
3 4

As In the given matrix each element can be accessed as -
0st Element - 0th Row, 0th Col
1nd Element - 0th Row, 1st Col
2rd Element - 1st Row, 0th Col
3th Element - 1st Row, 1st Col
So For Accessing ith element of the matrix, the relation which can be defined as –

Ith Element of the Matrix = Mat[ i / cols ][ i % cols ]

Algorithm:

Find the number of rows(say rows) and columns(say cols) in the matrix by finding the length of the
number of rows in the 2D-Array and the elements in each row in the Array.
Iterate over each element of the matrix from 0 to number of elements (rows * cols).
Find the appropriate position of the element in the matrix using above formulae for each element.
Compare each element with the next element (For the last element in the row, next element will be
next row first element) in the matrix and if the next element is the less then swap these elements.*/

/**  Ith Element of the Matrix = Mat[ i / cols ][ i % cols ]   */

public class SortAMatrix {
    public static void main(String[] args)
    {

        int[][] mat = { { 5, 4, 7 },
                        { 1, 3, 8 },
                        { 2, 9, 6 } };

        int row = mat.length;
        int col = mat[0].length;
        sortMatrixNoSpace(mat, row, col);
        printMatrix(mat, row, col);
    }
//    Time Complexity: In the given approach, we are sorting the elements in the matrix by
//    considering the elements in 1D-Array using Bubble sort, So the overall complexity will be
//    O(N * M>)
//    Space Complexity: In the given approach no extra space is used, So the overall space
//    complexity will be O(1)

    private static void sortMatrixNoSpace(int[][] mat, int row, int col) {
        int size = row*col;
        // Loop to sort the matrix using Bubble Sort
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1); j++) {
                if(mat[j/col][j%col] > mat[(j+1)/col][(j+1)%col])
                {
                    // Swap if previous value is greater
                    int temp = mat[j/col][j%col];
                    mat[j/col][j%col] = mat[(j+1)/col][(j+1)%col];
                    mat[(j+1)/col][(j+1)%col] = temp;
                }
            }
        }
    }
//    Time Complexity: In the given approach, we are sorting the elements in the matrix by
//    considering the elements in 1D-Array using Bubble sort, So the overall complexity will be
//    O(N * M>)
//    Space Complexity: In the given approach no extra space is used, So the overall space
//    complexity will be O(1)

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

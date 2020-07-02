package com.Matrixs;

//Print maximum sum square sub-matrix of given size
//Given an N x N matrix, find a k x k sub-matrix where k <= N and k >= 1, such that sum of all the elements
// in sub-matrix is maximum. The input matrix can contain zero, positive and negative numbers.

//We can solve this problem in O(N2) time. This problem is mainly an extension of this problem of
// printing all sums. The idea is to preprocess the given square matrix. In the preprocessing step,
// calculate sum of all vertical strips of size k x 1 in a temporary square matrix stripSum[][].
// Once we have sum of all vertical strips, we can calculate sum of first sub-square in a row as sum of
// first k strips in that row, and for remaining sub-squares, we can calculate sum in O(1) time by removing
// the leftmost strip of previous sub-square and adding the rightmost strip of new square.

public class MaxSumKSquareSubMatrix {
    // Class to store the position of start of maximum sum in matrix
    static class Position {
        int x;
        int y;
        // Constructor
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // Updates the position if new maximum sum is found
        void updatePosition(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // returns the current value of X
        int getXPosition() {
            return this.x;
        }
        // returns the current value of y
        int getYPosition() {
            return this.y;
        }
    }
    // Size of given matrix
    static int N;
    public static void main(String[] args)
    {
        N = 5;
        int[][] mat = { { 1, 1, 1, 1, 1 },
                        { 2, 2, 2, 2, 2 },
                        { 3, 8, 6, 7, 3 },
                        { 4, 4, 4, 4, 4 },
                        { 5, 5, 5, 5, 5 } };
        int k = 3;

        System.out.println("Maximum sum 3 x 3 matrix is");
        printMaxSumSub(mat, k);
    }

    // A O(n^2) function to the maximum sum sub-squares of size k x k in a given square matrix of size n x n
    private static void printMaxSumSub(int[][] mat, int k) {
        // k must be smaller than or equal to n
        if (k > N)
            return;

        // 1: PREPROCESSING To store sums of all strips of size k x 1
        int[][] stripSum = new int[N][N];

        // Go column by column
        for (int j = 0; j < N; j++)
        {
            // Calculate sum of first k x 1 rectangle in this column
            int sum = 0;
            for (int i = 0; i < k; i++)
                sum += mat[i][j];

            stripSum[0][j] = sum;

            // Calculate sum of remaining rectangles
            for (int i = 1; i < (N-k+1); i++) {
                sum += ( mat[i + k - 1][j] -  mat[i - 1][j] );
                stripSum[i][j] = sum;
            }
        }
        // max_sum stores maximum sum and its position in matrix
        int max_sum = Integer.MIN_VALUE;
        Position pos = new Position(-1, -1);
        // 2: CALCULATE SUM of Sub-Squares using stripSum[][]
        for (int i = 0; i <(N-k+1); i++)
        {
            // Calculate and print sum of first sub-square in this row
            int sum = 0;
            for (int j = 0; j < k; j++)
                sum += stripSum[i][j];

            // Update max_sum and position of result
            if (sum > max_sum) {
                max_sum = sum;
                pos.updatePosition(i, 0);
            }
            // Calculate sum of remaining squares in current row by removing the leftmost
            // strip of previous sub-square and adding a new strip
            for (int j = 1; j < N - k + 1; j++) {
                sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]);

                // Update max_sum and position of result
                if (sum > max_sum) {
                    max_sum = sum;
                    pos.updatePosition(i, j);
                }
            }
        }

        // Print the result matrix
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(mat[i + pos.getXPosition()][j + pos.getYPosition()] + " ");
            }
            System.out.println();
        }
    }
}

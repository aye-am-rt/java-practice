package com.Matrixs;

/*Minimum cells to be flipped to get a 2*2 submatrix with equal elements
Given a matrix of size M * N, the task is to find the count of the minimum number of cells that
must be flipped such that there is at least a submatrix of size 2*2 with all equal elements.

Examples:
Input: mat[] = {“00000”, “10111”, “00000”, “11111”}
Output: 1
One of the possible sub matrix could be {{0, 0}, {1, 0}}
where only a single element has to be flipped.

Input: mat[] = {“0101”, “0101”, “0101”}
Output: 3*/

//Approach: For every submatrix of size 2*2, count the number of 0s and the number of 1s in it and
// the minimum of these two will be the count of flips required to get the matrix with all equal
// elements. The minimum of this value for all the submatrices is the required answer.

public class MinCellFlipsEqualMat {
    public static void main(String[] args)
    {
        String[] mat = { "0101", "0101", "0101" };
        int r = mat.length;
        int c = mat[0].length();
        System.out.print(minFlips(mat, r, c));
    }

    private static int minFlips(String[] mat, int r, int c) {
        // To store the result
        int res = Integer.MAX_VALUE;

        // For every sub matrix of size 2*2
        for (int i = 0; i < r - 1; i++)
        {
            for (int j = 0; j < c - 1; j++)
            {
                // Update the count of flips required
                // for the current sub matrix
                res = Math.min(res, minFlipsSub(mat, i, j));
            }
        }
        return res;
    }

    private static int minFlipsSub(String[] mat, int i, int j) {

        int cnt0 = 0, cnt1 = 0;

        if (mat[i].charAt(j) == '1')
            cnt1++;
        else
            cnt0++;

        if (mat[i].charAt(j+1) == '1')
            cnt1++;
        else
            cnt0++;

        if (mat[i + 1].charAt(j) == '1')
            cnt1++;
        else
            cnt0++;

        if (mat[i + 1].charAt(j+1) == '1')
            cnt1++;
        else
            cnt0++;

        return Math.min(cnt0, cnt1);
    }
}

package com.Matrixs;

public class MaxSumPathWay2 {
    public static void main (String[]args)
    {
        int[][] mat = { {10, 10, 2, 0, 20, 4},
                        {1, 0, 0, 30, 2, 5},
                        {0, 10, 4, 0, 2, 0},
                        {1, 0, 2, 20, 0, 4} };
        int r = 4;
        int c = 6;

        System.out.println(findMaxPath(mat,r,c));
    }
    static int findMaxPath (int[][] mat, int r, int c)
    {
        // To find max val in first row
        int res = -1;
        for (int i = 0; i < c; i++)
            res = Math.max(res, mat[0][i]);

        for (int i = 1; i < r; i++)
        {
            res = -1;
            for (int j = 0; j < c; j++)
            {
                // When all paths are possible
                if (j > 0 && j < c - 1)
                    mat[i][j] += Math.max(mat[i - 1][j], Math.max(mat[i - 1][j - 1], mat[i - 1][j + 1]));

                    // When diagonal right is not possible
                else if (j > 0)
                    mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j - 1]);

                    // When diagonal left is not possible
                else if (j < c - 1)
                    mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j + 1]);

                // Store Math.max() path sum
                res = Math.max(mat[i][j], res);
            }
        }
        return res;
    }
}


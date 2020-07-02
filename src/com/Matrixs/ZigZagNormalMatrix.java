package com.Matrixs;
/*
Print a given matrix in zigzag form Given a 2D array, print it in zigzag form.
Examples :

Input :
1    2   3   4   5
6    7   8   9   10
11   12  13  14  15
16  17  18  19   20
Output :
1 2 3 4 5 10 9 8 7 6 11 12 13 14 15 20 19 18 17 16

Input :
10    24   32
50    6    17
99    10   11

Output :
10 24 32 17 6 50 99 10 11*/

public class ZigZagNormalMatrix {
    public static void main(String[] args)
    {

        int r = 3, c = 5;

        int[][] mat = { {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15} };

        printZigZag(r , c , mat);
    }

    private static void printZigZag(int r, int c, int[][] mat) {
        if(r<1 || c <1)
        {
            return;
        }
        for (int i = 0; i < r; i++) {
            if(i%2==0)
            {
                for (int j = 0; j < c; j++) {
                    System.out.print(mat[i][j]+"  ");
                }
            }
            else
            {
                for (int j = c-1; j > -1; j--) {
                    System.out.print(mat[i][j]+"  ");
                }
            }
        }
    }

}

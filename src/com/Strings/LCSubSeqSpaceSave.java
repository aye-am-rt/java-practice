package com.Strings;
/*A Space Optimized Solution of LCS
Given two strings, find the length of longest subsequence present in both of them.
Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
We have discussed typical dynamic programming based solution for LCS. We can optimize space used by lcs
problem. We know recurrence relation of LCS problem is*/

/**One important observation in above simple implementation is, in each iteration of outer loop we only, need
 * values
 * from all columns of previous row. So there is no need of storing all rows in our DP matrix, we can just store
 * two rows at a time and use them, in that way used space will reduce from L[m+1][n+1] to L[2][n+1]. Below is
 * the implementation of above idea.*/

public class LCSubSeqSpaceSave {
    public static void main(String[] args)
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        System.out.println("Length of LCS is " + LCSubSeqLengthONSp(X, Y));
    }

    private static int LCSubSeqLengthONSp(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        int[][] L = new int[2][l2+1];
        // Binary index, used to index current row and previous row.
        int bi=0;
        for (int i = 0; i <= l1; i++)
        {
            bi=i&1;

            for (int j = 0; j <= l2; j++)
            {
                if(i==0 || j==0)
                    L[bi][j] = 0;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    L[bi][j] = 1 + L[1- bi][ j- 1];
                else
                    L[bi][j] =  Math.max(L[1-bi][j],L[bi][j-1]);
            }
        }
        // Last filled entry contains length of
        // LCS for X[0..n-1] and Y[0..m-1]
        return L[bi][l2];
    }
}

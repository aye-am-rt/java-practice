package com.Arrays.AmazonSubSeq;
//
//Following is a general recursive solution with all cases handled.

//// Every single character is a palindrome of length 1
//        L(i, i) = 1 for all indexes i in given sequence
//
//// IF first and last characters are not same
//        If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)}
//
//// If there are only 2 characters and both are same
//        Else if (j == i + 1) L(i, j) = 2
//
//// If there are more than two characters, and first and last
//// characters are same
//        Else L(i, j) =  L(i + 1, j - 1) + 2

/**Longest Palindromic Subsequence | DP-12
Given a sequence, find the length of the longest palindromic subsequence in it.
longest-palindromic-subsequence
As another example, if the given sequence is “BBABCBCAB”, then the output should be 7 as
 “BABCBAB” is the longest palindromic subsequence in it. “BBBBB” and “BBCBB” are also palindromic
 subsequences of the given sequence, but not the longest ones.

The naive solution for this problem is to generate all subsequences of the given sequence and find the
 longest palindromic subsequence. This solution is exponential in term of time complexity. Let us
 see how this problem possesses both important properties of a Dynamic Programming (DP) Problem and
 can efficiently solved using Dynamic Programming.*/

public class LongestPalSubSeqDP {
    public static void main(String[] args)
    {
        String seq = "abc__cba";   // ans == 8
        int n = seq.length();
        System.out.println("The length of the lps is "+ lps(seq,n));
    }

    private static int lps(String seq, int ln) {
        if(ln<1)
            return 0;

        int[][] dpLs= new int[ln][ln];
        for (int i = 0; i < ln; i++) {
            dpLs[i][i]=1; // // Strings of length 1 are palindrome of length 1
        }
        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process.
        // subStl is length of substring used in for loop
        for (int subStL = 2; subStL <= ln; subStL++)
        {
            for (int i = 0; i < (ln-subStL+1); i++)
            {
                int j= i+subStL-1;
                boolean areCharsEqual = seq.charAt(i) == seq.charAt(j);
                if(areCharsEqual && subStL==2)
                {
                    dpLs[i][j]=2;
                }
                else if(areCharsEqual)
                {
                    dpLs[i][j]=dpLs[i+1][j-1]+2;
                }
                else
                {
                    dpLs[i][j] = Math.max(dpLs[i][j-1], dpLs[i+1][j]);
                }

            }
        }
        return dpLs[0][ln-1];
    }
}

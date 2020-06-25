package com.Strings.JustSubStrings;
//Longest Common Substring | DP-29
//        Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
//        Examples :
//
//        Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
//        Output : 5
//        The longest common substring is “Geeks” and is of length 5.
//
//        Input : X = “abcdxyz”, y = “xyzabcd”
//        Output : 4
/**
Dynamic Programming can be used to find the longest common substring in O(m*n) time. The idea is to
 find length of the longest common suffix for all substrings of both strings and store these lengths
 in a table.

        The longest common suffix has following optimal substructure property.

        If last characters match, then we reduce both lengths by 1
        LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1]
        If last characters do not match, then result is 0, i.e.,
        LCSuff(X, Y, m, n) = 0 if (X[m-1] != Y[n-1])

        Now we consider suffixes of different substrings ending at different indexes.
        The maximum length Longest Common Suffix is the longest common substring.
        LCSubStr(X, Y, m, n) = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m and 1 <= j <= n*/

public class LCommonSubStringDP {
    public static void main(String[] args)
    {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is "
                + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
        System.out.println("Length of Longest Common Substring is " + LCSubStrSpaceSave(X,Y));
        System.out.println("Printing the LCS better way = "+FindLCSPrint(X,Y));
    }

    private static int LCSubStrSpaceSave(String str1, String str2) {
        int l1=str1.length();
        int l2= str2.length();
        int resultLength= 0;
        // Matrix to store result of two consecutive rows at a time.
        int[][] LDP=new int[2][l2+1];
        // Variable to represent which row of matrix is current row.
        int currRow = 0;
        // For a particular value of i and j, len[currRow][j] stores length of longest
        // common substring in string X[0..i] and Y[0..j].
        for (int i = 0; i <= l1; i++)
        {
            for (int j = 0; j <= l2; j++)
            {
                if(i==0 || j==0)
                    LDP[currRow][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    LDP[currRow][j] = 1 + LDP[1-currRow][j-1];
                else
                    LDP[currRow][j] = 0;

                resultLength=Math.max(resultLength,LDP[currRow][j]);
            }
            // Make current row as previous row and previous row as new current row.
            currRow = 1 - currRow;
        }

        return resultLength;
    }

    private static String FindLCSPrint(String x, String y) {
        String out="";
        if(x.length()==0 || y.length()==0)
            return out;
        int maxLenFound=0;
        int[][] LengthCache=new int[x.length()][y.length()];
        for (int i = 0; i < x.length(); i++) {
            for (int j = 0; j < y.length(); j++) {
                if(x.charAt(i)==y.charAt(j))
                {
                    if(i==0 || j==0)
                        LengthCache[i][j]=1;
                    else
                        LengthCache[i][j]=LengthCache[i-1][j-1]+1;
                }
                if(LengthCache[i][j]>maxLenFound)
                {
                    maxLenFound=LengthCache[i][j];
                    out=x.substring(i-maxLenFound+1,i+1);  // start including ending not (Exclude)
                }
            }
        }
        return out;
    }

    private static int LCSubStr(char[] str1Arr, char[] str2Arr, int l1, int l2) {
        int[][] LCStuff = new int[l1 + 1][l2 + 1];
        int result = 0;
        for (int i = 0; i < l1+1; i++) {
            for (int j = 0; j < l2+1; j++) {
                if(i==0 || j==0)
                    LCStuff[i][j]=0;
                else if(str1Arr[i-1]==str2Arr[j-1])
                {
                    LCStuff[i][j]=LCStuff[i-1][j-1]+1;
                    result=Math.max(result,LCStuff[i][j]);
                }
                else
                    LCStuff[i][j]=0;
            }
        }
        return result;
    }
}

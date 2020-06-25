package com.Strings.SubSequences;

import java.util.HashSet;
import java.util.Set;

/**
Printing Longest Common Subsequence | Set 2 (Printing All)
Given two sequences, print all longest subsequence present in both of them.
Examples:
Input:
string X = "AGTGATG"
string Y = "GTTAG"
Output:
GTAG
GTTG

Input:
string X = "AATCC"
string Y = "ACACG"
Output:
ACC
AAC

Input:
string X = "ABCBDAB"
string Y = "BDCABA"
Output:
BCAB
BCBA
BDAB*/
//Following is detailed algorithm to print the all LCS.
//
//We construct L[m+1][n+1] table as discussed in the previous post and traverse the 2D array starting from
// L[m][n]. For current cell L[i][j] in the matrix,
//
//a) If the last characters of X and Y are same (i.e. X[i-1] == Y[j-1]), then the character must be present in all
// LCS of substring X[0…i-1] and Y[0..j-1]. We simply recurse for L[i-1][j-1] in the matrix and append current
// character to all LCS possible of substring X[0…i-2] and Y[0..j-2].
//
//b) If the last characters of X and Y are not same (i.e. X[i-1] != Y[j-1]), then LCS can be constructed from
// either top side of the matrix (i.e. L[i-1][j]) or from left side of matrix (i.e. L[i][j-1]) depending upon
// which value is greater. If both the values are equal(i.e. L[i-1][j] == L[i][j-1]), then it will be constructed
// from both sides of matrix. So based on values at L[i-1][j] and L[i][j-1], we go in direction of greater value or
// go in both directions if the values are equal.

public class PrintLCSubSeqOFStrings {
    public static void main(String[] args)
    {
        String X = "AGTGATG";
        String Y = "GTTAG";
        int m = X.length();
        int n = Y.length();

        System.out.println("LCS length is " + LCSLength(X, Y, m, n));
        Set<String> s = findLCS(X, Y, m, n);

        System.out.println("printing answer strings =  ");
        for (String str : s)
            System.out.println(str);
    }
    /** Returns set containing all LCS for  X[0..m-1], Y[0..n-1] **/
    private static Set<String> findLCS(String str1, String str2, int l1, int l2) {
        Set<String> lcsAnsSet = new HashSet<>();
        // If we reaches end of either String, return a empty set
        if(l1==0 || l2==0)
        {
            lcsAnsSet.add("");
            return lcsAnsSet;
        }
        if(str1.charAt(l1-1)==str2.charAt(l2-1)) // if last chars of both the string are same
        {
            // recur for possible lcs in l1-2 and l2-2
            Set<String> temp = findLCS(str1,str2,l1-1,l2-1);
            // append current character to all possible LCS of subString X[0..m-2] and Y[0..n-2].
            for (String str : temp)
                lcsAnsSet.add(str + str1.charAt(l1 - 1)); // both string chars are equal here so use any one of them
        }
        else // means last chars of string are not same
        {
            //If LCS can be constructed from top side of the matrix, recurse for X[0..m-2] and Y[0..n-1]
            if(L[l1-1][l2] >= L[l1][l2-1])
            {
                Set<String> temp = findLCS(str1,str2,l1-1,l2);
                lcsAnsSet.addAll(temp);
            }
            //we are not writing else if because we have to take both cases when both can be greater than
            // current cell in matrix
            if(L[l1][l2-1] >= L[l1-1][l2])
            {
                Set<String> temp = findLCS(str1,str2,l1,l2-1);
                lcsAnsSet.addAll(temp);
            }
        }
        return lcsAnsSet;
    }

    // Maximum String length
    static int N = 100;
    static int [][]L = new int[N][N];  // this technique is called tabulation and memoization is below another function
    // where it is checked that is this value is calculated before somewhere then just simply return it. dont calculate
    // again
    private static int LCSLength(String str1, String str2, int l1, int l2) {
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if(i==0 || j==0)
                {   L[i][j] = 0;  }
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                {   L[i][j] = 1 + L[i-1][j-1];    }
                else
                {   L[i][j] = Math.max(L[i-1][j],L[i][j-1]);    }
            }
        }//Time Complexity of the above implementation is O(mn) which is much better than
        // the worst-case time complexity of Naive Recursive implementation.
        return L[l1][l2];
    }
}

/** Returns length of LCS for X[0..m-1], Y[0..n-1]
 * this is recursive function bad time complexity
 * Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens when
 * all characters of X and Y mismatch i.e., length of LCS is 0.
 * Considering the above implementation, following is a partial recursion tree for input strings “AXYT” and
 * “AYZX”
 * So this problem has Overlapping Substructure property and recomputation of same subproblems can be avoided
 * by either using Memoization or Tabulation. Following is a tabulated implementation for the LCS problem.*/
/*
    int lcs( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
        else
            return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    } */

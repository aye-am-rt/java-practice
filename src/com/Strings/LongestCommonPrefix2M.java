package com.Strings;
/**
Longest Common Prefix using Character by Character Matching
        Given a set of strings, find the longest common prefix.

        Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
        Output : "gee"

        Input  : {"apple", "ape", "april"}
        Output : "ap"*/

public class LongestCommonPrefix2M {
    public static void main(String[] args)
    {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        int n = arr.length;

        String ans = commonPrefixCharMatching(arr, n);

        if (ans.length() > 0) {
            System.out.println("The longest common prefix is " + ans);
        } else {
            System.out.println("There is no common prefix");
        }
    }

    private static String commonPrefixCharMatching(String[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        int minLenOfStr=FindMinLen(arr,n);

        StringBuilder sBld=new StringBuilder();
        char currChar;
        for (int i = 0; i < minLenOfStr; i++) {
            currChar=arr[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if(arr[j].charAt(i)!=currChar)
                    return sBld.toString();
            }
            sBld.append(currChar);
        }

        return sBld.toString();
    }

    private static int FindMinLen(String[] arr, int n) {
        int minLen=arr[0].length();
        for (int i = 1; i < n; i++) {
            minLen = Math.min(minLen,arr[i].length());
        }
        return minLen;
    }
}

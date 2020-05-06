package com.Strings;
/*
Longest Common Prefix using Divide and Conquer Algorithm
        Given a set of strings, find the longest common prefix.
        Examples:

        Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
        Output : "gee"

        Input  : {"apple", "ape", "april"}
        Output : "ap"

        We have discussed word by word matching and character by character matching algorithms.

        In this algorithm, a divide and conquer approach is discussed. We first divide the
        arrays of string into two parts. Then we do the same for left part and after that for the
        right part. We will do it until and unless all the strings become of length 1. Now after that,
         we will start conquering by returning the common prefix of the left and the right strings.
        The algorithm will be clear using the below illustration. We consider our strings as –
         “geeksforgeeks”, “geeks”, “geek”, “geezer”*/

public class LongestCommonPrefixDC {
    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        int n = arr.length;
        String ans = LongestCommonPrefix(arr, 0, n - 1);

        if (ans.length() != 0) {
            System.out.println("The longest common prefix is ==  " + ans);
        } else {
            System.out.println("There is no common prefix");
        }
    }

    private static String LongestCommonPrefix(String[] arr, int left, int right) {
        if(left==right)
            return arr[left];
        if(right>left) {
            int mid = left + (right - left) / 2;
            String strLeft = LongestCommonPrefix(arr, left, mid);
            String strRight = LongestCommonPrefix(arr, mid + 1, right);
            return MergeBackAfterChecking(strLeft, strRight);
        }
        return null;
    }

    private static String MergeBackAfterChecking(String strLeft, String strRight) {
        StringBuilder sBld=new StringBuilder();
        int n1=strLeft.length();
        int n2=strRight.length();

        int i=0;
        int j=0;
        while (i<n1 && j<n2)
        {
            if(strLeft.charAt(i)!=strRight.charAt(j))
                break;
            sBld.append(strLeft.charAt(i));
            i+=1;
            j+=1;
        }
        return sBld.toString();
    }
}
/**Time Complexity : Since we are iterating through all the characters of all the
 * strings, so we can say that the time complexity is O(N M) where,
N = Number of strings
M = Length of the largest string string
Auxiliary Space : To store the longest prefix string we are allocating space which is O(M Log N).*/

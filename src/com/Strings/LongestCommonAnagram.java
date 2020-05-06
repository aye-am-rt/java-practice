package com.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**

Longest Common Anagram Subsequence
Given two strings str1 and str2 of length n1 and n2 respectively. The problem is to find the length
 of the longest subsequence which is present in both the strings in the form of anagrams.
Note: The strings contain only lowercase letters.

Examples:

Input : str1 = "abdacp", str2 = "ckamb"
Output : 3
Subsequence of str1 = abc
Subsequence of str2 = cab
OR
Subsequence of str1 = bac
Subsequence of str2 = cab

These are longest common anagram subsequences.

Input : str1 = "abbcfke", str2 = "fbaafbly"
Output : 4

Approach: Create two hash tables say freq1 and freq2. Store frequencies of each character of str1
 in freq1. Likewise, store frequencies of each character of str2 in freq2. Initilaize len = 0.
 Now, for each lowercase letter finds its lowest frequency from the two hash tables and accumulate
 it to len.
*/

public class LongestCommonAnagram {
    public static void main(String[] args)
    {
        String str1 = "abdacp";
        String str2 = "ckamb";
        int n1 = str1.length();
        int n2 = str2.length();
        System.out.print("Length = " + longCommonAnagramSubSeq(str1, str2, n1, n2));
        System.out.print("Length = " + longCommonAnagramSubSeqArrayMethod(str1, str2, n1, n2));


    }

    private static int longCommonAnagramSubSeqArrayMethod(String str1, String str2, int n1, int n2) {
        // hash tables for storing frequencies of each character
        int []freq1 = new int[SIZE];
        int []freq2 = new int[SIZE];

        for(int i = 0; i < SIZE; i++)
        {
            freq1[i] = 0;
            freq2[i] = 0;
        }

        int len = 0;

        // calculate frequency of each character of 'str1[]'
        for (int i = 0; i < n1; i++)
            freq1[(int)str1.charAt(i) - (int)'a']++;

        // calculate frequency of each character of 'str2[]'
        for (int i = 0; i < n2; i++)
            freq2[(int)str2.charAt(i) - (int)'a']++;

        // for each character add its minimum frequency out of the two Strings in 'len'
        for (int i = 0; i < SIZE; i++)
            len += Math.min(freq1[i],
                    freq2[i]);
        System.out.println(Arrays.toString(freq1));
        System.out.println(Arrays.toString(freq2));

        // required length()
        return len;
    }

    static int SIZE = 26;
    private static int longCommonAnagramSubSeq(String str1, String str2, int n1, int n2) {

        HashMap<Character,Integer> charFMap1=new HashMap<>(SIZE);
        HashMap<Character,Integer> charFMap2=new HashMap<>(SIZE);
        for (int i = 0; i < n1; i++) {
            charFMap1.put(str1.charAt(i),charFMap1.getOrDefault(str1.charAt(i),0)+1);
        }
        for (int i = 0; i < n2; i++) {
            charFMap2.put(str2.charAt(i),charFMap2.getOrDefault(str2.charAt(i),0)+1);
        }
        System.out.println(charFMap1);
        System.out.println(charFMap2);
        int len = 0;
        HashSet<Character> lcSet= new HashSet<>();
        // for each character add its minimum frequency out of the two Strings in 'len'
        if(n1>=n2) // chose for  char counting which one is largest see line 102 and 113 difference
        {
            //        String str1 = "abdacp";
            //        String str2 = "ckamb";
            for (int i = 0; i < n1; i++) {
                if(! lcSet.contains(str1.charAt(i))) {
                    len += Math.min(charFMap1.getOrDefault(str1.charAt(i), 0),
                            charFMap2.getOrDefault(str1.charAt(i), 0));
                    lcSet.add(str1.charAt(i));
                    //System.out.println("len = " + len + " i = " + i);
                }
            }
        }
        else
        {
            for (int i = 0; i < n2; i++) {
                if(! lcSet.contains(str1.charAt(i))) {
                    len += Math.min(charFMap1.getOrDefault(str2.charAt(i), 0),
                            charFMap2.getOrDefault(str2.charAt(i), 0));
                    lcSet.add(str1.charAt(i));
                    //System.out.println("len = " + len + " i = " + i);
                }
            }
        }
        //System.out.println(lcSet);
        return len;
    }
}

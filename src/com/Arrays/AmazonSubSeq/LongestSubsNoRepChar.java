package com.Arrays.AmazonSubSeq;

import java.util.HashMap;

/**Print Longest substring without repeating characters
Given a string, print the longest substring without repeating characters. For example, the longest
 substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
 For “BBBB” the longest substring is “B”, with length 1. The desired time complexity is O(n) where
 n is the length of the string.
Prerequisite: Length of longest substring without repeating characters
Examples:
Input : GEEKSFORGEEKS
Output : EKSFORG

Input : ABDEFGABEF
Output : BDEFGA
Recommended : Please try your approach first on IDE and then look at the solution.

Approach: The idea is to traverse the string and for each already visited character store its last
 occurrence in a hash table(Here unordered_map is used as hash with key as character and value as its
 last position). The variable st stores starting point of current substring, maxlen stores length of
 maximum length substring and start stores starting index of maximum length substring.
 While traversing the string, check whether current character is present in hash table or not.
 If it is not present, then store current character in hash table with value as current index.
 If it is already present in hash table, this means the current character could repeat in current
 substring. For this check if the previous occurrence of character is before or after the starting
 point st of current substring. If it is before st, then only update the value in hash table.
 If it is after st, then find length of current substring currlen as i-st, where i is current index.
 Compare currlen with maxlen. If maxlen is less than currlen, then update maxlen as currlen and start
 as st. After complete traversal of string, the required longest substring without repeating characters
 is from s[start] to s[start+maxlen-1].*/

public class LongestSubsNoRepChar {
    public static void main (String[] args) {
        String str = "GEEKSFORGEEKS";
        int n = str.length();
        System.out.println(PrintLongestSubsNoRepChar(str, n));
    }
//    Time Complexity: O(n)
//    Auxiliary Space: O(n)
    private static String PrintLongestSubsNoRepChar(String str, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        int currSubStart=0;
        int maxLenFound=0;
        int startCurrMax=0;
        HashMap<Character,Integer> charLastSeenMap= new HashMap<>();
        charLastSeenMap.put(str.charAt(0),0);
        for (int i = 1; i < n; i++) {
            if(! charLastSeenMap.containsKey(str.charAt(i)))
                charLastSeenMap.put(str.charAt(i),i);
            else
            {
                if(charLastSeenMap.get(str.charAt(i))>=currSubStart)
                {
                    int currLen=i-currSubStart;
                    if(currLen>maxLenFound) {
                        maxLenFound = currLen;
                        startCurrMax=currSubStart;
                    }
                    currSubStart=charLastSeenMap.get(str.charAt(i))+1;
                }
                charLastSeenMap.put(str.charAt(i),i);
            }
            if(maxLenFound< i-currSubStart) {
                maxLenFound = i - currSubStart;
                startCurrMax=currSubStart;
            }
        }
        return str.substring(startCurrMax,startCurrMax+maxLenFound);
    }
//    Time Complexity: O(n)
//    Auxiliary Space: O(n)
}

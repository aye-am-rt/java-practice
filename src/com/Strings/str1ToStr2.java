package com.Strings;

/**
Count of characters in str1 such that after deleting anyone of them str1 becomes str2
 Given two strings str1 and str2, the task is to count the characters in str1 such
 that after removing any one of them str1 becomes identical to str2. Also, print positions of these
 characters. If it is not possible then print -1.

        Examples:

        Input: str1 = “abdrakadabra”, str2 = “abrakadabra”
        Output: 1
        The only valid character is at index 2 i.e. str1[2]



        Input: str1 = “aa”, str2 = “a”
        Output: 2

        Input: str1 = “geeksforgeeks”, str2 = “competitions”
        Output: 0
**/

public class str1ToStr2 {

        static int Find_Index(String str1, String str2)
        {
            int n = str1.length();
            int m = str2.length();
            int l = 0;
            int r = 0;

            // Solution doesn't exist
            if (n != m + 1)
            { return -1; }

            // Find the length of the longest
            // common prefix of strings
            for (int i = 0; i < m; i++)
            {
                if (str1.charAt(i) == str2.charAt(i))
                {
                    l += 1;
                }
                else
                {
                    break;
                }
            }

            // Find the length of the longest
            // common suffix of strings
            int i = n - 1;
            int j = m - 1;
            while (i >= 0 && j >= 0 && str1.charAt(i) == str2.charAt(j))
            {
                r += 1;
                i -= 1;
                j -= 1;
            }

            // If solution does not exist
            if (l + r < m)
            {
                return -1;
            }

            // Return the count of indices
            else
            {
                i = Math.max(n - r, 1);
                j = Math.min(l + 1, n);
                return (j - i + 1);
            }
        }

        // Driver code
        public static void main(String[] args)
        {
            String str1 = "abdrakadabra", str2 = "abrakadabra";
            System.out.println(Find_Index(str1, str2));
        }
}

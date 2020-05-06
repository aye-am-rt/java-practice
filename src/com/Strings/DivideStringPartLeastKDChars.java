package com.Strings;

import java.util.HashMap;
import java.util.Map;

/**
Partition the string in two parts such that both parts have at least k different characters
Given a string of lowercase English alphabets and an integer 0 < K <= 26. The task is to divide the
 string into two parts (also print them) such that both parts have at least k different characters.
 If there are more than one answers possible, print one having the smallest left part. If there is no
 such answers, print “Not Possible”.

Examples:

Input : str = “geeksforgeeks”, k = 4
Output : geeks , forgeeks
The string can be divided into two parts as “geeks” and “forgeeks”. Since “geeks” has four different
 characters ‘g’, ‘e’, ‘k’ and ‘s’ and this is the smallest left part, “forgeeks” has also at least
 four different characters.

Input : str = “aaaabbbb”, k = 2
Output :Not Possible*/
//
//Approach :
//
//Idea is to count the number of distinct characters using a Hashmap.
//If the count of the distinct variable becomes equal to k, then the left part of the string is found so
// store this index, break the loop and unmark all the characters.
//Now run a loop from where the left string ends to end of the given string and repeat the same
// process as it was done to find the left string.
//If count is greater than or equal to k, then right string could be found otherwise print “Not Possible”.
//If it is possible , then print the left string and right string.

public class DivideStringPartLeastKDChars {
    // Function to find the partition of the
// string such that both parts have at
// least k different characters
    static void division_of_string(char[] str, int k)
    {
        // Length of the string
        int n = str.length;

        // To check if the current
        // character is already found
        Map<Character, Boolean> has = new HashMap<>();

        int ans = 0, cnt = 0, i = 0;

        // Count number of different
        // characters in the left part
        while (i < n)
        {

            // If current character is not
            // already found, increase cnt by 1
            if (!has.containsKey(str[i]))
            {
                cnt++;
                has.put(str[i], true);
            }

            // If count becomes equal to k, we've
            // got the first part, therefore,
            // store current index and break the loop
            if (cnt == k)
            {
                ans = i;
                break;
            }

            i++;
        }

        // Clear the map
        has.clear();

        // Assign cnt as 0
        cnt = 0;

        while (i < n)
        {

            // If the current character is not
            // already found, increase cnt by 1
            if (!has.containsKey(str[i]))
            {
                cnt++;
                has.put(str[i], true);
            }

            // If cnt becomes equal to k, the
            // second part also have k different
            // characters so break it
            if (cnt == k)
            {
                break;
            }

            i++;
        }

        // If the second part has less than
        // k different characters, then
        // print "Not Possible"
        if (cnt < k)
        {
            System.out.println("Not possible");
        }

        // Otherwise print both parts
        else
        {
            i = 0;
            while (i <= ans)
            {
                System.out.print(str[i]);
                i++;
            }
            System.out.println("");

            while (i < n)
            {
                System.out.print(str[i]);
                i++;
            }
            System.out.println("");
        }

        System.out.println("");
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "geeksforgeeks";
        int k = 4;

        // Function call
        division_of_string(str.toCharArray(), k);
    }
}

package com.practiceTab2.StacksMake;
/*
Rearrange the characters of the string such that no two adjacent characters are consecutive English alphabets
    Given string str of size N consists of lower-case English alphabets. The task is to find the
    arrangement of the characters of the string such that no two adjacent characters are neighbors
    in English alphabets. In case of multiple answers print any of them. If no such arrangement
    is possible then print -1*/

import java.util.Arrays;

public class RearrangeNotNeighbour {
    public static void main(String[] args)
    {
        String str = "aabcd";
        Rearrange(str);
    }

    private static void Rearrange(String str) {
        if(str.length()<=1)
            System.out.println("not possible ");
        String oddStr="";
        String evenStr="";
        for (int i = 0; i < str.length(); i++) {
            int val=Character.getNumericValue(str.charAt(i));
            if(val%2==0)
                evenStr+=Character.toString(str.charAt(i));
            else
                oddStr+=Character.toString(str.charAt(i));
        }
        // Sort both the strings-make a new function for it convert them to char array then sort then
        // join back and return the string
        // Method to sort a string alphabetically
//        public static String sort(String inputString)
//        {
//            // convert input string to char array
//            char tempArray[] = inputString.toCharArray();
//
//            // sort tempArray
//            Arrays.sort(tempArray);
//
//            // return new sorted string
//            return new String(tempArray);
//        }
//        oddStr = sort(oddStr);
//        evenStr = sort(evenStr);
        if(CheckNeighbours(evenStr.concat(oddStr)))
            System.out.println("arrangement= "+evenStr+oddStr);
        else if(CheckNeighbours(oddStr.concat(evenStr)))
            System.out.println("arrangement= "+oddStr+evenStr);
        else
            System.out.println("-1");
    }

    private static boolean CheckNeighbours(String addedString) {
        // (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 1) direct subtraction also would have  worked
        for (int i = 1; i < addedString.length()-1; i++) {
            int curr=Character.getNumericValue(addedString.charAt(i));
            int prev=Character.getNumericValue(addedString.charAt(i-1));
            int next=Character.getNumericValue(addedString.charAt(i+1));
            if(Math.abs(curr-prev)==1 ||Math.abs(curr-next)==1)
                return false;
        }
        return true;
    }

}

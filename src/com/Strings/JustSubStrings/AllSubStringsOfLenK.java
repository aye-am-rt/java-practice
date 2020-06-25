package com.Strings.JustSubStrings;

import java.util.HashSet;

public class AllSubStringsOfLenK {
    public static void main(String[] args) {
        String input = "algo";
        int k = 2;
        printAllSubSofSizeK(input,k);
    }

    private static void printAllSubSofSizeK(String input, int k) {
        if(input==null || input.length()==0 || k==0)
        {
            throw new IllegalArgumentException();
        }
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if(i+k <= input.length())
                hs.add(input.substring(i,i+k));
        }
        System.out.println(" hash set of all unique substring of size k =");
        System.out.println(hs);
    }
}

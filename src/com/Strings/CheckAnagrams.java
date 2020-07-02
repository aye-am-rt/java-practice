package com.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckAnagrams {
    public static void main(String[] args)
    {
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";

        if (areAnagram(str1, str2))
            System.out.println(" yes The two strings are" + "anagram of each other");
        else
            System.out.println("No The two strings are not" + " anagram of each other");

        if(areAnagramsUsingHash(str1,str2))
            System.out.println(" yes The two strings are" + "anagram of each other");
        else
            System.out.println("No The two strings are not" + " anagram of each other");

    }

    private static boolean areAnagramsUsingHash(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        HashMap<Character,Integer> cMap1= new HashMap<>();
        HashMap<Character,Integer> cMap2= new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            cMap1.put(str1.charAt(i),cMap1.getOrDefault(str1.charAt(i),0)+1);
            cMap2.put(str2.charAt(i),cMap2.getOrDefault(str2.charAt(i),0)+1);
        }
       Iterator<Map.Entry<Character, Integer>> it = cMap1.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry ent = it.next();
            Character c = (Character) ent.getKey();
            Integer count = (Integer) ent.getValue();

            System.out.println("c = "+c +" and count = "+ count);
        }
        cMap2.forEach((k, v) -> System.out.println(k + " : " + (v)));

        return cMap1.equals(cMap2);
    }

    private static boolean areAnagram(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        char[] ca1= str1.toCharArray();
        char[] ca2= str2.toCharArray();
        Arrays.sort(ca1);
        Arrays.sort(ca2);
        for (int i = 0; i < str1.length(); i++) {
            if(ca1[i]!=ca2[i])
                return false;
        }
        return true;
    }
}

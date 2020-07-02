package com.Strings;
/*
Given a sequence of words, print all anagrams together | Set 1
Given an array of words, print all anagrams together. For example, if the given array is
{“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat tac act dog god”.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**In the previous approach, we were sorting every string in order to maintain a similar key, but that
 *  cost extra time in this approach will take the advantage of another hashmap to maintain the frequency of
 *  the characters which will generate the same hash function for different string having same frequency
 *  of characters.

Here, we will take HashMap<HashMap, ArrayList>, the inner hashmap will count the frequency of the
 characters of each string and the outer HashMap will check whether that hashmap is present or not
 if present then it will add that string to the corresponding list.*/

public class MakeAllAnagramsTogether1 {
    // Drivers Method
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("ogd");
        list.add("god");
        list.add("atc");

        System.out.println(CollectAnagrams_Using_HMap_Nested(list));
    }

    private static ArrayList<ArrayList<String>> CollectAnagrams_Using_HMap_Nested(ArrayList<String> listAll)
    {
        // Inner hashmap counts frequency of characters in a string. Outer hashmap for if same frequency
        // characters are present in in a string then it will add it to the arraylist.

        HashMap<HashMap<Character,Integer>,ArrayList<String>> hMapL= new HashMap<>();

        for (String str : listAll)
        {
            HashMap<Character,Integer> tempInrMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                tempInrMap.put(str.charAt(i),tempInrMap.getOrDefault(str.charAt(i),0)+1);
            }

            // If the same frequency of characters are already present then add that string into that
            // arraylist otherwise created a new arraylist and add that string
            if(hMapL.containsKey(tempInrMap))  // this is outer map
            {
                hMapL.get(tempInrMap).add(str);
            }
            else
            {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(str);
                hMapL.put(tempInrMap,tempList);
            }
        }
        // Stores the result in a arraylist
        ArrayList<ArrayList<String> > result = new ArrayList<>();

        for (Map.Entry<HashMap<Character,Integer>,ArrayList<String>> ent: hMapL.entrySet())
        {
            HashMap<Character,Integer> tempInMap = ent.getKey();
            result.add(hMapL.get(tempInMap));
        }
        return result;
    }
}

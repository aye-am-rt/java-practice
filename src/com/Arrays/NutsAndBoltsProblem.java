package com.Arrays;

import java.util.HashMap;

/**Nuts & Bolts Problem (Lock & Key problem) | Set 2 (Hashmap)
Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one
 mapping between nuts and bolts. Match nuts and bolts efficiently.
Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means
 nut can only be compared with bolt and bolt can only be compared with nut to see which one is
 bigger/smaller.

Examples:

Input : nuts[] = {'@', '#', '$', '%', '^', '&'}
bolts[] = {'$', '%', '&', '^', '@', '#'}
Output : Matched nuts and bolts are-
$ % & ^ @ #
$ % & ^ @ #

 We have discussed a sorting based solution in below post.
 Nuts & Bolts Problem (Lock & Key problem) | Set 1

 In this post, hashmap based approach is discussed.
 Traverse the nuts array and create a hashmap
 Traverse the bolts array and search for it in hashmap.
 If it is found in the hashmap of nuts than this means bolts exist for that nut.
 */

public class NutsAndBoltsProblem {
    public static void main(String[] args)
    {
        char[] nuts = {'@', '#', '$', '%', '^', '&'};
        char[] bolts = {'$', '%', '&', '^', '@', '#'};
        int n = nuts.length;
        NutBoltMatchHashMap(nuts, bolts, n);
    }

    private static void NutBoltMatchHashMap(char[] nuts, char[] bolts, int ln) {
        HashMap<Character,Integer> hMap= new HashMap<>();

        // creating a hashmap for nuts
        for (int i = 0; i < ln; i++) {
            hMap.put(nuts[i],hMap.getOrDefault(nuts[i],0)+1);
        }
        // searching for nuts for each bolt in hash map
        for (int i = 0; i < ln; i++) {
            if(hMap.containsKey(bolts[i]))
            {
                nuts[i]=bolts[i];
            }
        }
        // print the result
        System.out.println("matched nuts and bolts are- ");
        for (int i = 0; i <ln; i++) {
            System.out.print(nuts[i]+"  ");
        }
        System.out.println();
        for (int i = 0; i <ln; i++) {
            System.out.print(bolts[i]+"  ");
        }
    }



}

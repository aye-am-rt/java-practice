package com.Arrays.SortingFs;

/*Given an integer array, sort the array according to the frequency of elements in
decreasing order, if frequency of two elements are same then sort in increasing order

        Examples:
        Input: arr[] = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}
        Output: 3 3 3 3 2 2 2 12 12 4 5

        Approach:

Java Map has been used in this set to solve the problem. The java.util.Map interface represents
a mapping between a key and a value. The Map interface is not a subtype of the Collection interface.
Therefore it behaves a bit different from the rest of the collection types.

map-interface In the below program:

Get the element with its count in a Map
By using the Comparator Interface, compare the frequency of an elements in a given list.
Use this comparator to sort the list by implementing Collections.sort() method.
Print the sorted list.

  */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

// Time Complexity : O(n Log n)
public class SortByFreqJMap {
    public static void main(String[] args) {
        int[] array = {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};
        HashMap<Integer,Integer> map1=new HashMap<>();
        ArrayList<Integer> outputArray = new ArrayList<>();
        for (int curr:array) {
            int count=map1.getOrDefault(curr,0);
            map1.put(curr,count+1);
            outputArray.add(curr);
        }
        SortComparator comp=new SortComparator(map1);
        Collections.sort(outputArray,comp);
        for (Integer i : outputArray) {
            System.out.print(i + " ");
        }
    }
}
/**    Map is an interface, i.e. an abstract "thing" that defines how something can be used.
* HashMap is an implementation of that interface.
Map<K,V> is an interface, HashMap<K,V> is a class that implements Map.
you can do
Map<Key,Value> map = new HashMap<Key,Value>();*/


class SortComparator implements Comparator<Integer>
{
    private final HashMap<Integer, Integer> freqMap;

    SortComparator(HashMap<Integer, Integer> freqMap) {
        this.freqMap = freqMap;
    }

    @Override
    public int compare(Integer k1, Integer k2) {
        int freqCompare=freqMap.get(k2).compareTo(freqMap.get(k1));
        int valueCompare=k1.compareTo(k2);
        if(freqCompare==0)
            return valueCompare;
        else
            return freqCompare;
    }
}


/*
It’s strange thinking about the “utility” of the modulo operator — it’s like someone asking why
exponents are useful. In everyday life, not very, but it’s a tool to understand patterns in the
world, and create your own.

        In general, I see a few general use cases:

        Range reducer: take an input, mod N, and you have a number from 0 to N-1.
        Group assigner: take an input, mod N, and you have it tagged as a group from 0 to N-1.
            This group can be agreed upon by any number of parties — for example, different servers that
            know N = 20 can agree what group ID=57 belongs to.
        Property deducer: treat numbers according to properties (even, threeven, and so on)
            and work out principles derived at the property level

            We do this intuitively, but it’s nice to give it a name. You have a flight arriving at 3pm.
            It’s getting delayed 14 hours. What time will it land?

            Well, 14 ≡ 2 mod 12. So I think of it as “2 hours and an am/pm switch”,
            so I know it will be “3 + 2 = 5am”.

            This is a bit more involved than a plain modulo operator, but the principle is the same.

            In programming, taking the modulo is how you can fit items into a hash table:
            if your table has N entries, convert the item key to a number, do mod N, and put the item
            in that bucket (perhaps keeping a linked list there). As your hash table grows in size,
            you can recompute the modulo for the keys.

            */

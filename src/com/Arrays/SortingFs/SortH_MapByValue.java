package com.Arrays.SortingFs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortH_MapByValue {

    public static void main(String[] args) {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(5, "A");
        hmap.put(11, "C");
        hmap.put(4, "Z");
        hmap.put(77, "Y");
        hmap.put(9, "P");
        hmap.put(66, "Q");
        hmap.put(0, "R");
        System.out.println("Before Sorting:");
        Set<Map.Entry<Integer, String>> set = hmap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, String> me = iterator.next();
            System.out.print(me.getKey() + ":");
            System.out.print(me.getValue()+" , ");
        }
        // *************************************** //
        Map<Integer, String> map = sortByValues(hmap);


        System.out.println("\nAfter Sorting:");
        Set<Map.Entry<Integer, String>> set2 = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry<Integer, String> me2 = iterator2.next();
            System.out.print(me2.getKey() + ":");
            System.out.print(me2.getValue()+" , ");
        }
    }

    private static HashMap<Integer, String> sortByValues(HashMap<Integer, String> map) {
        List<Map.Entry<Integer, String>> list = new LinkedList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue()); // java 11 works here better

/**    // Defined Custom Comparator here // this is old and messy way of doing new one is just above
            Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

 */

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, String> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}

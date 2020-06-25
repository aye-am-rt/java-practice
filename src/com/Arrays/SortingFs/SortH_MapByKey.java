package com.Arrays.SortingFs;

import java.util.*;

public class SortH_MapByKey {
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
        hmap.forEach((K,V)-> System.out.print(K+":"+V+" , "));

        Map<Integer, String> map = new TreeMap<>(hmap);
        System.out.println("\nAfter Sorting:");

        Set<Map.Entry<Integer, String>> set2 = map.entrySet();

        for (Map.Entry<Integer, String> me2 : set2) {
            System.out.print(me2.getKey() + ":");
            System.out.print(me2.getValue()+" , ");
        }
    }
}

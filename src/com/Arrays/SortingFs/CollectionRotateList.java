package com.Arrays.SortingFs;
//
//java.util.Collections.rotate() method is present in java.util.Collections class. It is used to rotate
// the elements present in the specified list of Collection by a given distance.
//        Syntax:
//public static void rotate(List< type > list, int distance)
//        Parameters :
//        list - the list to be rotated.
//        distance - the distance to rotate the list.
//        type - Type of list to be rotated. Examples of
//        types are Integer, String, etc.
//        Returns :
//        NA
//        Throws:
//        UnsupportedOperationException - if the specified list or
//        its list-iterator does not support the set operation.
//        There are no constraints on distance value. It may be zero, negative, or greater than
//        list.size(). After calling this method, the element at index i will be the element previously
//        at index (i – distance) mod list.size(), for all values of i between 0 and list.size()-1,
//        inclusive.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionRotateList {
    public static void main(String[] args)
    {
        // Let us create a list of strings
        List<String> myList = new ArrayList<String>();
        myList.add("practice");
        myList.add("code");
        myList.add("quiz");
        myList.add("geeksforgeeks");

        System.out.println("Original List : " + myList);

        // Here we are using rotate() method
        // to rotate the element by distance 2
        Collections.rotate(myList, 2);

        System.out.println("Rotated List: " + myList);
// ===============================================================================================
//        Arrays class in Java doesn’t have rotate method. We can use Collections.rotate() to quickly
//        rotate an array also. Let us create an array of integers
        Integer[] arr = {10, 20, 30, 40, 50};

        System.out.println("Original Array : " + Arrays.toString(arr));

        // Please refer below post for details of asList()
        // https://www.geeksforgeeks.org/array-class-in-java/
        // rotating an array by distance 2
        Collections.rotate(Arrays.asList(arr), 2);

        System.out.println("Modified Array : " + Arrays.toString(arr));
    }
}

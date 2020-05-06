package com.Arrays.practiceTab1;
/*
Median of sliding window in an array
Given an array of integer arr[] and an integer k, the task is to find the median of each window of
size k starting from the left and moving towards the right by one position each time.
Examples:
Input: arr[] = {-1, 5, 13, 8, 2, 3, 3, 1}, k = 3
Output: 5 8 8 3 3 3
Input: arr[] = {-1, 5, 13, 8, 2, 3, 3, 1}, k = 4
Output: 6.5 6.5 5.5 3.0 2.5*/

import javafx.util.Pair;

import java.util.Arrays;
import java.util.TreeSet;

/**
Approach: Create a pair class to hold the items and their index. It also implements the comparable
 interface so that compareTo() method will be invoked by the Treeset to find the nodes. Note that
 the two pairs are equal only when their indices are equal. This is important since a window can
 contain duplicates and we may end up deleting multiple items in single remove() call if we
 only check for the value.

        The idea is to maintain two sorted sets (minSet and maxSet) of Pair objects of length
 (k / 2) and (k / 2) + 1 depending on whether k is even or odd, minSet will always contain the first
 set of numbers (smaller) of window k and maxSet will contain the second set of numbers (larger).

        As we move our window, we will remove elements from either of the sets (log n) and
 add a new element (log n) maintaining the minSet and maxSet rule specified above.*/

public class MedianOfSlidingWindow {
    public static void main(String[] args)
    {
        int[] arr = new int[] { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        int k = 3;
        findMedianOfAllWindows(arr, k);
    }
    static class Pair implements Comparable<Pair>
    {
        private int value,index;
        public Pair(int v, int i)
        {
            this.value=v; this.index=i;
        }

        @Override
        public int compareTo(Pair pairObject) {
            if(index==pairObject.index)
                return 0;
            else if(value==pairObject.value)
                return Integer.compare(index,pairObject.index);
            else
                return Integer.compare(value,pairObject.value);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
        public void renew(int v, int p)
        {
            value = v;
            index = p;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }

    private static void findMedianOfAllWindows(int[] arr, int k) {
        TreeSet<Pair> minSet=new TreeSet<>();
        TreeSet<Pair> maxSet=new TreeSet<>();

        // To hold the pairs, we will keep renewing these instead of creating the new pairs
        Pair[] windowPairs = new Pair[k];
        for (int i = 0; i < k; i++) {
            windowPairs[i]=new Pair(arr[i],i); // value and index in constructor
        }
        //TreeSet<Pair> maxSet = new TreeSet<>(Arrays.asList(windowPairs).subList(0, (k / 2)));
        for (int i = 0; i < (k / 2); i++) {
            maxSet.add(windowPairs[i]);
        }
        for (int i = (k/2); i < k; i++)
        {
            // Below logic is to maintain the maxSet and the minSet criteria
            if(arr[i]<maxSet.first().getValue())
                minSet.add(windowPairs[i]);
            else {
                minSet.add(maxSet.pollFirst());
                maxSet.add(windowPairs[i]);
            }
        }
        printMedian(minSet, maxSet, k);
        for (int i = k; i < arr.length; i++) {
            // Get the pair at the start of the window, this will reset to 0 at every k, 2k, 3k, ...
            Pair temp= windowPairs[i%k];
            if(temp.getValue()<=minSet.last().getValue())
            {
                minSet.remove(temp); // // Remove the starting pair of the window
                temp.renew(arr[i],i); // // Renew window start to new window end
                if (temp.getValue() < maxSet.first().getValue()) {
                    minSet.add(temp);
                }
                else {
                    minSet.add(maxSet.pollFirst());
                    maxSet.add(temp);
                }
            }
            else
            {
                maxSet.remove(temp);
                temp.renew(arr[i],i);
                if(temp.getValue()>minSet.last().getValue())
                    maxSet.add(temp);
                else
                {
                    maxSet.add(minSet.pollLast());
                    minSet.add(temp);
                }
            }
            printMedian(minSet, maxSet, k);
        }
    }

    private static void printMedian(TreeSet<Pair> minSet, TreeSet<Pair> maxSet, int window) {
        // If the window size is even then the
        // median will be the average of the
        // two middle elements
        if (window % 2 == 0) {
            System.out.print((minSet.last().getValue() + maxSet.first().getValue()) / 2.0);
        }
        // Else it will be the middle element
        else {
            System.out.print(minSet.size() > maxSet.size() ?
                    minSet.last().getValue() : maxSet.first().getValue());
        }
        System.out.print(" ");
    }
}

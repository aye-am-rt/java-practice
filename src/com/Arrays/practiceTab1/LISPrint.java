package com.Arrays.practiceTab1;

/*
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
of a given sequence such that all elements of the subsequence are sorted in increasing order.
 For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80}
is 6 and LIS is {10, 22, 33, 50, 60, 80}.

Let arr[0..n-1] be the input array. We define vector L such that L[i] is itself is a vector
that stores LIS of arr that ends with arr[i].For example, for array [3, 2, 6, 4, 5, 1],
L[0]: 3
L[1]: 2
L[2]: 2 6
L[3]: 2 4
L[4]: 2 4 5
L[5]: 1

Therefore for an index i, L[i] can be recursively written as –

L[0] = {arr[O]}
L[i] = {Max(L[j])} + arr[i]
where j < i and arr[j] < arr[i] and if there is no such j then L[i] = arr[i]
*/

import java.util.ArrayList;
import java.util.Iterator;

public class LISPrint {
    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
//        int array[] = {10, 2, 9, 3, 5, 4, 6, 8};
//        int[] array = {10, 9, 8, 6, 5, 4};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> longestList = new ArrayList<>();
        int currentMax;
        int highestCount = 0;
        for(int i = 0; i < array.length;i++)
        {
            currentMax = Integer.MIN_VALUE;
            for(int j = i; j < array.length; j++)
            {
                if(array[j] > currentMax)
                {
                    list.add(array[j]);
                    currentMax = array[j];
                }
            }

            //Compare previous highest subsequence
            if(highestCount < list.size())
            {
                highestCount = list.size();
                longestList = new ArrayList<>(list);
            }
            list.clear();
        }
        //System.out.println();

        //Print list
        Iterator<Integer> itr = longestList.iterator();
        System.out.println("The Longest subsequence");
        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("Length of LIS: " + highestCount);
    }
}

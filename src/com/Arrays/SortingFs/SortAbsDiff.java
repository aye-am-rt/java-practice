package com.Arrays.SortingFs;
//Sort an array according to absolute difference with given value
//        Given an array of n distinct elements and a number x, arrange array elements according to the
//        absolute difference with x, i. e., element having minimum difference comes first and so on.
//        Note : If two or more elements are at equal distance arrange them in same sequence as in the
//        given array.
//
//        Examples :
//
//        Input : arr[] : x = 7, arr[] = {10, 5, 3, 9, 2}
//        Output : arr[] = {5, 9, 10, 3, 2}

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortAbsDiff {
    public static void main(String[] args)
    {
        int[] arr = {10, 5, 3, 9 ,2};
        int n = arr.length;
        int x = 7;
        SortByAbsDifference(arr, n, x);
        System.out.println(Arrays.toString(arr));
        /***************** testing binary search built in java below ***********************/
        int[] bsAr={12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int[] myIntArray={10, -20, 30, -40, 50};
        ArrayList<Integer> IntegerListFromIntArray =
                Arrays.stream(bsAr).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> list = IntStream.of(myIntArray)
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        int ind=Collections.binarySearch(IntegerListFromIntArray,42);
        if(ind>=0 && ind<bsAr.length)
        { System.out.println("binary search index of 42 == " + ind); }
        else
        { System.out.println("element is not present in array "); }
/**        If key is not present, the it returns "(-(insertion point) - 1)".
            The insertion point is defined as the point at which the key
            would be inserted into the list. */

        int ind2=Collections.binarySearch(list,-20,Collections.reverseOrder());
        // The last parameter specifies the comparator method used for sorting.
        // without Collections.reverseOrder() it returns -1 which is index of actual -20.
        System.out.println(list);
        if(ind2<myIntArray.length)
        { System.out.println("binary search index of -20 == " + ind2); }
        else
        { System.out.println("element is not present in array "); }
    }

    private static void SortByAbsDifference(int[] arr, int n, int x) {
        if(n<=0)
            throw new IllegalArgumentException();
        if(x==0)
        {
            Arrays.sort(arr);
            return;
        }
        //HashMap<Integer,Integer> hm=new HashMap<>();
        TreeMap<Integer, ArrayList<Integer>> tMap=new TreeMap<>();
        // tree map keeps them sorted keys , nlogn time .
        for (int i = 0; i < n; i++) {
            int DiffsKey=Math.abs(x-arr[i]);
            if(tMap.containsKey(DiffsKey))
            {
                ArrayList<Integer> Values=tMap.get(DiffsKey);
                Values.add(arr[i]);
                tMap.put(DiffsKey,Values);
            }
            else
            {
                ArrayList<Integer> Values=new ArrayList<>();
                Values.add(arr[i]);
                tMap.put(DiffsKey,Values);
            }
        }
        //Iterator TmIterator=tMap.entrySet().iterator();
        int index=0;
        for(Map.Entry ent:tMap.entrySet())
        {
            ArrayList<Integer> al=tMap.get(ent.getKey());
            for (Integer integer : al) {
                arr[index++] = integer;
            }
        }

    }
}



package com.Arrays.GST;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class SecondSmallest {
    public static void main (String[] args)
    {
        int[] arr = {-1,-23,-1,2, 2, 1, 10, 34, 1};
        int[] allSingles={1,2,3,40,-1,-3};
        int[] onlyOnes={5};
        int[] oneTypes={2,2,2,2,2};
        print2Smallest(allSingles);
    }

    private static void print2Smallest(int[] arr) {
        if(arr.length<1) {
            System.out.println("invalid array ");
            throw new IllegalArgumentException();
        }
        if(arr.length<2) {
            System.out.println("only one element in array ");
            System.out.println(arr[0]);
            return;
        }
        int smallest=Integer.MAX_VALUE;
        int secSmallest=Integer.MAX_VALUE;
        for (int value : arr) {
            if (value < smallest) {
                secSmallest = smallest;
                smallest = value;
            } else if (value < secSmallest && value != smallest) {
                secSmallest = value;
            }
        }
        if(secSmallest==Integer.MAX_VALUE)
            System.out.println("No sec smallest element");
        else
            System.out.println("smallest = "+smallest+" secSmallest= "+secSmallest);


        HashSet<Integer> hs=new HashSet<>();
        TreeSet<Integer> ts=new TreeSet<>();
        for (int value : arr) {
            hs.add(value);
            ts.add(value);
        }
        Object[] secArray=hs.toArray();
        Arrays.sort(secArray);

        Integer[] intArr= ts.toArray(new Integer[0]);
        if(secArray.length==1 || intArr.length==1) {
            System.out.println("set 0 element single type present= " + (Integer)secArray[0]);
            System.out.println("tree set auto sorted 0 index element single type present = " + intArr[0]);
        }
        else
        {
            System.out.println("set 1 element = " + (Integer) secArray[1]);
            System.out.println("tree set auto sorted 1 index element = " + intArr[1]);
        }

        Arrays.sort(arr);  // nLog(n) timing
        for(int i=0;i<arr.length-1;i++)
        {
           if(arr[i]!=arr[i+1])
           {
               System.out.println("sec smallest sorting then discontinuity found = "+arr[i+1]);
               break;
           }
        }
    }
}

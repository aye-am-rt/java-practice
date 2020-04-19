package com.Arrays.GST;

import java.util.HashSet;

public class FirstRepeatingElemFind {
    public static void main(String[] args)
    {
        int[] arr = {-1,-23,-1,2, 2, 1, 10, 34, 1};
        int[] allSingles={1,2,3,40,-1,-3};
        int[] onlyOnce={5};
        int[] oneTypes={2,2,2,2,2};
        int[] OneToN={9,8,7,7,6,1,2,3,4};
        int[] OneToN2={9,8,2,2,6,1,7,7,4};
        int[] OneToN3={9,8,7,2,6,1,2,2,4};
        int[] NoRepeat={3,4,2,1,5,16};
        FirstRepeatingElem(OneToN2);
    }

    private static void FirstRepeatingElem(int[] arr) {
        if(arr.length<1) {
            System.out.println("invalid array ");
            throw new IllegalArgumentException();
        }
        if(arr.length<2) {
            System.out.println("only one element in array ");
            System.out.println(arr[0]);
            return;
        }
        int FirstRepElemIndex=-1;
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i = 0; i <arr.length ; i++) {
            if(hashSet.contains(arr[i]))  // or if(! hashSet.add(arr[i])){return arr[i];} also works
            {
                FirstRepElemIndex=i;
                break; // if you don't want to use break, then if you are using hashSet or linked_hash_set
                // the final value of i which is last repeating element will be printed.
                // so break is necessary to stop as soon as you find the first repeating element.

                // tree set also wont work because though its sorting elements but eventually it will be
                // replaced by last repeating element. because we are using contains() to check.
            }
            else
                hashSet.add(arr[i]);
        }
        if(FirstRepElemIndex!=-1)
            System.out.println("first rep element = "+arr[FirstRepElemIndex]);
        else
            System.out.println(" no repeating element present ");

    }
}

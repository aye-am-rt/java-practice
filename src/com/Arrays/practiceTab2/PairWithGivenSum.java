package com.Arrays.practiceTab2;
//
//Given a list of positive integers nums and an int target, return indices of the two numbers such that
// they add up to a target - 30.
//        Conditions:
//        You will pick exactly 2 numbers.
//        You cannot pick the same element twice.
//        If you have multiple pairs, select the pair with the largest number.

import java.util.LinkedHashMap;

public class PairWithGivenSum {
    public static void main(String[] args)
    {
        int[] arr={20,50,40,25,30,10};
        int target=90;
        PrintPairWithBestSum(arr,target,arr.length);
    }

    private static void PrintPairWithBestSum(int[] arr, int target, int length) {
        if(length<2)
            return;
        LinkedHashMap<Integer,Integer> lhm=new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            lhm.put(arr[i],i);
        }
        int fNum=-10;
        int sNum=-20;
        for (int i = 0; i < length; i++) {
            if(lhm.containsKey(target-30-arr[i]))
            {
                if(arr[i]>fNum && arr[i]>sNum) {
                    fNum = arr[i];
                    int secIndex = lhm.get(target - 30 - arr[i]);
                    sNum = arr[secIndex];
                }
            }
        }
        System.out.println("best pair which is equal to target-30 = "+(target-30)+" are ==");
        System.out.println("firstNum = "+fNum+ " secNum = "+sNum);
        System.out.println("indices are = "+lhm.get(fNum)+ " and "+lhm.get(sNum));
    }

}

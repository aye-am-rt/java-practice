package com.Arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/**Find the length of largest subarray with 0 sum
        Given an array of integers, find the length of the longest sub-array with sum equals to 0.
        Examples :

        Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        Output: 5
        Explanation: The longest sub-array with
        elements summing up-to 0 is {-2, 2, -8, 1, 7}

        Input: arr[] = {1, 2, 3}
        Output: 0
        Explanation:There is no subarray with 0 sum

        Input:  arr[] = {1, 0, 3}
        Output:  1
        Explanation: The longest sub-array with
        elements summing up-to 0 is {0}*/

public class Largest0SumSubA {
    public static void main(String arg[])
    {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("Length of the longest 0 sum sub array is " + maxLenZeroSumArray(arr));
    }

    private static int maxLenZeroSumArray(int[] arr) {
        if(arr.length<1)
            return -1;
        if(arr.length==1 && arr[0]==0)
            return 1;
        LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<Integer, Integer>
                (16,0.75f,true)
        {
            protected boolean removeOldestEntry(Map.Entry eldest )
            { return size()>16; }
        };
        int sum=0;
        int maxLength=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum==0)
                maxLength+=i+1;
            if(hm.get(sum)!=null)
                maxLength=Math.max(maxLength,i-hm.get(sum));
            else
                hm.put(sum,i);
        }
        return maxLength;
    }
}

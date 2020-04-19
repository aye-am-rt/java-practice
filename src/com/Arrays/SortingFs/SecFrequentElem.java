package com.Arrays.SortingFs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class SecFrequentElem {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       // int sum = Integer.parseInt(br.readLine().strip());
//        System.out.print("give space separated integers for array 1 = ");
//        int[] arr1 = Arrays.stream(br.readLine().strip().split("\\s"))
//                .mapToInt(Integer::parseInt).toArray();
        int[] arr2={4,4,4,9,-1,2,2,2,2,2,-3,-3,5,5,5,5};
        System.out.println("second freq occurring element = "+SecondMaxFrequency(arr2,arr2.length));
    }

    private static int SecondMaxFrequency(int[] arr, int n) {
        if(n<=0)
            return -11;
        if(n==1)
            return arr[0];
        LinkedHashMap<Integer,Integer> freqHashMap=new LinkedHashMap<>(n);
        int FirstMaxFreqElem=arr[0];
        int SecMaxFreq=arr[0];
        int HighestFreqCount=0;
        int currMinDiff=20000;
        for (int i = 0; i < n; i++)
                freqHashMap.put(arr[i],freqHashMap.getOrDefault(arr[i],0)+1);
        for (int i = 0; i < n; i++) {
            if (freqHashMap.get(arr[i]) > freqHashMap.get(FirstMaxFreqElem))
            {
                FirstMaxFreqElem = arr[i];
                HighestFreqCount=freqHashMap.get(FirstMaxFreqElem);
            }
        }
        System.out.println(freqHashMap);
        System.out.println("first max freq elem = "+FirstMaxFreqElem+" and its freq= "+
                freqHashMap.get(FirstMaxFreqElem));
        System.out.println("highest freq count = "+HighestFreqCount);
        for (int i = 0; i < n; i++) {
            int currDiff= HighestFreqCount-freqHashMap.get(arr[i]);
            if (currDiff < currMinDiff && currDiff !=0 ) {
                SecMaxFreq= arr[i];
                currMinDiff = currDiff;
            }
        }
        return SecMaxFreq;
    }
}

/*
System.out.println("freq h m = "+freqHashMap);
System.out.println(Arrays.toString(arr));
System.out.println("fmfe= "+FirstMaxFreqElem+" its count= "+HighestFreqCount);*/

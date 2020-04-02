package com.practiceTab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
All of the above approaches work in O(n Log n) time where n is total number of elements.
In this post, a new approach is discussed that works in O(n + m Log m) time where n is total number of
elements and m is total number of distinct elements.

        The idea is to use hashing.

        We insert all elements and their counts into a hash. This step takes O(n) time where
        n is number of elements.
        We copy contents of hash to an array (or vector) and sort them by counts.
        This step takes O(m Log m) time where m is total number of distinct elements.
        For maintaining the order of elements if the frequency is same, we use another hash which
        has the key as elements of the array and value as the index. If the frequency is same for
        two elements then sort elements according to the index.
*/
public class SortByFreqHash {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] arr= Arrays.stream(br.readLine().strip().split("\\s")).mapToInt(Integer::parseInt).toArray();
        // int findSum=Integer.parseInt(br.readLine().strip());
        System.out.println("sorted by frequency decreasing " +SortByFreq(arr, arr.length));
    }

    private static StringBuffer SortByFreq(int[] arr, int ln) {
        Map<Integer,Integer> countMap=getCountMap(arr,ln);
        StringBuffer result=new StringBuffer();
        countMap.entrySet().stream().sorted(Map.Entry.<Integer,Integer> comparingByValue().reversed())
                .forEach(e->{int key=e.getKey();int val=e.getValue();
                    for (int i = 0; i < val; i++) {
                        result.append(key+" ");
                    }});
        return result;
    }

    private static Map<Integer, Integer> getCountMap(int[] arr2, int ln2) {
        Map<Integer,Integer> counterMap=new LinkedHashMap<>();
        for (int i = 0; i < ln2; i++) {
            if(counterMap.containsKey(arr2[i]))
            {
                counterMap.put(arr2[i],counterMap.get(arr2[i])+1);
            }
            else
            {
                counterMap.put(arr2[i],1);
            }
        }
        return counterMap;
    }

}
//    Time Complexity : O(n) + O(m Log m) where n is total number of elements and m is total
//    number of distinct elements
package com.Arrays.SortingFs;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //int[] arr= Arrays.stream(br.readLine().strip().split("\\s"))
        //                                          .mapToInt(Integer::parseInt).toArray();
        // int findSum=Integer.parseInt(br.readLine().strip());
        int[] arr = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        System.out.println("sorted by frequency decreasing " +SortByFreq(arr, arr.length));
    }

    private static StringBuffer SortByFreq(int[] arr, int ln) {
        Map<Integer,Integer> countMap =getCountMapMyFunction(arr,ln);

        StringBuffer resultBuffer=new StringBuffer();

        countMap.entrySet().stream().sorted(Map.Entry.<Integer,Integer> comparingByValue().reversed())
                .forEach(e->{int key=e.getKey();int val=e.getValue();
                    resultBuffer.append((key + " ").repeat(Math.max(0, val)));
                });

        int[] ansArray= Arrays.stream(resultBuffer.toString().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> lhsInts=new LinkedHashSet<>();

        for (int val : ansArray) {
            lhsInts.add(val);
        }
        System.out.println("linked hash set = "+lhsInts);
        System.out.println("ans as integer array = "+Arrays.toString(ansArray));
        return resultBuffer;
    }

/** output of program =======
 *  linked hash set = [3, 2, 12, 4, 5]
    ans as integer array = [3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5]
    sorted by frequency decreasing 3 3 3 3 2 2 2 12 12 4 5   */

    private static Map<Integer, Integer> getCountMapMyFunction(int[] arr2, int ln2) {
        Map<Integer,Integer> counterMap=new LinkedHashMap<>();
        for (int i = 0; i < ln2; i++) {
            if(counterMap.containsKey(arr2[i]))
            { counterMap.put(arr2[i],counterMap.get(arr2[i])+1); }
            else
            { counterMap.put(arr2[i],1); }
        }
        return counterMap;
    }

}
//    Time Complexity : O(n) + O(m Log m) where n is total number of elements and m is total
//    number of distinct elements
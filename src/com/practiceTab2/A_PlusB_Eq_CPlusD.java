package com.practiceTab2;

import java.util.HashMap;

/**An Efficient Solution can solve this problem in O(n2) time. The idea is to use hashing.
 *  We use sum as key
 * and pair as value in hash table.

Loop i = 0 to n-1 :
Loop j = i + 1 to n-1 :
calculate sum
If in hash table any index already exist
Then print (i, j) and previous pair
from hash table
Else update hash table
EndLoop;
EndLoop;
Below are implementations of above idea. In below implementation, map is used instead of hash.
 Time complexity of map insert and search is actually O(Log n) instead of O(1). So below implementation
 is O(n2 Log n).*/

public class A_PlusB_Eq_CPlusD {
    // Class to represent a pair
    static class pair
    {
        int first, second;
        pair(int f,int s)
        {
            first = f; second = s;
        }

        @Override
        public String toString() {
            return "("+first+","+second+")";
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        find2PairsSumEqual(arr);
    }

    private static void find2PairsSumEqual(int[] arr) {
        int ln = arr.length;

        if(ln<4)
            throw new IllegalArgumentException();

        // Create an empty Hash to store mapping from sum to pair indexes
        HashMap<Integer, pair> sumPairMap= new HashMap<>();
        //Pair<Integer,Integer> p = new Pair<>();

        for (int i = 0; i < ln; i++) {
            for (int j = (i+1); j < ln - 1; j++)
            {
                // If sum of current pair is not in hash, then store it and continue to next pair
                int currSum = arr[i]+arr[j];
                if(!sumPairMap.containsKey(currSum))
                {
                    sumPairMap.put(currSum, new pair(i, j));
                }
                else
                {
                    pair p = sumPairMap.get(currSum);
                    // Since array elements are distinct, we don't need to check if any element is common
                    // among pairs
                    System.out.println("("+arr[p.first]+", "+arr[p.second]+ ") and ("+arr[i]+", "+arr[j]+")");
                    //return true;
                }
            }
        }
        System.out.println("hashmap sum and respective index in array Not elements ");
        System.out.println(sumPairMap);
        //return false;
    }
}

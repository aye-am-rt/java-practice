package com.Arrays.AmazonSubArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Print all subarrays with 0 sum
 * Given an array, print all subarrays in the array which has sum 0.
 * Examples:
 * Input:  arr = [6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7]
 * Output:
 * Subarray found from Index 2 to 4
 * Subarray found from Index 2 to 6
 * Subarray found from Index 5 to 6
 * Subarray found from Index 6 to 9
 * Subarray found from Index 0 to 10
 *
 * A better approach is to use Hashing.
Do following for each element in the array

Maintain sum of elements encountered so far in a variable (say sum).
If current sum is 0, we found a sub-array starting from index 0 and ending at index current index
Check if current sum exists in the hash table or not.
If current sum already exists in the hash table then it indicates that this sum was the sum of
 some sub-array elements arr[0]…arr[i] and now the same sum is obtained for the current sub-array
 arr[0]…arr[j] which means that the sum of the sub-array arr[i+1]…arr[j] must be 0.
Insert current sum into the hash table*/

public class PrintAllSubAs0Sum {
    static class myPair
    {
        int first,second;
        public myPair(int first, int second)
        {
            this.first=first;
            this.second=second;
        }

        @Override
        public String toString() {
            return "( "+first+","+second+" )";
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int n = arr.length;
        ArrayList<myPair> outAL = findSubArrays(arr, n);
        // if we did not find any sub-array with 0 sum, then sub-array does not exists
        if (outAL.isEmpty())
            System.out.println("No sub-array exists");
        else {
            //System.out.println(Arrays.toString(outAL.toArray()));
            //System.out.println(outAL);
            //System.out.println(outAL.toString());
            outAL.forEach(aPair -> System.out.println("subArray of 0 sum Exists from index = "+aPair.first+
                    " and ending at index = "+aPair.second));
        }
    }

    private static ArrayList<myPair> findSubArrays(int[] arr, int ln) {
        if(ln<2)
            throw new IllegalArgumentException();
        HashMap<Integer,ArrayList<Integer>> hMap = new HashMap<>();

        // create an empty vector of pairs to store sub array starting and ending index
        ArrayList<myPair> outList = new ArrayList<>();
        int sum=0;
        for (int i = 0; i < ln; i++) {
            sum+=arr[i];

            // if sum is 0, we found a sub-array starting from index 0 and ending at index i
            if(sum==0)
            {
                outList.add(new myPair(0,i));
            }
            ArrayList<Integer> al =new ArrayList<>();
            // If sum already exists in the map there exists at-least one sub-array ending at
            // index i with 0 sum
            if(hMap.containsKey(sum))
            {
                // map[sum] stores starting index of all sub-arrays
                al = hMap.get(sum);
                for (Integer integer : al) {
                    outList.add(new myPair(integer + 1, i));
                }
            }
            al.add(i);
            hMap.put(sum,al);
        }
        return outList;
    }
}

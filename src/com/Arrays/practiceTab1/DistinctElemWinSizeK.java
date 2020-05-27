package com.Arrays.practiceTab1;

import java.util.HashMap;

/**
Efficient Approach: So, there is an efficient solution using hashing, though hashing requires extra
 O(n) space but the time complexity will improve. The trick is to use the count of the previous
 window while sliding the window. To do this a hash map can be used that stores elements of the
 current window. The hash-map is also operated on by simultaneous addition and removal of an
 element while keeping track of distinct elements. The problem deals with finding the count of
 distinct elements in a window of length k, at any step while shifting the window and discarding all
 the computation done in the previous step, even though k – 1 elements are same from the previous
 adjacent window. For example, assume that elements from index i to i + k – 1 are stored in a Hash
 Map as an element-frequency pair. So, while updating the Hash Map in range i + 1 to i + k,
 reduce the frequency of the i-th element by 1 and increase the frequency of (i + k)-th element
 by 1.
Insertion and deletion from the HashMap takes constant time.

Algorithm:
Create an empty hash map. Let the hash map be hM.
Initialize the count of distinct element as dist_count to 0.
Traverse through the first window and insert elements of the first window to hM. The elements are used
 as key and their counts as the value in hM. Also, keep updating dist_count
Print distinct count for the first window.
Traverse through the remaining array (or other windows).
Remove the first element of the previous window.
If the removed element appeared only once, remove it from hM and decrease the distinct count,i.e.
 do “dist_count–“
else (appeared multiple times in hM), then decrement its count in hM
Add the current element (last element of the new window)
If the added element is not present in hM, add it to hM and increase the distinct count,i.e. do
 “dist_count++”
Else (the added element appeared multiple times), increment its count in hM*/

public class DistinctElemWinSizeK {
    public static void main(String[] arg)
    {
        int[] arr =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        countDistinctWinSizeK(arr, k);
    }

    //    Complexity Analysis:
//        Time complexity O(n). As single traversal of the array is required.
//        Space Compelxity O(n). Since, the hashmap requires linear space.

    private static void countDistinctWinSizeK(int[] arr, int k) {
        if(arr.length<k)
            throw new IllegalArgumentException();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int dist_count=0;
        for (int i = 0; i < k; i++) {
            if(!hm.containsKey(arr[i]))
                dist_count++;

            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        // Print count of first window
        System.out.print(dist_count+" ");

        for (int i = k; i < arr.length; i++) {
            // Remove first element of previous window
            // If there was only one occurrence, then
            // reduce distinct count.
            if(hm.get(arr[i-k])==1)
            {
                hm.remove(arr[i-k]);
                dist_count--;
            }
            else// reduce count of the removed element
            {
                hm.put(arr[i-k],hm.get(arr[i-k])-1);
            }
            // Add new element of current window
            // If this element appears first time,
            // increment distinct element count
            if(!hm.containsKey(arr[i]))
            {
                hm.put(arr[i],1);
                dist_count++;
            }
            else
            {
                hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            }
            System.out.print(" "+dist_count+" ");
        }
    }
}
//    Complexity Analysis:
//        Time complexity O(n). As single traversal of the array is required.
//        Space Compelxity O(n). Since, the hashmap requires linear space.

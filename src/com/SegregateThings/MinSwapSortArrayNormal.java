package com.SegregateThings;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

/**This problem is already discussed in the previous article using graph.
 * In this article another approach to solve
 * this problem is discussed which is slightly different from the cycle approach.

The idea is to create a vector of pair in C++ with first element as array values and second
 element as array indices. The next step is to sort the vector of pair according to the first
 element of the pair. After that traverse the vector and check if the index mapped with the value
 is correct or not, if not then keep swapping until the element is placed correctly and keep
 counting the number of swaps.


 Note: The problem is not asking to sort the array by the minimum number of swaps.
 The problem is to find the minimum swaps in which the array can be sorted.
 Examples:
 Input : arr[] = {4, 3, 2, 1}
 Output : 2
 Explanation : Swap index 0 with 3 and 1 with 2 to get the sorted array {1, 2, 3, 4}.*/

public class MinSwapSortArrayNormal {
    public static void main(String[] args)
    {
        int[] arr = {1, 5, 3, 2};
        int[] arr2= {7,6,5,4};
        int[] arr3= {1,2,3,4,5};
        int n=arr.length;
        System.out.print(MinSwapsSortArrayNormal(arr, n));
    }
    // not working stuck in loop waste don't use
    private static int MinSwapsSortArrayNormal(int[] arr, int n) {
        ArrayList<Pair<Integer,Integer>> pairList=new ArrayList<>(n){
            @Override
            public String toString() {
                return super.toString();
            }
        };
        for (int i = 0; i < n; i++) {
            pairList.add(new Pair<>(arr[i],i));
        }
        pairList.sort((p1, p2) -> {
            if (p1.equals(p2))
                return 0;
            else if (p1.getKey() > p2.getKey())
                return 1;
            else
                return -1;
        });
        System.out.println("sorted pair list acc to first Element which is element of array");
        System.out.println(pairList);
//
//        // below this not working stuck in loop waste don't use
//        int ans=0;
//        for (int i = 0; i < n; i++) {
//            if(pairList.get(i).getValue()==i)
//                continue;
//            else
//            {   // not working stuck in loop waste don't use
//                int k1 = pairList.get(i).getKey();
//                int k2= pairList.get(pairList.get(i).getValue()).getKey();
//                int temp=k1;
//                k1=k2;
//                k2=temp;
//                // not working stuck in loop waste don't use
//                int v1 = pairList.get(i).getValue();
//                int v2 = pairList.get(pairList.get(i).getValue()).getValue();
//                temp=v1;
//                v1=v2;
//                v2=temp;
//            }
//            // swap until the correct index matches
//            if(i!=pairList.get(i).getValue())
//                --i;
//            // each swap makes one element move to its correct index, so increment answer
//            ans++;
//        }
//        // not working stuck in loop waste don't use
        return 0;
    }

}

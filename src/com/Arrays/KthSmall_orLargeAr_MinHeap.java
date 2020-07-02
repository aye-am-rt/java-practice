package com.Arrays;
/*
k largest(or smallest) elements in an array | added Min Heap method
        Question: Write an efficient program for printing k largest elements in an array. Elements in
        array can be in any order.
        For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest
        3 elements i.e., k = 3 then your program should print 50, 30 and 23.
        */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**

 Method 3(Use Sorting)
 1) Sort the elements in descending order in O(nLogn)
 2) Print the first k numbers of the sorted array O(k).


Method 6 (Use Min Heap)
This method is mainly an optimization of method 1. Instead of using temp[] array, use Min Heap.

1) Build a Min Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)

2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
……a) If the element is greater than the root then make it root and call heapify for MH
……b) Else ignore it.
// The step 2 is O((n-k)*logk)

3) Finally, MH has k largest elements and root of the MH is the kth largest element.

Time Complexity: O(k + (n-k)Logk) without sorted output. If sorted output is needed then O(k + (n-k)Logk + kLogk)

All of the above methods can also be used to find the kth largest (or smallest) element.*/

public class KthSmall_orLargeAr_MinHeap {
    public static void main(String[] args) {
        int[] arr = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int size = arr.length;
        int k = 3;
        FirstK_ElementsLargest(arr,size,k);
    }

    private static void FirstK_ElementsLargest(int[] arr, int size, int k)
    {
        if(size<1)
            throw new IllegalArgumentException();

        PriorityQueue<Integer> pqI =  new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pqI.offer(arr[i]);
        }

        for (int i = k; i < size; i++)
        {
            if(!pqI.isEmpty() && pqI.peek() < arr[i])
            {
                pqI.remove();
                pqI.offer(arr[i]);
            }
        }
//        System.out.print("priority queue max heap of all elements = ");
//        System.out.println(Arrays.toString(pqI.toArray()));

        while (!pqI.isEmpty())
        {
            System.out.print(pqI.poll()+"  ");
        }

    }
}

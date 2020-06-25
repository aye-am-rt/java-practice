package com.practiceTab2;

import java.util.*;

/**
 Find k closest numbers in an unsorted array
Given an unsorted array and two numbers x and k, find k closest values to x.
Examples:
Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3
Output : 4 6 7
Three closest values of x are 4, 6 and 7.

Time Complexity : O(n Log n)
A better solution is to use Heap Data Structure
1) Make a max heap of differences with first k elements.
2) For every element starting from (k+1)-th element, do following.
…..a) Find difference of current element with x.
…..b) If difference is more than root of heap, ignore current element.
…..c) Else insert the current element to the heap after removing the root.
3) Finally the heap has k closest elements.
*/

public class FindKClosestValues {
    public static void main(String[] args)
    {
        int[] arr={-10,-50,20,17,80};
        int x=20;
        int k=2;
        PrintKClosestValues(arr,x,k,arr.length);
    }
    static class MyALComparator implements Comparator<ArrayList<Integer>> {

        @Override
        public int compare(ArrayList<Integer> al1, ArrayList<Integer> al2) {
            if(al1.isEmpty() && al2.isEmpty())
                return 0;
            if(al1.get(0)>al2.get(0))      // return al1.get(0).compareTo(al2.get(0));
                return 1;
            else if(al1.get(0)<al2.get(0))
                return -1;
            else
                return 0;
        }
    }

    private static void PrintKClosestValues(int[] arr, int x, int k, int length) {
        if(length<=k || k<=0)
        {
            System.out.println("not enough elements in array");
            return;
        }
        PriorityQueue<ArrayList<Integer>> pqAl= new PriorityQueue<>(new MyALComparator());
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> al=new ArrayList<>();
            al.add(0,-Math.abs(arr[i]-x));
            al.add(1,i);
            pqAl.add(al);
        }
        for (int i = k; i < length ; i++) {
            int diff=Math.abs(arr[i]-x);
            int p=pqAl.peek().get(0);
            int pi=pqAl.poll().get(1);
            int curr=-p;
            ArrayList<Integer> al=new ArrayList<>();
            if(diff>curr)
            {
                al.add(0,-curr);
                al.add(1,pi);
            }
            else
            {
                al.add(0,-diff);
                al.add(1,i);
            }
            pqAl.add(al);
        }
        while(! pqAl.isEmpty())
        {
            int q=pqAl.poll().get(1);
            System.out.print(arr[q]+"  ");
        }

    }
}

// to print the whole priority queue in java is we can use .toArray method.
// and to do the same in python we can override __str__ function.
//def __str__(self):
//        return ' '.join([str(i) for i in self.queue])
// or better to use heapq to make heap from list with that you can easily print like
// print(list(myHql))
// heapify(iterable)
// heappush(heap, ele)
// heappop(heap)

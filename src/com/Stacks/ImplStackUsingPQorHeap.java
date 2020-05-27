package com.Stacks;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
How to implement stack using priority queue or heap?
How to Implement stack using a priority queue(using min heap)?.
Asked In: Microsoft, Adobe.

In priority queue, we assign priority to the elements that are being pushed. A stack requires
 elements to be processed in Last in First Out manner. The idea is to associate a count that
 determines when it was pushed. This count works as a key for the priority queue.

So the implementation of stack uses a priority queue of pairs, with the first element serving as
 the key.

pair <int, int> (key, value)

 */

public class ImplStackUsingPQorHeap {
    static class myNumOrdPair
    {
        int firstNum;
        int numsOrder;
        public myNumOrdPair(int n1 , int n2)
        {
            this.firstNum = n1;
            this.numsOrder = n2;
        }

        @Override
        public String toString() {
            return "("+firstNum+","+numsOrder+")";
        }
    }
    static class pairMaxHeapOrdComparator implements Comparator<myNumOrdPair>
    {
        @Override
        public int compare(myNumOrdPair pair1, myNumOrdPair pair2) {
            if(pair1.numsOrder>pair2.numsOrder)
                return -1;
            else if(pair1.numsOrder<pair2.numsOrder)
                return 1;
            else
                return 0;
        }
    }
    static class myStackUsingPQ
    {
        int cnt;
        PriorityQueue<myNumOrdPair> pqSt;

        public myStackUsingPQ() {
            this.cnt = 0;
            this.pqSt = new PriorityQueue<>(new pairMaxHeapOrdComparator());
        }
        public void push(int newNum)
        {
            cnt++;
            pqSt.offer(new myNumOrdPair(newNum,cnt));
        }
        public void pop()
        {
            if(pqSt.isEmpty()) {
                System.out.println(" stack is empty , nothing to pop");
                return;
            }
            cnt--;
            pqSt.poll();
        }
        public int top()
        {
            if(pqSt.isEmpty()) {
                System.out.println(" stack is empty , No element is on top");
                return Integer.MIN_VALUE;
            }
            else
            {
                myNumOrdPair temp = pqSt.peek();
                return temp.firstNum;
            }
        }
        public boolean isEmpty()
        {
            return pqSt.isEmpty();
        }
    }
    public static void main(String[] args) {
        myStackUsingPQ s=new myStackUsingPQ();
        s.push(11);
        s.push(21);
        s.push(31);
        System.out.println("the priority queue after 3 push = ");
        System.out.println(s.pqSt.toString());
        while(!s.isEmpty())
        {
            System.out.println(s.top());
            s.pop();
        }
    }
}

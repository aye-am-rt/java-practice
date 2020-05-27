package com.Stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
Implement a stack using single queue
We are given queue data structure, the task is to implement stack using only given queue data
 structure.
We have discussed a solution that uses two queues. In this article, a new solution is discussed
 that uses only one queue. This solution assumes that we can find size of queue at any point.
 The idea is to keep newly inserted element always at rear of queue, keeping order of previous elements
 same. Below are complete steps.

// x is the element to be pushed and s is stack
push(s, x)
1) Let size of q be s.
1) Enqueue x to q
2) One by one Dequeue s items from queue and enqueue them.
// Removes an item from stack
pop(s)
1) Dequeue an item from q */

public class StackBy1Q {
    static class StackBy1Queue
    {
        Queue<Integer> q = new LinkedList<>();
        public void push(int newVal)
        {
            int size = q.size();
            q.offer(newVal);
            // Pop (or Dequeue) all previous elements and put them after current element
            for (int i = 0; i < size; i++) {
                // this will add front element into rear of queue
                int x = q.remove();
                q.offer(x);
            }
        }
        public int pop()
        {
            if(q.isEmpty())
            {
                System.out.println("no elements");
                return Integer.MIN_VALUE;
            }
            return q.remove();
        }
        public int top()
        {
            if(q.isEmpty())
            {
                System.out.println("no elements");
                return Integer.MIN_VALUE;
            }
            return q.peek();
        }
        public boolean isEmpty()
        {
            return q.isEmpty();
        }
    }
    public static void main(String[] args)
    {
        StackBy1Queue s = new StackBy1Queue();
        s.push(10);
        s.push(20);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.push(30);
        System.out.println("popped top element is= "+s.pop());
        System.out.println("Top element :" + s.top());
    }
}

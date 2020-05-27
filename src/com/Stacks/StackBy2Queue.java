package com.Stacks;

import java.util.LinkedList;
import java.util.Queue;

/**Implement Stack using Queues
The problem is opposite of this post. We are given a Queue data structure that supports standard
 operations like enqueue() and dequeue(). We need to implement a Stack data structure using only
 instances of Queue and queue operations allowed on the instances.

 A stack can be implemented using two queues. Let stack to be implemented be ‘s’ and queues used
 to implement be ‘q1’ and ‘q2’. Stack ‘s’ can be implemented in two ways:

 Method 2 (By making pop operation costly)
 In push operation, the new element is always enqueued to q1. In pop() operation, if q2 is empty
 then all the elements except the last, are moved to q2. Finally the last element is dequeued
 from q1 and returned.

 push(s, x) operation:
 Enqueue x to q1 (assuming size of q1 is unlimited).
 pop(s) operation:
 One by one dequeue everything except the last element from q1 and enqueue to q2.
 Dequeue the last item of q1, the dequeued item is result, store it.
 Swap the names of q1 and q2
 Return the item stored in step 2.
 */

public class StackBy2Queue {
    static class StackUsing2Q
    {
        Queue<Integer> q1 ,q2;
        int currSize;

        public StackUsing2Q() {
            this.q1 = new LinkedList<>();
            this. q2 = new LinkedList<>();
            this.currSize = 0;
        }
        public void remove()
        {
            if(q1.isEmpty())
                return;
            while (q1.size()!=1)
            {
                q2.offer(q1.peek());
                q1.remove();
            }
            System.out.println("removed element "+q1.remove()+" from stack");
            currSize--;

            Queue<Integer> tempSwap = q1;
            q1 = q2;
            q2 = tempSwap;
        }
        public void add(int x)
        {
            q1.offer(x);
            currSize++;
            System.out.println("added element "+x+" in stack");
        }

        public int top()
        {
            if(q1.isEmpty()) {
                System.out.println("currently stack is empty returning integer min value");
                return Integer.MIN_VALUE;
            }
            while (q1.size()!=1)
            {
                q2.offer(q1.peek());
                q1.remove();
            }
            int temp = q1.peek(); // last pushed element
            q1.remove();    // to empty the auxiliary queue after last operation
            q2.add(temp);  // push last element to q2

            Queue<Integer> tempSwap = q1;
            q1 = q2;
            q2 = tempSwap;

            System.out.println("top element on stack right now = ");
            return temp;
        }
        public int size()
        {
            System.out.println("curr size of stack is  = ");
            return currSize;
        }

    }
    public static void main(String[] args)
    {
        StackUsing2Q s = new StackUsing2Q();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        System.out.println("current size: " + s.size());
    }
}

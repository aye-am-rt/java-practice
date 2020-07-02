package com.LinkedLists;

import java.util.HashMap;
import java.util.Map;

/**
Clone a linked list with next and random pointer | Set 2
We have already discussed 2 different ways to clone a linked list. In this post, one more simple
 method to clone a linked list is discussed.

The idea is to use Hashing. Below is algorithm.

1. Traverse the original linked list and make a copy in terms of data.
2. Make a hash map of key value pair with original linked list node and copied linked list node.
3. Traverse the original linked list again and using the hash map adjust the next and random
 reference of cloned linked list nodes.*/

public class CloneLLWithRandomPointer {
    static class LLNode
    {
        int data;
        LLNode next,random;
        public LLNode(int data)
        {
            this.data = data;
            this.next=this.random=null;
        }
    }
    //    Time complexity : O(n)
    //        Auxiliary space : O(n)
    static class myLinkedList
    {
        LLNode head;//Linked list head reference

        // Linked list constructor
        public myLinkedList(LLNode head)
        { this.head = head; }

        // push method to put data always at the head in the linked list.
        public void pushInFront(int newVal)
        {
            LLNode temp = new LLNode(newVal);
            temp.next = this.head;
            this.head = temp;
        }

        // Method to print the list.
        public void print()
        {
            LLNode temp = head;
            while (temp != null)
            {
                LLNode random = temp.random;
                int randomData = (random != null)? random.data: -1;

                System.out.println("Data = " + temp.data + ", Random data = "+ randomData+"  ");
                temp = temp.next;
            }
        }
        // Actual clone method which returns head reference of cloned linked list.
        public myLinkedList cloneLLWithRandom()
        {
            LLNode origCurr = this.head , cloneCurr = null ;
            Map<LLNode,LLNode> orToCloneHMap = new HashMap<>();

            // Traverse the original list and make a copy of that in the clone linked list.
            while (origCurr!=null)
            {
                cloneCurr = new LLNode(origCurr.data);
                orToCloneHMap.put(origCurr,cloneCurr);
                origCurr = origCurr.next;
            }
            // Adjusting the original list reference again.
            origCurr = this.head;

            // Traversal of original list again to adjust the next and random references of clone
            // list using hash map.
            while (origCurr!=null)
            {
                cloneCurr = orToCloneHMap.get(origCurr);
                cloneCurr.next = orToCloneHMap.get(origCurr.next);
                cloneCurr.random = orToCloneHMap.get(origCurr.random);
                origCurr = origCurr.next;
            }
            //return the head reference of the clone list.
            return new myLinkedList(orToCloneHMap.get(this.head));
        }
    }

    // Main method.
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        myLinkedList list = new myLinkedList(new LLNode(5));
        list.pushInFront(4);
        list.pushInFront(3);
        list.pushInFront(2);
        list.pushInFront(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random = list.head.next.next.next;
        list.head.next.next.random = list.head.next.next.next.next;
        list.head.next.next.next.random = list.head.next.next.next.next.next;
        list.head.next.next.next.next.random = list.head.next;

        // Making a clone of the original linked list.
        myLinkedList clone = list.cloneLLWithRandom();

        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();
    }
}
//    Time complexity : O(n)
//        Auxiliary space : O(n)

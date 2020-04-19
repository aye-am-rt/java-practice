package com.LinkedLists;
//
//Print reverse of a Linked List without extra space and modifications
//        Given a Linked List, display the linked list in reverse without using recursion, stack or
//        modifications to given list.
//        Examples:
//        Input : 1->2->3->4->5->NULL
//        Output :5->4->3->2->1->NULL

import java.util.Stack;

/**
Below are different solutions that are now allowed here as we cannot use extra space and modify list.

1) Recursive solution to print reverse a linked list. Requires extra space.
2) Reverse linked list and then print. This requires modifications to original list.
3) Stack based solution to print linked list reverse. Push all nodes one by one to a stack. Then
one by one pop elements from stack and print. This also requires extra space.
Algorithms:
1) Find n = count nodes in linked list.
2) For i = n to 1, do following.
Print i-th node using get n-th node function*/

public class ReverseLLNOSP {
    static class LLNode
    {
        int data;
        LLNode next;
        public LLNode(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    static class LinkedList
    {
        LLNode head=null;
        public void push(int data)
        {
            if(this.head==null)
            {
                this.head=new LLNode(data);
                return;
            }
            LLNode temp=new LLNode(data);
            temp.next=this.head;
            this.head=temp;
        }
        public void displayLL()
        {
            if(this.head==null)
            {
                System.out.println("linked list is empty");
                return;
            }
            LLNode temp=this.head;
            while(temp!=null)
            {
                System.out.print(temp.data+"-->");
                temp=temp.next;
            }
            System.out.println("NULL");
        }
        public int getCount()
        {
            int count=0;
            if(this.head==null)
                return count;
            LLNode temp=this.head;
            while(temp!=null)
            {
                count+=1;
                temp=temp.next;
            }
            return count;
        }
        public int getNthIndexData(int n)
        {
            LLNode temp=this.head;
            int i=0;
            while(i<n && temp!=null)
            {
                i+=1;
                temp=temp.next;
            }
            assert temp != null;
            return temp.data;
        }
        public void ReversePrintLL()
        {
            if(this.head!=null)
            {
                int totalNodes=this.getCount();
                for (int i = totalNodes-1; i >-1; i--) {
                    System.out.print(getNthIndexData(i)+"-->");
                }
                System.out.println("NULL");
            }
        }
        // WE CAN DO SAME THING USING STACK of LLNodes.... AND NOT using  FOR LOOP.
        public void printReverse(LLNode head)  // agar is public nhi bnaoge to bahar main me
        // access nhi kr sakte
        {
            // store Node addresses in stack
            Stack<LLNode > stk = new Stack<>();
            LLNode ptr = head;
            while (ptr != null)
            {
                stk.push(ptr);
                ptr = ptr.next;
            }
            // print data from stack
            while (! stk.isEmpty())
            {
                System.out.print( stk.peek().data + " ");
                stk.pop(); // pop after print
            }
            System.out.println( "\n");
        }
    }
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList head = new LinkedList();
        /* Use push() to add in front of l-list 1->2->3->4->5 */
//        push(head, 5);
//        push(head, 4);
//        push(head, 3);
//        push(head, 2);
//        push(head, 1);
        head.push(5);
        head.push(4);
        head.push(3);
        head.push(2);
        head.push(1);
        System.out.println("original linked list = ");
        head.displayLL();
        //printReverse();
        System.out.println("Reversed linked list = ");
        head.ReversePrintLL();
        head.printReverse(head.head);
    }
}

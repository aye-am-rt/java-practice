package com.LinkedLists;
//Print the last k nodes of the linked list in reverse order | Iterative Approaches
//        Given a linked list containing N nodes and a positive integer K where K should be less than or
//        equal to N. The task is to print the last K nodes of the list in reverse order.
//
//        Examples:
//
//        Input : list: 1->2->3->4->5, K = 2
//        Output : 5 4
//
//        Input : list: 3->10->6->9->12->2->8, K = 4
//        Output : 8 2 12 9

/** Approach 1: The idea is to use stack data structure. Push all the linked list nodes data value to
    stack and pop first K elements and print them. Time Complexity: O(N) Auxiliary Space: O(N)

The auxiliary space of the above approach can be reduced to O(k). The idea is to use two pointers.
Place first pointer to beginning of the list and move second pointer to k-th node form beginning.
Then find k-th node from end using approach discussed in this article: Find kth node from end of linked
list. After finding kth node from end push all the remaining nodes in the stack. Pop all elements one by
one from stack and print them. Time Complexity: O(N) Auxiliary Space: O(k)

Approach-2:
Count the number of nodes in the linked list.
Declare an array with the number of nodes as its size.
Start storing the value of nodes of the linked list from the end of the array i.e. reverse manner.
Print k values from starting of the array. Time Complexity: O(N) Auxiliary Space: O(N)

Approach-3: The idea is to first reverse the linked list iteratively as discussed in following post:
Reverse a linked list. After reversing print first k nodes of the reversed list. After printing restore
the list by reversing the list again.
Time Complexity: O(N)
Auxiliary Space: O(1)
*/

public class PrintLastKNodes {
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
        LLNode head;
        public LinkedList() {
            this.head = null;
        }

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
        public void ReverseLLIterative()
        {
            LLNode curr=this.head;
            LLNode nxt;
            while (curr.next!=null)
            {
                nxt=curr.next;
                curr.next=nxt.next;
                nxt.next=this.head;
                this.head=nxt;
            }
            //return hdNode;
        }
        public void displayLLOnlyKNodes(int k)
        {
            if(this.head==null)
            {
                System.out.println("linked list is empty");
                return;
            }
            LLNode temp=this.head;
            int i=0;
            while(temp!=null && i<k)
            {
                System.out.print(temp.data+" ");
                i+=1;
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args)
    {
        LinkedList list=new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        System.out.println("original linked list = ");
        list.displayLL();
        list.ReverseLLIterative();
        System.out.println("reversed linked list = ");
        list.displayLL();
        System.out.println("only k nodes of reversed linked list = ");
        int k=4;
        list.displayLLOnlyKNodes(k);
        System.out.println("\nreversed restored to original linked list = ");
        list.ReverseLLIterative();
        list.displayLL();


    }
}

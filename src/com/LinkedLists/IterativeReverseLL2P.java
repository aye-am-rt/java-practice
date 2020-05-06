package com.LinkedLists;
//Iteratively Reverse a linked list using only 2 pointers (An Interesting Method)
//        Given pointer to the head node of a linked list, the task is to reverse the linked list.
//        Examples:
//        Input : Head of following linked list
//        1->2->3->4->NULL
//        Output : Linked list should be changed to,
//        4->3->2->1->NULL

public class IterativeReverseLL2P {
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
    private static LLNode pushInFront(LLNode head, int data)
    {
        LLNode new_node = new LLNode(data);
        new_node.next = head;
        head = new_node;
        return head;
    }
    private static void displayLL(LLNode hdNode)
    {
        if(hdNode==null)
        {
            System.out.println("linked list is empty");
            return;
        }
        LLNode temp=hdNode;
        while(temp!=null)
        {
            System.out.print(temp.data+"--> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    private static LLNode ReverseLLIterative(LLNode hdNode)
    {
        LLNode curr=hdNode;
        LLNode nxt;
        while (curr.next!=null)
        {
            nxt=curr.next;
            curr.next=nxt.next;
            nxt.next=hdNode;
            hdNode=nxt;
        }
        return hdNode;
    }
    public static void main(String[] args)
    {
        LLNode head=null;
        head=pushInFront(head,20);
        head=pushInFront(head,4);
        head=pushInFront(head,15);
        head=pushInFront(head,85);

        System.out.println("given linked list = ");
        displayLL(head);
        LLNode sameReversed= ReverseLLIterative(head);
        System.out.println(" after reversing ll changed ll = ");
        displayLL(sameReversed);
    }
}

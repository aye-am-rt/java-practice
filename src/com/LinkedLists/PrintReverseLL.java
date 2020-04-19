package com.LinkedLists;
//
//Print reverse of a Linked List without actually reversing
//  Given a linked list, print reverse of it using a recursive function. For example, if the given
//  linked list is 1->2->3->4, then output should be 4->3->2->1.
//
//   Note that the question is only about printing the reverse. To reverse the list itself
//  Algorithm
//  printReverse(head)
//      1. call print reverse for hed->next
//      2. print head->data

public class PrintReverseLL {
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
    static class LinkedList {
        LLNode head;
        public LinkedList() {
            this.head = null;
        }
        public LLNode pushInLLBeginning(LLNode hdNode, int newVal) {
            if (hdNode == null) {
                return new LLNode(newVal);
            }
            LLNode temp = new LLNode(newVal);
            temp.next = hdNode;
            hdNode = temp;
            return hdNode;
        }

        public void PrintReverseLLRecursive(LLNode hdNode) {
            if (hdNode == null)
            {
                //System.out.println("NULL");
                return;
            }
            PrintReverseLLRecursive(hdNode.next);
            System.out.print(hdNode.data + " --> ");
        }
    }
    public static void main(String[] args)
    {
        // Let us create linked list 1->2->3->4
        LinkedList lList = new LinkedList();
        lList.head=lList.pushInLLBeginning(lList.head,4);
        lList.head=lList.pushInLLBeginning(lList.head,3);
        lList.head=lList.pushInLLBeginning(lList.head,2);
        lList.head=lList.pushInLLBeginning(lList.head,1);
        lList.PrintReverseLLRecursive(lList.head);
        System.out.println("NULL");
    }
}

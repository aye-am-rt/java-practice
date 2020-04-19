package com.LinkedLists;

import java.util.Stack;

public class PrintLastKsp2 {
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
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args)
    {

        // Create list: 1->2->3->4->5 
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(5);

        int k = 3;

        // print the last k nodes
        displayLL(head);
        System.out.println("last k=3 elements of this l list= ");
        printLastKRev(head, k);
    }

    private static void printLastKRev(LLNode hdNode, int k) {
         if(hdNode==null)
             return;
         Stack<Integer> LastKNodeStack=new Stack<>();
         LLNode firstMover=hdNode;
         LLNode secMover=hdNode;
        for (int i = 0; i < k; i++) {
            if(firstMover!=null) {
                firstMover=firstMover.next;
            }
            else
            {
                System.out.println("cant print k= "+k+" nodes in this list");
                return;
            }
        }
        while (firstMover!=null)
        {
            firstMover=firstMover.next;
            secMover=secMover.next;
        }
        while (secMover!=null)
        {
            LastKNodeStack.push(secMover.data);
            secMover=secMover.next;
        }
        while(! LastKNodeStack.isEmpty())
        {
            System.out.print(LastKNodeStack.pop()+"  ");
        }
    }
}

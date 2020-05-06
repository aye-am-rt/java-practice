package com.LinkedLists;
/*
Find the middle of a given linked list in C and Java
Given a singly linked list, find middle of the linked list. For example, if given linked list
 is 1->2->3->4->5 then output should be 3.

If there are even nodes, then there would be two middle nodes, we need to print second middle
element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.

Method 1:
Traverse the whole linked list and count the no. of nodes. Now traverse the list again till
count/2 and return the node at count/2.
Method 2:
Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
When the fast pointer reaches end slow pointer will reach middle of the linked list.*/

public class PrintMidElementLL {
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
    public static void main(String [] args)
    {
        LLNode lList=null;
        for (int i=5; i>0; --i)
        {
            lList = PushInFrontOfLL(lList , i);
            printList(lList);
            printMiddleElement2PointerMethod(lList);
            System.out.println("***** second method *******");
            printMiddleElementOnlyOddMove(lList);
        }
    }

    private static void printMiddleElementOnlyOddMove(LLNode lHead) {
        if (lHead == null) {
            return;
        }
        int count=0;
        LLNode tempHead=lHead;
        LLNode findMid=lHead;
        while (tempHead!=null)
        {
            if(count%2 != 0)
                findMid=findMid.next;

            ++count;
            tempHead=tempHead.next;
        }
        if(findMid!=null)
            System.out.println("The middle element is [" + findMid.data + "]");

    }

    /**    Method 3:
    Initialize mid element as head and initialize a counter as 0. Traverse the list from head,
 while traversing increment the counter and change mid to mid->next whenever the counter is odd.
 So the mid will move only half of the total length of the list.*/

    private static void printMiddleElement2PointerMethod(LLNode lHead) {
        if (lHead == null) {
            return;
        }
        LLNode slow=lHead;
        LLNode fast=lHead;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println("The middle element is [" + slow.data + "]");
    }

    private static void printList(LLNode llHead) {
        if(llHead==null)
            return;
        LLNode temp=llHead;
        while(temp != null)
        {
            System.out.print(temp.data+" -->  ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private static LLNode PushInFrontOfLL(LLNode headNode, int newVal) {
        if(headNode==null)
            return new LLNode(newVal);

        LLNode temp = new LLNode(newVal);
        temp.next=headNode;
        headNode=temp;
        return headNode;
    }
}

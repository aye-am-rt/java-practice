package com.LinkedLists;

public class ReverseDoublyLinkedLists {
    static class DLLNode
    {
        int data;
        DLLNode next,prev;

        public DLLNode(int data) {
            this.data = data;
            this.next=this.prev=null;
        }
    }
    private static DLLNode pushInBeginning(DLLNode hdNode , int newVal)
    {
        if(hdNode==null)
            return new DLLNode(newVal);
        DLLNode temp=new DLLNode(newVal);
        temp.next=hdNode;
        hdNode.prev=temp;
        hdNode=temp;
        return hdNode;
    }
    public static void main(String[] args)
    {
        // Start with the empty list
        DLLNode head = null;
        // Create doubly linked: 10< - >8< - >4< - >2 /
        head = pushInBeginning(head, 2);
        head = pushInBeginning(head, 4);
        head = pushInBeginning(head, 8);
        head = pushInBeginning(head, 10);

        System.out.print("Original list: ");
        printDLList(head);

        // Reverse doubly linked list
        head = reverseDLList(head);

        System.out.print("Reversed list: ");
        printDLList(head);
    }

    private static DLLNode reverseDLList(DLLNode headNode) {
        if(headNode==null || headNode.next==null)
        {
            System.out.println("nothing to reverse in this dll ");
            return null;
        }
        DLLNode temp=null; DLLNode curr=headNode; DLLNode nxt;
        while(curr != null)
        {
            nxt=curr.next;
            temp=pushInBeginning(temp,curr.data);
            curr=nxt;
        }
        headNode=temp;
        return headNode;
    }

    private static void printDLList(DLLNode hdNode) {
        if(hdNode==null)
        {
            System.out.println("no nodes present in this list");
            return;
        }
        DLLNode temp=hdNode;
        while(temp != null)
        {
            System.out.print(temp.data+" <--> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
}

package com.LinkedLists;
/*
Union and Intersection of two Linked Lists
Given two Linked Lists, create union and intersection lists that contain union and intersection of
the elements present in the given lists. Order of elments in output lists doesn’t matter.
Example:

Input:
List1: 10->15->4->20
lsit2:  8->4->2->10
Output:
Intersection List: 4->10
Union List: 2->8->20->4->15->10

Method 3 (Use Hashing)
Union (list1, list2)
Initialize the result list as NULL and create an empty hash table. Traverse both lists one by one,
for each element being visited, look the element in hash table. If the element is not present, then
insert the element to result list. If the element is present, then ignore it.

Intersection (list1, list2)
Initialize the result list as NULL and create an empty hash table. Traverse list1. For each element
being visited in list1, insert the element in hash table. Traverse list2, for each element being visited
in list2, look the element in hash table. If the element is present, then insert the element to result
list. If the element is not present, then ignore it.

*/

import java.util.HashMap;
import java.util.HashSet;

public class UnionIntersectionLL {
    static class LLNode
    {
        int data; LLNode next;
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

        public void pushInFront(int newVal)
        {
            if(this.head==null)
            {this.head=new LLNode(newVal);return;}

            LLNode temp = new LLNode(newVal);
            temp.next=head;
            head = temp;
        }
        public void appendInLast(int newVal)
        {
            if(this.head==null)
            {this.head=new LLNode(newVal);return;}

            LLNode hdNode= this.head;
            LLNode temp = new LLNode(newVal);
            while (hdNode.next!=null)
                hdNode=hdNode.next;

            hdNode.next=temp;

        }
        public void displayLL()
        {
            if(this.head==null)
                System.out.println("linked list is empty");
            LLNode temp = this.head;
            while (temp!=null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
        public boolean isPresentInLL(int data)
        {
            LLNode temp=head;
            while(temp!=null)
            {
                if(temp.data==data)
                    return true;
                temp=temp.next;
            }
            return false;
        }
        public LinkedList getIntersection(LLNode head1, LLNode head2)
        {
            HashSet<Integer> hSet= new HashSet<>();
            LLNode n1 = head1;
            LLNode n2 = head2;
            LinkedList IntersectionList=new LinkedList();
            while (n1!=null)
            {
                hSet.add(n1.data);
                n1=n1.next;
            }
            while (n2!=null)
            {
                if(hSet.contains(n2.data))
                    IntersectionList.pushInFront(n2.data);
                n2=n2.next;
            }
            return IntersectionList;
        }

        public LinkedList getUnion(LLNode head1, LLNode head2)
        {
            // HashMap that will store the elements of the lists with their counts
            HashMap<Integer,Integer> nodeCountMap=new HashMap<>();
            LLNode n1 = head1;
            LLNode n2 = head2;
            LinkedList UnionList=new LinkedList();
            while (n1!=null)
            {
                nodeCountMap.put(n1.data,nodeCountMap.getOrDefault(n1.data,0)+1);
                n1=n1.next;
            }
            while (n2!=null)
            {
                nodeCountMap.put(n2.data,nodeCountMap.getOrDefault(n2.data,0)+1);
                n2=n2.next;
            }
            // Eventually add all the elements
            // into the result that are present in the hmap
            nodeCountMap.forEach((K,V)->UnionList.appendInLast(K));
            return UnionList;
        }
    }

    public static void main(String[] args)
    {
        LinkedList lList1 = new LinkedList();
        LinkedList lList2 = new LinkedList();
        LinkedList union = new LinkedList();
        LinkedList intersection = new LinkedList();

        /*create a linked list 10->15->4->20 */
        lList1.pushInFront(20);
        lList1.pushInFront(4);
        lList1.pushInFront(15);
        lList1.pushInFront(10);

        /*create a linked list 8->4->2->10 */
        lList2.pushInFront(10);
        lList2.pushInFront(2);
        lList2.pushInFront(4);
        lList2.pushInFront(8);

        intersection = intersection.getIntersection(lList1.head, lList2.head);
        union=union.getUnion(lList1.head, lList2.head);

        System.out.println("First List is");
        lList1.displayLL();

        System.out.println("Second List is");
        lList2.displayLL();

        System.out.println("Intersection List is");
        intersection.displayLL();

        System.out.println("Union List is");
        union.displayLL();
    }
}

package com.LinkedLists;

/*Detect and Remove Loop in a Linked List
Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and
if loop is present then removes the loop and returns true. If the list doesn’t contain loop then
it returns false. Below diagram shows a linked list with a loop. detectAndRemoveLoop() must change
 the below list to 1->2->3->4->5->NULL.

 Method 3 (Optimized Method 2: Without Counting Nodes in Loop)
We do not need to count number of nodes in Loop. After detecting the loop, if we start slow
pointer from head and move both slow and fast pointers at same speed until fast don’t meet,
they would meet at the beginning of the loop.

How does this work?
Let slow and fast meet at some point after Floyd’s Cycle finding algorithm. Below diagram shows
the situation when cycle is found.

LinkedListCycle
We can conclude below from above diagram

Distance traveled by fast pointer = 2 * (Distance traveled by slow pointer)
(m + n*x + k) = 2*(m + n*y + k)

Note that before meeting the point shown above, fast
was moving at twice speed.

x -->  Number of complete cyclic rounds made by
       fast pointer before they meet first time

y -->  Number of complete cyclic rounds made by
       slow pointer before they meet first time

From above equation, we can conclude below

    m + k = (x-2y)*n

Which means m+k is a multiple of n.

So if we start moving both pointers again at same speed such that one pointer (say slow)
begins from head node of linked list and other pointer (say fast) begins from meeting point.
When slow pointer reaches beginning of loop (has made m steps), fast pointer would have made
also moved m steps as they are now moving same pace. Since m+k is a multiple of n and fast
starts from k, they would meet at the beginning. Can they meet before also? No because slow
pointer enters the cycle first time after m steps.

 */

public class DetectRemoveLoop {
    static class NodeLL
    {
        int data;
        NodeLL next;
        public NodeLL(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public static void PrintList(NodeLL hdNode)
    {
        if(hdNode==null)
        {
            System.out.println(" list is empty ");
        }
        else
        {
            NodeLL temp = hdNode;
            while(temp!=null)
            {
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println("NULL");
        }
    }
    static boolean flagFound = false;
    public static void main(String[] args)
    {

        NodeLL head = new NodeLL(50);
        head.next = new NodeLL(20);
        head.next.next = new NodeLL(15);
        head.next.next.next = new NodeLL(4);
        head.next.next.next.next = new NodeLL(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        detectAndRemoveLoopFloydMethod(head);
        if(flagFound)
        {
            System.out.println("Loop found --- Linked List after removing loop : ");
        }
        else
        {
            System.out.println("there is no loop in linked list printing normally");
        }
        PrintList(head);
    }

    private static void detectAndRemoveLoopFloydMethod(NodeLL head) {
        if (head == null || head.next==null) {
            return;
        }
        NodeLL slow = head;
        NodeLL fast =  head;

        slow = slow.next;
        fast= fast.next.next;
        while (fast!=null && fast.next!=null)
        {
            if(slow==fast)
                break;

            slow = slow.next;
            fast= fast.next.next;
        }

        if(slow==fast) // this means loop exists
        {
            flagFound = true;
            slow = head;
            // assert fast != null;
            while (slow.next!= fast.next)
            {
                slow=slow.next;
                fast=fast.next;
            }
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
    }
}

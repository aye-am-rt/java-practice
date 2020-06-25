package com.LinkedLists;

import java.util.HashSet;

public class DetectRemoveLoopHSet {
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
        detectAndRemoveLoopByHashSet(head);
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

//    Method 4 Hashing: Hash the address of the linked list nodes
//    We can hash the addresses of the linked list nodes in an unordered map and just check
//    if the element already exists in the map. If it exists, we have reached a node which already
//    exists by a cycle, hence we need to make the last node’s next pointer NULL.
    private static void detectAndRemoveLoopByHashSet(NodeLL hdNode) {
        HashSet<NodeLL> hSetNodes= new HashSet<>();
        NodeLL prev = null;

        while (hdNode!=null)
        {
            // If we have already has this node in hashmap it means their is a cycle and we
            // need to remove this cycle so set the next of the previous pointer with null.
            if(hSetNodes.contains(hdNode))
            {
                prev.next = null;
                flagFound = true;
                return;
            }
            // If we are seeing the node for the first time, insert it in hash
            else
            {
                hSetNodes.add(hdNode);
                prev = hdNode;
                hdNode = hdNode.next;
            }
        }
        flagFound = false;
        // return;
    }

}

package com.LinkedLists;
//An interesting method to print reverse of a linked list
//        We are given a linked list, we need to print the linked list in reverse order.
//        Examples:
//        Input : list : 5-> 15-> 20-> 25
//        Output : Reversed Linked list : 25-> 20-> 15-> 5
/**
 * // not working method don't use this
Trick : Idea behind printing a list in reverse order without any recursive function or loop is to use
 Carriage return (“r”). For this, we should have knowledge of length of list. Now, we should print
 n-1 blanck space and then print 1st element then “r”, futher again n-2 blank space and 2nd node
 then “r” and so on..
 Carriage return (“r”) : It commands a printer (cursor or the display of a system console),
 to move the position of the cursor to the first position on the same line.*/

public class InterestingReverseLL {
    static class Node {
        int data;
        Node next;
        Node(int val)
        {
            data = val;
            next = null;
        }
    }

    private static Node pushInFront(Node head, int data)
    {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;

        return head;
    }
    // not working method don't use this
    private static int printListAndGiveLength(Node head)
    {
        // i for finding length of list
        int i = 0;
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
            i++;
        }

        return i;
    }
    // not working method don't use this
    private static void printReverseLLInteresting(Node head, int n) {
        int j=0;
        Node current=head;
        while (current != null)
        {
            for (int i = 0; i < 2 * (n - j); i++) {
                System.out.print(" ");
            }
            System.out.print("\r"+current.data);
            current=current.next;
            j++;
        }

    }
    // Driver code
    // not working method don't use this
    public static void main(String[] args)
    {
        /* Start with the empty list */
        Node head = null;
        // list nodes are as 6 5 4 3 2 1
        head = pushInFront(head, 1);
        head = pushInFront(head, 2);
        head = pushInFront(head, 3);
        head = pushInFront(head, 4);
        head = pushInFront(head, 5);
        head = pushInFront(head, 6);

        System.out.println("Given linked list: ");
        // printList print the list and
        // return the size of list
        int n = printListAndGiveLength(head);
        System.out.print("\nnode count = "+n);
        // print reverse list with help
        // of carriage return function
        System.out.println("\nReversed Linked list: ");
        printReverseLLInteresting(head, n);
        System.out.println();
    }
    // not working method don't use this
}

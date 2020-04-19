package com.Trees;

import java.util.Arrays;

/**
Zig Zag Level order traversal of a tree using single queue
 Write a function to print spiral order traversal of a tree. For below tree, function
 should print 1, 2, 3, 4, 5. like a snake movement.


 The idea behind this approach is first we have to take a queue,
 a direction flag and a separation flag which is NULL

 Insert the root element into the queue and again insert NULL into the queue.
    For every element in the queue insert its child nodes.
 If a NULL is encountered then check the direction to traverse the particular level is left to right
    or right to left. If it’s an even level then traverse from left to right otherwise traverse
    the tree in right to level order i.e., from the front to the previous front
    i.e., from the current NULL to to the last NULL that has been visited. This continues till
    the last level then there the loop breaks and we print what is left (that has not printed) by
    checking the direction to print.
*/

public class ZigZagLOTree {
    static class Node
    {
        int data;
        Node left, right;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    // A utility function to create a new node
    static Node newNode(int data)
    {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }
    // Driver code
    public static void main(String args[])
    {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(7);
        root.left.right = newNode(6);
        root.right.left = newNode(5);
        root.right.right = newNode(4);
        ZigZagLevelOrderQueue(root, 7);
    }
//    Time Complexity: O(n)
//    Auxiliary Space : O(2*n) = O(n)
    private static void ZigZagLevelOrderQueue(Node rtNode, int totalNodes) {
        if (rtNode == null) {
            return;
        }
        Node[] queueArray=new Node[2*totalNodes];
        for (int i = 0; i < 2 * totalNodes; i++) {
            queueArray[i]=new Node();
        }
        int top=-1;
        int front=1;
        queueArray[++top] = null;  // means 0th index
        queueArray[++top] = rtNode; // means 1st index
        queueArray[++top] = null; // means 2nd index
        // for just 1 and 2 and 3 as nodes this is result ..elements of array and subtrees are inside
        // left and right of 1 index element  --------> // top=-1, front=1
        //[null,
        // Node{data=1, left=Node{data=2, left=null, right=null}, right=Node{data=3, left=null, right=null}},
        // null,
        // Node{data=0, left=null, right=null},
        // Node{data=0, left=null, right=null},
        // Node{data=0, left=null, right=null}]
        System.out.println(Arrays.toString(queueArray));
        int prevFront = 0, count = 1;
        while (true)
        {
            Node currNode=queueArray[front];
            if(currNode==null)
            {
                // top=-1, front=1 at first declared
                if(front==top)
                {
                    break;
                }
                else
                {
                    if(count%2==0)
                    {
                        for (int i = prevFront + 1; i < front; i++)
                            System.out.printf("%d ", queueArray[i].data);
                    }
                    else
                    {
                        for (int i = front - 1; i > prevFront; i--)
                            System.out.printf("%d ", queueArray[i].data);
                    }
                    prevFront = front;
                    count++;
                    front++;

                    // Insert a new level separator
                    queueArray[++top] = null;
                    continue;
                }
            }
            if (currNode.left != null)
                queueArray[++top] = currNode.left;
            if (currNode.right != null)
                queueArray[++top] = currNode.right;
            front++;
        }
        if (count % 2 == 0)
        {
            for (int i = prevFront + 1; i < top; i++)
                System.out.printf("%d ", queueArray[i].data);
        }
        else
        {
            for (int i = top - 1; i > prevFront; i--)
                System.out.printf("%d ", queueArray[i].data);
        }
    }
}

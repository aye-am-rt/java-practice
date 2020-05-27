package com.Trees.Views;

import java.util.Stack;

/**
        Print All Leaf Nodes of a Binary Tree from left to right | Set-2 ( Iterative Approach )
        Given a Binary Tree, the task is to print the leaf nodes from left to right. The nodes must
 be printed in the order they appear from left to right.

        Examples:

        Input :
        1
        /  \
        2    3
        / \  / \
        4  5  6  7

        Output :4 5 6 7

        Input :
        4
        /  \
        5    9
        / \  / \
        8   3 7  2
        /         / \
        12        6   1

        Output :12 3 7 6 1


 Approach:The idea is to use two stacks, one to store all the nodes of the tree and the other
 one to store all the leaf nodes. We will pop the top node of the first stack. If the node has a
 left child, we will push it on top of the first stack, if it has a right child then we will push it
 onto the top of the first stack, but if the node is a leaf node then we will push it onto the top of
 the second stack. We will do it for all the nodes until we have traversed the Binary tree completely.

 Then we will start popping the second stack and print all its elements until the stack gets empty.

 */

public class PrintLeafNodesIterative {
    static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left=this.right=null;
        }
    }
    // Function to Print all the leaf nodes
    // of Binary tree using two stacks
    static void PrintLeafLeftToRight(Node root)
    {
        // Stack to store all the nodes of tree
        Stack<Node> s1 = new Stack<>();

        // Stack to store all the leaf nodes
        Stack<Node> s2 = new Stack<>();;

        // Push the root node
        s1.push(root);

        while (!s1.empty())
        {
            Node curr = s1.peek();
            s1.pop();

            // If current node has a left child
            // push it onto the first stack
            if (curr.left!=null)
                s1.push(curr.left);

            // If current node has a right child
            // push it onto the first stack
            if (curr.right!=null)
                s1.push(curr.right);

                // If current node is a leaf node
                // push it onto the second stack
            else if (curr.left==null && curr.right==null)
                s2.push(curr);
        }

        // Print all the leaf nodes
        while (!s2.empty())
        {
            System.out.print(s2.peek().data +" ");
            s2.pop();
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.left.left.left = new Node(10);
        root.left.left.right = new Node(11);
        root.right.right.left = new Node(8);

        PrintLeafLeftToRight(root);
    }
}

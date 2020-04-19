package com.Trees;

public class MaxInBSTMain {
    static class node
    {
        int data;
        node left;
        node right;
    }

    /* Helper function that allocates a new node
    with the given data and null left and right
    pointers. */
    static node newNode(int data)
    {
        node node = new node();
        node.data = data;
        node.left = null;
        node.right = null;

        return (node);
    }

    /* Give a binary search tree and a number,
    inserts a new node with the given number in
    the correct place in the tree. Returns the new
    root pointer which the caller should then use
    (the standard trick to avoid using reference
    parameters). */
    static node insert(node node, int data)
    {

    /* 1. If the tree is empty, return a new,
    single node */
        if (node == null)
            return (newNode(data));
        else
        {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    static int maxValue(node node)
    {
        if (node.right == null)
            return node.data;
        return maxValue(node.right);
    }

    // Driver code
    public static void main(String args[])
    {

        // Create the BST
        node root = null;
        root = insert(root, 4);
        root = insert(root, 2);
        root = insert(root, 1);
        root = insert(root, 3);
        root = insert(root, 6);
        root = insert(root, 5);

        System.out.println(maxValue(root));
    }
}

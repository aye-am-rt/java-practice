package com.Trees;
/**
Maximum XOR path of a Binary Tree
Given a Binary Tree, the task is to find the maximum of all the XOR value of all the nodes in
 the path from the root to leaf.
Examples:
Input:
2
/ \
1   4
/ \
10  8
Output: 11
Explanation:
All the paths are:
2-1-10 XOR-VALUE = 9
2-1-8 XOR-VALUE = 11
2-4 XOR-VALUE = 6

Input:
2
/   \
1     4
/ \   / \
10  8 5  10
Output: 12
Approach:
To solve the question mentioned above we have to traverse the tree recursively using pre-order
 traversal. For each node keep calculating the XOR of the path from root till the current node.
XOR of current node’s path = (XOR of the path till the parent) ^ (current node value)

If the node is a leaf node that is left and the right child for the current nodes are NULL then we
 compute the max-Xor, as
max-Xor = max(max-Xor, cur-Xor).*/

public class MaxXorPathBT {
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.left = new Node(10);
        root.left.right = new Node(8);
        root.right.left = new Node(5);
        root.right.right = new Node(10);

        System.out.println(findMaxXor(root));
    }

    private static int findMaxXor(Node root) {
        int xr=0;
        int maxXor=0;
        return SolveRecursive(root,xr,maxXor);
    }

    private static int SolveRecursive(Node root, int xr, int maxXor) {
        xr = xr ^ root.data;
        if(root.left==null && root.right==null) { // Check if node is leaf node
            maxXor = Math.max(maxXor, xr);
            return maxXor;
        }
        // Check if the left node exist in the tree
        if (root.left != null) {
            SolveRecursive(root.left, xr, maxXor);
        }

        // Check if the right node exist in the tree
        if (root.right != null) {
            SolveRecursive(root.right, xr, maxXor);
        }
        return 0;
    }
}

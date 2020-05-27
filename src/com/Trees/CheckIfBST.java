package com.Trees;
//
//In this article, we will discuss a simple yet efficient approach to solve the above problem.
//
//        The idea is to use Inorder traversal and keep track of the previously visited node’s value.
//        Since the inorder traversal of a BST generates a sorted array as output, So, the previous
//        element should always be less than or equals to the current element.
//
//        While doing In-Order traversal, we can keep track of previously visited Node’s value by
//        passing an integer variable using reference to the recursive calls. If the value of the
//        currently visited node is less than the previous value, then the tree is not BST.

public class CheckIfBST {
    static class Node
    {
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            this.left=this.right=null;
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        if (isBST(root))
            System.out.print("Is BST");
        else
            System.out.print("Not a BST");
    }

    private static boolean isBST(Node root) {
        int prev=Integer.MIN_VALUE;
        return CheckIfBSTUsingPrevValue(root,prev);
    }

    private static boolean CheckIfBSTUsingPrevValue(Node root, int prev) {
        if (root == null) {
            return true;
        }
        if(!CheckIfBSTUsingPrevValue(root.left,prev))
            return false;

        if(root.data<=prev)
            return false;
        prev=root.data;

        return CheckIfBSTUsingPrevValue(root.right,prev);
    }
}

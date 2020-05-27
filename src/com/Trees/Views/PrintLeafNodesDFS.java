package com.Trees.Views;

public class PrintLeafNodesDFS {
    // Time Complexity: O( n ) , where n is number of nodes in the binary tree.
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
    // Time Complexity: O( n ) , where n is number of nodes in the binary tree.
    public static void main(String[] args)
    {
        // Time Complexity: O( n ) , where n is number of nodes in the binary tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printLeafLeftToRightDfs(root);
    }
    // Time Complexity: O( n ) , where n is number of nodes in the binary tree.
    private static void printLeafLeftToRightDfs(Node root) {
        if(root==null)
            return;

        printLeafLeftToRightDfs(root.left);

        if(root.left==null && root.right==null)
            System.out.print(root.data+"  ");

        printLeafLeftToRightDfs(root.right);
        // Time Complexity: O( n ) , where n is number of nodes in the binary tree.
    }
}

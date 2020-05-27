package com.Trees.Views;

/**
The left view contains all nodes that are first nodes in their levels. A simple solution is to do
 level order traversal and print the first node in every level.

The problem can also be solved using simple recursive traversal. We can keep track of the level of
 a node by passing a parameter to all recursive calls. The idea is to keep track of the maximum level
 also. Whenever we see a node whose level is more than maximum level so far, we print the node because
 this is the first node in its level (Note that we traverse the left subtree before right subtree).
 Following is the implementation-*/
//
//Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n).
//        Auxiliary Space: O(n), due to the stack space during recursive call.

public class LeftViewRecursive {
    static class Node
    {
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree
    {
        Node root;
        int maxLevel=0;
        void leftView()
        {
            leftViewUtil(root, 1);
        }

        private void leftViewUtil(Node rt, int currLevel) {
            if(rt==null)
                return;
            if(currLevel>maxLevel)
            {
                System.out.print(rt.data+"  ");
                maxLevel=currLevel;
            }
            leftViewUtil(rt.left,currLevel+1);
            leftViewUtil(rt.right,currLevel+1);

        }
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        tree.leftView();
    }
}

//    Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n).
//        Auxiliary Space: O(n), due to the stack space during recursive call.

package com.practiceTab2;

public class MaxInBST {
    static class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;
        int max_found=Integer.MIN_VALUE;
        BinaryTree() { root = null; }
        void printMaxInBST(Node root) {
            if (root == null)
                return;
            if(root.right !=null)
            {
//                if(root.key>max_found)
//                { max_found=root.key; }
                printMaxInBST(root.right);
            }
            else
            {
                max_found=root.key;
                System.out.println("max value in bst = "+max_found);
            }

        }
    }
    public static void main(String args[])
    {

        /* creating a binary tree and entering
        the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.left.right = new Node(3);
        tree.root.right = new Node(40);
        tree.root.right.left = new Node(39);
        tree.root.right.right = new Node(99);
        tree.printMaxInBST(tree.root);
    }
}

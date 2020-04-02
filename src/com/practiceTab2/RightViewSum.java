package com.practiceTab2;

/*
Sum of nodes in the right view of the given binary tree
Given a binary tree, the task is to find the sum of the nodes which are visible in the right view.
The right view of a binary tree is the set of nodes visible when the tree is viewed from the right.
*/

public class RightViewSum {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        Node root;
        static int max_level = 0;
        static int sum = 0;

        BinaryTree() {
            root = null;
        }
        // Recursive function to find the sum of nodes
        // of the right view of the given binary tree
        static void sumRightViewUtil(Node node, int level)
        {
            // Base Case
            if (node == null)
                return;

            // If this is the last node of its level
            if (max_level < level) {
                sum += node.data;
                max_level = level;
            }

            // Recur for left and right subtrees
            sumRightViewUtil(node.right, level + 1);
            sumRightViewUtil(node.left, level + 1);
        }

        // A wrapper over sumRightViewUtil()
        void sumRightView()
        {
            sumRightViewUtil(root, 1);
            System.out.print(sum);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("sum of right side view nodes = ");
        tree.sumRightView();
    }
}

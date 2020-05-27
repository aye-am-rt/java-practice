package com.Trees;
//
//Check if a binary tree is subtree of another binary tree | Set 1
//        Given two binary trees, check if the first tree is subtree of the second one. A subtree of a
//        tree T is a tree S consisting of a node in T and all of its descendants in T. The subtree
//        corresponding to the root node is the entire tree; the subtree corresponding to any other
//        node is called a proper subtree.

public class CheckIfSubTreeOfAnother {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
        }
    }
    public static void main(String[] args)
    {

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        if (isSubtree(root1, root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }

    private static boolean isSubtree(Node bigTree, Node smallTree) {
        if(bigTree==null)
            return false;

        if(smallTree==null)
            return true;

        if(checkAreIdentical(bigTree,smallTree))
            return true;

        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(bigTree.left,smallTree) || isSubtree(bigTree.right,smallTree);
    }

    private static boolean checkAreIdentical(Node bigTree, Node smallTree) {
        if (bigTree == null && smallTree==null) {
            return true;
        }
        if (bigTree == null || smallTree==null) {
            return false;
        }
        return (bigTree.data==smallTree.data &&
                checkAreIdentical(bigTree.left,smallTree.left) &&
                checkAreIdentical(bigTree.right, smallTree.right));
    }
}

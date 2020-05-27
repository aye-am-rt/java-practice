package com.Trees.LCA;

import java.util.ArrayList;

/**Least Common Ancestor of any number of nodes in Binary Tree
Given a binary tree (not a binary search tree) and any number of Key Nodes, the task is to find the
 least common ancestor of all the key Nodes.

Following is the definition of LCA from Wikipedia:
Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest
 node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of
 itself).

 Approach:
 Following is the simple approach for Least Common Ancestor for any number of nodes.

 For every node calculate the matching number of nodes at that node and its sub-tree.
 If root is also a matching node.
 matchingNodes = matchingNodes in left sub-tree + matchingNodes in right sub-tree + 1

 If root is not a matching node.
 matchingNodes = matchingNodes in left sub-tree + matchingNodes in right-subtree

 If matching Nodes count at any node is equal to number of keys then add that node into the
 Ancestors list.
 The First node in the Ancestors List is the Least Common Ancestor of all the given keys.

 */

public class FindLcaOf_N_nodes {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value)
        {
            this.data = value;
            left = right = null;
        }
    }
    // Driver Code
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        // Key Nodes for LCA
        ArrayList<Integer> keyNodes = new ArrayList<>();
        keyNodes.add(12);
        keyNodes.add(14);
        keyNodes.add(15);
        System.out.println(lcaOfNodes(root, keyNodes).data);
    }

    private static TreeNode lcaOfNodes(TreeNode root, ArrayList<Integer> keyNodes) {
        // Create a new list for capturing all the ancestors of the given nodes
        ArrayList<TreeNode> ancestors = new ArrayList<>();
        int matchingNodes=0;  // Initially there is No Matching Nodes 

        getKeysCount(root,keyNodes,matchingNodes,ancestors);

        // First Node in the Ancestors list is the Least Common Ancestor of Given keyNodes
        return ancestors.get(0);
    }

    private static int getKeysCount(TreeNode root, ArrayList<Integer> keyNodes,
                                    int matchingNodes, ArrayList<TreeNode> ancestors) {
        if (root == null) {
            return 0;
        }
        matchingNodes += getKeysCount(root.left,keyNodes,matchingNodes,ancestors)
                +getKeysCount(root.right,keyNodes, matchingNodes,ancestors);

        // Condition to check if Root Node is also in Key Node
        if (keyNodes.contains(root.data)){
            matchingNodes++;
        }
        // Condition when matching Nodes is equal to the Key Nodes found
        if(matchingNodes==keyNodes.size())
            ancestors.add(root);

        return matchingNodes;
    }

}

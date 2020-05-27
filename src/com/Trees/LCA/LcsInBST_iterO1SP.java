package com.Trees.LCA;

/*Approach: For Binary search tree, while traversing the tree from top to bottom the first node which
lies in between the two numbers n1 and n2 is the LCA of the nodes, i.e. the first node n with the
lowest depth which lies in between n1 and n2 (n1<=n<=n2) n1 < n2. So just recursively traverse
the BST in, if node's value is greater than both n1 and n2 then our LCA lies in the left side of
the node, if it's is smaller than both n1 and n2, then LCA lies on the right side. Otherwise,
the root is LCA (assuming that both n1 and n2 are present in BST).

Algorithm:

Create a recursive function that takes a node and the two values n1 and n2.
If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree.
Call the recursive function for thr right subtree.
If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree.
 Call the recursive function for thr left subtree.
If both the above cases are false then return the current node as LCA.*/
/**
Iterative Implementation: The above solution uses recursion. The recursive solution requires extra
 space in the form of the function call stack. So an iterative solution can be implemented which does
 not occupy space in the form of the function call stack.*/
//
//Time Complexity: O(h).
//        The Time Complexity of the above solution is O(h), where h is the height of the tree.
//        Space Complexity: O(1).
//        The space complexity of the above solution is constant.

public class LcsInBST_iterO1SP {
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
    static class BstTree
    {
        TreeNode root;

        public TreeNode lca(TreeNode rt, int n1, int n2) {
            while (rt!=null)
            {
                // If both n1 and n2 are smaller // than root, then LCA lies in left
                if(rt.data>n1 && rt.data>n2)
                {
                    rt=rt.left;
                }
                else if(rt.data<n1 && rt.data<n2)
                {
                    rt=rt.right;
                }
                else
                    break;
            }
            return rt;
        }
    }

    /* Driver program to test lca() */
    public static void main(String[] args)
    {
        // Let us construct the BST shown in the above figure
        BstTree tree = new BstTree();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        int n1 = 10, n2 = 14;
        TreeNode t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }
}

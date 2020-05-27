package com.Trees.LCA;
/**Lowest Common Ancestor in a Binary Tree | Set 1
Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to
 find the least common ancestor.
Following is definition of LCA from Wikipedia:
Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the
 lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant
 of itself).

The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
 Computation of lowest common ancestors may be useful, for instance, as part of a procedure for
 determining the distance between pairs of nodes in a tree: the distance from n1 to n2 can be
 computed as the distance from the root to n1, plus the distance from the root to n2, minus twice
 the distance from the root to their lowest common ancestor. (Source Wiki)

 ========================================================================================

 Method 2 (Using Single Traversal)
 The method 1 finds LCA in O(n) time, but requires three tree traversals plus extra spaces for
 path arrays. If we assume that the keys n1 and n2 are present in Binary Tree, we can find LCA using
 single traversal of Binary Tree and without extra storage for path arrays.
 The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2)
 matches with root, then root is LCA (assuming that both keys are present). If root doesn’t match with
 any of the keys, we recur for left and right subtree. The node which has one key present in its left
 subtree and the other key present in right subtree is the LCA. If both keys lie in left subtree, then
 left subtree has LCA also, otherwise LCA lies in right subtree.

 */

public class LCA_set1 {
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
    static class BinaryTree
    {
        TreeNode root;
        static boolean v1=false,v2=false;

        public TreeNode findLCA(int n1, int n2) {
            v1=false;
            v2=false;

            TreeNode lca = findLCAUtil(root,n1,n2);
            if( v1 && v2)
                return lca;

            return null;
        }

        // This function returns pointer to LCA of two given
        // values n1 and n2.
        // v1 is set as true by this function if n1 is found
        // v2 is set as true by this function if n2 is found
        private TreeNode findLCAUtil(TreeNode node, int n1, int n2) {
            if(node==null)
                return null;
            TreeNode temp = null;
            if(node.data==n1)
            {
                v1=true; temp=node;
            }
            if(node.data==n2)
            {
                v2=true; temp=node;
            }

            TreeNode left_lca=findLCAUtil(node.left,n1,n2);
            TreeNode right_lca=findLCAUtil(node.right,n1,n2);

            if(temp!=null)
                return temp;

            if(left_lca!=null && right_lca!=null)
                return node;
            else
                return (left_lca != null) ? left_lca : right_lca;
        }
        
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        TreeNode lca = tree.findLCA(4, 5);

        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = tree.findLCA(4, 10);

        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }

}

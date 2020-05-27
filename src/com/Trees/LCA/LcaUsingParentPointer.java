package com.Trees.LCA;
/*
Lowest Common Ancestor in a Binary Tree | Set 2 (Using Parent Pointer)
Given values of two nodes in a Binary Tree, find the Lowest Common Ancestor (LCA).
It may be assumed that both nodes exist in the tree.

Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the
lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of
 itself). Source : Wikipedia.*/

/**A O(h) time and O(1) Extra Space Solution:
        The above solution requires extra space because we need to use a hash table to store
 visited ancestors. We can solve the problem in O(1) extra space using following fact :
 If both nodes are at same level and if we traverse up using parent pointers of both nodes, the
 first common node in the path to root is lca.
        The idea is to find depths of given nodes and move up the deeper node pointer by the
 difference between depths. Once both nodes reach same level, traverse them up and return the first
 common node.*/

public class LcaUsingParentPointer {
    static class Node
    {
        int data;
        Node left, right, parent;
        Node(int data)
        {
            this.data = data;
            left = right = parent = null;
        }
    }
    public static class BinaryTree
    {
        Node root,n1,n2,lca;

        public Node insert(Node rt, int key) {
            if(rt==null)
                return new Node(key);

            if(key<rt.data)
            {
                rt.left=insert(rt.left,key);
                rt.left.parent=rt;
            }
            else if(key>rt.data)
            {
                rt.right=insert(rt.right,key);
                rt.right.parent=rt;
            }
            return rt;
        }

        public Node LCA(Node n1, Node n2) {
            // Find depths of two nodes and differences
            int d1 = depth(n1), d2 = depth(n2);
            int diff = d1 - d2;
            if(diff<0) // // If n2 is deeper, swap n1 and n2
            {
                Node temp = n1;
                n1=n2;
                n2=temp;
                diff = -diff;
            }
            // Move n1 up until it reaches the same level as n2
            while (diff--!=0)
            {
                n1=n1.parent;
            }
            // now n1 and n2 are on same level
            while (n1!=null && n2!=null)
            {
                if(n1==n2)
                    return n1;
                n1=n1.parent;
                n2=n2.parent;
            }

            return null;
        }
        // A utility function to find depth of a node (distance of it from root)
        private int depth(Node nodeAny) {
            int d=-1;
            while(nodeAny!=null)
            {
                ++d;
                nodeAny=nodeAny.parent;
            }
            return d;
        }
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);

        tree.n1 = tree.root.left.right.left;
        tree.n2 = tree.root.right;
        tree.lca = tree.LCA(tree.n1, tree.n2);

        System.out.println("LCA of " + tree.n1.data+ " and " + tree.n2.data+ " is " + tree.lca.data);
    }
}

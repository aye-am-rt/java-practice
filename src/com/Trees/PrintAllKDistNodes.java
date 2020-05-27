package com.Trees;

/**There are two types of nodes to be considered.
1) Nodes in the subtree rooted with target node. For example if the target node is 8 and k is 2,
 then such nodes are 10 and 14.
2) Other nodes, may be an ancestor of target, or a node in some other subtree. For target node 8 and
 k is 2, the node 22 comes in this category.

Finding the first type of nodes is easy to implement. Just traverse subtrees rooted with the target
 node and decrement k in recursive call. When the k becomes 0, print the node currently being traversed
 (See this for more details). Here we call the function as print_k_distance_NodeDown().

How to find nodes of second type? For the output nodes not lying in the subtree with the target node
 as the root, we must go through all ancestors. For every ancestor, we find its distance from target
 node, let the distance be d, now we go to other subtree (if target was found in left subtree, then
 we go to right subtree and vice versa) of the ancestor and find all nodes at k-d distance from
 the ancestor.*/

//    Time Complexity: At first look the time complexity looks more than O(n), but if we take a closer
//    look, we can observe that no node is traversed more than twice. Therefore the time complexity
//    is O(n).

public class PrintAllKDistNodes {
    // A binary tree node
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    //    Time Complexity: At first look the time complexity looks more than O(n), but if we take a closer
    //    look, we can observe that no node is traversed more than twice. Therefore the time complexity
    //    is O(n).
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.print_k_distance_Nodes(tree.root, target, 2);
    }
    static class BinaryTree
    {
        Node root;
        /* Recursive function to print all the nodes at distance k in tree (or subtree) rooted with
           target root. */
        public void print_k_distance_NodeInSubTree(Node nodeAny, int KDist) {
            if(nodeAny==null || KDist<0)
                return;
            if(KDist==0)
            {
                System.out.print(nodeAny.data+"  ");
                return;
            }
            print_k_distance_NodeInSubTree(nodeAny.left,KDist-1);
            print_k_distance_NodeInSubTree(nodeAny.right,KDist-1);

        }
        // Prints all nodes at distance k from a given target node.
        // The k distant nodes may be upward or downward.This function
        // Returns distance of root from target node, it returns -1
        // if target node is not present in tree rooted with root.
        public int print_k_distance_Nodes(Node nodeAny, Node target, int KDist) {
            if(nodeAny==null)
                return -1;
            if(nodeAny==target)
            {print_k_distance_NodeInSubTree(nodeAny,KDist); return 0;}

            int dl = print_k_distance_Nodes(nodeAny.left,target,KDist); // recursive call self
            if(dl!=-1)
            {
                // If root is at distance k from target, print root Note that dl is Distance of
                // root's left child from target
                if(dl+1==KDist)
                {
                    System.out.print(nodeAny.data+"  ");
                }
                else
                {
                    // Else go to right subtree and print all k-dl-2 distant nodes
                    // Note that the right child is 2 edges away from left child
                    print_k_distance_NodeInSubTree(nodeAny.right,KDist-dl-2);
                }
                return (dl+1);
            }
            // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
            // Note that we reach here only when node was not found in left subtree
            int dr = print_k_distance_Nodes(nodeAny.right,target,KDist); // recursive call self
            if(dr!=-1)
            {
                // If root is at distance k from target, print root Note that dr is Distance of
                // root's right child from target
                if(dr+1==KDist)
                {
                    System.out.print(nodeAny.data+"  ");
                }
                else
                {
                    // Else go to right subtree and print all k-dr-2 distant nodes
                    // Note that the right child is 2 edges away from right child
                    print_k_distance_NodeInSubTree(nodeAny.left,KDist-dr-2);
                }
                return (dr+1);
            }
            return -1;
        }
    }
}
//
//    Time Complexity: At first look the time complexity looks more than O(n), but if we take a closer
//    look, we can observe that no node is traversed more than twice. Therefore the time complexity
//    is O(n).

package com.Trees.Views;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
Print nodes in top view of Binary Tree | Set 2
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given
 a binary tree, print the top view of it. The output nodes should be printed from left to right.

Note: A node x is there in output if x is the topmost node at its horizontal distance. Horizontal
 distance of the left child of a node x is equal to the horizontal distance of x minus 1, and that of
 right child is the horizontal distance of x plus 1.

Input:
    1
/     \
2       3
/  \    / \
4    5  6   7
Output: Top view: 4 2 1 3 7

Input:
 1
/ \
2  3
\
 4
  \
   5
    \
     6
Output: Top view: 2 1 3 6

 The idea is to do something similar to Vertical Order Traversal.
 Like Vertical Order Traversal, we need to group nodes of same horizontal distance together.
 We do a level order traversal so that the topmost node at a horizontal node is visited before any
 other node of same horizontal distance below it. A Map is used to map the horizontal distance of the
 node with the node’s Data and vertical distance of the node.
 */

public class TopViewOfTree2 {
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
    static class DHPair
    {
        int data,height;
        public DHPair(int data, int height)
        {
            this.data=data;
            this.height=height;
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        System.out.print("Top View : ");
        printTopView(root);
    }

    private static void printTopView(Node root) {
        // Map to store horizontal distance, height and node's data
        Map<Integer,DHPair> hMap=new HashMap<>();
        printTopViewUtil(root,0,0,hMap);
        // Print the node's value stored by printTopViewUtil()
        hMap.forEach((K,P)-> System.out.print(P.data+"  "));

        // or use iterator =========
        // Iterator<Map.Entry<Object, Object>> itr = new hMap.entrySet().iterator();  // this not working
//        for (Map.Entry<Integer, DHPair> ent : hMap.entrySet()) {
//            DHPair p = ent.getValue();
//            System.out.print(p.data+"  ");
//        }
    }

    private static void printTopViewUtil(Node root, int height, int dist, Map<Integer, DHPair> hMap) {
        if (root == null) {
            return;
        }
        // If the node for particular horizontal distance is not present in the map, add it.
        // For top view, we consider the first element at horizontal distance in level order traversal
        if(!hMap.containsKey(dist))
        {
            hMap.put(dist,new DHPair(root.data,height));
        }
        else
        {
            DHPair p = hMap.get(dist);
            if(p.height>height)
            {
                hMap.remove(dist);
                hMap.put(dist,new DHPair(root.data,height));
            }
        }
        printTopViewUtil(root.left,height+1,dist-1,hMap);
        printTopViewUtil(root.right,height+1,dist+1,hMap);

    }
}

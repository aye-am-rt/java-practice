package com.Trees.Views;
/*Print nodes in the Top View of Binary Tree | Set 3
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary
 tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity
 is O(n)

A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance
of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is
horizontal distance of x plus 1*/

import java.util.*;

/**
The idea here is to observe that, if we try to see a tree from its top, then only the nodes which are
 at top in vertical order will be seen.
        Start BFS from root. Maintain a queue of pairs comprising of node(Node *) type and vertical
 distance of node from root. Also, maintain a map which should store the node at a particular vertical
 distance.
        While processing a node, just check if any node is there in the map at that vertical distance.
        If any node is there, it means the node can’t be seen from top, do not consider it. Else, if
 there is no node at that vertical distance, store that in map and consider for top view.*/
public class TopView3 {
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
        Node node;
        int distance;
        public DHPair(Node node, int distance)
        {
            this.node=node;
            this.distance=distance;
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args)
    {
    /* Create following Binary Tree
         1
        / \
        2 3
        \
         4
          \
           5
            \
             6*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        System.out.println( "Following are nodes in top view of Binary Tree");
        topView(root);

    }

    private static void topView(Node root) {
        if (root == null) {
            return;
        }
        Node temp=null;
        Queue<DHPair> q =new LinkedList<>();
        Map<Integer, Integer> hMap= new HashMap<>();
        q.offer(new DHPair(root,0));
        // BFS
//        BFS uses Queue to find the shortest path. DFS uses Stack to find the shortest path.
//        BFS is better when target is closer to Source. DFS is better when target is far from
        while (!q.isEmpty())
        {
            temp = q.peek().node;
            int d = q.peek().distance;
            q.remove();
            // If any node is not at that vertical distance
            // just insert that node in map and print it
            if(hMap.get(d)==null)
                hMap.put(d,temp.data);
            if(temp.left!=null)
                q.add(new DHPair(temp.left,d-1));
            if(temp.right!=null)
                q.add(new DHPair(temp.right,d+1));
        }
        for (Integer data : hMap.values())
            System.out.print(data+" ");
    }

}

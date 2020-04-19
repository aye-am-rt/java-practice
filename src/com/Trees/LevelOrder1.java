package com.Trees;
//Given a binary tree, print level order traversal in a way that nodes of all levels are printed
// in separate lines.

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder1 {
    static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    // Driver program to test above functions 
    public static void main(String[] args)
    {
        // Let us create binary tree shown in above diagram 
       /*             1 
                   /     \ 
                  2       3 
                /   \       \ 
               4     5       6 
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        printLevelOrder(root);

    }

    private static void printLevelOrder(Node root) {
        if(root == null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(true)
        {
            int nodeCountInList=q.size();
            if(nodeCountInList==0)
                break;
            while (nodeCountInList>0)
            {
                    Node topNode = q.peek();
                    if(topNode != null)
                        System.out.print(topNode.data + "  ");
                    q.remove();
                assert topNode != null;
                if (topNode.left != null)
                        q.add(topNode.left);
                    if (topNode.right != null)
                        q.add(topNode.right);
                    nodeCountInList--;
            }
            System.out.println();
        }
    }
}

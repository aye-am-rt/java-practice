package com.Trees.Views;

/*The idea is to do level order traversal of the Tree using a queue and print the first node at each level.

While doing level order traversal, after traversing all node at each level, push a NULL delimiter
to mark the end of the current level. So, do the level order traversal of the tree. Print the first
 node at each level in the tree and push the children of all nodes at each level in the queue until a
NULL delimiter is encountered.*/

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewIterateQ {
    static class Node
    {
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.left.right = new Node(6);
        root.right.left.right.left = new Node(18);
        root.right.left.right.right = new Node(7);

        leftView(root);
    }

    private static void leftView(Node rtNode) {
        if(rtNode==null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(rtNode);
        q.add(null);
        while (!q.isEmpty())
        {
            Node temp = q.peek();
            if(temp!=null)
            {
                System.out.print(temp.data + " ");// Prints first node of each level

                while (q.peek()!=null) // add children of all nodes at current level
                {
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                    q.remove();
                    temp=q.peek();
                }
                q.add(null); // add delimiter for the next level
            }
            q.remove(); // remove the delimiter of the previous level
        }
    }

}

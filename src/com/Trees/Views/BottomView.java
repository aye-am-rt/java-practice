package com.Trees.Views;

import java.util.*;

/**
Bottom View of a Binary Tree
Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in
 output if x is the bottommost node at its horizontal distance. Horizontal distance of left
 child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal
 distance of x plus 1.

Examples:

20
/    \
8       22
/   \      \
5      3      25
/ \
10    14

For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root, then print the later
 one in level traversal. For example, in the below diagram, 3 and 4 are both the bottom-most nodes
 at horizontal distance 0, we need to print 4.


20
/    \
8       22
/   \    /   \
5      3 4     25
/ \
10    14
For the above tree the output should be 5, 10, 4, 14, 25.

 Method 1 – Using Queue
 The following are steps to print Bottom View of Binary Tree.
 1. We put tree nodes in a queue for the level order traversal.
 2. Start with the horizontal distance(hd) 0 of the root node, keep on adding left child to
 queue along with the horizontal distance as hd-1 and right child as hd+1.
 3. Also, use a TreeMap which stores key value pair sorted on key.
 4. Every time, we encounter a new horizontal distance or an existing horizontal distance put the
 node data for the horizontal distance as key. For the first time it will add to the map, next
 time it will replace the value. This will make sure that the bottom most element for that
 horizontal distance is present in the map and if you see the tree from beneath that you will see
 that element.

 */

public class BottomView {
    static class Node
    {
        int data;
        int hd;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.hd=Integer.MAX_VALUE;
            this.left=this.right=null;
        }
    }
    static class MyTree
    {
        Node root;
        public MyTree(Node aNode){
            this.root=aNode;
        }
        public void BottomView()
        {
            if(root==null)
                return;

            int hd=0;
            Map<Integer,Integer> tMap= new TreeMap<>();
            Queue<Node> queueNodes = new LinkedList<>();
            // Assign initialized horizontal distance value to root node and add it to the queue.
            root.hd=hd;
            queueNodes.offer(root);
            // Loop until the queue is empty (standard level order loop)
            while(!queueNodes.isEmpty())
            {
                Node temp = queueNodes.remove();  // removes the head.
                hd=temp.hd;
                // Put the de-queued tree node to TreeMap having key
                // as horizontal distance. Every time we find a node
                // having same horizontal distance we need to replace
                // the data in the map.
                tMap.put(hd,temp.data);
                if(temp.left!=null) {
                    temp.left.hd = hd - 1;
                    queueNodes.offer(temp.left);
                }
                if(temp.right!=null) {
                    temp.right.hd = hd + 1;
                    queueNodes.offer(temp.right);
                }
            }
            tMap.forEach((K,V)-> System.out.print(V+"  "));
//
//            // Extract the entries of map into a set to traverse
//            // an iterator over that.
//            Set<Map.Entry<Integer, Integer>> set = tMap.entrySet();
//
//            // Make an iterator
//            Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
//
//            // Traverse the map elements using the iterator.
//            while (iterator.hasNext())
//            {
//                Map.Entry<Integer, Integer> me = iterator.next();
//                System.out.print(me.getValue()+" ");
//            }
        }

    }
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        MyTree tree = new MyTree(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.BottomView();
    }

}

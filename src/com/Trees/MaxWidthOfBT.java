package com.Trees;
/**
    Maximum width of a binary tree
    Given a binary tree, write a function to get the maximum width of the given tree.
 Width of a tree is maximum of widths of all levels.
    Let us consider the below example tree.

    1
    /  \
    2    3
    /  \     \
    4    5     8
    /  \
    6    7
    For the above tree,
    width of level 1 is 1,
    width of level 2 is 2,
    width of level 3 is 3
    width of level 4 is 2.
    So the maximum width of the tree is 3.*/

import java.util.LinkedList;
import java.util.Queue;

/**
Method 2 (Using Level Order Traversal with Queue)
        In this method we store all the child nodes at the current level in the queue and then
 count the total number of nodes after the level order traversal for a particular level is completed.
 Since the queue now contains all the nodes of the next level, we can easily find out the total
 number of nodes in the next level by finding the size of queue. We then follow the same procedure
 for the successive levels. We store and update the maximum number of nodes found at each level.*/

public class MaxWidthOfBT {
    static class node
    {
        int data;
        node left, right;

        public node(int data)
        {
            this.data = data;
        }
    }
    public static void main(String[] args)
    {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.right = new node(8);
        root.right.right.left = new node(6);
        root.right.right.right = new node(7);

    /*   Constructed Binary tree is:
                1
              /   \
            2      3
          /  \      \
         4    5      8
                   /   \
                  6     7
         */

     System.out.println("Maximum width = " + maxWidthOfBT(root));
    }

    private static int maxWidthOfBT(node root) {
        // Function to find the maximum width of
        // the tree using level order traversal
        // Base case
            if (root == null)
                return 0;

            // Initialize result
            int maxWidth = 0;

            // Do Level order traversal keeping
            // track of number of nodes at every level
            Queue<node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty())
            {
                // Get the size of queue when the level order
                // traversal for one level finishes
                int count = q.size();

                // Update the maximum node count value
                maxWidth = Math.max(maxWidth, count);

                // Iterate for all the nodes in
                // the queue currently
                while (count-- > 0)
                {
                    // Dequeue an node from queue
                    node temp = q.remove();  // removes head of the linked list.

                    // Enqueue left and right children
                    // of dequeued node
                    if (temp.left != null)
                    {
                        q.add(temp.left);
                    }
                    if (temp.right != null)
                    {
                        q.add(temp.right);
                    }
                }
            }
            return maxWidth;
    }
}

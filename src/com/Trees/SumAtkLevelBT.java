package com.Trees;
//Sum of all nodes at Kth level in a Binary Tree
//        Given a binary tree with N nodes and an integer K, the task is to find the sum of all the nodes
//        present at the Kth level.

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SumAtkLevelBT {
    static class node
    {
        int data;
        node left;
        node right;
    }
    public static node newNode(int val)
    {
        node temp=new node();
        temp.data=val;
        temp.left=temp.right=null;
        return temp;
    }
    public static void main(String[] args)
    {
        node root;
        root = newNode(50);
        root.left = newNode(30);
        root.right = newNode(70);
        root.left.left = newNode(20);
        root.left.right = newNode(40);
        root.right.left = newNode(60);
        int level = 2;
        int initialSum=0;
        int result = sumOfNodesAtNthLevel(root, level,initialSum);
        // Printing the result
        System.out.print(result);
    }

    private static int sumOfNodesAtNthLevel(node root, int level, int iniSum) {
        if (root == null) {
            return iniSum;
        }
        if(level==0)
        {
            return root.data+iniSum;
        }
        int leftSum = sumOfNodesAtNthLevel(root.left,level-1,iniSum);
        int rightSum = sumOfNodesAtNthLevel(root.right,level-1,iniSum);

        return (leftSum + rightSum + iniSum);
    }
    static int sumOfNodesAtNthLevelWithQueue(node root, int k)
    {
        if (root == null)
            return 0;
        Queue<node> que = new LinkedList<>();
        que.add(root);
        // Level is used to track
        // the current level
        int level = 0;

        // To store the sum of nodes
        // at the Kth level
        int sum = 0;

        // flag is used to break out of
        // the loop after the sum of all
        // the nodes at Nth level is found
        int flag = 0;

        // Iterate the queue till its not empty
        while (!que.isEmpty())
        {

            // Calculate the number of nodes
            // in the current level
            int size = que.size();

            // Process each node of the current
            // level and enqueue their left
            // and right child to the queue
            while (size-- >0)
            {
                node ptr = que.peek();
                que.remove();
                // If the current level matches the
                // required level then calculate the
                // sum of all the nodes at that level
                if (level == k)
                {

                    // Flag initialized to 1
                    // indicates that sum of the
                    // required level is calculated
                    flag = 1;

                    // Calculating the sum of the nodes
                    assert ptr != null;
                    sum += ptr.data;
                }
                else {

                    // Traverse to the left child
                    assert ptr != null;
                    if (ptr.left != null)
                        que.add(ptr.left);

                    // Traverse to the right child
                    if (ptr.right != null)
                        que.add(ptr.right);
                }
            }

            // Increment the variable level
            // by 1 for each level
            level++;

            // Break out from the loop after the sum
            // of nodes at K level is found
            if (flag == 1)
                break;
        }
        return sum;
    }

}

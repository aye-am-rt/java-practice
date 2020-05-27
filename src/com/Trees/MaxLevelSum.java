package com.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
Find maximum level sum in Binary Tree
        Given a Binary Tree having positive and negative nodes, the task is to find maximum sum level
 in it.

        Examples:

        Input :               4
        /   \
        2    -5
        / \    /\
        -1   3 -2  6
        Output: 6
        Explanation :
        Sum of all nodes of 0'th level is 4
        Sum of all nodes of 1'th level is -3
        Sum of all nodes of 0'th level is 6
        Hence maximum sum is 6

        Input :          1
        /   \
        2      3
        /  \      \
        4    5      8
        /   \
        6     7
        Output :  17
        Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
        This problem is a variation of maximum width problem. The idea is to do level order traversal of
 tree. While doing traversal, process nodes of different level separately. For every level being
 processed, compute sum of nodes in the level and keep track of maximum sum.*/

public class MaxLevelSum {
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
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left  = new Node(6);
        root.right.right.right  = new Node(7);

    /*   Constructed Binary tree is:
                 1
               /   \
             2      3
           /  \      \
          4    5      8
                    /   \
                   6     7    */
        System.out.println("Maximum level sum is using queue "+ maxLevelSumUsingQ(root));
        System.out.println("Maximum level sum is by recursion "+ maxLevelSumUsingRecursion(root));

    }

    //    Time Complexity : O(n)
    //    Auxiliary Space : O(n)
    private static int maxLevelSumUsingQ(Node root) {
        if(root == null)
            return 0;
        int maxSumFound=root.data;
        Queue<Node> queueNodes = new LinkedList<>();
        queueNodes.offer(root);
        while (!queueNodes.isEmpty())
        {
            int count = queueNodes.size();
            int currSum=0;
            while (count-- >0)
            {
                Node top = queueNodes.poll();
                assert top != null;
                currSum+=top.data;
                if(top.left!=null)
                    queueNodes.offer(top.left);
                if(top.right!=null)
                    queueNodes.offer(top.right);
            }
            maxSumFound = Math.max(currSum,maxSumFound);
        }
        return maxSumFound;
    }


    private static int maxLevelSumUsingRecursion(Node root) {
        int maxHeight = FindMaxLevel(root);
        int[] sumArray = new int[maxHeight+1];
        fillLevelsSumInArray(root,maxHeight,sumArray,1);
        int maxSumFound=0;
        for (int i = 1; i <= maxHeight; i++) {
            maxSumFound = Math.max(maxSumFound,sumArray[i]);
        }
        return maxSumFound;
    }

    private static void fillLevelsSumInArray(Node root, int maxHeight, int[] sumArray, int currLevel) {
        if (root == null || currLevel > maxHeight) {
            return;
        }
        sumArray[currLevel]+=root.data;
        fillLevelsSumInArray(root.left,maxHeight,sumArray,currLevel+1);
        fillLevelsSumInArray(root.right,maxHeight,sumArray,currLevel+1);
    }

    private static int FindMaxLevel(Node root) {
        if(root==null)
            return 0;

        int leftH= FindMaxLevel(root.left);
        int rightH = FindMaxLevel(root.right);
        if(leftH>rightH)
            return leftH+1;
        else
            return rightH+1;

        // return (1 + Math.max( maxLevel(root.left), maxLevel(root.right) ) );  //in short
    }
}

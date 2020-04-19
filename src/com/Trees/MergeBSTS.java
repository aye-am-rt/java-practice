package com.Trees;
//
//Merge two BSTs with limited extra space
//        Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form. The
//        expected time complexity is O(m+n) where m is the number of nodes in first tree and n is the
//        number of nodes in second tree. Maximum allowed auxiliary space is
//        O(height of the first tree + height of the second tree).
//        Examples:
//        First BST
//           3
//        /     \
//        1       5
//        Second BST
//          4
//        /   \
//       2      6
//        Output: 1 2 3 4 5 6

import java.util.Stack;

/**
The idea is to use iterative inorder traversal. We use two auxiliary stacks for two BSTs. Since we need
 to print the elements in sorted form, whenever we get a smaller element from any of the trees, we print
 it. If the element is greater, then we push it back to stack for the next iteration.*/

public class MergeBSTS {
    static class BSTNode
    {
        int data;
        BSTNode left;
        BSTNode right;

        public BSTNode(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[]args)
    {
        BSTNode root1 = null;
        BSTNode root2 = null;

        root1 = new BSTNode(3) ;
        root1.left = new BSTNode(1);
        root1.right = new BSTNode(5);


        root2 = new BSTNode(4) ;
        root2.left = new BSTNode(2);
        root2.right = new BSTNode(6);

        // Print sorted nodes of both trees
        MergeTwoBSTSorted(root1, root2);
    }
    static void PrintInorderOfBST(BSTNode root)
    {
        if (root != null)
        {
            PrintInorderOfBST(root.left);
            System.out.print(root.data + " ");
            PrintInorderOfBST(root.right);
        }
    }

    private static void MergeTwoBSTSorted(BSTNode root1, BSTNode root2) {
        Stack<BSTNode> s1=new Stack<>();
        BSTNode curr1=root1;
        Stack<BSTNode> s2=new Stack<>();
        BSTNode curr2=root2;
        if(root1==null)
            PrintInorderOfBST(root2);
        if(root2==null)
            PrintInorderOfBST(root1);
        while(curr1 !=null || !s1.isEmpty() || curr2 !=null || s2.isEmpty())
        {
            if(curr1 !=null || curr2 !=null)
            {
                if(curr1 !=null)
                {
                    s1.push(curr1);
                    curr1=curr1.left;
                }
                if(curr2 !=null)
                {
                    s2.push(curr2);
                    curr2 = curr2.left;
                }
            }
            else
            {
                if(s1.isEmpty())
                {
                    while(! s2.isEmpty())
                    {
                        curr2=s2.pop();
                        curr2.left=null;
                        PrintInorderOfBST(curr2);
                    }
                    return;
                }
                if(s2.isEmpty())
                {
                    while(! s1.isEmpty())
                    {
                        curr1=s1.pop();
                        curr1.left=null;
                        PrintInorderOfBST(curr1);
                    }
                    return;
                }
                curr1=s1.pop();
                curr2=s2.pop();
                // If element of first tree is smaller, then print it and push the right subtree.
                // If the element is larger,then we push it back to the corresponding stack
                if(curr1.data<curr2.data)
                {
                    System.out.print(curr1.data+" ");
                    curr1=curr1.right;
                    s2.push(curr2);
                    curr2=null;
                }
                else
                {
                    System.out.print(curr2.data+" ");
                    curr2=curr2.right;
                    s1.push(curr1);
                    curr1=null;
                }
            }
        }
        while(!s1.isEmpty())
            System.out.println(s1.pop().data);
        while (!s2.isEmpty())
            System.out.println(s2.pop().data);
    }
}

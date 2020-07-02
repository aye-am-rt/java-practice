package com.Trees;

//This problem can be solved using two stacks. Assume the two stacks are current: current level
// and next level. We would also need a variable to keep track of the current level order(whether
// it is left to right or right to left). We pop from the current level stack and print the nodes value.
// Whenever the current level order is from left to right, push the nodes left child, then its right
// child to the stack next level. Since a stack is a LIFO(Last-In-First_out) structure, next time when
// nodes are popped off next level, it will be in the reverse order. On the other hand, when the current
// level order is from right to left, we would push the nodes right child first, then its left child.
// Finally, do-not forget to swap those two stacks at the end of each level(i.e., when current level is
// empty)

import java.util.Stack;
//    Time Complexity: O(n)
//    Space Complexity: O(n)+(n)=O(n)
public class ZigZagNryTreeG {
    static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data)
        {
            this.data=data;
            this.left=this.right=null;
        }
    }
    //    Time Complexity: O(n)
    //    Space Complexity: O(n)+(n)=O(n)
    static class BinaryTree
    {
        TreeNode root;
        void PrintZigZagTraversal()
        {
            if(root==null)
            {return;}
            Stack<TreeNode> currLevel = new Stack<>();
            Stack<TreeNode> nextLevel = new Stack<>();

            currLevel.push(root);
            boolean goLtoR = true;

            while(!currLevel.isEmpty())
            {
                TreeNode currTop = currLevel.pop();
                System.out.print(currTop.data+" ");

                if(goLtoR)
                {
                    if(currTop.left!=null)
                    {
                        nextLevel.push(currTop.left);
                    }
                    if(currTop.right!=null)
                    {
                        nextLevel.push(currTop.right);
                    }
                }
                else
                {
                    if(currTop.right!=null)
                    {
                        nextLevel.push(currTop.right);
                    }
                    if(currTop.left!=null)
                    {
                        nextLevel.push(currTop.left);
                    }
                }
                if(currLevel.isEmpty())
                {
                    goLtoR = false;
                    Stack<TreeNode> tempStack = currLevel;
                    currLevel = nextLevel;
                    nextLevel =  tempStack;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(7);
        tree.root.left.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.PrintZigZagTraversal();
    }
//    Time Complexity: O(n)
//    Space Complexity: O(n)+(n)=O(n)
}

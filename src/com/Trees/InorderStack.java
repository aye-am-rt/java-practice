package com.Trees;

/*
    Inorder Tree Traversal without Recursion
        Using Stack is the obvious way to traverse tree without recursion. Below is an algorithm for
        traversing binary tree using stack. See this for step wise step execution of the algorithm.
        1) Create an empty stack S.
        2) Initialize current node as root
        3) Push the current node to S and set current = current->left until current is NULL
        4) If current is NULL and stack is not empty then
            a) Pop the top item from stack.
            b) Print the popped item, set current = popped_item->right
            c) Go to step 3.
        5) If current is NULL and stack is empty then we are done.*/

import java.util.LinkedList;
import java.util.Stack;

public class InorderStack {
//    private LinkedList<Integer> adj[];
    static class Node
    {
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            this.left=this.right=null;
        }
    }
    static class BinaryTreeForStack
    {
        Node root;
        BinaryTreeForStack()
        { root = null; }
        void printInorderUsingStack()
        {
            if (root == null)
                return;

            Stack<Node> nodeStack=new Stack<>();
            Node curr=root;
            while(curr!=null || ! nodeStack.isEmpty())
            {
                while (curr !=null)
                {
                    nodeStack.push(curr);
                    curr=curr.left;
                }
                curr=nodeStack.pop();
                System.out.print(curr.data+"  ");
                curr=curr.right;
            }
        }
    }
    public static void main(String args[])
    {

        /* creating a binary tree and entering
        the nodes */
        BinaryTreeForStack tree = new BinaryTreeForStack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printInorderUsingStack();
    }
}

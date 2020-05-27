package com.Trees.Views;

/*Print leaf nodes in binary tree from left to right using one stack
Given a binary tree, the task is to print all leaf nodes of the given binary tree from left to right.
 That is, the nodes should be printed in the order they appear from left to right in the given tree.

Examples:

Input :
1
/  \
2    3
/ \  / \
4  5  6  7
Output : 4 5 6 7

Input :
            4
           /  \
          5    9
         / \  / \
        8   3 7  2
       /         / \
      12        6   1
Output : 12 3 7 6 1


*/
//Approach:The idea is to perform iterative post order traversal using one stack and print the leaf nodes.

import java.util.Stack;

public class PrintLeafNodesBFS {
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
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printLeafLeftToRight(root);
    }

    private static void printLeafLeftToRight(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stackNodes= new Stack<>();
        while(true)
        {
            // If p is not null then push it on the stack
            if(root!=null)
            {
                stackNodes.push(root);
                root=root.left;
            }
            else
            {
                if(stackNodes.isEmpty())
                    break;
                else
                {
                    // If the node on top of the stack has its right subtree as null then pop that node and
                    // print the node only if its left subtree is also null
                    if(stackNodes.peek().right==null)
                    {
                        root=stackNodes.peek();
                        stackNodes.pop();

                        if(root.left==null)
                            System.out.print(root.data+"  ");
                    }
                    while (root==stackNodes.peek().right)
                    {
                        root=stackNodes.peek();
                        stackNodes.pop();
                        if(stackNodes.isEmpty())
                            break;
                    }
                    // If stack is not empty then assign p as
                    // the stack's top node's right child
                    if(!stackNodes.isEmpty())
                        root=stackNodes.peek().right;
                    else
                        root=null;
                }
            }
        }
    }
}

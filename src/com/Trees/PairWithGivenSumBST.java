package com.Trees;

//Find a pair with given sum in a Balanced BST
//Given a Balanced Binary Search Tree and a target sum, write a function that returns true if there is a
// pair with sum equals to target sum, otherwise return false. Expected time complexity is O(n) and only
// O(Logn) extra space can be used. Any modification to Binary Search Tree is not allowed.
// Note that height of a Balanced BST is always O(Logn)

import java.util.Stack;

/**The solution discussed below takes O(n) time, O(Logn) space and doesn’t modify BST. The idea is same as
 * finding the pair in sorted array (See method 1 of this for details). We traverse BST in Normal Inorder
 * and Reverse Inorder simultaneously. In reverse inorder, we start from the rightmost node which is the
 * maximum value node. In normal inorder, we start from the left most node which is minimum value node.
 * We add sum of current nodes in both traversals and compare this sum with given target sum. If the sum
 * is same as target sum, we return true. If the sum is more than target sum, we move to next node in
 * reverse inorder traversal, otherwise we move to next node in normal inorder traversal. If any of the
 * traversals is finished without finding a pair, we return false. Following is C++ implementation of
 * this approach.*/

public class PairWithGivenSumBST {
    static class bstNode
    {
        int data;
        bstNode left,right;

        public bstNode(int data) {
            this.data = data;
            this.left=this.right = null;
        }
    }

    public static void printInorder(bstNode rtNode)
    {
        if(rtNode==null)
            return;

        printInorder(rtNode.left);
        System.out.print(rtNode.data+"  ");
        printInorder(rtNode.right);
    }
    public static bstNode insertInTree(bstNode rtNode, int newVal)
    {
        if(rtNode==null)
        {
            rtNode= new bstNode(newVal);
            return rtNode;
        }

        if(newVal < rtNode.data)
            rtNode.left =  insertInTree(rtNode.left,newVal);
        else
            rtNode.right = insertInTree(rtNode.right,newVal);

        return rtNode;
    }

    public static boolean isPairWithSumPresent(bstNode root, int target)
    {
        Stack<bstNode> s1F_in = new Stack<>();
        Stack<bstNode> s2B_in = new Stack<>();
        // done1, val1 and curr1 are used for normal inorder traversal using s1
        // done2, val2 and curr2 are used for reverse inorder traversal using s2
        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;
        bstNode curr1 = root, curr2 = root;

        // The loop will break when we either find a pair or one of the two traversals is complete
        while(true)
        {
            while (!done1)
            {
                if(curr1 != null)
                {
                    s1F_in.push(curr1);
                    curr1 = curr1.left;
                }
                else
                {
                    if(s1F_in.isEmpty())
                    {
                        done1 = true;
                    }
                    else
                    {
                        curr1 = s1F_in.pop();
                        val1 = curr1.data;
                        curr1 = curr1.right;
                        done1 = true;
                    }
                }
            }


            while (!done2)
            {
                if(curr2 != null)
                {
                    s2B_in.push(curr2);
                    curr2 = curr2.right;
                }
                else
                {
                    if(s2B_in.isEmpty())
                    {
                        done2 = true;
                    }
                    else
                    {
                        curr2 = s2B_in.pop();
                        val2 = curr2.data;
                        curr2 = curr2.left;
                        done2 = true;
                    }
                }
            }

            // If we find a pair, then print the pair and return. The first
            // condition makes sure that two same values are not added
            if(val1 != val2 && (val1+val2)==target)
            {
                System.out.println("pair found with sum= "+target+ " =====> val1= "+val1+" val2= "+val2);
                return true;
            }
            // If sum of current values is smaller, then move to next node in normal inorder traversal
            else if((val1+val2)<target)
            {
                done1 = false;
            }
            // If sum of current values is greater, then move to next node in reverse inorder traversal
            else if ((val1 + val2) > target)
                done2 = false;
            // If any of the inorder traversals is over, then there is no pair so return false
            if (val1 >= val2)
                return false;

        } // while(true) loop ending

    } // function closing

    public static void main(String[] args) {
            /*
                   15
                  /  \
                 10   20
                / \   / \
               8  12 16 25
                          \
                           37   */

        bstNode root = new bstNode(15);
        root.left = new bstNode(10);
        root.right = new bstNode(20);
        root.left.left = new bstNode(8);
        root.left.right = new bstNode(12);
        root.right.left = new bstNode(16);
        root.right.right = new bstNode(25);

        System.out.println(" printing normal in-order traversal of tree = ");
        printInorder(root);

        root = insertInTree(root, 37);

        System.out.println("\n printing normal in-order traversal of tree = ");
        printInorder(root);

        System.out.println("\n====================");

        int target = 33;
        if (! isPairWithSumPresent(root, target))
            System.out.println("No such values are found");
    }
}

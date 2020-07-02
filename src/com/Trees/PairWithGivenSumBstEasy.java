package com.Trees;

import java.util.Stack;

/**
 Pair with a given sum in BST | Set 2
 Given a binary search tree, and an integer X, the task is to check if there exists a pair of
 distinct nodes in BST with sum equal to X. If yes then print Yes else print No.

 Examples:

 Input: X = 5
 5
 /   \
 3     7
 / \   / \
 2   4 6   8
 Output: Yes
 2 + 3 = 5. Thus, the answer is "Yes"

 Input: X = 10
 1
 \
 2
 \
 3
 \
 4
 \
 5
 Output: No

 * Approach: We have already discussed a hash based approach in this article. The space complexity of
 *  this is O(N) where N is the number of nodes in BST.

In this article, we will solve the same problem using a space efficient method by reducing the space
 complexity to O(H) where H is the height of BST. For that, we will use two pointer technique on BST.
 Thus, we will maintain a forward and a backward iterator that will iterate the BST in the order of
 in-order and reverse in-order traversal respectively. Following are the steps to solve the problem:

Create a forward and backward iterator for BST. Let’s say the value of nodes they are pointing at are
 v1 and v2.

Now at each step,
If v1 + v2 = X, we found a pair.
If v1 + v2 < x, we will make forward iterator point to the next element.
If v1 + v2 > x, we will make backward iterator point to the previous element.
If we find no such pair, answer will be “No”.*/

public class PairWithGivenSumBstEasy {
    static class node
    {
        int data;
        node left;
        node right;
        node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args)
    {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(7);
        root.left.left = new node(2);
        root.left.right = new node(4);
        root.right.left = new node(6);
        root.right.right = new node(8);

        int x = 5;

        // Calling required function
        if (IfExistsPair(root, x))
            System.out.print("Yes");
        else
            System.out.print("No");

    }

    private static boolean IfExistsPair(node root, int target) {
        if (root == null)
            throw new IllegalArgumentException();

        Stack<node> fStack = new Stack<>();
        Stack<node> bStack = new Stack<>();

        node f = root;  // Initializing forward iterator
        while (f != null) {
            fStack.push(f);
            f = f.left;
        }

        node b = root;  // Initializing backward iterator
        while (b != null) {
            bStack.push(b);
            b = b.right;
        }
        // Two pointer technique
        while (fStack.peek() != bStack.peek()) {
            // Variables to store values at fStack and bStack
            int v1 = fStack.peek().data, v2 = bStack.peek().data;

            // Base case
            if (v1 + v2 == target)
                return true;

            // Moving forward pointer
            if (v1 + v2 < target) {
                node c = fStack.peek().right;
                fStack.pop();
                while (c != null) {
                    fStack.push(c);
                    c = c.left;
                }
            }
            // Moving backward pointer
            else {
                node c = bStack.peek().left;
                bStack.pop();
                while (c != null) {
                    bStack.push(c);
                    c = c.right;
                }
            }
        }
        // Case when no pair is found
        return false;
    }
}

package com.Trees.Views;

import java.util.Stack;

/**
Approach: An approach to solve this problem has been discussed in this article. In this article,
 an even optimised recursive approach will be discussed.
    In this recursive approach, below are the steps:

    Find the first value recursively, once found add the value to the stack.
    Now every node that is visited whether in backtracking or forward tracking, add the values to
 the stack but if the node was added in the forward tracking then remove it in the backtracking and
 continue this until the second value is found or all nodes are visited.
    For example: Consider the path between 7 and 9 is to be found in the above tree.
 We traverse the tree as DFS, once we find the value 7, we add it to the stack.
 Traversing path 0 -> 1 -> 3 -> 7.
    Now while backtracking, add 3 and 1 to the stack. So as of now, the stack has [7, 3, 1],
 child 1 has a right child so we first add it to the stack. Now, the stack contains [7, 3, 1, 4].
 Visit the left child of 4, add it to the stack. The stack contains [7, 3, 1, 4, 8] now. Since there
 is no further node we would go back to the previous node and since 8 was already added to the stack
 so remove it. Now the node 4 has a right child and we add it to the stack since this is the second
 value we were looking for there won’t be any further recursive calls. Finally, the stack contains
 [7, 3, 1, 4, 9].*/

public class PrintPath2Nodes {
    private static class Node {
        public Node left;
        public int value;
        public Node right;

        public Node(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        Stack<Node> stack = pathBetweenNode(root,5, 9);
        while (!stack.isEmpty())
        {
            int data = stack.pop().value;
            System.out.print(data+"  ");
        }

    }
    private static boolean firstValueFound = false;
    private static boolean secondValueFound = false;
    private static final Stack<Node> stackPath = new Stack<>();
    //private static Node root = null;

    private static Stack<Node> pathBetweenNode(Node root, int n1Data, int n2Data) {
        if (root == null) {
            return new Stack<>();
        }
        if(firstValueFound && secondValueFound)
            return stackPath;

        boolean isAddedToStack=false;
        // If one of the value is found then add the value to the stack and make the
        // isAddedToStack = true
        if(firstValueFound ^ secondValueFound) {
            stackPath.add(root);
            isAddedToStack=true;
        }
        if(! firstValueFound && ! secondValueFound)
            pathBetweenNode(root.left,n1Data,n2Data);

        // Copy of current state of firstValueFound and secondValueFound flag
        boolean localFirstValueFound = firstValueFound;
        boolean localSecondValueFound = secondValueFound;
        if(root.value==n1Data)
            firstValueFound=true;
        if(root.value==n2Data)
            secondValueFound=true;

        boolean localAdded=false;

        if ((firstValueFound ^ secondValueFound || localFirstValueFound ^ localSecondValueFound)
                && !isAddedToStack) {
            localAdded = true;
            stackPath.add(root);
        }
        // If none of the two values is found yet
        if (!(firstValueFound && secondValueFound)) {
            pathBetweenNode(root.right, n1Data, n2Data);
        }
        if ((firstValueFound ^ secondValueFound) && !isAddedToStack && !localAdded)
            stackPath.add(root);
        if ((firstValueFound ^ secondValueFound) && isAddedToStack)
            stackPath.pop();
        return stackPath;
    }
}

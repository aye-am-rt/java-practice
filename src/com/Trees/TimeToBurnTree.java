package com.Trees;
//Minimum time to burn a Tree starting from a Leaf node
//        Given a binary tree and a leaf node from this tree. It is known that in 1s all nodes connected
//        to a given node (left child, right child and parent) get burned in 1 second. Then all the nodes
//        which are connected through one intermediate get burned in 2 seconds, and so on. The task is to
//        find the minimum time required to burn the complete binary tree.
/**
So the solution is to apply recursion and for every node calculate the below-required values:
Left Depth.
Right Depth.
The time required for fire to reach the current node.
Is the current subtree conatins initial burnt leaf node.
So, for the minimum time required to burn any subtree will be:

The time required for fire to reach the root node from initial burnt leaf + depth of the opposite side

Therefore, to find time required to burn the complete tree, we need to calculate the above value for
every node, and take maximum of that value.

ans = max(ans, (time required for fire to reach current node + depth of other subtree))*/

public class TimeToBurnTree {
    // Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    /**
    ***********ADDITIONAL INFO*************
    lDepth - maximum height of left subtree
    rDepth - maximum height of right subtree
    contains - stores true if tree rooted at current node
            contains the first burnt node
    time - time to reach fire from the initially burnt leaf
        node to this node
*/
    static class Data {
        int leftDepth, rightDepth, time;
        boolean contains;
        Data()
        {
            contains = false;
            leftDepth = rightDepth = 0;
            time = -1;
        }
    }
    public static int res;
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(11);

        int target = 11;
        res = 0;
        getResultTimeToBurn(root, new Data(), target);
        System.out.println(res);
    }

    private static void getResultTimeToBurn(Node node, Data data, int startTarget) {
        if (node == null) {
            return;
        }
        if(node.left==null && node.right==null)
        {
            if(node.data==startTarget)
            {
                data.contains=true;
                data.time=0;
            }
            return;
        }
        Data leftData=new Data();
        getResultTimeToBurn(node.left,leftData,startTarget);
        Data rightData=new Data();
        getResultTimeToBurn(node.right,rightData,startTarget);

        // If left subtree contains the fired node then time required to reach fire to current node
        // will be (1 + time required for left child)
        //data.time=(leftData.contains)?(leftData.time+1):-1;
        if(leftData.contains && !rightData.contains) {
            data.time = leftData.time + 1;
            data.contains=true;
        }
        else if(rightData.contains && !leftData.contains) {
            data.time = rightData.time + 1;
            data.contains=true;
        }

        data.leftDepth=(node.left==null)?0:(1+Math.max(leftData.leftDepth,leftData.rightDepth));
        data.rightDepth=(node.right==null)?0:(1+Math.max(rightData.leftDepth,rightData.rightDepth));

        if(data.contains)
        {
            if(leftData.contains)
                res = Math.max(res,data.time+data.rightDepth);
            if(rightData.contains)
                res = Math.max(res,data.time+data.leftDepth);
        }
    }
}

package com.Trees;

/*Print the longest leaf to leaf path in a Binary tree
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two
end nodes. In this post, we will see how to print the nodes involved in the diameter of the tree.
The diagram below shows two trees each with diameter nine, the leaves that form the ends of the
longest path are shaded (note that there is more than one path in each tree of length nine, but no
path longer than nine nodes).*/

/**
We have already discussed how to find the diameter of a binary tree.Diameter of a Binary tree

We know that Diameter of a tree can be calculated by only using the height function because the
 diameter of a tree is nothing but the maximum value of (left_height + right_height + 1) for each node.
Now for the node which has the maximum value of (left_height + right_height + 1), we find the longest
 root to leaf path on the left side and similarly on the right side. Finally, we print left
 side path, root and right side path.
Time Complexity is O(N). N is the number of nodes in the tree.*/

public class LongestLeafToLeaf {
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
        // Enter the binary tree ...
        //           1
        //         /   \
        //        2     3
        //      /   \
        //     4     5
        //      \   / \
        //       8 6   7
        //      /
        //     9
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.left.left.right = new Node(8);
        root.left.left.right.left = new Node(9);
        System.out.println("diameter then distance to leaf to leaf: ");
        Diameter(root);

    }

    private static void Diameter(Node root) {
        if (root == null) {
            return;
        }
        int ansHeight=Integer.MIN_VALUE;
        int lh=0;
        int rh=0;
        // f is a flag whose value helps in printing
        // left & right part of the diameter only once
        int f=0;
        Node k=new Node(-1);
        int heightOfTree=height(root,ansHeight,k,lh,rh,f);
        System.out.println("height of tree == "+heightOfTree);
        int[] lPath=new int[50];
        int pathLength=0;
        printPathRecursive(k.left,lPath,pathLength,lh,f);
        System.out.print(k.data+"  ");
        int[] rPath = new int[50];
        f=1;
        printPathRecursive(k.right,rPath,pathLength,rh,f);


    }

    private static void printPathRecursive(Node node, int[] pathArray, int pLength, int maxH, int flag) {
        if (node == null) {
            return;
        }
        pathArray[pLength]=node.data;
        pLength++;
        // If it's a leaf, so print the path that led to here
        if (node.left == null && node.right==null) {
            if(pLength==maxH && (flag==0 || flag==1))
            {
                printPathArrayByFlag(pathArray,pLength,flag);
                flag=2;
            }
        }
        else
        {
            printPathRecursive(node.left,pathArray,pLength,maxH,flag);
            printPathRecursive(node.right,pathArray,pLength,maxH,flag);
        }
    }

    private static void printPathArrayByFlag(int[] pathArray, int pLength, int flag) {
        if(flag==0)
        {// print left part of the path in reverse order
            for (int i = pLength-1; i >-1; i--) {
                System.out.print(pathArray[i]+"  ");
            }
        }
        else if(flag==1)
        {// print right part of the path
            for (int i = 0; i <pLength; i++) {
                System.out.print(pathArray[i]+"  ");
            }
        }
    }

    private static int height(Node root, int ansHeight, Node k, int lh, int rh, int f) {
        if (root == null) {
            return 0;
        }
        int leftHeight= height(root.left,ansHeight,k,lh,rh,f);
        int rightHeight= height(root.right,ansHeight,k,lh,rh,f);
        // update the answer, because diameter of a tree is nothing but maximum value of
        // (left_height + right_height + 1) for each node
        if((1+leftHeight+rightHeight) > ansHeight)
        {
            ansHeight=1+leftHeight+rightHeight;
            k=root;
            lh=leftHeight;
            rh=rightHeight;
        }

        return (1+Math.max(leftHeight,rightHeight));
    }
}

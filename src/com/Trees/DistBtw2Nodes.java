package com.Trees;
/**Find distance between two nodes of a Binary Tree
        Find the distance between two keys in a binary tree, no parent pointers are given. Distance
        between two nodes is the minimum number of edges to be traversed to reach one node from other.

Better Solution :
We first find LCA of two nodes. Then we find distance from LCA to two nodes.
*/

public class DistBtw2Nodes {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left=this.right=null;
        }
    }
    // Driver program to test above functions 
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));

        System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));

        System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));

        System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));

        System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));

    }

    private static int findDistance(Node root, int n1Data, int n2Data) {
        Node lca= FindLCA(root,n1Data,n2Data);
        int d1= findLevel(lca,n1Data,0);
        int d2= findLevel(lca,n2Data,0);
        return (d1+d2);
    }

    private static int findLevel(Node aNode, int dataToFind, int level) {
        if (aNode == null) {
            return -1;
        }
        if(aNode.value==dataToFind)
            return level;

        int left=findLevel(aNode.left,dataToFind,level+1);

        if(left==-1)
            return findLevel(aNode.right,dataToFind,level+1);
        else
            return left;
    }

    private static Node FindLCA(Node root, int n1Data, int n2Data) {
        if(root==null)
            return null;
        if(root.value==n1Data || root.value==n2Data)
            return root;

        Node leftLca=FindLCA(root.left,n1Data,n2Data);
        Node rightLca=FindLCA(root.right,n1Data,n2Data);

        if (leftLca != null && rightLca!=null) {
            return root;
        }
        if (leftLca != null) {
            return leftLca;
        }
        else
            return rightLca;
    }
}

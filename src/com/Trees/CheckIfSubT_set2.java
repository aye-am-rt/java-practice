package com.Trees;

import java.util.ArrayList;

/**
Check if a binary tree is subtree of another binary tree | Set 2
Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is
 a tree S consisting of a node in T and all of its descendants in T.
The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other
 node is called a proper subtree.

For example, in the following case, Tree1 is a subtree of Tree2.
Tree1
x
/    \
a       b
\
c


Tree2
z
/   \
x      e
/    \     \
a       b      k
\
c
 The idea is based on the fact that inorder and preorder/postorder uniquely identify a binary tree.
 Tree S is a subtree of T if both inorder and preorder traversals of S arew substrings of inorder
 and preorder traversals of T respectively.

 Following are detailed steps.

 1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].

 2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].

 3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.

 We can also use postorder traversal in place of preorder in the above algorithm.

 */

public class CheckIfSubT_set2 {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
        }
    }
    public static void main(String[] args)
    {

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        if (isSubtree(root1, root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }

    private static boolean isSubtree(Node tree1, Node subT2) {
        if(subT2==null)
            return true;
        if (tree1 == null) {
            return false;
        }
        StringBuilder inOrderT1 = new StringBuilder();
        storeInOrder(tree1,inOrderT1);
        StringBuilder inOrderSubT2 = new StringBuilder();
        storeInOrder(subT2,inOrderSubT2);

        // If inS[] is not a substring of preS[], return false
        System.out.println("in1 = "+inOrderT1.toString().substring(1));
        System.out.println("in2 sub = "+inOrderSubT2.toString().substring(1));
        if (checkAreSubStrings(inOrderT1.toString().substring(1), inOrderSubT2.toString().substring(1)) == null) {
            return false;
        }

        StringBuilder preOrderT1 = new StringBuilder();
        storePreOrder(tree1,preOrderT1);
        StringBuilder preOrderSubT2 = new StringBuilder();
        storePreOrder(subT2,preOrderSubT2);

        System.out.println("pre1 = "+preOrderT1.toString().substring(1));
        System.out.println("pre1 = "+preOrderSubT2.toString().substring(1));
        // If inS[] is not a substring of preS[], return false Else return true
        return (checkAreSubStrings(preOrderT1.toString().substring(1), preOrderSubT2.toString().substring(1)) != null);
    }

    private static String checkAreSubStrings(String str1Big, String str2Small) {
        if(str1Big==null || str2Small==null)
            return null;
        int stL1=str1Big.length();
        int stL2=str2Small.length();
       // System.out.println("stl1 = "+stL1+" and stl2 = "+stL2);
        if(stL1<stL2)
            return null;
        if(stL2==0)
            return str1Big;

        for (int i = 0; i <= (stL1-stL2); i++) {
            if(str1Big.charAt(i)==str2Small.charAt(0))
            {
                int j;
                for (j = 0; j < stL2; j++) {
                    if(str1Big.charAt(i+j)!=str2Small.charAt(j))
                        break;
                }
                //System.out.println("j final = "+j);
                if(j==str2Small.length()) {
                    //System.out.println("returning strBig sub str = "+str1Big.substring(i));
                    return str1Big.substring(i);
                }
            }
        }
        return null;
    }

    private static void storePreOrder(Node rtNode, StringBuilder sbIn) {
        if (rtNode == null) {
            return;
        }
        sbIn.append("_").append(rtNode.data);
        storePreOrder(rtNode.left,sbIn);
        storePreOrder(rtNode.right,sbIn);
    }

    private static void storeInOrder(Node rtTree,StringBuilder sbPre) {
        if(rtTree==null)
            return;
        storeInOrder(rtTree.left,sbPre);
        sbPre.append("_").append(rtTree.data);
        storeInOrder(rtTree.right,sbPre);
    }


}

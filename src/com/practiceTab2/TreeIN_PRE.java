package com.practiceTab2;
import java.util.HashMap;


/** Algorithm: buildTree()
        1) Pick an element from PreOrder. Increment a PreOrder
            Index Variable (preIndex in below code) to pick next element in next recursive call.

        2) Create a new tree node tNode with the data as picked element.
        3) Find the picked element’s index in Inorder. Let the index be inIndex.
        4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
        5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
        6) return tNode.*/

public class TreeIN_PRE {
    static class Node
    {
        char data;
        Node left, right;

        public Node(char item)
        {
            data = item;
            left = right = null;
        }
    }
    static class BinaryTree {
        Node root;
        static int preIndex = 0;

        /* Recursive function to construct binary of size len from
           Inorder traversal in[] and PreOrder traversal pre[].
           Initial values of inStrt and inEnd should be 0 and len -1.
           The function doesn't do any error checking for cases where
           inorder and preOrder do not form a tree */
        static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd, HashMap<Character, Integer> mp)
        {
            if (inStrt > inEnd)
                return null;

        /* Pick current node from PreOrder traversal using preIndex and increment preIndex */
            Node tNode = new Node(pre[preIndex++]);

            /* If this node has no children then return */
            if (inStrt == inEnd)
                return tNode;

            /* Else find the index of this node in Inorder traversal */
            int inIndex = mp.get(tNode.data);

        /* Using index in Inorder traversal, construct left and right subtress */
            tNode.left = buildTree(in, pre, inStrt, inIndex - 1, mp);
            tNode.right = buildTree(in, pre, inIndex + 1, inEnd, mp);

            return tNode;
        }

        /* UTILITY FUNCTIONS */
        /* This function is here just to test buildTree() */
        void printInorder(Node node)
        {
            if (node == null)
                return;
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
        // This function mainly creates an unordered_map, then
        // calls buildTree()  Time Complexity : O(n)
        static Node buildTreeWrap(char[] in, char[] pre, int len)
        {
            // Store indexes of all items so that we
            // we can quickly find later
            HashMap<Character,Integer> mp=new HashMap<>();
            for (int i = 0; i < len; i++)
                mp.put(in[i],i);

            return buildTree(in, pre, 0, len - 1, mp);
        }
        // Time Complexity : O(n)
        // driver program to test above functions
        public static void main(String[] args)
        {
            BinaryTree tree = new BinaryTree();
            char[] in = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
            char[] pre = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
            int len = in.length;
            Node root = buildTreeWrap(in, pre, len);

            // building the tree by printing inorder traversal
            System.out.println("Inorder traversal of constructed tree is : ");
            tree.printInorder(root);
        }
    } }

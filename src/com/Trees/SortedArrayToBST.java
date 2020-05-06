package com.Trees;
/**
Sorted Array to Balanced BST
Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.
Examples:

Input:  Array {1, 2, 3}
Output: A Balanced BST
2
/  \
1    3

Input: Array {1, 2, 3, 4}
Output: A Balanced BST
        3
      /  \
    2    4
   /
 1
 */

/**Algorithm
In the previous post, we discussed construction of BST from sorted Linked List. Constructing from
 sorted array in O(n) time is simpler as we can get the middle element in O(1) time.
 Following is a simple algorithm where we first find the middle node of list and make
 it root of the tree to be constructed.

1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
a) Get the middle of left half and make it left child of the root
created in step 1.
b) Get the middle of right half and make it right child of the
root created in step 1.*/
public class SortedArrayToBST {
    static class treeNode
    {
        int data;
        treeNode left,right;
        public treeNode(int data)
        {
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        treeNode root = sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Pre order traversal of constructed BST");
        printPreOrder(root);
    }

    private static treeNode sortedArrayToBST(int[] arr, int left, int right) {
        if(left>right)
            return null;
        int mid=(left+right)/2;
        treeNode nodeAtMid = new treeNode(arr[mid]);
        nodeAtMid.left = sortedArrayToBST(arr,left,mid-1);
        nodeAtMid.right = sortedArrayToBST(arr,mid+1,right);
        return nodeAtMid;
    }

    static void printPreOrder(treeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}

/**   Time Complexity: O(n)
Following is the recurrence relation for sortedArrayToBST().

T(n) = 2T(n/2) + C
T(n) -->  Time taken for an array of size n
C   -->  Constant (Finding middle of array and linking root to left and right subtrees take constant time)*/

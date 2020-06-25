package com.Arrays.ArrayInversions;
/**
Approach:
We will iterate backwards in the array and store each element into the Trie. To store a number
 in Trie we
have to break the number into its binary form and If the bit is 0 then it signifies we store
that bit into the left pointer of the current node and if it is 1 we will store it into the
right pointer of the current node and correspondingly change the current node. We will also
maintain the count which signifies how many numbers follow the same path till that node.

Structure of Node of the Trie

struct node{
int count;
node* left;
node* right;
};
At any point, while we are storing the bits, we happen to move to the right pointer
 (i.e the bit is 1) we will check if the left child exists then this means there are numbers
 which are smaller than the current number who are already been stored into the Trie, these numbers
 are only the inversion count so we will add these to the count.*/

public class CountInversionTireDS {
    // Structure of the node
    static class trieNode
    {
        int count;
        trieNode left;
        trieNode right;
    }
    static trieNode makeNewNode()
    {
        trieNode temp = new trieNode();
        temp.count = 1;
        temp.left = null;
        temp.right = null;
        return temp;
    }
    public static void main(String[] args)
    {
        int[] arr= { 8, 4, 2, 1 };
        int n = arr.length;
        System.out.print("Number of inversions are : " + getInvCount(arr, n));
    }

    private static int getInvCount(int[] arr, int ln) {
        trieNode head = makeNewNode();
        ans = 0;
        // run opposite loop .. see carefully
        for (int i = (ln-1); i > -1; i--) {
            // inserting each element in Trie
            InsertNewTrie(arr[i], head);
        }
        return ans;
    }


    static int ans;
    public static void InsertNewTrie(int num, trieNode root)
    {
        // Converting the number into binary form from 63 bit to 0 decreasing(64 bits)
        for (int i = 63; i > -1; i--) {
            int bit = (num & (1 << i));  // left shift ==> 1 * 2^i times

            if(bit != 0)  // means 1
            {
                // if the bit is 1 that means we have to go to the right
                // but we also checks if left pointer exists i.e there is
                // at least a number smaller than the current number already in
                // the trie we add that count to ans
                if(root.left!=null)
                    ans+=root.left.count;

                // If right pointer is present we just iterate to that position and
                // increment the count
                if(root.right!=null)
                {
                    root =  root.right;
                    root.count+=1;
                }
                // else If right is null we add a new node over there and initialize
                // the count with 1
                else
                {
                    root.right = makeNewNode();
                    root = root.right;
                }
            }
            else // means bit is 0
            {
                // We have to iterate to left, we first check if left exists? if yes then change
                // the root and the count
                if (root.left != null) {
                    root=root.left;
                    root.count++;
                }
                // otherwise we create the left node a new trie-node
                else
                {
                    root.left = makeNewNode();
                    root=root.left;
                }
            }
        }
    }
}

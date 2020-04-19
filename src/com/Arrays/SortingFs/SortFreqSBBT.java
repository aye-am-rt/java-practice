package com.Arrays.SortingFs;

import java.util.Arrays;
import java.util.Comparator;

/** Implementations
Data structures implementing this type of tree include:

2–3 tree , AA tree,  AVL tree ,B-tree , Red–black tree . Scapegoat tree,  Splay tree,  Treap,
Weight-balanced tree

Applications
Self-balancing binary search trees can be used in a natural way to construct and maintain ordered lists,
such as priority queues. They can also be used for associative arrays; key-value pairs are simply inserted
with an ordering based on the key alone. In this capacity, self-balancing BSTs have a number of
advantages and disadvantages over their main competitor, hash tables. One advantage of self-balancing
BSTs is that they allow fast (indeed, asymptotically optimal) enumeration of the items in key order,
which hash tables do not provide. One disadvantage is that their lookup algorithms get more complicated
when there may be multiple items with the same key. Self-balancing BSTs have better worst-case lookup
performance than hash tables (O(log n) compared to O(n)), but have worse average-case performance
(O(log n) compared to O(1)).

Self-balancing BSTs can be used to implement any algorithm that requires mutable ordered lists,
to achieve optimal worst-case asymptotic performance. For example, if binary tree sort is implemented
with a self-balanced BST, we have a very simple-to-describe yet asymptotically optimal O(n log n) sorting
algorithm. Similarly, many algorithms in computational geometry exploit variations on self-balancing BSTs
to solve problems such as the line segment intersection problem and the point location problem efficiently.
(For average-case performance, however, self-balanced BSTs may be less efficient than other solutions.
Binary tree sort, in particular, is likely to be slower than merge sort, quick-sort, or heapsort,
because of the tree-balancing overhead as well as cache access patterns.)

Self-balancing BSTs are flexible data structures, in that it's easy to extend them to efficiently
record additional information or perform new operations. For example, one can record the number of
nodes in each subtree having a certain property, allowing one to count the number of nodes in a
certain key range with that property in O(log n) time. These extensions can be used, for example,
to optimize database queries or other list-processing algorithm*/

public class SortFreqSBBT {
    static class BSTNode
    {
        int data;
        int freq;
        BSTNode left,right;

        public BSTNode(int data) {
            this.data = data;
            this.freq = 1;
            this.left = null;
            this.right = null;
        }
    }
    static BSTNode insert(BSTNode node, int data)
    {
        if (node == null)
            return (new BSTNode(data));

        if(data==node.data)
            node.freq+=1;
        else if (data < node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }
    static class dataFreq
    {
        int data;
        int freq;

        public dataFreq(int data,int freq) {
            this.data = data;
            this.freq=freq;
        }

        @Override
        public String toString() {
            return "dataFreq{" +
                    "data=" + data +
                    ", freq=" + freq +
                    '}';
        }
    }
    static void printInorder(BSTNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + "--"+node.freq+"  ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // Function to copy elements and their frequencies to count[].
    static void store(BSTNode root, dataFreq[] count, int index)
    {
        // Base Case
        if (root == null) return;

        // Recur for left subtree
        store(root.left, count, index);

        // Store item from root and increment index
        count[index].freq = root.freq;
        count[index].data = root.data;
        index++;

        // Recur for right subtree
        store(root.right, count, index);
    }
    /*  Compare frequencies to sort the array according to decreasing order of frequency */
    static class SortComparator implements Comparator<dataFreq>
    {

        SortComparator(dataFreq[] dataFreqArray) {
        }

        @Override
        public int compare(dataFreq a,dataFreq b)
        {
            return(b.freq-a.freq);
        }
    }
    static String sortByFrequencySBBST(int[] arr, int n)
    {
        BSTNode root=null;
        for (int i = 0; i < n; ++i)
            root = insert(root, arr[i]);

        printInorder(root);
        System.out.println();
        // Create an auxiliary array 'count[]' to store data and
        // frequency pairs. The maximum size of this array would
        // be n when all elements are different
        dataFreq[] count=new dataFreq[n];
        for (int i = 0; i < n; i++) {
            count[i]=new dataFreq(i,1);
        }
        int index = 0;
        System.out.println(Arrays.toString(count));
        store(root, count, index);
        System.out.println(Arrays.toString(count));

        // Sort the count[] array according to frequency (or count)
        SortComparator comp=new SortComparator(count);
        Arrays.sort(count,comp);
        // Finally, traverse the sorted count[] array and copy the
        // i'th item 'freq' times to original array 'arr[]'
        int j = 0;
        for (int i = 0; i < index; i++)
        {
            for (int freq = count[i].freq; freq > 0; freq--)
                arr[j++] = count[i].data;
        }
    return Arrays.toString(arr);
    }
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        int n = arr.length;
        System.out.println(sortByFrequencySBBST(arr, n));
    }
}

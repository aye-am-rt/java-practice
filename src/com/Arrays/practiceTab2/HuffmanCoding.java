package com.Arrays.practiceTab2; 
//Huffman Coding | Greedy Algo-3
//Prefix Codes, means the codes (bit sequences) are assigned in such a way that the code assigned to
// one character is not the prefix of code assigned to any other character. This is how Huffman Coding
// makes sure that there is no ambiguity when decoding the generated bit stream.
//Let us understand prefix codes with a counter example. Let there be four characters a, b, c and d,
// and their corresponding variable length codes be 00, 01, 0 and 1. This coding leads to ambiguity
// because code assigned to c is the prefix of codes assigned to a and b. If the compressed bit stream
// is 0001, the de-compressed output may be “cccd” or “ccb” or “acd” or “ab”.
//See this for applications of Huffman Coding.
//
//There are mainly two major parts in Huffman Coding
//1) Build a Huffman Tree from input characters.
//2) Traverse the Huffman Tree and assign codes to characters.

//Steps to build Huffman Tree
//Input is an array of unique characters along with their frequency of occurrences and output is
// Huffman Tree.
//1. Create a leaf node for each unique character and build a min heap of all leaf nodes
// (Min Heap is used as a priority queue. The value of frequency field is used to compare two nodes in
// min heap. Initially, the least frequent character is at root)
//2. Extract two nodes with the minimum frequency from the min heap.
//3. Create a new internal node with a frequency equal to the sum of the two nodes frequencies.
// Make the first extracted node as its left child and the other extracted node as its right child.
// Add this node to the min heap.
//4. Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root
// node and the tree is complete.

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCoding {
    static class HuffManNode
    {
        int freqOfChar;
        char charInNode;
        HuffManNode left,right;

        public HuffManNode(int data, char c) {
            this.freqOfChar = data;
            this.charInNode = c;
            this.left=this.right=null;
        }
    }
    static class MyComparator implements Comparator<HuffManNode>
    {
        @Override
        public int compare(HuffManNode x, HuffManNode y) {
            return (x.freqOfChar-y.freqOfChar);
        }
    }
    public static void PrintHuffmanCodedStringRECUR(HuffManNode root, String s)
    {
        if(root.left==null && root.right==null && Character.isLetter(root.charInNode))
        {
            System.out.println(root.charInNode+" : "+s);
            return;
        }
        //assert root.left != null;
        PrintHuffmanCodedStringRECUR(root.left,s+"0");
        PrintHuffmanCodedStringRECUR(root.right,s+"1");
    }
    public static void main(String[] args)
    {

       // Scanner scanner = new Scanner(System.in);
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFreqArray = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffManNode> pqHF=new PriorityQueue<>(n, new MyComparator());
        // initial Capacity and comparator to compare objects inside this pr.Queue so that it can
        // sort them using this.
        for (int i = 0; i < n; i++) {
            HuffManNode hn=new HuffManNode(charFreqArray[i],charArray[i]);
            pqHF.add(hn);
        }
        HuffManNode root=null;
        // Here we will extract the two minimum value from the heap each time until
        // its size reduces to 1, extract until all the nodes are extracted.
        while(pqHF.size()>1)
        {
            HuffManNode x=pqHF.poll(); //// first min extract.
            HuffManNode y=pqHF.poll(); //// second min extract.

            assert y != null;
            HuffManNode newNode= new HuffManNode((x.freqOfChar+y.freqOfChar),'-');
            newNode.left=x;
            newNode.right=y;
            root=newNode;
            pqHF.add(root);
        }
        assert root != null;
        PrintHuffmanCodedStringRECUR(root,"");
    }
}
//    Time complexity: O(nlogn) where n is the number of unique characters. If there are n nodes,
//    extractMin() is called 2*(n – 1) times. extractMin() takes O(logn) time as it calles
//    minHeapify(). So, overall complexity is O(nlogn).

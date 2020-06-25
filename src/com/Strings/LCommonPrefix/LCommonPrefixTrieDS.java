package com.Strings.LCommonPrefix;

import java.util.Arrays;

public class LCommonPrefixTrieDS {
    public static void main(String[] args)
    {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        int n = arr.length;
        String ans = LCommonPrefixUsingTrie(arr, n);
        if (ans.length() != 0)
            System.out.println("The longest common prefix is == "+ans);
        else
            System.out.println("There is no common prefix");
    }
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isLeaf is true if the node represents end of a word
        boolean isLeaf;

        public TrieNode() {  // constructor
            isLeaf = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }

        @Override
        public String toString() {
            return "{" + "children=" + Arrays.toString(children) + ",isLeaf=" + isLeaf + '}';
        }
    }
    static TrieNode root;
    static int indexStat;
    private static String LCommonPrefixUsingTrie(String[] arr, int ln) {
        root = new TrieNode();
        constructTrie(arr,ln);
        //System.out.println(" after inserting = ");
        //System.out.println(root.toString());
        // Perform a walk on the trie
        return walkTrie();
    }
    private static void constructTrie(String[] arr, int ln) {
        for (int i = 0; i < ln; i++) {
            insertInTrie(arr[i]);
        }
    }
    // If not present, inserts the key into the trie
    // If the key is a prefix of trie node, just marks leaf node
    private static void insertInTrie(String key) {
        int keyLen = key.length();
        int index;
        TrieNode  pCrawl = root;
        for (int level = 0; level < keyLen; level++) {
            //index = Character.getNumericValue(key.charAt(level));
            index = key.charAt(level) - 'a';

            if(pCrawl.children[index]==null)
            {
                pCrawl.children[index]= new TrieNode();
            }

            pCrawl = pCrawl.children[index];
        }
        // after for loop -- mark last node as leaf
        pCrawl.isLeaf = true;
    }

    // Perform a walk on the trie and return the longest common prefix string
    private static String walkTrie() {
        TrieNode pCrawl2 = root;
        indexStat = 0;
        StringBuilder sblPrefixAns=new StringBuilder();

        while (countChildren(pCrawl2) == 1 && ! pCrawl2.isLeaf)
        {
            pCrawl2 = pCrawl2.children[indexStat];
            //System.out.print("addingChar = "+(char)('a' + indexStat)+"  ");
            sblPrefixAns.append((char)('a' + indexStat));

        }
        //System.out.println(" sblPrefixAns.toString() = "+sblPrefixAns.toString());
        return sblPrefixAns.toString();
    }

    // Counts and returns the number of children of the current node
    private static int countChildren(TrieNode anyNode) {
        int count =0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if(anyNode.children[i]!=null) {
                count++;
                indexStat = i;
            }
        }
        //System.out.println(" current count = "+count);
        return count;
    }
}




/*Time Complexity : Inserting all the words in the trie takes O(MN) time and performing a walk
on the trie takes O(M) time, where-
N = Number of strings
M = Length of the largest string
Auxiliary Space: To store all the strings we need to allocate O(26*M*N) ~ O(MN) space
 for the Trie.*/

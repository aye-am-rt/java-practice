package com.Trees;

import com.Trees.Views.PrintLeafNodesBFS;

import java.util.*;

/**Print all nodes at distance K from given node: Iterative Approach
Given a binary tree, a target node and an integer K, the task is to find all the nodes that are at
 distance K from the given target node.

 Approach:
 There are generally two cases for the nodes at a distance of K:
 Node at a distance K is a child node of the target node.
 Node at a distance K is the ancestor of the target node.
 The idea is to store the parent node of every node in a hash-map with the help of the Level-order
 traversal on the tree. Then, Simply Traverse the nodes from the Target node using Breadth-First Search
 on the left-child, right-child, and the parent node. At any instant when the distance of a node the
 from the target node is equal to K then print all the nodes of the queue.
 */

public class PrintAllKDistanceNodes {
    static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left=this.right=null;
        }

        @Override
        public String toString() {
            return "("+this.data+")=>{"
                    +" left's data = "+this.left.data
                    +", right's data = "+this.right.data+" }";
        }
    }
    public static void main(String[] args)
    {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.left = new Node(5);
        root.right.right = new Node(8);
        root.left.left = new Node(4);
        root.left.left.left = new Node(25);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.left.left = new Node(15);
        root.left.right.left.right = new Node(18);
        root.left.right.left.right.right = new Node(23);
        root.left.right.right = new Node(14);
        Node target = root.left.right;
        System.out.println("printing in-order traversal ");
        printInOrderTree(root);
        System.out.println("\ntarget == "+target.data);
        storeParent(root);
        nodeAtDistK(root, target, 3);

    }

    // Function to find the nodes at distance K from give node
    private static void nodeAtDistK(Node root, Node target, int KDist) {
        // Keep track of each node which are visited so that while doing BFS we will
        // not traverse it again
        HashSet<Node> visitedSet = new HashSet<>();
        int dist=0;
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        visitedSet.add(target);
        //System.out.println("visited set = "+visitedSet);
        // Loop to iterate over the nodes until the queue is not empty
        while(!q.isEmpty())
        {
            if(dist==KDist)
            {
                while(!q.isEmpty())
                {
                    System.out.print(q.poll().data+"  ");
/*                  if(q.peek()!=null)   // same thing doing as upper line just more checking
                    { System.out.print(q.peek().data + "  "); }
                    else
                    { System.out.print(" NULL "); }
                    q.remove();*/
                }
            }
            int qSize=q.size();
            System.out.println("q.size()= "+qSize);
            //System.out.println("curr Vis set = "+visitedSet);
            for (int i = 0; i < qSize; i++) {
                Node p = q.poll();
                if(p!=null) {
                    System.out.println("polled node data== "+p.data+" ** for dist = "+dist);
                    // if the left of node is not visited yet then push it in queue and
                    // insert it in set as well
                    if (p.left != null && !visitedSet.contains(p.left)) {
                        q.add(p.left);
                        visitedSet.add(p.left);
                    }
                    // if the right of node is not visited yet then push it in queue and
                    // insert it in set as well
                    if (p.right != null && !visitedSet.contains(p.right)) {
                        q.add(p.right);
                        visitedSet.add(p.right);
                    }
                    // if the parent of node is not visited yet then push it in queue and
                    // insert it in set as well
                    if (hMapNodes.containsKey(p)
                            && !visitedSet.contains(hMapNodes.get(p))
                            && hMapNodes.get(p)!=null)
                    {
                        q.add(hMapNodes.get(p));
                        visitedSet.add(hMapNodes.get(p));
                    }
                }
            }
            dist++;
        }
    }

    // Map to store the parent node of every node of the given Binary Tree
    static HashMap<Node,Node> hMapNodes= new HashMap<>()
    { // we don't need to override hashMaps toString method its just calling super.toString so we just
        // need to override toString in our node class and it will print. i realized that after i did all
        // this and it looks badass that's why i left it like this otherwise no use.

        @Override
        public String toString()
        {
            for (Map.Entry<Node,Node> entry : hMapNodes.entrySet())
            {
                if(entry.getKey()!=null && entry.getValue()!=null) {
                    System.out.print("{ " + entry.getKey().data + ":" + entry.getValue().data + " }, ");
                }
                else
                {
                    if(entry.getKey()==null)
                        System.out.print("{ " + "NULL" + ":" + entry.getValue().data + " }, ");
                    else
                        System.out.print("{ " + entry.getKey().data + ":" + "NULL" + " }, ");
                }
            }
            return " END ";  // here by default it was returning super().toString().
        }
    };

    // Function to store all nodes parent in hash Map
    private static void storeParent(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node p = q.poll();  // front node we want to get
            if(p==root) // Condition if the node is a  root node that storing its parent as NULL
            {
                hMapNodes.put(p,null);
            }
            if(p.left!=null)
            {
                hMapNodes.put(p.left,p);
                q.add(p.left);
            }
            if(p.right!=null)
            {
                hMapNodes.put(p.right, p);
                q.add(p.right);
            }
        }
//        System.out.print("queue after = ");
//        System.out.println(q);
        System.out.println("hash map of nodes and their parents => { Node data:Parent data} == ");
        System.out.println(hMapNodes);
    }
    private static void printInOrderTree(Node root) {
        if(root==null)
            return;
        printInOrderTree(root.left);
        System.out.print(root.data+"  ");
        printInOrderTree(root.right);
    }
}

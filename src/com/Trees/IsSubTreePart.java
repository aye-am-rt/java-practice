package com.Trees;

import java.util.Stack;

public class IsSubTreePart {
    static class Node {
        int data;
        Node left;
        Node right;
    }
    static Node newNode(int x)
    {
        Node temp = new Node();
        temp.data = x;
        temp.left = null;
        temp.right = null;
        return temp;
    }
    public static void main(String[] args)
    {
    /*
            1
           / \
          2   3
         / \ / \
        4  5 6  7
    */
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
    /*
         2
        / \
       4   5
    */

        Node root2 = newNode(2);
        root2.left = newNode(4);
        root2.right = newNode(5);
        if (isSubTree(root2, root))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    // Function to check if the Tree s is the subtree of the Tree T
    private static boolean isSubTree(Node rtSmall, Node rtBig) {
        Stack<Node> stk=new Stack<>();
        Node temp;
        stk.add(rtBig);
        while(!stk.isEmpty())
        {
            temp=stk.pop();
            if(temp.data==rtSmall.data)
            {
                if(ArePreOrdersSameIdentical(rtSmall,temp))
                    return true;
            }
            if(temp.right!=null)
                stk.add(temp.right);
            if(temp.left!=null)
                stk.add(temp.left);
        }
        return false;
    }

    private static boolean ArePreOrdersSameIdentical(Node rtSmall, Node temp) {
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        Node temp1;
        Node temp2;
        s1.add(rtSmall);
        s2.add(temp);
        while (!s1.isEmpty() && !s2.isEmpty())
        {
            temp1=s1.pop();
            temp2=s2.pop();
            if(temp1==null && temp2==null)
                continue;
            if(temp1 == null || temp2 == null)
                return false;
            if(temp1.data!=temp2.data)
                return false;
            s1.add(temp1.right);
            s2.add(temp2.right);

            s1.add(temp1.left);
            s2.add(temp2.left);
        }
        // if both tree are identical both stacks must be empty.
        return s1.isEmpty() && s2.isEmpty();
    }
}

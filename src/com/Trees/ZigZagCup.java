package com.Trees;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class ZigZagCup {
    public static class N_aryTreeNode
    {
        int k;
        N_aryTreeNode[] childSArray ;

        public N_aryTreeNode(int k) {
            this.k = k;
            this.childSArray = new N_aryTreeNode[k];
        }
        public N_aryTreeNode[] getChild() {
            return childSArray;
        }
        public int getData() {
            return k;
        }

        public void setData(int k) {
            this.k = k;
        }
        public void setChild(N_aryTreeNode[] childSArray) {
            this.childSArray = childSArray;
        }
    }
    static int k = 3;
    public static void main(String[] args)
    {
        N_aryTreeNode root = createN_aryTree();
        zigZagTraversal(root, k);
    }

    private static void zigZagTraversal(N_aryTreeNode root, int k) {
    int leftToRight = 1;
    N_aryTreeNode temp;
    Queue<N_aryTreeNode> currentLevel = new LinkedBlockingDeque<>();
    Stack<N_aryTreeNode> nextLevel = new Stack<>();

    System.out.println("Zig Zag Traversal");
    currentLevel.add(root);

    while (!currentLevel.isEmpty())
    {
        temp = currentLevel.poll();
        N_aryTreeNode[] childArr = temp.getChild();
        System.out.print(temp.getData()+"  ");
        if (leftToRight == 1)
        {
            for (int i = 0; i < k; i++)
            {
                if (childArr != null && childArr[i] != null)
                    nextLevel.push(childArr[i]);
            }

        }
        else
            {
                for (int i = k - 1; i >= 0; i--)
                    {
                        if (childArr != null && childArr[i] != null)
                            nextLevel.push(childArr[i]);
                    }

            }

        if (currentLevel.isEmpty())
        {
            leftToRight = 1 - leftToRight;
            while (!nextLevel.isEmpty())
            {
                currentLevel.add(nextLevel.pop());
            }
        }
        }
    }

    private static N_aryTreeNode createN_aryTree() {
    N_aryTreeNode node1 = new N_aryTreeNode(k);
    N_aryTreeNode node2 = new N_aryTreeNode(k);
    N_aryTreeNode node3 = new N_aryTreeNode(k);
    N_aryTreeNode node4 = new N_aryTreeNode(k);
    N_aryTreeNode node5 = new N_aryTreeNode(k);
    N_aryTreeNode node6 = new N_aryTreeNode(k);
    N_aryTreeNode node7 = new N_aryTreeNode(k);
    N_aryTreeNode node8 = new N_aryTreeNode(k);
    N_aryTreeNode node9 = new N_aryTreeNode(k);
    N_aryTreeNode node10 = new N_aryTreeNode(k);

    node5.setData(5);

    node1.setData(1);
    N_aryTreeNode[] childNode1 = { node2, node6, node10 };
    node1.setChild(childNode1);

    node2.setData(2);
    N_aryTreeNode[] childNode2 = { node3, node4, node5 };
    node2.setChild(childNode2);

    node6.setData(6);
    N_aryTreeNode[] childNode6 = { node7, node8, node9 };
    node6.setChild(childNode6);

    node3.setData(3);
    node3.setChild(null);

    node4.setData(4);
    node4.setChild(null);

    node5.setData(5);
    node5.setChild(null);

    node7.setData(7);
    node7.setChild(null);
    node8.setData(8);
    node8.setChild(null);
    node9.setData(9);
    node9.setChild(null);
    node10.setData(10);
    node10.setChild(null);
    return node1;
    }
}

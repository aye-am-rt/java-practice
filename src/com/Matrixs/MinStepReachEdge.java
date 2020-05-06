package com.Matrixs;
/*
Minimum steps to reach any of the boundary edges of a matrix | Set-2
Given an N X M matrix, where ai, j = 1 denotes the cell is not empty, ai, j = 0 denotes the
cell is empty and ai, j = 2, denotes that you are standing at that cell. You can move vertically
up or down and horizontally left or right to any cell which is empty. The task is to find the
 minimum number of steps to reach any boundary edge of the matrix. Print -1 if not possible to reach
  any of the boundary edges.

Note: There will be only one cell with value 2 in the entire matrix.

Examples:
Input: matrix[] =   {1, 1, 1, 0, 1}
                    {1, 0, 2, 0, 1}
                    {0, 0, 1, 0, 1}
                    {1, 0, 1, 1, 0}
Output: 2
Move to the right and then move
upwards to reach the nearest boundary
edge.*/

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinStepReachEdge {
    static final int r=4;
    static final int c=5;
    public static void main(String[] args)
    {
        // Initialize all the elements of a matrix
        int[][] arr = { { 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 2, 1, 0, 1 },
                        { 1, 1, 1, 1, 0 } };

        System.out.print( "Matrix initially:\n");
        printMatrix(arr,arr.length,arr[0].length);

        System.out.println("min steps to reach edge from (2)start == "+
                findMinStepsToReachEdge(arr,r,c));
    }

    private static int findMinStepsToReachEdge(int[][] arr, int rows, int cols) {
        int indX=-1;
        int indY=-1;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++) {
                if(arr[i][j]==2)
                {
                    indX=i;
                    indY=j;
                    break;
                }
            }
            if(indX != -1)
                break;
        }
        //Pair<Integer,Integer> p =new Pair<>();
        Queue< Pair< Integer , Pair<Integer , Integer> > > pairQueue =new LinkedList<>();

        // Push the position 2 with moves as 0
        pairQueue.offer(new Pair<>( 0 , new Pair<>(indX , indY) ) );
        // ===  add, remove , element throw an exception when error happens
        // but  offer(), poll(), peek() return a special value which is good.

        if(CheckIfValidAndEmpty(indX,indY,rows,cols,arr))
            return 0;

        boolean[][] vis=new boolean[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(vis[i],false);
        }
        while (! pairQueue.isEmpty())
        {
            // Get the front of the queue
            // Pop the first element from the queue
            Pair<Integer,Pair<Integer,Integer>> it = pairQueue.poll();
            // Get the position
            Integer x = it.getValue().getKey();  // getting indX
            Integer y = it.getValue().getValue(); // getting indY

            // Moves
            Integer moveVal = it.getKey();

            // If a boundary edge
            if (x == 0 || x == (rows - 1) || y == 0 || y == (cols - 1)) {
                return moveVal;
            }
            vis[x][y]= true; // mark this visited position

            if(CheckIfValidAndEmpty(x-1,y,rows,cols,arr))
            {
                if(! vis[x-1][y])
                    pairQueue.offer(new Pair<>( moveVal+1 , new Pair<>(x-1 , y) ) );
            }
            if(CheckIfValidAndEmpty(x+1,y,rows,cols,arr))
            {
                if(! vis[x+1][y])
                    pairQueue.offer(new Pair<>( moveVal+1 , new Pair<>(x+1 , y) ) );
            }
            if(CheckIfValidAndEmpty(x,y+1,rows,cols,arr))
            {
                if(! vis[x][y+1])
                    pairQueue.offer(new Pair<>( moveVal+1 , new Pair<>(x , y+1) ) );
            }
            if(CheckIfValidAndEmpty(x,y-1,rows,cols,arr))
            {
                if(! vis[x][y-1])
                    pairQueue.offer(new Pair<>( moveVal+1 , new Pair<>(x , y-1) ) );
            }
        }
        return -1;
    }

    private static boolean CheckIfValidAndEmpty(int indX, int indY, int rows, int cols, int[][] arr) {
        if(indX >= 0 && indY >= 0 && indX < rows && indY < cols)
        {
            // 0 means cell is empty to go.
            return arr[indX][indY] == 0;
        }
        return false;
    }

    private static void printMatrix(int[][] mat, int r, int c) {
        if(r==0 || c==0)
        {
            System.out.println("nothing to print");
            return;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j]+"  ");
            }
            System.out.println("  ");
        }
    }

}

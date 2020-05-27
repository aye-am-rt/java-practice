package com.Arrays.practiceTab1;
/**
Snake and Ladder Problem
Given a snake and ladder board, find the minimum number of dice throws required to reach the
 destination or last cell from source or 1st cell. Basically, the player has total control over
 outcome of dice throw and wants to find out minimum number of throws required to reach last cell.

If the player reaches a cell which is base of a ladder, the player has to climb up that ladder
 and if reaches a cell is mouth of the snake, has to go down to the tail of snake without a dice
 throw.

 The idea is to consider the given snake and ladder board as a directed graph with number of vertices
 equal to the number of cells in the board. The problem reduces to finding the shortest path in a
 graph. Every vertex of the graph has an edge to next six vertices if next 6 vertices do not have a
 snake or ladder. If any of the next six vertices has a snake or ladder, then the edge from current
 vertex goes to the top of the ladder or tail of the snake. Since all edges are of equal weight,
 we can efficiently find shortest path using Breadth First Search of the graph.

 Following is the implementation of the above idea. The input is represented by two things, first is
 ‘N’ which is number of cells in the given board, second is an array ‘move[0…N-1]’ of size N.
 An entry move[i] is -1 if there is no snake and no ladder from i, otherwise move[i] contains
 index of destination cell for the snake or the ladder at i.

 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// efficiently find shortest path using Breadth First Search of the graph.
public class SnakeLadderGame {

    // An entry in queue used in BFS
    static class qEntry
    {
        int v;// Vertex number
        int dist;// Distance of this vertex from source

        public qEntry() { }  // empty constructor

        @Override
        public String toString() {
            return "{" + "v=" + v + ", dist=" + dist + "}";
        }

        public qEntry(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
    public static void main(String[] args)
    {
        //efficiently find shortest path using Breadth First Search of the graph.
        // Let us construct the board given in above diagram
        int N = 30;
        int[] moves = new int[N];
        /*for (int i = 0; i < N; i++)
            moves[i] = -1;*/
        Arrays.fill(moves,-1);

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
    //efficiently find shortest path using Breadth First Search of the graph.
        System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
    }

    // This function returns minimum number of dice throws required to Reach last cell from 0'th cell
    // in a snake and ladder game. move[] is an array of size N where N is no. of cells on board If there
    // is no snake or ladder from cell i, then move[i] is -1 Otherwise move[i] contains cell to which
    // snake or ladder at i takes to.

    private static int getMinDiceThrows(int[] moves, int ln) {
        int[] visited = new int[ln];
        Arrays.fill(visited,0);
        Deque<qEntry> dq = new LinkedList<>();
        qEntry q0 = new qEntry(0,0);
        visited[0] = 1;
        dq.offer(q0);
        while (!dq.isEmpty())
        {
            q0 = dq.poll();
            int v = q0.v;
            // If front vertex is the destination vertex, we are done
            if(v==ln-1)
                break;
            // Otherwise dequeue the front vertex and enqueue its adjacent vertices (or cell
            // numbers reachable through a dice throw)
            for (int i = (v+1); i <=(v + 6)&& i<ln; i++) {
                if(visited[i]==0)  // means not visited ever
                {
                    qEntry curr = new qEntry();
                    curr.dist = q0.dist+1;
                    visited[i]=1;
                    // Check if there a snake or ladder at 'i' then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if(moves[i]!=-1)
                        curr.v =moves[i];
                    else
                        curr.v = i;
                    dq.add(curr);
                }
            }
        }
        // We reach here when 'q0 has last vertex == return the distance of vertex in 'q0'
        return q0.dist;
    }
}

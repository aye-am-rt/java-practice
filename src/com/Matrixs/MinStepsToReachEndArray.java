package com.Matrixs;
/*
Minimize the number of steps required to reach the end of the array | Set 2
Given an integer array arr[] of length N consisting of positive integers, the task
is to minimize the number of steps required to reach the arr[N – 1] starting from arr[0].
At a given step if we are at index i we can go to index i – arr[i] or i + arr[i] given we have not
visited those indexes before. Also, we cannot go outside the bounds of the array. Print -1 if there
is no possible way.
Examples:

Input: arr[] = {1, 1, 1}
Output: 2
The path will be 0 -> 1 -> 2.

Input: arr[] = {2, 1}
Output: -1*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
Here we’re going to discuss a BFS based solution:

        This problem can be visualized as a directed graph where ith cell is connected with cells
 i + arr[i] and i – arr[i].
        And the graph is un-weighted.
        Due to above, BFS can be used to find the shortest path between 0th and the (N – 1)th index.
 We will use the following algorithm:
        Push index 0 in a queue.
        Push all the adjacent cells to 0 in the queue.
        Repeat the above steps i.e. traverse all the elements in the queue individually again if
 they have not been visited/traversed before.
        Repeat till we don’t reach the index N – 1.
        The depth of this traversal will give the minimum steps required to reach the end.
        Remember to mark a cell visited after it has been traversed. For this, we will use a boolean
 array.*/

public class MinStepsToReachEndArray {
    public static void main(String[] args)
    {
        int[] arr = { 1, 1, 1, 1, 1, 1 };
        int n = arr.length;
        System.out.println(minStepsToReachArrayEnd(arr, n));
        // Deque<Integer> dq = new LinkedList<>();  Doubly linked list ...first and last both ends
        System.out.println(minJumps(arr));
    }

    //Time complexity: O(N)
    private static int minStepsToReachArrayEnd(int[] arr, int n) {
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);
        // queue for bfs
        Queue<Integer> q = new LinkedList<>();  // Time complexity: O(N)
        q.offer(0);  // q.add(0);
        int depth=0;
        while(! q.isEmpty())
        {
            int currSize=q.size();
            while(currSize-- >0)
            {
                int i = q.poll();
                if(vis[i])
                    continue;

                if(i== n-1)
                    return depth;


                vis[i] = true;

                // Pushing the adjacent nodes i.e. indices reachable from the current index
                if(i+arr[i] < n )
                    q.offer(i+arr[i]);
                if(i-arr[i] >= 0)
                    q.offer(i-arr[i]);
            }
            depth++;
        }
        return -1;  // Time complexity: O(N)
    }

    static int minJumps(int[] arr)  // this is also o(n) solution
    {
        if (arr.length <= 1)
            return 0;
        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;
        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jumpCount = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++)
        {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jumpCount;

            // updating maxReach
            maxReach = Math.max(maxReach, i+arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0)
            {
                //  we must have used a jumpCount
                jumpCount++;

                //Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if(i>=maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }
        return -1;
    }
/**    Variables to be used:

maxReach The variable maxReach stores at all time the maximal reachable index in the array.
step The variable step stores the number of steps we can still take(and is initialized with value at index
 0,i.e. initial number of steps)
jump jump stores the amount of jumps necessary to reach that maximal reachable position.
Given array arr = 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9

maxReach = arr[0]; // arr[0] = 1, so the maximum index we can reach at the moment is 1.
step = arr[0]; // arr[0] = 1, the amount of steps we can still take is also 1.
jump = 1; // we will always need to take at least one jump.
Now, starting iteration from index 1, the above values are updated as follows:
First we test whether we have reached the end of the array, in that case we just need to return the jump variable.
if (i == arr.length - 1)
    return jump;
Next we update the maxReach. This is equal to the maximum of maxReach and i+arr[i](the number of steps we can take from the current position).
maxReach = Math.max(maxReach,i+arr[i]);
We used up a step to get to the current index, so steps has to be decreased.
step--;
If no more steps are remaining (i.e. steps=0, then we must have used a jump. Therefore increase jump.
 Since we know that it is possible somehow to reach maxReach, we again initialize the steps to the number
 of steps to reach maxReach from position i. But before re-initializing step, we also check whether a step
 is becoming zero or negative. In this case, It is not possible to reach further.
    if (step == 0) {
jump++;
if(i>=maxReach)
    return -1;
step = maxReach - i;
}*/
}

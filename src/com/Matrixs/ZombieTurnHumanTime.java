package com.Matrixs;
//Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent
// (up/down/left/right) human beings into zombies every hour. Find out how many hours does
// it take to infect all humans?

import java.util.Deque;
import java.util.LinkedList;

/**Input:
[[0, 1, 1, 0, 1],
[0, 1, 0, 1, 0],
[0, 0, 0, 0, 1],
[0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1],
[0, 1, 0, 1, 1],
[1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1],
[1, 1, 1, 1, 1]]*/
public class ZombieTurnHumanTime {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 },
                         { 0, 1, 0, 1, 0 },
                         { 0, 0, 0, 0, 1 },
                         { 0, 1, 0, 0, 0 } };
        System.out.println(minDaysToConvertAll(grid));
    }

    private static int minDaysToConvertAll(int[][] grid) {
        Deque<int[]> q = new LinkedList<>();
        int target = grid.length * grid[0].length;
        int cnt=0, res=0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) // zombie 1 or  human 0
                {
                    q.offer(new int[]{i,j});
                    cnt++;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty())
        {
            int size = q.size();
            if(cnt==target)
            {
                return res;
            }

            for (int i = 0; i < size; i++) {
                int[] currArray = q.poll();
                for(int[] dir : dirs)
                {
                    assert currArray != null;
                    int ni = currArray[0]+dir[0];
                    int nj = currArray[1]+dir[1];
                    if(isWithinBoundariesAndHuman(grid,ni,nj))
                    {
                        cnt++;  // number of days for conversion
                        q.offer(new int[]{ni,nj});
                        grid[ni][nj]=1;  // make it zombie
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private static boolean isWithinBoundariesAndHuman(int[][] grid,int ni, int nj) {
        return (ni>=0 && ni<grid.length
                && nj>=0 && nj<grid[0].length
                && grid[ni][nj]==0);
    }
}

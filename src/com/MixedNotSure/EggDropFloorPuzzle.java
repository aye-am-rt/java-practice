package com.MixedNotSure;
/**
Eggs dropping puzzle | Set 2
Given N eggs and K floors, the task is to find the minimum number of trials needed in the worst case
 to find the floor below which all floors are safe. A floor is safe if dropping an egg from it
 does not break the egg. Please refer n eggs and k floors for more insight.

Examples:

Input: N = 2, K = 10
Output: 4
Explanation:
The first trial is from 4th floor. Two cases arise after this:

If egg breaks, we have one egg left so we need three more trials.
If the egg does not break, the next try is from 7th floor. Again two cases arise.
Notice that if 4th floor is chosen as first floor, 7th as the next floor
and 9 as last floor, the number of trials can never exceed 4.

Input: N = 2, K = 100
Output: 14

Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Prerequisites: Egg Dropping Puzzle

Approach: Consider this problem in a different way:
Let dp[x][n] is the maximum number of floors that can be checked with given n eggs and x moves.

Then the equation is:

dp[x][n] = dp[x – 1][n – 1] + dp[x – 1][n] + 1
which means we take 1 move to a floor,
If the egg breaks, then we can check dp[x – 1][n – 1] floors.
If the egg doesn’t break, then we can check dp[x – 1][n] + 1 floors.
Since we need to cover k floors, dp[x][n] >= k.

dp[x][n] is similar to the number of combinations and it increases exponentially to k*/
//    Time Complexity: O(NlogK)
//    Space Complexity: O(N * K)
public class EggDropFloorPuzzle {
    public static void main(String[] args)
    {
        int n = 2, k = 36;
        System.out.println( eggDropSafeFloor(n, k));
    }
//    Time Complexity: O(NlogK)
//    Space Complexity: O(N * K)

    private static int eggDropSafeFloor(int nEggs, int kFloors) {
        int[][] dp = new int[kFloors+1][nEggs+1];
        int xF = 0;
        while(dp[xF][nEggs]<kFloors)
        {
           xF++;
            for (int i = 1; i <(nEggs+1); i++) {
                dp[xF][i] = dp[xF-1][i-1] + dp[xF-1][i] + 1;
            }
        }
        return xF;
    }
    //    Time Complexity: O(NlogK)
//    Space Complexity: O(N * K)
}

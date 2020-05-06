package com.Arrays.AmazonSubArrays;
/*
# Count of subArrays of an Array having all unique digits(numbers) as elements. not their digits
# Given an array A containing N positive integers, the task is to find the number of subArrays of this
# array such that in each subArray, no digit is repeated twice, i.e. all the digits of the subArray must be
# unique.
#
# Examples:
#
# Input: A = [1, 12, 23, 34]
# Output: 7
# The subArrays are: {1}, {12}, {23}, {34}, {1, 23}, {1, 34}, {12, 34}
# Therefore the count of such subArrays = 7

# Input: A = [5, 12, 2, 1, 165, 2323, 7]
# Output: 33

"""Efficient Approach: This approach depends upon the fact that there exist only 10 unique digits
in the Decimal
 number system. Therefore the longest subArray will have only 10 digits in it, to meet the required
 condition.

We will use Bitmasking and Dynamic Programming to solve the problem.
Since there are only 10 digits, consider a 10-bit representation of every number where each bit is
1 if digit
 corresponding to that bit is present in that number.
Let, i be the current array element (elements from 1 to i-1 are already processed). An integer
variable ‘mask‘
indicates the digits which have already occurred in the subArray. If i’th bit is set in the mask, then i’th
digit has occurred, else not.
At each step of recurrence relation, the element can either be included in the subArray or not. If the element
 is not included in the subArray, then simply move to the next index. If it is included, change the mask by
 setting all the bits corresponding to the current element’s digit, ON in the mask.
Note: The current element can only be included if all of its digits have not occurred previously.

This condition will be satisfied only if the bits corresponding to the current element’s digits in the mask
are OFF.
If we draw the complete recursion tree, we can observe that many subproblems are being solved again and
 again. So we use Dynamic Programming. A table dp[][] is used such that for every index dp[i][j], i is the
 position of the element in the array and j is the mask.
*/

class CountSubArAllUnqDigits
{  // Time Complexity: O(N * 2^10)
    public static void main(String[] args)
    {
        int N = 4;
        int[] A = { 1, 12, 23, 34 };
        System.out.print(numberOfSubArrays(A, N));
    }
    // Function to find the count of // subArray with all digits unique
    static int numberOfSubArrays(int[] a, int n)
    {
        // initializing dp
        for(int i = 0;i<5000;i++)
        {
            for (int j = 0; j < (1 << 10) + 5; j++)
            {
                dp[i][j] = -1;
            }
        }
        return countWays(0, 0, a, n);
    }

    // Dynamic programming table
    static int [][]dp = new int[5000][(1 << 10) + 5];
    // Function to obtain the mask for any integer
    static int getMask(int val)
    {
        int mask = 0;
        if (val == 0)
            return 1;
        while (val > 0)
        {
            int d = val % 10;
            mask |= (1 << d);
            val /= 10;
        }
        return mask;
    }

    // Function to count the number of ways
    static int countWays(int pos, int mask, int[] a, int n)
    {
        // SubArray must not be empty
        if (pos == n)
            return (mask > 0 ? 1 : 0);

        // If subProblem has been solved
        if (dp[pos][mask] != -1)
            return dp[pos][mask];

        int count = 0;
        // Excluding this element in the subArray
        count = count + countWays(pos + 1, mask, a, n);
        // If there are no common digits then only this element can be included
        if ((getMask(a[pos]) & mask) == 0)
        {
            // Calculate the new mask if this element is included
            int new_mask = (mask | (getMask(a[pos])));
            count = count + countWays(pos + 1, new_mask, a, n);
        }
        return dp[pos][mask] = count;
    }
}
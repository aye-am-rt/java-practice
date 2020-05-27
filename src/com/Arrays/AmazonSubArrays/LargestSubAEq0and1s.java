package com.Arrays.AmazonSubArrays;

import java.util.Arrays;
import java.util.HashMap;

/**
Largest subarray with equal number of 0s and 1s
Given an array containing only 0s and 1s, find the largest subarray which contains equal no of
 0s and 1s. Expected time complexity is O(n).
Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6
(Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4

 Approach: The concept of taking cumulative sum, taking 0’s as -1 will help us in optimising the approach. While taking the cumulative sum, there are two cases when there can be a sub-array with equal number of 0’s and 1’s.

 When cumulative sum=0, which signifies that sub-array from index (0) till present index has equal
 number of 0’s and 1’s.
 When we encounter a cumulative sum value which we have already encountered before, which means that
 sub-array from the previous index+1 till the present index has equal number of 0’s and 1’s as
 they give a cumulative sum of 0 .

 In a nutshell this problem is equivalent to finding two indexes i & j in array[] such that
 array[i] = array[j] and (j-i) is maximum. To store the first occurrence of each unique cumulative
 sum value we use a hash_map wherein if we get that value again we can find the sub-array size and
 compare it with maximum size found till now.

 Algorithm :

 Let input array be arr[] of size n and max_size be the size of output sub-array.
 Create a temporary array sumleft[] of size n. Store the sum of all elements from arr[0] to arr[i] in
 sumleft[i].
 There are two cases, the output sub-array may start from 0th index or may start from some other index.
 We will return the max of the values obtained by two cases.
 To find the maximum length sub-array starting from 0th index, scan the sumleft[] and find the maximum
 i where sumleft[i] = 0.
 Now, we need to find the subarray where subarray sum is 0 and start index is not 0. This problem is
 equivalent to finding two indexes i & j in sumleft[] such that sumleft[i] = sumleft[j] and j-i is
 maximum.

 To solve this, we create a hash table with size = max-min+1 where min is the minimum value in
 the sumleft[] and max is the maximum value in the sumleft[]. Hash the leftmost occurrences of all
 different values in sumleft[]. The size of hash is chosen as max-min+1 because there can be these many
 different possible values in sumleft[]. Initialize all values in hash as -1.
 To fill and use hash[], traverse sumleft[] from 0 to n-1. If a value is not present in hash[],
 then store its index in hash. If the value is present, then calculate the difference of current index
 of sumleft[] and previously stored value in hash[]. If this difference is more than maxsize, then
 update the maxsize.
 To handle corner cases (all 1s and all 0s), we initialize maxsize as -1. If the maxsize remains -1,
 then print there is no such subarray.
 Pseudo Code:

 int sum_left[n]
 Run a loop from i=0 to n-1
 if(arr[i]==0)
 sumleft[i] = sumleft[i-1]+-1
 else
 sumleft[i] = sumleft[i-1]+-1
 if (sumleft[i]  max)
 max = sumleft[i];


 Run a loop from i=0 to n-1
 if (sumleft[i] == 0)
 {
 maxsize = i+1;
 startindex = 0;
 }

 // Case 2: fill hash table value. If already
 then use it

 if (hash[sumleft[i]-min] == -1)
 hash[sumleft[i]-min] = i;
 else
 {
 if ((i - hash[sumleft[i]-min]) > maxsize)
 {
 maxsize = i - hash[sumleft[i]-min];
 startindex = hash[sumleft[i]-min] + 1;
 }
 }

 return maxsize
 */

public class LargestSubAEq0and1s {
    public static void main(String[] args)
    {
        int[] arr = { 1, 1, 0, 1, 0, 0, 1 };
        int n = arr.length;
        System.out.println("array given = "+ Arrays.toString(arr));
        System.out.print("max len subArray having equal 0 and 1s = "+FindMaxLenEqual0and1s(arr, n));
    }

    private static int FindMaxLenEqual0and1s(int[] arr, int ln) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum=0;
        // Initialize result
        int max_len = 0;
        int ending_index = -1;
        int start_index = 0;
        for (int i = 0; i < ln; i++) {
            arr[i] = (arr[i]==0)?-1:1;
        }
        for (int i = 0; i < ln; i++) {
            sum += arr[i];
            if(sum==0)
            {
                max_len = i+1;
                ending_index=i;
            }
            // If this sum is seen before, then update max_len if required
            if(hm.containsKey(sum))
            {
                if(max_len < (i - hm.get(sum)))
                {
                    max_len = (i - hm.get(sum) );
                    ending_index=i;
                }
            }
            else
                hm.put(sum,i);
        }

        for (int i = 0; i < ln; i++) {
            arr[i] = (arr[i]==-1)?0:1;
        }

        start_index = (ending_index - max_len) + 1;
        System.out.println("index = "+start_index +" to "+ending_index+" index ");

        return max_len;
    }

}

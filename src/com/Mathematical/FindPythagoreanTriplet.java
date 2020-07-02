package com.Mathematical;

import java.util.HashMap;

/**
Pythagorean Triplet in an array
Given an array of integers, write a function that returns true if there is a triplet (a, b, c)
 that satisfies a2 + b2 = c2.
Example:

Input: arr[] = {3, 1, 4, 6, 5}
Output: True
There is a Pythagorean triplet (3, 4, 5).

Input: arr[] = {10, 4, 6, 12, 5}
Output: False
There is no Pythagorean triplet.

 Method 3: (Using Hashing)
 The problem can also be solved using hashing. We can use a hash map to mark all the values of the
 given array. Using two loops, we can iterate for all the possible combinations of a and b, and then
 check if there exists the third value c. If there exists any such value, then there is a Pythagorean
 triplet.
 */

public class FindPythagoreanTriplet {
    public static void main(String[] args)
    {
        int[] arr = { 3, 2, 4, 6, 5 };
        int n = arr.length;
        if (checkTriplet(arr, n))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    private static boolean checkTriplet(int[] arr, int n) {
        int maximum = 0;
        // Find the maximum element
        for (int i = 0; i < n; i++)
        {
            maximum = Math.max(maximum, arr[i]);
        }
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }
        for (int i = 1; i < maximum+1; i++) {
            if(countMap.get(i)!=null)
            {
                for (int j = 1; j < maximum + 1; j++)
                {
                    if((i==j && countMap.get(i)==1 )|| (countMap.get(j) != null && countMap.get(j)==0 ))
                    { continue; }
                    int val = (int) Math.sqrt((double)i*i +  j*j);
                    if((val*val) != (i*i + j*j))
                        continue;
                    if(val>maximum)
                        continue;
                    if(countMap.get(val)==1)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

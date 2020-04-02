package com.practiceTab1;

//# Given a set of non-negative integers, and a value sum, determine if there is a subset of the given
//        # set with sum equal to given sum.
//        # Example:
//        # Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//        # Output:  True  //There is a subset (4, 5) with sum 9.

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class subsetSum {
    static boolean checkSubsetSum(int[] set,int n,int sum)
    {
        if(sum == 0)
        { return true;}
        if(n==0)
        {return false;}
        if(set[n-1]>sum)
        {
            return checkSubsetSum(set,n-1,sum);
        }
        else
        {
            return checkSubsetSum(set,n-1,sum) || checkSubsetSum(set,n-1,sum-set[n-1]);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("give size of array ");
        int n=sc.nextInt();
        int [] set = new int[n];
        Point ar[]=new Point[n];
        for( int i=0;i<n;i++)
        {
            System.out.print(" give "+ i +" element of set ");
            set[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(set));
        System.out.print("give sum to check in array ");
        int sum=sc.nextInt();
/*        for(int i: set){ //for printing array
            System.out.println(i);
        }
        int [] set = {3,34,4, 12,5,2};
        int sum = 3965;*/
        if (checkSubsetSum(set, set.length, sum))
            System.out.println("Found a subset" + " with given sum");
        else
            System.out.println("No subset with" + " given sum");
    }
}

//    The above solution may try all subsets of given set in worst case. Therefore time complexity of the
//    above solution is exponential. The problem is in-fact NP-Complete
//    (There is no known polynomial time solution for this problem)

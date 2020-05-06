package com.Arrays.AmazonSubArrays;
//
//Count subarrays with Prime sum
//Given an array A[] of integers. The task is to count total subarrays whose sum is prime with
// ( size > 1 ).
//
//Examples:
//
//Input : A[] = { 1, 2, 3, 4, 5 }
//Output : 3
//Subarrays are -> {1, 2}, {2, 3}, {3, 4}
//
//Input : A = { 22, 33, 4, 1, 10 };
//Output : 4
//
//Approach: Generate all possible subarrays and store their sum in a vector. Iterate the vector and
// check whether a sum is prime or not. It YES increment the count.
//
//  You can use sieve-of-eratosthenes to check whether a sum is prime in O(1).

import java.util.Vector;

public class CountSubArraysPrimeSum {
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5 };
        int n = A.length;
        System.out.print( CountPrimeSubarrays(A, n));

    }
// Time Complexity: O(N2)
    private static int CountPrimeSubarrays(int[] arr, int n) {
        int max_val = (int)(Math.pow(10, 7));
        Vector<Boolean> prime= new Vector<>(max_val + 1);
        for (int i = 0; i < max_val; i++) {
            prime.add(i,true);
        }
        prime.set(0,false);
        prime.set(1,false);
        for (int p = 2; p*p < max_val; p++) {
            if(prime.get(p)) //If prime[p] is not changed, then it is a prime
            {
                // Update all multiples of p 
                for (int j = 2*p ; j < max_val; j+=p) {
                    prime.set(j,false);
                }
            }
        }// Time Complexity: O(N2)
        int countOfSubArrays=0;
        for (int i = 0; i < n; i++) {
            int currSum=arr[i];
            for (int j = i+1; j < n; j++) {
                currSum+=arr[j];
                if(prime.get(currSum))
                    countOfSubArrays++;
            }
        }
        return countOfSubArrays;  //Time Complexity: O(N2)
    }

}

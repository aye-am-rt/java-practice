package com.MixedNotSure;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
Absolute difference between the XOR of Non-Prime numbers and Prime numbers of an Array
        Given an array arr[] of N positive integers, the task is to calculate the absolute difference
        between XOR of non-prime numbers and prime numbers. Note that 1 is neither prime nor composite.

Efficient approach:
    Generate all primes up to the maximum element of the array using the Sieve of
    Eratosthenes. Now, traverse the array and check whether the current element is prime or not.
    If the element is prime then XOR it with X1 else XOR it with X2. Final print abs(X1 – X2).
*/
// Note that 1 is neither prime nor composite.
public class PrimeNpDiffs {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //  Note that 1 is neither prime nor composite.
        int[] arr1= Arrays.stream(br.readLine().strip().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
//        int[] arr2= Arrays.stream(br.readLine().strip().split("\\s"))
//                .mapToInt(Integer::parseInt).toArray();
        System.out.println("abs diff of primes and non primes = "+findAbsDiff(arr1,arr1.length));
    }

    private static int findAbsDiff(int[] arr1, int length) {
        int maxInArr1=findMax(arr1,length);
        System.out.println("max in array= "+maxInArr1);
        boolean[] trueForPrimesArray=new boolean[maxInArr1+1];
        // Note that 1 is neither prime nor composite.
        Arrays.fill(trueForPrimesArray, true);
        trueForPrimesArray[0]=false;
        trueForPrimesArray[1]=false;
        for (int i = 2; i*i < (maxInArr1 + 1); i++) {
            if(trueForPrimesArray[i]) {
                for (int j = 2*i; j <maxInArr1+1 ; j+=i) {
                    trueForPrimesArray[j]=false;
                }
            }//  Note that 1 is neither prime nor composite.
        }
        int xorOfPrimes = 1, xorOfNonPrimes = 1;
        for (int i = 0; i < length; i++) {
            if(trueForPrimesArray[arr1[i]])
                xorOfPrimes^=arr1[i];
            else if(arr1[i]!=1)    // Note that 1 is neither prime nor composite. that is why
                // checking here that arr[i] is not = 1
                xorOfNonPrimes^=arr1[i];
        }
        System.out.println("xorOfNonPrimes in array= "+xorOfNonPrimes);
        System.out.println("xorOfNonPrimes in array= "+xorOfPrimes);
        return Math.abs(xorOfNonPrimes-xorOfPrimes);
    }

    private static int findMax(int[] arr1, int length) {
        int max=Integer.MIN_VALUE;
        int left=0;
        int right=length-1;
        while(left<right)
        {
            if(arr1[left]>max)
                max=arr1[left];
            if(arr1[right]>max)
                max=arr1[right];

            left++;
            right--;
        }
        return max;
    }
}
/*
    A Better Solution can find XOR without using loop.   //not related to above program just for info.

        1) Find bitwise OR of x and y (Result has set bits where either x has set or y has set bit).
        OR of x = 3 (011) and y = 5 (101) is 7 (111)

        2) To remove extra set bits find places where both x and y have set bits. The value of
        expression “~x | ~y” has 0 bits wherever x and y both have set bits.

        3) bitwise AND of “(x | y)” and “~x | ~y” produces the required result.

        Below is implementation.

class GFG
{

    // Returns XOR of x and y
    static int myXOR(int x, int y)
    {
        return (x | y) & (~x | ~y);
    }
    // Driver Code
    public static void main (String[] args)
    {
        int x = 3, y = 5;
        System.out.println("XOR is "+ (myXOR(x, y)));
    }
}*/

package com.vmware;
/**
Count number of bits to be flipped to convert A to B
Given two numbers ‘a’ and b’. Write a program to count number of bits needed to be flipped to
 convert ‘a’ to ‘b’.
Example :

Input : a = 10, b = 20
Output : 4
Binary representation of a is 00001010
Binary representation of b is 00010100
We need to flip highlighted four bits in a
to make it b.

Input : a = 7, b = 10
Output : 3
Binary representation of a is 00000111
Binary representation of b is 00001010
We need to flip highlighted three bits in a
to make it b.


1. Calculate XOR of A and B. a_xor_b = A ^ B
2. Count the set bits in the above calculated XOR result.
   countSetBits(a_xor_b) */

public class CountBitFlipsForAtoB {
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;
        System.out.print(FlippedCount(a, b));
    }

    private static int FlippedCount(int a, int b) {
        return countSetBits(a^b);
    }

    private static int countSetBits(int xorOfNums) {
        int count=0;
        while(xorOfNums!=0)
        {
            count++;
            xorOfNums &= (xorOfNums-1);
        }
        return count;
    }
}
// 2nd approach not better than 1st but simple thinking.
//Approach: An approach to solve this problem has already been discussed here. Here, the count of
// bits that need to be flipped can be found by matching all the bits in both the integers one by one.
// If the bit under consideration differs then increment the count.

// Function to return the count of bits
// to be flipped to convert a to b

/** static int countBits(int a, int b)
    {

        // To store the required count
        int count = 0;

        // Loop until both of them become zero
        while (a > 0 || b > 0)
        {

            // Store the last bits in a
            // as well as b
            int last_bit_a = a & 1;
            int last_bit_b = b & 1;

            // If the current bit is not same
            // in both the integers
            if (last_bit_a != last_bit_b)
                count++;

            // Right shift both the integers by 1
            a = a >> 1;
            b = b >> 1;
        }

        // Return the count
        return count;
    }*/

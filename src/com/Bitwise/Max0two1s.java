package com.Bitwise;
//Maximum 0’s between two immediate 1’s in binary representation
//        Given a number n, the task is to find the maximum 0’s between two immediate 1’s in binary
//        representation of given n. Return -1 if binary representation contains less than two 1’s.
//
//        Examples :
//        Input : n = 47
//        Output: 1
//// binary of n = 47 is 101111
//
//        Input : n = 549
//        Output: 3
//// binary of n = 549 is 1000100101

public class Max0two1s {
    public static void main(String[] args) {
        int n = 549;
        // Initially check that number must not
        // be 0 and power of 2
        System.out.println(maxZerosBtw2Ones(n));
        System.out.println(1<<1);   // 1*2^1==> x<<y x left shift y means multiply x by 2^y
    }

    private static int maxZerosBtw2Ones(int n) {
        if(n==0 || (n &(n-1)) ==0)
            return -1;

        //int size in java is 4 byte
        byte b = 4;
        // loop to find position of left most 1
        // here sizeof int is 4 that means total 32 bits
        int setBit = 1, prev = 0, i;
        for (i = 1; i <= (b* 8); i++) {
            prev++;
            if((n & setBit)==setBit)  // we have found left most 1
            {
                setBit=setBit<<1; break;
            }
            // left shift setBit by 1 to check next bit
            setBit = setBit << 1;
        }
        // now loop through for remaining bits and find
        // position of immediate 1 after prev
        int max0 = Integer.MIN_VALUE, cur = prev;
        for (int j = i + 1; j <= b * 8; j++) {
            cur++;

            // if current bit is set, then compare
            // difference of cur - prev -1 with
            // previous maximum number of zeros
            if ((n & setBit) == setBit) {
                if (max0 < (cur - prev - 1)) {
                    max0 = cur - prev - 1;
                }

                // update prev
                prev = cur;
            }
            setBit = setBit << 1;
        }
        return max0;
    }
}

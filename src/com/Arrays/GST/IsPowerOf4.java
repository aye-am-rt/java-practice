package com.Arrays.GST;
//Find whether a given number is a power of 4 or not
//        Given an integer n, find whether it is a power of 4 or not.

//1. A simple method is to take log of the given number on base 4, and if we get an integer then number
// is power of 4.

//2. Another solution is to keep dividing the number by 4, i.e, do n = n/4 iteratively.
// In any iteration, if n%4 becomes non-zero and n is not 1 then n is not a power of 4, otherwise n
// is a power of 4.

public class IsPowerOf4 {
    public static void main(String[] args)
    {
        int test_no = 4;
        if(isPowerOfFour(test_no) == 1)
            System.out.println(test_no +" is a power of 4 |||| checked by divide 4 then remainder !=0 ");
        else
            System.out.println(test_no +" is not a power of 4 |||| checked by divide 4 then remainder !=0");

        if(isPowerOfFourBitwiseAnd(test_no) == 1)
            System.out.println(test_no +" is a power of 4 |||||| checked by bitwise & then even zeros");
        else
            System.out.println(test_no +" is not a power of 4 checked ||||| by bitwise & then even zeros");
    }

    private static int isPowerOfFourBitwiseAnd(int test_no) {
        if(test_no<4)
            return -1;
        int countZeros=0;
        int x= test_no & (test_no-1);
        if(x == 0)
        {
            while (test_no > 1)
            {
                test_no >>= 1;
                countZeros+=1;
            }
            if(countZeros%2==0)
                return 1;
            else
                return 0;
        }
       else
           return -1; /* If there are more than  1 bit set then n is not a power of 4*/
    }

    private static int isPowerOfFour(int test_no) {
        if(test_no<4)
            return -1;
        for (int i = test_no; i > 1 ; i/=4) {
            if(test_no%4 != 0)
            { return 0; }
        }
        return 1;
    }
/** 3. A number n is a power of 4 if following conditions are met.
    a) There is only one bit set in the binary representation of n (or n is a power of 2)
    b) The count of zero bits before the (only) set bit is even.

    For example: 16 (10000) is power of 4 because there is only one bit set and count of 0s before the
    set bit is 4 which is even.*/
}

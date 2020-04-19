package com.Bitwise;
/**
Method 2 (Simple and efficient than Method 1)
    If we observe bits from rightmost side at distance i than bits get inverted after 2^i
    position in vertical sequence.
    for example n = 5;
    0 = 0000
    1 = 0001
    2 = 0010
    3 = 0011
    4 = 0100
    5 = 0101

    Observe the right most bit (i = 0) the bits get flipped after (2^0 = 1)
    Observe the 3rd rightmost bit (i = 2) the bits get flipped after (2^2 = 4)

    So, We can count bits in vertical fashion such that at i’th right most position bits will be get
    flipped after 2^i iteration;*/

public class CountSetBits {
    public static void main(String[] args)
    {
        int n = 17;

        System.out.println(countSetBitsRightFlips(n));
    }

    private static int countSetBitsRightFlips(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int ansSum=0,i=0;
        while(n>=(1<<i))
        {
            // << (left shift) Takes two numbers, left shifts the bits of the first
            // operand, the second operand decides the number of places to shift. Or in other words
            // left shifting an integer “x” with an integer “y” (x<<y) is equivalent to
            // multiplying x with 2^y (2 raise to power y).

            boolean k= false;  // This k will get flipped after 2^i iterations
            // change is iterator from 2^i to 1
            int change = 1 << i;
            for(int j=0;j<=n;j++)
            {
                if(k)
                    ansSum+=1;
                if(change==1)
                {
                    k=!k;  // when change == 1 flip the bit
                    change=1<<i; // again set change to 2^i
                }
                else
                    change--;
            }
            i+=1;
        }
        return ansSum;
    }
}

// >> (right shift) Takes two numbers, right shifts the bits of the first operand, the second operand
// decides the number of places to shift.Similarly right shifting (x>>y) is equivalent to dividing
// x with 2^y.
//
//  << (left shift) Takes two numbers, left shifts the bits of the first operand, the second operand
//  decides the number of places to shift. Or in other words left shifting an integer “x” with an
//  integer “y” (x<<y) is equivalent to multiplying x with 2^y (2 raise to power y).

/**
    Important Points :

        The left shift and right shift operators should not be used for negative numbers. The result of
          is undefined behaviour if any of the operands is a negative number. For example results of both
          -1 << 1 and 1 << -1 is undefined.
        If the number is shifted more than the size of integer, the behaviour is undefined. For example,
          1 << 33 is undefined if integers are stored using 32 bits. See this for more details.
        The left-shift by 1 and right-shift by 1 are equivalent to the product of first term and 2 to the
          power given element(1<<3 = 1*pow(2,3)) and division of first term and second term raised to power
          2 (1>>3 = 1/pow(2,3)) respectively.
        As mentioned in point 1, it works only if numbers are positive.*/

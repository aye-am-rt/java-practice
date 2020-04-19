package com.Bitwise;

//Add 1 to a given number
//        Write a program to add one to a given number. The use of operators like ‘+’, ‘-‘, ‘*’, ‘/’, ‘++’
//        , ‘–‘ …etc are not allowed.

//Method 1
//        To add 1 to a number x (say 0011000111), flip all the bits after the rightmost 0 bit
//        (we get 0011000000). Finally, flip the rightmost 0 bit also (we get 0011001000)
//        to get the answer.

/**Method 2
        We know that the negative number is represented in 2’s complement form on most of the
 architectures. We have the following lemma hold for 2’s complement representation of signed numbers.

        Say, x is numerical value of a number, then
        ~x = -(x+1) [ ~ is for bitwise complement ]
        (x + 1) is due to addition of 1 in 2’s complement conversion
        To get (x + 1) apply negation once again. So, the final expression becomes (-(~x))*/

public class Add1toNum {
    static int addOne(int x)
    {
        int m = 1;

        // Flip all the set bits
        // until we find a 0
        while( (x & m) >= 1)
        {
            x = x ^ m;
            m <<= 1;
        }

        // flip the rightmost 0 bit
        x = x ^ m;
        return x;
    }
    static int addOneUsingTilda(int x)
    {
        return (-(~x));
    }

    /* Driver program to test above functions*/
    public static void main(String[] args)
    {
        System.out.println("add one using bit flipping-rightest 0 trick ==> "+addOne(13));
        System.out.println("using -(~x) to add 1 ==> "+addOneUsingTilda(16));
    }
}

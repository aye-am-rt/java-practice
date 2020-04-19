package com.Arrays.SortingFs;
//
//public static long numberOfTrailingZeros(long num)
//        Parameters:
//        num - the number passed
//        Returns:
//        the number of trailing zeros after the lowest-order set bit

//  If the number does not contain any set bit(in other words, if the number is zero), it returns 64.

public class JavaLongTrailingZeros {

    public static void main(String[] args)
    {

        long l = 10;

        // returns the number of zero bits following the lowest-order
        // set bit
        System.out.println("Number of trailing zeros = " + Long.numberOfTrailingZeros(l));

        // second example
        l = 25;
        System.out.println("Number of trailing zeros = " + Long.numberOfTrailingZeros(l));



        long lNeg = -12;
        // returns the number of zero bits following the lowest-order set bit
        System.out.println("Number of trailing zeros = " + Long.numberOfTrailingZeros(lNeg));


        // Long.numberOfTrailingZeros(12.34)  error. no float . or string given.


        /////// ***************************************************   /////////////////////////

        long lLeadingZeros = 8;

        // returns the number of zero bits before the highest-order
        // set bit
        System.out.println("Number of leading zeros = " + Long.numberOfLeadingZeros(lLeadingZeros));

        // second example
        l = 25;
        System.out.println("Number of leading zeros = " + Long.numberOfLeadingZeros(lLeadingZeros));

        //In case of a negative number, every number will have 0 leading zeros.

    }
}

package com.Bitwise;
/*Compute modulus division by a power-of-2-number
        Compute n modulo d without division(/) and modulo(%) operators, where d is a power of 2 number.
        Let ith bit from right is set in d. For getting n modulus d, we just need to return 0 to i-1
        (from right) bits of n as they are and other bits as 0.

        For example if n = 6 (00..110) and d = 4(00..100). Last set bit in d is at position 3
        (from right side). So we need to return last two bits of n as they are and other bits as 0,
        i.e., 00..010.*/

public class FindModulusPower2 {
    public static void main(String[] arguments)
    {
        // n % d without using / or %. ===> given d is always a power of 2 number.
        int n=19;
        int d=4;
        System.out.println(n+" modulo "+d+" with bitShifting = "+ getModuloD_Pow2(n,d));

    }

    private static int getModuloD_Pow2(int number, int deNom2) {

        return (number & (deNom2 - 1));
    }
}
/**    Generalizing the above pattern, a number that can be written in 2n form will have only one bit set
 *  followed by n zeros on the right side of 1. When a number (N) divided by (2n), the bit positions
 *  corresponding to the above mentioned zeros will contribute to the remainder of division operation.
 *  An example can make it clear,

        N = 87 (1010111 – binary form)

        N%2 = N & (2-1) = 1010111 & 1 = 1 = 1

        N%4 = N & (4-1) = 1010111 & 11 = 11 = 3

        N%8 = N & (8-1) = 1010111 & 111 = 111 = 7

        N%16 = N & (16-1) = 1010111 & 1111 = 111 = 7

        N%32 = N & (32-1) = 1010111 & 11111 = 10111 = 23

        Modulus operation over exact powers of 2 is simple and faster bitwise ANDing.
        This is the reason, programmers usually make buffer length as powers of 2.

        Note that the technique will work only for divisors that are powers of 2.*/

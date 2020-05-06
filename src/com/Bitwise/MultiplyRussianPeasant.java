package com.Bitwise;
//
//There are many other ways to multiply two numbers (For example, see this). One interesting method
// is the Russian peasant algorithm. The idea is to double the first number and halve the second
// number repeatedly till the second number doesn’t become 1. In the process, whenever the second
// number become odd, we add the first number to result (result is initialized as 0)
//        The following is simple algorithm.
//
//        Let the two given numbers be 'a' and 'b'
//        1) Initialize result 'res' as 0.
//        2) Do following while 'b' is greater than 0
//        a) If 'b' is odd, add 'a' to 'res'
//        b) Double 'a' and halve 'b'
//        3) Return 'res'.

public class MultiplyRussianPeasant {
    // Function to multiply two
    // numbers using Russian Peasant method
    static int russianPeasant(int a, int b)
    {
        // initialize result
        int res = 0;

        // While second number doesn't become 1
        while (b > 0)
        {
            // If second number becomes odd,
            // add the first number to result
            if ((b & 1) != 0)
                res = res + a;

            // Double the first number
            // and halve the second number
            a = a << 1;  // left shift equals multiplying by 2
            b = b >> 1;
        }
        return res;
    }

    // driver program
    public static void main (String[] args)
    {
        System.out.println(russianPeasant(18, 1));
        System.out.println(russianPeasant(20, 12));
    }
}

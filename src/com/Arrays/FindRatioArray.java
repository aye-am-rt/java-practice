package com.Arrays;

/**Find the ratio of number of elements in two Arrays from their individual and combined average

 Given the average of elements in two arrays as ‘a’ and ‘b’ respectively, and their
 combined average as ‘c’, the task is to find the ratio of the number of elements in two array.

        Examples:

        Input:  a = 2, b = 8, c = 5
        Output: 1:1

        Input: a = 4, b = 10, c = 6
        Output: 2:1

 Let the number of elements in two arrays are respectively x and y.
 So sum of all elements in the combined array is (a*x + b*y).
 Total number of elements in the combined array is (x + y) and let f = x / y.
 So, (a*x + b*y) / (x + y) = c
 (a*f + b) / (f + 1) = c
 f * (c - a) = b - c
 So, f = (b - c) / (c - a)
 Here f is our required answer.

 */

public class FindRatioArray {
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }

    // function to find the ratio
    // of number of array elements
    static void FindRatio(int a, int b, int c)
    {
        int up = Math.abs(b - c);
        int down = Math.abs(c - a);

        // calculating GCD of them
        int g = gcd(up, down);

        // make neumarator and
        // denominator coprime
        up /= g;
        down /= g;

        System.out.println(up + ":" + down);
    }

    // Driver Code
    public static void main (String[] args)
    {
        int a = 4, b = 10, c = 6;

        FindRatio(a, b, c);
    }

}

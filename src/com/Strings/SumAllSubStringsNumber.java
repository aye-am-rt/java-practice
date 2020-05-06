package com.Strings;
/*
Sum of all substrings of a string representing a number | Set 2 (Constant Extra Space)
Given a string representing a number, we need to get the sum of all possible sub strings of this string.

Examples :

Input : s = "6759"
Output : 8421
sum = 6 + 7 + 5 + 9 + 67 + 75 +
59 + 675 + 759 + 6759
= 8421*/
/**

The solution is based on a different approach which does not use any extra space.

    This problem can be viewed as follows.
    Let number be s = “6759”

    1    10    100    1000
    6   1     1      1       1
    7   2     2      2
    5   3     3
    9   4
    The above table indicates that, when all the substrings are converted further to the ones, tens,
 hundreds etc.. form, each index of the string will have some fixed occurrence. The 1st index will have
 1 occurrence each of ones, tens etc..The 2nd will have 2, 3rd will have 3 and so on.
    One more point is that the occurrence of the last element will only be restricted to ones. Last 2nd
 element will be restricted to ones and tens. last 3rd will be up to a hundred and so on.
    From the above points lets find out the sum.

    sum = 6*(1*1 + 1*10 + 1*100 + 1*1000) + 7*(2*1 + 2*10 + 2*100) +
    5*(3*1 + 3*10) + 9*(4*1)
    = 6*1*(1111) + 7*2*(111) + 5*3*(11) + 9*4*(1)
    = 6666 + 1554 + 165 + 36
    = 8421
    Now, to handle the multiplication we will be having a multiplying factor which starts from 1. It’s clear
 from the example that the multiplying factor(in reverse) is 1, 11, 111, … and so on. So the multiplication
 will be based on three factors. number, its index, and a multiplying factor.
*/


public class SumAllSubStringsNumber {
    // Returns sum of all substring of num
    public static long sumOfSubstrings(String num)
    {
        long sum = 0; // Initialize result

        // Here traversing the array in reverse
        // order.Initializing loop from last
        // element.
        // mf is multiplying factor.
        long mf = 1;
        for (int i = num.length() - 1; i >= 0; i --)
        {
            // Each time sum is added to its previous
            // sum. Multiplying the three factors as
            // explained above.
            // s[i]-'0' is done to convert char to int.
            sum += (num.charAt(i) - '0') * (i + 1) * mf;

            // Making new multiplying factor as
            // explained above.
            mf = mf * 10 + 1;
        }

        return sum;
    }
    //  Driver code to test above methods
    public static void main(String[] args)
    {
        String num = "6759";

        System.out.println(sumOfSubstrings(num));

    }
}

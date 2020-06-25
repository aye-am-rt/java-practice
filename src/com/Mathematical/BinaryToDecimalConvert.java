package com.Mathematical;

import java.util.Arrays;

/**
Convert Binary fraction to Decimal
Given an string of binary number n. Convert binary fractional n into it’s decimal equivalent.

Exanples:

Input: n = 110.101
Output: 6.625

Input: n = 101.1101
Output: 5.8125
Following are the steps of converting binary fractional to decimal.

A) Convert the integral part of binary to decimal equivalent

Multiply each digit separately from left side of radix point till the first digit by 2^0, 2^1, 2^2,......
 respectively. Add all the result coming from step 1.
Equivalent integral decimal number would be the result obtained in step 2.

B) Convert the fractional part of binary to decimal equivalent

Divide each digit from right side of radix point till the end by 2^1, 2^2, 2^3, ....... respectively.
Add all the result coming from step 1.
Equivalent fractional decimal number would be the result obtained in step 2.
C) Add both integral and fractional part of decimal number.

Illustration
Let's take an example for n = 110.101
Step 1: Conversion of 110 to decimal
=> (110)2 = (1*2^2) + (1*2^1) + (0*2^0)
=> (110)2 = 4 + 2 + 0
=> (110)2 = 6
So equivalent decimal of binary integral is 6.

Step 2: Conversion of .101 to decimal
=> 0.1012 = (1*1/2) + (0*1/22) + (1*1/23)
=> 0.1012 = 1*0.5 + 0*0.25 + 1*0.125
=> 0.1012 = 0.625
So equivalent decimal of binary fractional is 0.625

Step 3: Add result of step 1 and 2.
=> 6 + 0.625 = 6.625*/

public class BinaryToDecimalConvert {
    public static void main(String[] args)
    {
        double n = 110.101;  // Output: 6.625
        System.out.println(BinaryToDecimal(n));

        System.out.println("*************************");

        n = 101.1101;  // Output: 5.8125
        System.out.println(BinaryToDecimal(n));
    }

    private static double BinaryToDecimal(double binNum) {
        if(binNum==0.0)
            return 0.0;

        String[] parts= String.valueOf(binNum).split("\\.", 2);
        System.out.println(Arrays.toString(parts));

        int intL = parts[0].length();
        double intPart=0.0;
        for (int i = 0; i < intL ; i++)
        {
           intPart += (parts[0].charAt(intL- i - 1) - '0')*Math.pow(2.0, i) ;
        }
        System.out.println("int part = "+intPart);
        int frL=parts[1].length();
        double fraPart = 0.0;
        for (int i = 1; i <= frL; i++)
        {
            fraPart += Character.getNumericValue(parts[1].charAt(i-1))*Math.pow(2.0,-i);
        }
        System.out.println("fra part = "+fraPart);

        return intPart+fraPart;
    }
}

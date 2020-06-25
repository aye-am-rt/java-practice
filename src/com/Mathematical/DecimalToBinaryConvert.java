package com.Mathematical;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
Convert decimal fraction to binary number
Given an fraction decimal number n and integer k, convert decimal number n into equivalent
binary number up-to k precision after decimal point.
Examples:

Input: n = 2.47, k = 5
Output: 10.01111

Input: n = 6.986 k = 8
Output: 110.11111100
We strongly recommend that you click here and practice it, before moving on to the solution.
A) Convert the integral part of decimal to binary equivalent

Divide the decimal number by 2 and store remainders in array.
Divide the quotient by 2.
Repeat step 2 until we get the quotient equal to zero.
Equivalent binary number would be reverse of all remainders of step 1.
B) Convert the fractional part of decimal to binary equivalent

Multiply the fractional decimal number by 2.
Integral part of resultant decimal number will be first digit of fraction binary number.
Repeat step 1 using only fractional part of decimal number and then step 2.



Let's take an example for n = 4.47 k = 3

Step 1: Conversion of 4 to binary
1. 4/2 : Remainder = 0 : Quotient = 2
2. 2/2 : Remainder = 0 : Quotient = 1
3. 1/2 : Remainder = 1 : Quotient = 0

So equivalent binary of integral part of decimal is 100.

Step 2: Conversion of .47 to binary
1. 0.47 * 2 = 0.94, Integral part: 0
2. 0.94 * 2 = 1.88, Integral part: 1
3. 0.88 * 2 = 1.76, Integral part: 1

So equivalent binary of fractional part of decimal is .011

Step 3: Combined the result of step 1 and 2.

Final answer can be written as:
100 + .011 = 100.011*/

public class DecimalToBinaryConvert {
    public static void main(String[] args)
    {
        double n = 4.47;
        int k = 3;
        System.out.println(decimalToBinary(n, k));

        System.out.println("*************************");

        n = 6.986;
        k = 5;
        System.out.println(decimalToBinary(n, k));
    }

    private static String decimalToBinary(double num, int kPres) {
        if(num==0.0)
            return "0";

//  int[] parts= Arrays.stream(String.valueOf(num).split("\\.", 3)).mapToInt(Integer::parseInt).toArray();

//  int Integral = (int) num;
//  double fractional = num - Integral;

        String[] parts= String.valueOf(num).split("\\.", 3);
        System.out.println(Arrays.toString(parts));

        StringBuilder sbInt= new StringBuilder();
        StringBuilder sbDec=new StringBuilder();

        int intPart = Integer.parseInt(parts[0]);
        System.out.println("int part "+intPart);

        while(intPart!=0)
        {
            sbInt.append(intPart%2);
            intPart/=2;
        }
        double decPart = Double.parseDouble("0." + parts[1]);
        System.out.println("dec part "+decPart);

        for (int i = 0; i < kPres; i++) {
            decPart = decPart*2;
            sbDec.append(String.valueOf(decPart).charAt(0));
            decPart=Double.parseDouble(String.valueOf(decPart).substring(1));
        }
        return sbInt.reverse().append(".").append(sbDec).toString();
    }
}

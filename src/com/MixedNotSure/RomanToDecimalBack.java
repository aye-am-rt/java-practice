package com.MixedNotSure;
/*
Converting Roman Numerals to Decimal lying between 1 to 3999
Given a Romal numeral, the task is to find its corresponding decimal value.

Example :

Input: IX
Output: 9
IX is a Roman symbol which represents 9

Input: XL
Output: 40
XL is a Roman symbol which represents 40

Input: MCMIV
Output: 1904
M is a thousand,
CM is nine hundred and
IV is four*/
/**
Approach: A number in Roman Numerals is a string of these symbols written in descending
 order(e.g. M’s first, followed by D’s, etc.). However, in a few specific cases, to avoid four
 characters being repeated in succession(such as IIII or XXXX), subtractive notation is often
 used as follows:

I placed before V or X indicates one less, so four is IV (one less than 5) and 9 is
 IX (one less than 10).
X placed before L or C indicates ten less, so forty is XL (10 less than 50) and 90 is
 XC (ten less than a hundred).
C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than
 five hundred) and nine hundred is CM (a hundred less than a thousand).
Algorithm to convert Roman Numerals to Integer Number:

Split the Roman Numeral string into Roman Symbols (character).
Convert each symbol of Roman Numerals into the value it represents.
Take symbol one by one from starting from index 0:
If current value of symbol is greater than or equal to the value of next symbol, then add this
 value to the running total.
else subtract this value by adding the value of next symbol to the running total.*/
//
//Complexity Analysis:
//
//Time Complexity: O(n), where n is the length of the string.
//Only one traversal of the string is required.
//Space Complexity: O(1).
public class RomanToDecimalBack {
    public static void main(String[] args)
    {
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral" + " is " +romanToDecimal(str));
    }

    private static int romanToDecimal(String str) {
        int res =0;
        for (int i = 0; i < str.length(); i++)
        {
            int s1=GetRomanSymbol(str.charAt(i));

            if(i+1 < str.length())
            {
                int s2=GetRomanSymbol(str.charAt(i+1));

                if(s1>=s2)
                {
                    // Value of current symbol is greater or equal to the next symbol
                    res = res + s1;
                }
                else
                {
                    // Value of current symbol is less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            }
            else
            {
                res=res+s1;
                i++;
            }
        }
        return res;
    }

    private static int GetRomanSymbol(char charAt) {
        if (charAt == 'I')
            return 1;
        if (charAt == 'V')
            return 5;
        if (charAt == 'X')
            return 10;
        if (charAt == 'L')
            return 50;
        if (charAt == 'C')
            return 100;
        if (charAt == 'D')
            return 500;
        if (charAt == 'M')
            return 1000;
        return -1;
    }
}

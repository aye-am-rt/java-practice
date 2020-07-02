package com.Mathematical;
/**
Program to add two fractions
Add two fraction a/b and c/d and print answer in simplest form.

Examples :
Input:  1/2 + 3/2
Output: 2/1

Input:  1/3 + 3/9
Output: 2/3

Input:  1/5 + 3/15
Output: 2/5

Algorithm to add two fractions

Find a common denominator by finding the LCM (Least Common Multiple) of the two denominators.
Change the fractions to have the same denominator and add both terms.
Reduce the final fraction obtained into its simpler form by dividing both numerator and denominator
 by there largest common factor.*/

public class SimpleFractionsSum {
    // Driver program
    public static void main(String[] args)
    {
        int num1=1, den1=500, num2=2, den2=1500;
        System.out.print(num1+"/"+den1+" + "+num2+"/"+den2+" is equal to (simplest form ) =  ");
        addFractionPrintSimplest(num1, den1, num2, den2);
    }

    private static void addFractionPrintSimplest(int num1, int den1, int num2, int den2) {
        if(den1==0 || den2==0)
        {
            throw new IllegalArgumentException();
        }
        if(num1==0)
        {
            System.out.println(num2+"/"+den2);
            return;
        }
        if(num2==0)
        {
            System.out.println(num1+"/"+den1);
            return;
        }
        int num = (num1*den2) + (num2*den1);
        int den = den1*den2;

        int gcd = findGcd(num,den);

        System.out.println((num/gcd)+"/"+(den/gcd));
    }

    private static int findGcd(int a, int b) {
        if(a==0)
            return b;
        else
            return findGcd(b%a,a);
    }
}

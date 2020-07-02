package com.Mathematical;
/**
Check if a number is a power of another number
Given two positive numbers x and y, check if y is a power of x or not.
Examples :
Input:  x = 10, y = 1
Output: True
x^0 = 1

Input:  x = 10, y = 1000
Output: True
x^3 = 1

Input:  x = 10, y = 1001
Output: False

A simple solution is to repeatedly compute powers of x. If a power becomes equal to y,
 then y is a power, else not.

public class Test {
public static void main(String[] args)
{
// check the result for true/false and print.
System.out.println(isPower(10, 1) ? 1 : 0);
System.out.println(isPower(1, 20) ? 1 : 0);
System.out.println(isPower(2, 128) ? 1 : 0);
System.out.println(isPower(2, 30) ? 1 : 0);
}

public static boolean isPower(int x, int y)
{
// The only power of 1 is 1 itself
if (x == 1)
return (y == 1);

// Repeatedly compute power of x
int pow = 1;
while (pow < y)
pow = pow * x;

// Check if power of x becomes y
return (pow == y);
}
}
*/

/**Alternate Solution :
The idea is to take log of y in base x. If it turns out to be an integer, we return true. Else false.*/

public class CheckIf_Y_isPowerOf_X {
    public static void main(String[] args)
    {
        if(isPower(27, 729))
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean isPower(int base, int target)
    {

        int resInt = (int) Math.log10(target) / (int) Math.log10(base);

        double resDouble = Math.log10(target) / Math.log10(base);

        return resInt==resDouble;
    }
}

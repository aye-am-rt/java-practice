package com.Mathematical;
/**
To check a number is palindrome or not without using any extra space
Given a number ‘n’ and our goal is to find out it is palindrome or not without using
any extra space. We can’t make a new copy of number .

Examples:

Input  : 2332
Output : Yes it is Palindrome.
Explanation:
original number = 2332
reversed number = 2332
Both are same hence the number is palindrome.

Input :1111
Output :Yes it is Palindrome.

Input : 1234
Output : No not Palindrome.

A recursive solution is discussed in below post.
Check if a number is Palindrome

In this post a different solution is discussed.
1) We can compare the first digit and the last digit, then we repeat the process.
2) For the first digit, we need the order of the number. Say, 12321. Dividing this by
 10000 would get us the leading 1. The trailing 1 can be retrieved by taking the mod with 10.
3 ) Now, to reduce this to 232.

(12321 % 10000)/10 = (2321)/10 = 232
4 ) And now, the 10000 would need to be reduced by a factor of 100.
Here is the implementation of the above algorithm :*/

public class CheckPalindromeO1SP {
    public static void main(String[] args)
    {
        int num = 1111;
        if(isPalindrome(num))
            System.out.println("Yes, "+ num +" it is Palindrome");
        else
            System.out.println("No, "+ num +" is not Palindrome");
    }

    private static boolean isPalindrome(int num) {
        int divisor10s=1;
        while(num/divisor10s >= 10)
        {
            divisor10s *= 10;
        }
        while (num!=0)
        {
            int firstDigit = num/divisor10s;
            int lastDigit = num%10;
            if(firstDigit != lastDigit)
                return false;
            // Removing the leading and trailing
            // digit from number
            num = (num % divisor10s) / 10;

            // Reducing divisor by a factor
            // of 2 as 2 digits are dropped
            divisor10s = divisor10s / 100;
        }
        return true;
    }
}

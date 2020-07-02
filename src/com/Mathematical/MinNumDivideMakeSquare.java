package com.Mathematical;
/*
Find minimum number to be divided to make a number a perfect square
Given a positive integer n. Find the minimum number which divide n to make it a perfect square.

Examples:

Input : n = 50
Output : 2
By Dividing n by 2, we get which is a perfect square.

Input : n = 6
Output : 6
By Dividing n by 6, we get which is a perfect square.

Input : n = 36
Output : 1

A number is perfect square if all prime factors appear even number of times. The idea is to find the
prime factor of n and find each prime factor power. Now, find and multiply all the prime factor whose
power is odd. The resultant of the multiplication is the answer*/

public class MinNumDivideMakeSquare {
    public static void main (String[] args)
    {
        int n = 72;
        System.out.print("the minimum number which divide n to make it a perfect square.== ");
        System.out.println(findMinNumberToMakePerfectSquare(n));
    }

    private static int findMinNumberToMakePerfectSquare(int num) {
        if(num==0 || num==1)
            return num;

        int count=0; int ans=1;
        if(num%2==0)  // If count is odd, it must be removed by dividing n by prime number.
        {
            count++;
            num/=2;
        }
        if(count==1)
        { ans*=2; }
        for (int i = 3; i < Math.sqrt(num); i+=2)
        {
            count=0;
            while (num%i==0)
            {
                count++;
                num/=i;
            }
            if(count%2==1) // If count is odd, it must be removed by dividing n by prime number.
            {
                ans*=i;
            }
        }
        if(num>2)
            ans*=num;

        return ans;
    }
}

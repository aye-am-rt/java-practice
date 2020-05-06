package com.Arrays.GST;

public class IsPerfectSquare {
    public static void main(String[] args) {
        int N = 16;
        System.out.println(N + " is perfect square: " + isPerfectSquare(N));
        N = 32;
        System.out.println(N + " is perfect square: " + isPerfectSquare(N));
    }

    private static boolean isPerfectSquare(int num) {
        if(num==0 || num==1)
            return true;
        int left=0;
        int right=num;
        while(left<right)
        {
            int mid = right- (right-left)/2;
            if(num%mid==0 && num==mid*mid)
                return true;
            else if(mid*mid<num)
                left= mid + 1;
            else
                right = mid -1;
        }
        return false;
    }
}

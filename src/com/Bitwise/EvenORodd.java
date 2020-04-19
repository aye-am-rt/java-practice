package com.Bitwise;
//Check a number is odd or even without modulus operator
//        Given a number, check whether it is even or odd.

public class EvenORodd {
    public static void main(String[] args)
    {

        int n = 101;
        if(isEvenLightSwitch(n))
            System.out.println("Even");
        else
            System.out.println("Odd");

        if(isEven2MlDv(n))
            System.out.println("Even");
        else
            System.out.println("Odd");

        if(isEvenBitwiseCheck(n))
            System.out.println("Even");
        else
            System.out.println("Odd");

    }
//    input : 5    // odd
//              00000101
//            & 00000001
//            --------------
//            00000001
//            --------------
//    input : 8     //even
//              00001000
//            & 00000001
//            --------------
//            00000000
//            --------------

    private static boolean isEvenBitwiseCheck(int n) {
/*      Method 3: Using Bitwise operator &.
        A better solution is to use bitwise operators. We need to check whether last bit is 1 or not.
        If last bit is 1 then the number is odd, otherwise always even.*/
        return (n & 1) != 1;
    }

    private static boolean isEven2MlDv(int n) {
        return (n / 2) * 2 == n;
    }

    private static boolean isEvenLightSwitch(int n) {
        boolean isEven=true;
        for (int i = 1; i <= n; i++) {
            isEven = ! isEven;
        }
        return isEven;
    }
}

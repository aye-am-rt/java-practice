package com.Arrays.GST;
//
//Find the Missing Number
//        You are given a list of n-1 integers and these integers are in the range of 1 to n.
//        There are no duplicates in the list. One of the integers is missing in the list.
//        Write an efficient code to find the missing integer.
//
//        Example :
//
//        Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
//        Output: 5

public class FindMissingNum {
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 4, 5 };
        System.out.println(getMissingNoWithoutOverFlow(arr, arr.length));
        System.out.println(getMissingNoByXOR(arr, arr.length));
    }
/**
Method 2: This method uses the technique of XOR to solve the problem.

    Approach:
XOR has certain properties
Assume a1 ^ a2 ^ a3 ^ …^ an = a and a1 ^ a2 ^ a3 ^ …^ an-1 = b
Then a ^ b = an
Using this property, the missing element can be found. Calculate XOR of all the natural
 number from 1 to n and store it as a. Now calculate XOR of all the elements of the array and
 store it as b. The missing number will be a ^ b.
^ is XOR operator.

    Algorithm:
Create two variables a = 0 and b = 0
Run a loop from 1 to n with i as counter.
For every index update a as a = a ^ i
Now traverse the array from start to end.
For every index update b as b = b ^ array[i]
Print the missing number as a ^ b.*/

    private static int getMissingNoByXOR(int[] arr, int length) {
        if(length<2)
            throw new IllegalArgumentException();
        int xor1toN=1;
        int xorArElems=0;
        for (int i = 2; i < (length+2); i++) {
            xor1toN ^= i;
            xorArElems ^= arr[i-2];
        }
        return xor1toN ^ xorArElems ;
    }

    private static int getMissingNoWithoutOverFlow(int[] arr, int length) {
        if(length<2)  // There are no duplicates in the list
            throw new IllegalArgumentException();
        int total1toN=1;   //these integers are in the range of 1 to n.
        for (int i = 2; i <= (length+1) ; i++)
        { //In order to avoid Integer Overflow, we can pick one number from known numbers and subtract
            // one number from given numbers. This way we won’t have Integer Overflow ever.
            total1toN += i;
            total1toN -= arr[i-2];
        }
        return total1toN;
    }
}

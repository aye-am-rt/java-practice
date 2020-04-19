package com.Arrays.GST;
//
//Find the Missing Number
//        You are given a list of n-1 integers and these integers are in the range of 1 to n.
//        There are no duplicates in the list. One of the integers is missing in the list.
//        Write an efficient code to find the missing integer.
//
//        Example :
//
//        Input: arr[] = {1, 2, 4,, 6, 3, 7, 8}
//        Output: 5

public class FindMissingNum {
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 4, 5 };
        System.out.println(getMissingNoWithoutOverFlow(arr, arr.length));
        System.out.println(getMissingNoByXOR(arr, arr.length));
    }

    private static int getMissingNoByXOR(int[] arr, int length) {
        if(length<2)
            throw new IllegalArgumentException();
        int xorAll=1;
        int xorElem=0;
        for (int i = 2; i < (length+2); i++) {
            xorAll ^= i;
            xorElem ^= arr[i-2];
        }
        return xorAll ^ xorElem ;
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

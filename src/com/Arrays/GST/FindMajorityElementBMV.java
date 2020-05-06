package com.Arrays.GST;
//
//Majority Element- Boyer–Moore majority vote algorithm
//        Objective:  Given an array of integer write an algorithm to find the majority element in it
//        (if exist).
//        Majority Element: If an element appears more than n/2 times in array where n is the size of
//        the array.
//        Example:
//        int [] arrA = {1,3,5,5,5,5,4,1,5};
//        Output: Element appearing more than n/2 times: 5
//        int []arrA = {1,2,3,4};
//        Output: No element appearing more than n/2 time
/**
As per above algorithm we can divide out implementation into two parts
        First iteration – Find the element which could be a majority element.
        Second iteration – check the element(found in first iteration) count is greater than n/2
 if there is no majority, the algorithm will not detect that fact, and will still output one of the
 elements. A version of the algorithm that makes a second pass through the data can be used to verify
 that the element found in the first pass really is a majority.
 */

public class FindMajorityElementBMV {
    public static void main(String[] args) {
        int [] arrA = {6,3,6,6,4,6,6,1,1};
        findMajorityElementByBMVAlgorithm(arrA,arrA.length);
    }

    private static void findMajorityElementByBMVAlgorithm(int[] arr, int ln) {
        if(ln<1)
            throw new IllegalArgumentException();
        int majorityElement=arr[0];
        int count=1;
        for (int i = 1; i < ln; i++) {
            if(majorityElement==arr[i])
                count+=1;
            else if(count==0)
            {
                majorityElement=arr[i];
                count=1;
            }
            else
                count--;
        }
        //check if majorityElement is appearing more than n/2 times
        count=0;
        for (int i = 0; i < ln; i++) {
            if(arr[i]==majorityElement)
                count++;
        }
        if (count>ln/2)
            System.out.println("(Boyer_Moore)Element appearing more than n/2 times: " + majorityElement);
        else
            System.out.println("No element appearing more than n/2 times");
    }
}

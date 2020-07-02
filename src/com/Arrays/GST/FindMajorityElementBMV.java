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
        for (int i = 1; i < ln; i++)
        {
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
/*
METHOD 4 (Using Hashmap):

Approach: This method is somewhat similar to Moore voting algorithm in terms of time complexity, but in
this case, there is no need for the second step of Moore voting algorithm. But as usual, here space
 complexity becomes O(n).
In Hashmap(key-value pair), at value, maintain a count for each element(key) and whenever the count is
greater than half of the array length, return that key(majority element).
Algorithm:
Create a hashmap to store a key-value pair, i.e. element-frequency pair.
Traverse the array from start to end.
For every element in the array, insert the element in the hashmap if the element does not exist as key,
else fetch the value of the key ( array[i] ) and increase the value by 1
If the count is greater than half then print the majority element and break.
If no majority element is found print “No Majority element”

Complexity Analysis:
Time Complexity: O(n).
One traversal of the array is needed, so the time complexity is linear.
Auxiliary Space : O(n).
Since a hashmap requires linear space.
*/
/**
METHOD 5
Approach:The idea is to sort the array. Sorting makes similar elements in the array adjacent, so
 traverse the array and update the count until the present element is similar to the previous one.
 If the frequency is more than half the size of the array, print the majority element.
Algorithm:
Sort the array and create a varibale count and previous ,prev = INT_MIN.
Traverse the element from start to end.
If the current element is equal to the previous element increase the count.
Else set the count to 1.
If the count is greater than half the size of array, print the element as majority element and break.
If no majority element found, print “No majority element”*/



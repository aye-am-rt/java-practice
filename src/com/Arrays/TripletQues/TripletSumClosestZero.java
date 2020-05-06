package com.Arrays.TripletQues;

//Given an array, find three-element sum closest to Zero
//        Objective: Given an array of integers, find the sum of any three elements which is closest
//        to zero. The array may contain positive and negative elements.
//        Example:
//        Given Input: [-1, 4, -2, 5, 10, -5]
//        Minimum Sum with three elements is: 1
//        Explanation:  -1, 4, -2 sums to -1

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
Better Solution:
Sort the given array in ascending order.
Initialize sum = 0, positiveClose = INTEGER_MAXIMUM, negativeClose = INTEGER_MINIMUM.
Use two loops.
Fix the element using the outer loop. Call it first
sum = first element.
Inside the inner loop, take two pointers, second and third. second at the next element to the
first element and third at the last element in the array. Do sum = sum +second+third.
Now if sum = 0, return 0.
Else if sum > 0 , do positiveClose = minimum(positiveClose, sum)
Else do negativeClose = maximum(negativeClose, sum)
If abs(negativeClose)<positiveClose return negativeClose else return positiveClose.
Time Complexity: O(N2)*/

public class TripletSumClosestZero {
    public static void getIPAddress(){
        try {
            //get the local host
            InetAddress localHost = InetAddress.getLocalHost();
            //get the myIpAddress
            String myIpAddress = localHost.getHostAddress();
            System.out.println("IP ADDRESS is : " + myIpAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        getIPAddress();
        int [] input = {-1, 4, -2, 5, 10, -5};
        System.out.println("Minimum Sum with three elements is: " +  findTripletSumClosestToZero(input));
    }

    private static int findTripletSumClosestToZero(int[] arr) {
        if(arr.length<3) {
            System.out.println("Invalid input");
            throw new IllegalArgumentException();
        }
        int posClose=Integer.MAX_VALUE;
        int negClose=Integer.MIN_VALUE;
        int sum=0;
        System.out.println("Given Input: " +  Arrays.toString(arr));
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int l=i+1;
            int r=arr.length-1;
            while(l<r)
            {
                sum=arr[i]+arr[l]+arr[r];
                if(sum==0)
                {
                    System.out.println("elements are = "+arr[i]+" ,"+arr[l]+", "+arr[r]);
                    return 0;
                }
                else if(sum>0)
                {
                    posClose=Math.min(posClose,sum);
                    r--;
                }
                else
                {
                    negClose=Math.max(sum,negClose);
                    l++;
                }
            }
        }
        if(Math.abs(negClose)<posClose)
            return negClose;
        return posClose;
    }

}

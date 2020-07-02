package com.Arrays.PairQues;
//
//Find a pair with maximum product in array of Integers
//Given an array with both +ive and -ive integers, return a pair with highest product.
//Examples :
//
//Input: arr[] = {1, 4, 3, 6, 7, 0}
//Output: {6,7}
//
//Input: arr[] = {-1, -3, -4, 2, 0, -5}
//Output: {-4,-5}

/**A Simple Solution is to consider every pair and keep track maximum product.

import java.util.*;

class GFG {

// Function to find maximum product pair // in arr[0..n-1]
static void maxProduct(int arr[], int n)
{
if (n < 2)
{
System.out.println("No pairs exists");
return;
}

// Initialize max product pair
int a = arr[0], b = arr[1];

// Traverse through every possible pair
// and keep track of max product
for (int i = 0; i < n; i++)
for (int j = i + 1; j < n; j++)
    if (arr[i] * arr[j] > a * b){
        a = arr[i];
        b = arr[j];
    }

System.out.println("Max product pair is {" + a + ", " + b + "}");
}

public static void main(String[] args)
{
int arr[] = {1, 4, 3, 6, 7, 0};
int n = arr.length;
maxProduct(arr, n);

}
}

Output :
Max product pair is {6, 7}
Time Complexity : O(n2)


A Better Solution is to use sorting. Below are detailed steps.
1) Sort input array in increasing order.
2) If all elements are positive, then return product of last two numbers.
3) Else return maximum of products of first two and last two numbers.
Time complexity of this solution is O(nLog n). Thanks to Rahul Jain for suggesting this method.

An Efficient Solution can solve the above problem in single traversal of input array. The idea is to
 traverse the input array and keep track of following four values.
a) Maximum positive value
b) Second maximum positive value
c) Maximum negative value i.e., a negative value with maximum absolute value
d) Second maximum negative value.
At the end of the loop, compare the products of first two and last two and print the maximum of two
 products. Below is the implementation of this idea.*/

public class PairWithMaxProduct {
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int[] arr = {1, 4, 3, 6, 7, 0};
        int n = arr.length;
        PrintMaxProduct(arr, n);

    }

    private static void PrintMaxProduct(int[] arr, int n) {
        if (n < 2)
        {
            System.out.println("No pairs exists");
            return;
        }

        if (n == 2)
        {
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }
        // Initialize maximum and second maximum
        int posa = Integer.MIN_VALUE, posb = Integer.MIN_VALUE;

        // Initialize minimum and second minimum
        int nega = Integer.MIN_VALUE, negb = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
        {
            if(arr[i]>posa)
            {
                posb = posa;
                posa=arr[i];
            }
            else if(arr[i]>posb)
            {
                posb = arr[i];
            }

            if(arr[i]<0 && Math.abs(arr[i])>Math.abs(nega))
            {
                negb = nega;
                nega = arr[i];
            }
            else if(arr[i]<0 && Math.abs(arr[i])>Math.abs(negb))
            {
                negb = arr[i];
            }
        } // for loop ends here

        if ((nega * negb) > posa * posb)
            System.out.println("Max product pair is {" + nega + ", " + negb + "}");
        else
            System.out.println("Max product pair is {" + posa + ", " + posb + "}");
    }
}


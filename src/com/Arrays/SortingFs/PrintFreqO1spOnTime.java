package com.Arrays.SortingFs;

/*Count frequencies of all elements in array in O(1) extra space and O(n) time
Given an unsorted array of n integers which can contain integers from 1 to n.
Some elements can be repeated multiple times and some other elements can be absent from the array.
Count frequency of all elements that are present and print the missing elements.

Examples:

Input: arr[] = {2, 3, 3, 2, 5}
Output: Below are frequencies of all elements
1 -> 0
2 -> 2
3 -> 2
4 -> 0
5 -> 1
Explanation: Frequency of elements 1 is
0, 2 is 2, 3 is 2, 4 is 0 and 5 is 1.

simple solution ===
Approach: Create an extra space of size n, as elements of the array is in range 1 to n.
 Use the extra space as HashMap. Traverse the array and update the count of the current element.
 Finally, print the frequencies of the HashMap along with the indices.
Algorithm:
Create an extra space of size n (hm), use it as an HashMap.
Traverse the array froms start to end.
For every element upadate hm[array[i]-1], i.e. hm[array[i]-1]++
Run a loop from 0 to n and print hm[array[i]-1] along with the index i
*/
/**
Method 3: By adding ‘n’ to keep track of counts.

Approach: All the array elements are from 1 to n. Reduce every element by 1. The array elements now are
 in range 0 to n-1 so it can be said that for every index i, floor(array[i]/n) = 0.
So as previously said that the idea is to traverse the given array, use elements as an index and
 store their counts at the index. Consider the basic approach, a Hashmap of size n is needed and
 the array is also of size n. So the array can be used as a hashmap but the difference is that
 instead of replacing elements add n to the array[i]th index.
So after the updadation the array[i]%n will give the ith element and array[i]/n will
 give the frequency of i+1.*/

public class PrintFreqO1spOnTime {

    // Function to find counts of all elements present in
    // arr[0..n-1]. The array elements must be range from
    // 1 to n
    static void printFrequency(int[] arr, int n)
    {
        // Subtract 1 from every element so that the elements
        // become in range from 0 to n-1
        for (int j = 0; j < n; j++)
            arr[j] = arr[j] - 1;

        // Use every element arr[i] as index and add 'n' to
        // element present at arr[i]%n to keep track of count of
        // occurrences of arr[i]
        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n;

        // To print counts, simply print the number of times n
        // was added at index corresponding to every element
        for (int i = 0; i < n; i++)
            System.out.print(i + 1 + "->" + (arr[i] / n) +" ,  " );
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 3, 2, 5};
        printFrequency(arr, arr.length);
        System.out.println("\n*************");

        int[] arr1 = {1};
        printFrequency(arr1, arr1.length);
        System.out.println("\n*************");

        int[] arr3 = {4, 4, 4, 4};
        printFrequency(arr3, arr3.length);
        System.out.println("\n*************");

        int[] arr2 = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
        printFrequency(arr2, arr2.length);
        System.out.println("\n*************");

        int[] arr4 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        printFrequency(arr4, arr4.length);
        System.out.println("\n*************");

        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        printFrequency(arr5, arr5.length);
        System.out.println("\n*************");

        int[] arr6 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        printFrequency(arr6, arr6.length);
        System.out.println("\n*************");
    }
}

/*
Method 2: By making elements negative.

Approach: The idea is to traverse the given array, use elements as an index and store their counts
at the index. Consider the basic approach, a Hashmap of size n is needed and the array is also
of size n. So the array can be used as a hashmap, all the elements of the array are from 1 to n,
i.e all are positive elements. So the frequency can be stored as negative. This might lead to
a problem. Let i-th element be a then the count should be stored at array[a-1], but when
the frequency will be stored the element will be lost. To deal with this problem, first,
replace the ith element by array[a-1] and then put -1 at array[a-1]. So our idea is to
replace the element by frequency and store the element in the current index and if the element
at array[a-1] is already negative then it is already replaced by a frequency so decrement
array[a-1].
Algorithm:
Traverse the array from start to end.
For each element check if the element is less than or equal to zero or not. If negative or zero
skip the element as it is freqeuncy.
If element (e = array[i] – 1 ) is positive then check if array[e] is positive or not. If
 positive then that means it is the first occurance of e in the array and replace array[i]
 with array[e], i.e array[i] = array[e] and assign array[e] = -1. If array[e] is negative then it is
 not the first occurance, the update array[e] as array[e]–1 and update array[i] as array[i] = 0.
Again traverse the array and print i+1 as value and array[i] as frequency.
*/
/**
void findCounts(int arr[], int n)
{
    // Traverse all array elements
    int i = 0;
    while (i < n)
    {
        // If this element is already processed,
        // then nothing to do
        if (arr[i] <= 0)
        {
            i++;
            continue;
        }

        // Find index corresponding to this element
        // For example, index for 5 is 4
        int elementIndex = arr[i] - 1;

        // If the elementIndex has an element that is not
        // processed yet, then first store that element
        // to arr[i] so that we don't loose anything.
        if (arr[elementIndex] > 0)
        {
            arr[i] = arr[elementIndex];

            // After storing arr[elementIndex], change it
            // to store initial count of 'arr[i]'
            arr[elementIndex] = -1;
        }
        else
        {
            // If this is NOT first occurrence of arr[i],
            // then decrement its count.
            arr[elementIndex]--;

            // And initialize arr[i] as 0 means the element
            // 'i+1' is not seen so far
            arr[i] = 0;
            i++;
        }
    }

    System.out.println("Below are counts of all elements");
    for (int j = 0; j < n; j++)
        System.out.println(j+1 + "->" + Math.abs(arr[j]));
}
 */


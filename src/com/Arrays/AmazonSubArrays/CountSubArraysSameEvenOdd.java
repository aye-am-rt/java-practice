package com.Arrays.AmazonSubArrays;
/**

Count subarrays with same even and odd elements
Given an array of N integers, count number of even-odd subarrays. An even – odd subarray is
 a subarray that contains the same number of even as well as odd integers.

Examples :

Input : arr[] = {2, 5, 7, 8}
Output : 3
Explanation : There are total 3 even-odd subarrays.
1) {2, 5}
2) {7, 8}
3) {2, 5, 7, 8}

Input : arr[] = {3, 4, 6, 8, 1, 10}
Output : 3
Explanation : In this case, 3 even-odd subarrays are:
1) {3, 4}
2) {8, 1}
3) {1, 10}

 An Efficient approach solves the problem in O(N) time and it is based on following ideas:

 Even-odd subarrays will always be of even length.
 Maintaining track of the difference between the frequency of even and odd integers.
 Hashing of this difference of frequencies is useful in finding number of even-odd subarrays.
 The basic idea is to use the difference between the frequency of odd and even numbers to obtain an
 optimal solution. We will maintain two integer hash arrays for the positive and negative value of
 the difference.
 -> Example to understand in better way :
 -> Consider difference = freq(odd) – freq(even)
 -> To calculate this difference, increment the value of ‘difference’ when there is
 an odd integer and decrement it when there is an even integer. (initially, difference = 0)
 arr[] = {3, 4, 6, 8, 1, 10}

 index 0 1 2 3 4 5 6

 array 3 4 6 8 1 10

 difference 0 1 0 -1 -2 -1 -2

 -> Observe that whenever a value ‘k’ repeats in the ‘difference’ array, there exists an
 even-odd subarray for each previous occurrence of that value i.e. subarray exists from
 index i + 1 to j where difference[i] = k and difference[j] = k.

 -> Value ‘0’ is repeated in ‘difference’ array at index 2 and hence subarray exists for
 (0, 2] indexes. Similarly, for repetition of values ‘-1’ (at indexes 3 and 5) and ‘-2’ (at
 indexes 4 and 6), subarray exists for (3, 5] and (4, 6] indexes.*/


public class CountSubArraysSameEvenOdd {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 8, 1, 10, 5, 7};
        int n = arr.length;
        // Printing total number of even-odd sub-arrays
        System.out.println("Total Number of EvenOddSubArrays = "+ countEvenOddSubArrays(arr, n));
    }

    private static int countEvenOddSubArrays(int[] arr, int n) {
        int diffPosNegFreq=0;
        int ansCount=0;

        // hash map can also be used. below create two auxiliary hash arrays to count frequency
        // of difference, one array for non-negative difference and other array for negative
        // difference. Size of these are n+1;
        int[] hash_positive_diff = new int[n + 1];
        int[] hash_negative_diff = new int[n + 1];

        hash_positive_diff[0]=1;
        for (int i = 0; i < n; i++) {
            if((arr[i]&1)==1) // this means arr[i] is odd
                diffPosNegFreq++; // increasing on odd;
            else
                diffPosNegFreq--;

            // adding hash value of 'difference' to our answer as all the previous
            // occurrences of the same difference value will make even-odd subarray
            // ending at index 'i'.

            if(diffPosNegFreq<0)
            {
                ansCount += hash_negative_diff[-diffPosNegFreq];
                hash_negative_diff[-diffPosNegFreq]++;
            }
            else
            {
                ansCount += hash_positive_diff[diffPosNegFreq];
                hash_positive_diff[diffPosNegFreq]++;
            }
        }
        return ansCount;
    }
}

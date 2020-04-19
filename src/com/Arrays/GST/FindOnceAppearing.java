package com.Arrays.GST;

//Find the element that appears once in an array where every other element appears twice
//        Given an array of integers. All numbers occur twice except one number which occurs once.
//        Find the number in O(n) time & constant extra space.


//One solution is to check every element if it appears once or not. Once an element with single
// occurrence is found, return it. Time complexity of this solution is O(n2)

//A better solution is to use hashing.
//        1) Traverse all elements and put them in a hash table. Element is used as key and count of
//        occurrences is used as value in hash table.
//        2) Traverse the array again and print the element with count 1 in hash table.
//        This solution works in O(n) time, but requires extra space.

/**The best solution is to use XOR. XOR of all array elements gives us the number with single occurrence.
        The idea is based on following two facts.
        a) XOR of a number with itself is 0.
        b) XOR of a number with 0 is number itself.*/

public class FindOnceAppearing {
    public static void main(String[] args)
    {
        int[] arr={1,1,3,3,9,8,8};
        int n=arr.length;
        PrintOnceAppearingNumber(arr,n);
        System.out.println(5^5); System.out.println(5^8);System.out.println(4^4);
        System.out.println("*******111111");
        System.out.println(1^6);System.out.println(1^7);System.out.println(1^2);
        System.out.println("*******2");
        System.out.println(0^8);System.out.println(0^9);System.out.println(1^3);
        System.out.println("*******3");
        System.out.println(1^1);System.out.println(0^0);System.out.println(1^0);
        System.out.println("*******4");
        System.out.println(-1^6);System.out.println(-1^7);
        System.out.println("*******-5");
        System.out.println(-1^0);System.out.println(-1^-1);
        System.out.println("*******-6");
        System.out.println(-2^-2);System.out.println(-1^-2);System.out.println(-1^-3);
        System.out.println("*******-7");
    }

    private static void PrintOnceAppearingNumber(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        if(n==1)
            System.out.println("only one element in array = "+arr[0]);
        else
        {
            int xorAll=arr[0];
            for (int i = 1; i < n; i++) {
                xorAll^=arr[i];
            }
            System.out.println("the element appeared once in twice elem array = "+xorAll);
        }
    }
}
//
//    Another approach:
//        This is not an efficient approach but just another way to get the desired results.
//        If we add each number once and multiply the sum by 2, we will get twice sum of each element
//        of the array. Then we will subtract the sum of the whole array from the twice_sum and get the
//        required number (which appears once in the array).
//
//        Array [] : [a, a, b, b, c, c, d]
//        Mathematical Equation = 2*(a+b+c+d) – (a + a + b + b + c + c + d)
//
//        In more simple words: 2*(sum_of_array_without_duplicates) – (sum_of_array)
//
//        let arr[] = {7, 3, 5, 4, 5, 3, 4}
//        Required no = 2*(sum_of_array_without_duplicates) - (sum_of_array)
//        = 2*(7 + 3 + 5 + 4) - (7 + 3 + 5 + 4 + 5 + 3 + 4)
//        = 2*     19         -      31
//        = 38 - 31
//        = 7 (required answer)

/**    static int singleNumber(int[] nums, int n)
    {
        HashSet<Integer, Integer> hSet = new HashSet<>();
        long sumEachOnce = 0, sumActualArray = 0;
        for (int i = 0; i < n; i++)
        {
            if (! hSet.contains(nums[i]))// hashMap.containsKey(Object o)but in hashSet.contains(Object o)
            {
                sumEachOnce += nums[i];
                hSet.add(nums[i]);     // .put is used in hash map
            }
            sumActualArray += nums[i];
        }

        // applying the formula.
        return (int)(2 * (sum1) - sum2);
    }

    // Driver code
    public static void main(String args[])
    {
        int[] a = {2, 3, 5, 4, 5, 3, 4};
        int n = 7;
        System.out.println(singleNumber(a,n));

        int[] b = {15, 18, 16, 18, 16, 15, 89};
        System.out.println(singleNumber(b,n));
    } */

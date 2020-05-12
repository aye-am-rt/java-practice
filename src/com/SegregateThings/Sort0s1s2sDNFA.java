package com.SegregateThings;

import java.util.Arrays;

/**
 *
 Sort an array of 0s, 1s and 2s
 Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the
 given array. The functions should put all 0s first, then all 1s and all 2s in last.
 Examples:
 Input: {0, 1, 2, 0, 1, 2}
 Output: {0, 0, 1, 1, 2, 2}

 Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 *
Method 1

Approach:The problem is similar to our old post Segregate 0s and 1s in an array, and both of these
 problems are variation of famous Dutch national flag problem.
The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four
 sections:

a[1..Lo-1] zeroes (red)
a[Lo..Mid-1] ones (white)
a[Mid..Hi] unknown
a[Hi+1..N] twos (blue)
Dutch National Flag Algorithm OR 3-way Partitioning:
At first, the full array is unknown. There are three indices – low, mid and high. Initially, the
 value of low = mid = 1 and high = N.

If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
If the element is 2 then swap it with an element in high range.
Algorithm:
Keep three indices low = 1, mid = 1 and high = N and there are four ranges, 1 to low (the range
 containing 0), low to mid (the range containing 1), mid to high (the range containing unknown
 elements) and high to N (the range containing 2).
Traverse the array from start to end and mid is less than high. (Loop counter is i)
If the element is 0 then swap the element with the element at index low and update low = low + 1
 and mid = mid + 1
If the element is 1 then update mid = mid + 1
If the element is 2 then swap the element with the element at index high and update high = high – 1
 and update i = i – 1. As the swapped element is not processed
Print the output array.

 */

public class Sort0s1s2sDNFA {
    public static void main(String[] args)
    {
        int[] arr = { 0, 1, 1, 0, 1, 1, 1, 2, 0, 0, 0, 1 };
        int arr_size = arr.length;
        sort012DNFA(arr, arr_size);
        System.out.println("Array after segregation ");
        System.out.println(Arrays.toString(arr));

        System.out.println("********* diff way 2 same problems sort 0 1 2 ****************");

        int[] arr2= {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int n2=arr2.length;
        sort012BySimpleCountAndPut(arr2, n2);
        System.out.println("Array after segregation ");
        System.out.println(Arrays.toString(arr2));

    }
//    Complexity Analysis:
//    Time Complexity: O(n). Only two traversals of the array is needed.
//    Space Complexity: O(1). As no extra space is required.
    private static void sort012BySimpleCountAndPut(int[] arr2, int n2) {
        int cnt0=0,cnt1=0,cnt2=0;
        for (int i = 0; i < n2; i++) {
            if(arr2[i]==0)
                cnt0++;
            if(arr2[i]==1)
                cnt1++;
            if(arr2[i]==2)
                cnt2++;
        }
        int i=0;
        while(cnt0>0) {
            arr2[i++] = 0;
            cnt0--;
        }
        while(cnt1>0) {
            arr2[i++] = 1;
            cnt1--;
        }
        while(cnt2>0) {
            arr2[i++] = 2;
            cnt2--;
        }
    }



//    Time Complexity: O(n). Only one traversal of the array is needed.
//    Space Complexity: O(1).No extra space is required.
    private static void sort012DNFA(int[] arr, int ln) {
        int low=0;
        int mid=0;
        int high=ln-1;

        while(mid<=high)
        {
            switch (arr[mid])
            {
                case 0:
                {
                    int temp=arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++; mid++; break;
                }
                case 1:
                    mid++; break;
                case 2:
                {
                    int temp=arr[mid];
                    arr[mid]=arr[high];
                    arr[high]=temp;
                    high--; break;
                }
                default:
                    break;
            }
        }
    }
}

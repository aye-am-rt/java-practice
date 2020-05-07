package com.Arrays.MergingArrays;

/*
Efficient Solution: The idea becomes clear once we start looking at the k arrays as the intermediate state of merge sort algorithm.

Since, we have got k arrays that are already sorted, all we need to do is merge the k arrays. Merging them, will create a recursion tree of log(k) height because, at each step, the number of remaining arrays becomes half. At each height, the algorithm will take a time of O(N*k). Thus, the time complexity boils down to O( N*k * log(k) ).

Algorithm:

Initialize the output array with the size N*k.
Call the function divide. Let l and r represent the range of arrays that are to be merged
and thus vary between 0 to k-1.
At each step, we call the left and right half of the range recursively so that, they will
 be sorted and stored in the output array.
After that, we merge the left and right half. For merging, we need to determine the range
 of indexes for the left and right halves in the output array. We can easily find that.
Left part will start from the index l * n of the output array.
Similarly, right part will start from the index ((l + r) / 2 + 1) * n of the output array.
We, also have to determine the length of the left and right parts.
Then, we create two temporary arrays, ‘l_arr’ and ‘r_arr’ to store the values from the left
and right part. Finally, we use two pointer technique to merge the results of the left and right
 part as we do in merge sort.


*/


import java.util.Arrays;

public class MergeKSortedArrays {
    public static void main(String[] args){
        int[][] arr= {  {2, 6, 12, 34},
                        {1, 9, 20, 1000},
                        {23, 34, 90, 2000}};
        int k=arr.length;
        int totalLength=0;
        for (int[] ints : arr) {
            totalLength += ints.length;
        }
        int[] output=new int[totalLength];
        divide(0,k-1,output,arr);

        System.out.println("Merged array is :");
        System.out.println(Arrays.toString(output));
    }

    private static void divide(int left, int right, int[] output, int[][] arr) {
        if(left==right)
        {
            System.arraycopy(arr[left], 0, output, left * arr[0].length, arr[0].length);
            return;
        }
        divide(left, (left+right)/2, output, arr);
        divide(1+(left+right)/2, right, output, arr);
        mergeBack(left,right,output,arr);
    }

    private static void mergeBack(int left, int right, int[] output, int[][] arr) {
        // to store the starting point of left and right array
        int l_in = left*arr[0].length;
        int r_in=(1+(left+right)/2 )*arr[0].length;

        // to store the size of left and  right array
        int l_c = ((left + right) / 2 - left + 1) * arr[0].length;
        int r_c = (right - (left + right) / 2) * arr[0].length;

        int[] l_arr = new int[l_c];
        int[] r_arr = new int[r_c];
        System.arraycopy(output, l_in, l_arr, 0, l_c);
        System.arraycopy(output, r_in, r_arr, 0, r_c);
        // to store the current index of temporary left and right array
        int l_curr = 0, r_curr = 0;
        // to store the current index for output array
        int in = l_in;
        while (l_curr+r_curr<l_c+r_c)
        {
            if(r_curr==r_c || (l_curr!=l_c && l_arr[l_curr]<r_arr[r_curr]))
            {
                output[in]= l_arr[l_curr];
                l_curr++;
                in++;
            }
            else
            {
                output[in] = r_arr[r_curr];
                r_curr++;
                in++;
            }

        }
    }
}

/**Time Complexity: O( n * k * log k).
There are log k levels as in each level the k arrays are divided in half and at
 each level the k arrays are traversed. So time Complexity is O( n * k ).

 Space Complexity: O( n * k * log k).
In each level O( n*k ) space is required So
 Space Complexity is O( n * k * log k).*/

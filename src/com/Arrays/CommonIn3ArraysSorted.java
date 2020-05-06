package com.Arrays;
/**
Find common elements in three sorted arrays
        Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
        Examples:

        Input:
        ar1[] = {1, 5, 10, 20, 40, 80}
        ar2[] = {6, 7, 20, 80, 100}
        ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
        Output: 20, 80

 we can find the common elements using a single loop and without extra space. The idea is similar
 to intersection of two arrays. Like two arrays loop, we run a loop and traverse three arrays.

 Let the current element traversed in ar1[] be x, in ar2[] be y and in ar3[] be z. We can
 have following cases inside the loop.

 If x, y and z are same, we can simply print any of them as common element
 and move ahead in all three arrays.
 Else If x < y, we can move ahead in ar1[] as x cannot be a common element.
 Else If x > z and y > z), we can simply move ahead in ar3[] as z cannot be a common element.
 */

public class CommonIn3ArraysSorted {
    // Driver code to test above
    public static void main(String[] args)
    {
        int[] ar1 = {1, 5, 10, 20, 40, 80};
        int[] ar2 = {6, 7, 20, 80, 100};
        int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.print("Common elements are ");
        findCommonIn3SortedArrays(ar1, ar2, ar3);
    }

    private static void findCommonIn3SortedArrays(int[] ar1, int[] ar2, int[] ar3) {
        int i=0; int j=0; int k=0;
        while (i<ar1.length && j<ar2.length && k<ar3.length)
        {
            if(ar1[i]==ar2[j] && ar2[j] ==ar3[k]) {
                System.out.print(ar1[i] + " ");
                i++;
                j++;
                k++;
            }
            else if(ar1[i]<ar2[j])
                i++;
            else if(ar2[j]<ar3[k])
                j++;
            else
                k++;
        }
    }
}
//    Time complexity of the above solution is O(n1 + n2 + n3). In the worst case,
//    the largest sized array may have all small elements and
//    middle-sized array has all middle elements.
/**
You can find the common elements between two lists by copying the elements of one list into a new list,
 and using retainAll:

List<T> commonElements = new ArrayList<>(list1);
commonElements.retainAll(list2);
This can be extended to n lists, since the common elements in n lists are the common elements
 of [the common elements of the first n-1 lists] and the [elements of the n-th list]:

commonElements.retainAll(list3);
commonElements.retainAll(list4);


 You can use the retainAll() methods which is part of the Java Collections class:

 List<Integer> list1 = new ArrayList<Integer>();
 list1.add(1);
 list1.add(2);
 list1.add(3);
 System.out.println("First list has elements: " + list1);

 List<Integer> list2 = new ArrayList<Integer>();
 list2.add(2);
 list2.add(3);
 list2.add(4);
 System.out.println("Second list has elements: " + list2);

 list1.retainAll(list2);
 System.out.println("Intersection between the lists is: " + list1);
 If you need to aggregate this for an arbitrary number of lists, you can simply call
 list1.retainAll(listn), where listn is another List.

 Output:

 First list has elements: [1, 2, 3]
 Second list has elements: [2, 3, 4]
 Intersection between the lists is: [2, 3]

 */


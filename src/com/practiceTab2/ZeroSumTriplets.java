package com.practiceTab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ZeroSumTriplets {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       // int sum = Integer.parseInt(br.readLine().strip());
//        System.out.print("give space separated integers for array 1 = ");
//        int[] arr1 = Arrays.stream(br.readLine().strip().split("\\s"))
//                .mapToInt(Integer::parseInt).toArray();
        int[] arr2={0,-1,2,-3,1};
        System.out.println(printAllTriplets(arr2,arr2.length));
    }

    private static ArrayList<ArrayList<String>> printAllTriplets(int[] arr1, int length) {
        if(length<=2)
        { return new ArrayList<>(0); }
        ArrayList<ArrayList<String>> ansLists=new ArrayList<>();
        Arrays.parallelSort(arr1);
        System.out.println("array sorted= "+Arrays.toString(arr1));
        for (int i = 0; i < length-1; i++)
        {
           int l=i+1;
           int r=length-1;
           int x=arr1[i];
           while (l<r)
           {
               if(x+arr1[r]+arr1[l] ==0)
               {
//                   System.out.println("x= "+x+" l= "+l+" r= "+r);
                   ansLists.add(new ArrayList<>(Arrays.asList(String.valueOf(x),
                           String.valueOf(arr1[l]), String.valueOf(arr1[r]))));
                   l++;
                   r--;
               }
               else if(x+arr1[r]+arr1[l]<0)
               {
                   l++;
               }
               else
               {
                   r--;
               }
           }
        }
    return ansLists;
    }
}
/*

Hash Table: An array that stores pointers to records corresponding to a given phone number.
An entry in hash table is NIL if no existing phone number has hash function value equal to the index
for the entry.

Collision Handling: Since a hash function gets us a small number for a big key, there is possibility that
two keys result in same value. The situation where a newly inserted key maps to an already occupied slot in
hash table is called collision and must be handled using some collision handling technique. Following are
the ways to handle collisions:

Chaining:The idea is to make each cell of hash table point to a linked list of records that have same hash
function value. Chaining is simple, but requires additional memory outside the table.
Open Addressing: In open addressing, all elements are stored in the hash table itself. Each table entry
contains either a record or NIL. When searching for an element, we one by one examine table slots until the
desired element is found or it is clear that the element is not in the table.

*/

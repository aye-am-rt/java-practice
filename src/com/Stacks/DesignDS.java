package com.Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**Design a data structure that supports insert, delete, search and getRandom in constant time
        Design a data structure that supports the following operations in Θ(1) time.

        insert(x): Inserts an item x to the data structure if not already present.

        remove(x): Removes an item x from the data structure if present.

        search(x): Searches an item x in the data structure.

        getRandom(): Returns a random element from current set of elements

        We can use hashing to support first 3 operations in Θ(1) time. How to do the 4th operation? The
 idea is to use a resizable array (ArrayList in Java, vector in C) together with hashing. Resizable
 arrays support insert in Θ(1) amortized time complexity. To implement getRandom(), we can simply pick
 a random number from 0 to size-1 (size is the number of current elements) and return the element at that
 index. The hash map stores array values as keys and array indexes as values.*/

public class DesignDS {
    static class MyDS
    {
        HashMap<Integer,Integer> hash;
        ArrayList<Integer> arList;

        public MyDS()
        {
            this.hash=new HashMap<>();
            this.arList=new ArrayList<>();
        }
        void add(int elem)
        {
            if(hash.get(elem)!=null)
                return;
            else
            {
                arList.add(elem);
                int size=arList.size();
                hash.put(elem,size-1);
            }
        }
        void remove(int elem)
        {
            Integer index = hash.get(elem);
            if(index == null)
                return;
            hash.remove(elem);
            int size=arList.size();
            // Swap element with last element so that remove from
            // arr[] can be done in O(1) time
            Integer lastElem=arList.get(size-1);
            Collections.swap(arList,index,size-1);
            arList.remove(size-1);  // Remove last element (This is O(1))
            hash.put(lastElem,index);

        }
        int getRandom()
        {
            Random rand=new Random();
            int index=rand.nextInt(arList.size());
            return arList.get(index);
        }
        Integer search(int x)
        {
            return hash.get(x);
        }
    }
    public static void main (String[] args)
    {
        MyDS ds = new MyDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }
}

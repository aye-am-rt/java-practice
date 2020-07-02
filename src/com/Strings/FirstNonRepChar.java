package com.Strings;
/*
Given a string, find its first non-repeating character
Given a string, find the first non-repeating character in it. For example, if the input string is
 “GeeksforGeeks”, then the output should be ‘f’ and if the input string is “GeeksQuiz”, then the output
 should be ‘G’.*/

import java.util.HashMap;

/**
Can this be done by traversing the string only once?
The above approach takes O(n) time, but in practice, it can be improved. The first part of the
 algorithm runs through the string to construct the count array (in O(n) time). This is reasonable.
 But the second part about running through the string again just to find the first non-repeater is not a
 good practice.

In real situations, the string is expected to be much larger than your alphabet. Take DNA sequences,
 for example, they could be millions of letters long with an alphabet of just 4 letters. What happens if
 the non-repeater is at the end of the string? Then we would have to scan for a long time (again).

Method 2: HashMap and single string traversal.

Approach: Make a count array instead of hash_map of maximum number of characters(256). We can augment the
 count array by storing not just counts but also the index of the first time you encountered the character
 e.g. (3, 26) for ‘a’ meaning that ‘a’ got counted 3 times and the first time it was seen is at position
 26. So when it comes to finding the first non-repeater, we just have to scan the count array, instead of
 the string. Thanks to Ben for suggesting this approach.

Algorithm :

Make a count_array which will have two fields namely frequency, first occurence of a character.
The size of count_array is ‘256’.
Traverse the given string using a pointer.
Increase the count of current character and update the occurence.
Now here’s a catch, the array will contain valid first occurence of the character which has frequency
 has unity otherwise the first occurence keeps updating.
Now traverse the count_array and find the character which has least value of first occurence and
 frequency value as unity.
Return the character
Pseudo Code :

for ( i=0 to str.length())
count_arr[str[i]].first++;
count_arr[str[i]].second=i;

int res=INT_MAX;
for(i=0 to count_arr.size())
if(count_arr[str[i]].first==1)
res=min(min, count_arr[str[i]].second)

return res*/

public class FirstNonRepChar {
    public static void main(String[] args)
    {
        String str = "geeksforgeeks";
        int index = firstNonRepeating(str);

        if(index != Integer.MAX_VALUE)
            System.out.println("First non-repeating character is " + str.charAt(index));
    }

    static class CountIndexPair
    {
        int count, index;
        // constructor for first occurrence
        public CountIndexPair(int index)
        {
            this.count = 1;
            this.index = index;
        }
        // method for updating count
        public void incCount()
        { this.count++; }

        @Override
        public String toString() {
            return "{" + "count=" + count + ",index=" + index + '}';
        }
    }

    private static int firstNonRepeating(String str) {
        if(str.length()==0) {
            System.out.println(" string is empty");
            return Integer.MAX_VALUE;
        }
        if(str.length()==1)
        {
            System.out.println("string length is 1, so index will be 0");
            return 0;
        }
        HashMap<Character, CountIndexPair> hMap = new HashMap<>();

        /* calculate count of characters in the passed string */
        for (int i = 0; i < str.length(); i++) {
            if(hMap.containsKey(str.charAt(i)))
            {
                hMap.get(str.charAt(i)).incCount();
            }
            else
            {
                hMap.put(str.charAt(i),new CountIndexPair(i));
            }
        }
        System.out.println("**********");
        System.out.println(hMap);

        int resultIndex = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++)
        {
            // If this character occurs only once and appears before the current result,
            // then update the result
            if(hMap.get(str.charAt(i)).count == 1 && resultIndex > hMap.get(str.charAt(i)).index )
            {
                resultIndex = hMap.get(str.charAt(i)).index;
            }
        }
        return resultIndex;
    }
}
//    Time Complexity: O(n).
//        As the string need to be traversed at-least once.
//        Auxiliary Space: O(n).

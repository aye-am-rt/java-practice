package com.practiceTab1;
/*
Word Break Problem using Backtracking
Given a valid sentence without any spaces between the words and a dictionary of valid English
 words, find all possible ways to break the sentence in individual dictionary words.
Example
Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,cream, icecream, man, go, mango}

Input: "ilikesamsungmobile"
Output: i like sam sung mobile
i like samsung mobile

Input: "ilikeicecreamandmango"
Output: i like ice cream and man go
i like ice cream and mango
i like icecream and man go
i like icecream and mango

*/

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**The Dynamic Programming solution only finds whether it is possible to break a word or not.
 *  Here we need to print all possible word breaks.

 We start scanning the sentence from left.
 As we find a valid word, we need to check whether rest of the sentence can make valid words
 or not.
 Because in some situations the first found word from left side can leave a remaining portion
 which is not further separable.
 So in that case we should come back and leave the current found word and keep on searching for
 the next word. And this process is recursive because to find out whether the right portion
 is separable or not, we need the same logic.

 So we will use recursion and backtracking to solve this problem.
 To keep track of the found words we will use a stack.
 Whenever the right portion of the string does not make valid words, we pop the top string
 from stack and continue finding.*/

public class WordBreakBackTrackPrintAll {
    static Set<String> hSet = new HashSet<>();

    public static void main(String[] args) {
        String[] dictionary = {"mobile","samsung","sam","sung", "man","mango", "icecream","and",
                "go","i","love","ice","cream"};
        Collections.addAll(hSet, dictionary);
        System.out.println(hSet);

/*
        Set<String> hSet= Arrays.stream(dictionary).collect(Collectors.toSet());
        Set<String> hSet3=new HashSet<>(Arrays.asList(dictionary));
        Set<String> set4 = new HashSet<>();
        // Iterate through the array // Add each element into the set
        for (String t : dictionary)
        {
            set4.add(t);
        }
*/

        System.out.println("First Test: ");
        wordBreakUsingSetGiven("iloveicecreamandmango");
        System.out.println("======================");
        System.out.println("Second Test: ");
        wordBreakUsingSetGiven("ilovesamsungmobile");
    }

    private static void wordBreakUsingSetGiven(String sentenceNoSp) {
        // last argument is prefix
        wordBreakUtil(sentenceNoSp, sentenceNoSp.length(), "");
    }

    // result store the current prefix with spaces between words
    private static void wordBreakUtil(String sentenceNoSp, int ln, String resultPrefix) {
        for (int i = 1; i <= ln; i++) {
            String prefix = sentenceNoSp.substring(0,i);
            // if dictionary contains this prefix, then
            // we check for remaining string. Otherwise we ignore this prefix
            // (there is no else for this if) and try next
            if(hSet.contains(prefix))
            {
                // if no more elements are there, print it
                if(i==ln)
                {
                    resultPrefix += prefix;
                    System.out.println(resultPrefix);
                    return;
                }
                wordBreakUtil(sentenceNoSp.substring(i),ln-i,(resultPrefix+prefix+" "));
            }
        }
    }
}

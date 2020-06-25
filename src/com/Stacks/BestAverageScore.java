package com.Stacks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class BestAverageScore {
    public static void main(String[] args) {
        String[][] scores = {{"a","100"},{"a","10"},{"b","-100"},{"b","-90"},{"c","0"}};
        findBestAverage(scores);
    }

    private static void findBestAverage(String[][] scores) {
        if(scores.length<1)
            throw new IllegalArgumentException();
        HashMap<String,Stack<Integer>> hMap = new HashMap<>() {};
        for (String[] score : scores) {
            Stack<Integer> s;
            if (hMap.containsKey(score[0])) {
                s = hMap.get(score[0]);
            } else {
                s = new Stack<>();
            }
            s.push(Integer.parseInt(score[1]));
            hMap.put(score[0], s);
        }
        int currAvg;
        int bestAvg = Integer.MIN_VALUE;

        Iterator<Map.Entry<String,Stack<Integer>>> itr = hMap.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<String,Stack<Integer>> ent = itr.next();
            Stack<Integer> s = ent.getValue();
            int size =  s.isEmpty()? 1 : s.size();  // this line is so that size never calculates
            // to be 0 because division by zero will throw math exception //
            Integer currSum=0;
            while(!s.isEmpty())
            {
                currSum+=s.peek();
                s.pop();
            }
            currAvg = Math.floorDiv(currSum,size);
            if(currAvg>=bestAvg)
            {
                bestAvg=currAvg;
            }
        }
        System.out.println(" best Average value = "+bestAvg);
    }
}

//    int num = 5;
//    int denom = 7;
//    double d = num / denom;
//    // the value of d is 0.0. It can be forced to work by casting:
//    double d = ((double) num) / denom;

package com.practiceTab2;

import java.io.IOException;
import java.util.*;

//Next Greater Frequency Element
//        Given an array, for each element find the value of nearest element to the right which is
//        having frequency greater than as that of current element. If there does not exist an answer
//        for a position, then make the value ‘-1’.


/**Efficient approach:
        We can use hashing and stack data structure to efficiently solve for many cases. A simple
 hashing technique is to use values as index and frequency of each element as value. We use stack data
 structure to store position of elements in the array.

        1) Create a list to use values as index to store frequency of each element.
        2) Push the position of first element to stack.
        3) Pick rest of the position of elements one by one and follow following steps in loop.
        …….a) Mark the position of current element as ‘i’ .
        ……. b) If the frequency of the element which is pointed by the top of stack is greater than
                frequency of the current element, push the current position i to the stack
        ……. c) If the frequency of the element which is pointed by the top of stack is less than
                frequency of the current element and the stack is not empty then follow these steps:
        …….i) continue popping the stack
        …….ii) if the condition in step c fails then push the current position i to the stack
        4) After the loop in step 3 is over, pop all the elements from stack and print -1 as next
            greater frequency element for them does not exist.*/

public class NGF {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       // int sum = Integer.parseInt(br.readLine().strip());
//        System.out.print("give space separated integers for array 1 = ");
//        int[] arr1 = Arrays.stream(br.readLine().strip().split("\\s"))
//                .mapToInt(Integer::parseInt).toArray();
        int[] arr2={1, 1, 2, 3, 4, 2, 1};
        System.out.println(findNextGreaterFreq(arr2,arr2.length));
    }

    private static String findNextGreaterFreq(int[] arr, int n) {
        LinkedHashMap<Integer,Integer> freqMap=new LinkedHashMap<>(16,0.75f,true);
        for (int i = 0; i < n; i++) {
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }
        System.out.println(freqMap);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int[] resArray=new int[n];
        Arrays.fill(resArray,0);
        for (int i = 1; i <n ; i++) {
            if(freqMap.get(arr[s.peek()])>freqMap.get(arr[i])) {
                s.push(i);
            }
            else
            {
                while(freqMap.get(arr[s.peek()])<freqMap.get(arr[i]) && s.size()>0)
                {
                    resArray[s.peek()]=arr[i];
                    s.pop();
                }
                s.push(i);
            }
        }
        while (!s.isEmpty())
        {
            resArray[s.peek()]=-1;
            s.pop();
        }
        return Arrays.toString(resArray);
    }

}

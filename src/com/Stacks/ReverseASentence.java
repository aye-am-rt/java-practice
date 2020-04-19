package com.Stacks;
//Reverse words in a given string
//        Example: Let the input string be “i like this program very much”. The function should change the
//        string to “much very program this like i

import java.util.Stack;

public class ReverseASentence {
    public static void main(String[] args)
    {
        String[] s = "i like this program very much".split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            ans.append(s[i]).append(" ");   // ans += s[i] + " ";
        }
        System.out.println("Reversed String:");
        System.out.println(ans.substring(0, ans.length() - 1));
        String k = "corona virus times be safe";
        System.out.println("Second string reversed printing == ");
        reverseUsingStack(k);
    }

    private static void reverseUsingStack(String k) {
        Stack<String> s=new Stack<>();
        String[] tokens=k.split(" ");
        for (String token : tokens) {
            s.push(token);
        }
        while (! s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}

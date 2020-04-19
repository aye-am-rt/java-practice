package com.Stacks;

import java.util.ListIterator;
import java.util.Stack;

//Reverse a stack using recursion
//        Write a program to reverse a stack using recursion. You are not allowed to use loop constructs
//        like while, for..etc, and you can only use the following ADT functions on Stack S:
//        isEmpty(S)
//        push(S)
//        pop(S)
//        Recommended: Please try your approach on {IDE} first, before moving on to the solution.
//        The idea of the solution is to hold all values in Function Call Stack until the stack becomes
//        empty. When the stack becomes empty, insert all held items one by one at the bottom of the
//        stack.
public class ReverseStackRecursive {
    static Stack<Character> st1=new Stack<>();
    public static void main(String[] args)
    {
        st1.push('3');st1.push('5');st1.push('1');st1.push('4');
        st1.push('9');
        System.out.println("Stack elements before sorting: ");
        printStack();
        //System.out.println(st1); //[30, -5, 18, 14, -3]
        ReverseStackRecursiveMethod();
        System.out.println("\nStack elements after sorting:");
        printStack();
    }

    private static void ReverseStackRecursiveMethod() {
        if(! st1.isEmpty())
        {
            char x=st1.peek();
            st1.pop();
            ReverseStackRecursiveMethod();
            insertAtBottom(x);
        }

    }

    private static void insertAtBottom(char x) {
        if (st1.isEmpty()) {
            st1.push(x);
        }
        else
        {
            char tempChar=st1.peek();
            st1.pop();
            insertAtBottom(x);
            st1.push(tempChar);
        }
    }

    private static void printStack() {
//        while(!st1.isEmpty()) this will empty the stack so you cant send it for reversing
//        { System.out.print(st1.pop()+"  "); }// that's why use list iterator.
        ListIterator<Character> lit= st1.listIterator();
        while(lit.hasNext())
            lit.next();
        while(lit.hasPrevious())
            System.out.print(lit.previous()+"  ");
    }
}

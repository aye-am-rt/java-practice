package com.Stacks;
//
//Sort a stack using recursion
//        Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is
//        not allowed. We can only use the following ADT functions on Stack S:
//        is_empty(S)  : Tests whether stack is empty or not.
//        push(S)         : Adds new element to the stack.
//        pop(S)         : Removes top element from the stack.
//        top(S)         : Returns value of the top element. Note that this
//                         function does not remove element from the stack.
//
//The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty.
// When the stack becomes empty, insert all held items one by one in sorted order. Here sorted order
// is important.

import java.util.ListIterator;
import java.util.Stack;

/**
Algorithm
        We can use below algorithm to sort stack elements:

        sortStack(stack S)
        if stack is not empty:
        temp = pop(S);
        sortStack(S);
        sortedInsert(S, temp);
        Below algorithm is to insert element is sorted order:

        sortedInsert(Stack S, element)
        if stack is empty OR element > top element
        push(S, elem)
        else
        temp = pop(S)
        sortedInsert(S, element)
        push(S, temp)*/

public class SortStackRecursive {
    public static void main(String[] args)
    {
        Stack<Integer> st1=new Stack<>();
        st1.push(30);st1.push(-5);st1.push(18);st1.push(14);
        st1.push(-3);
        System.out.println("Stack elements before sorting: ");
        printStack(st1);
        sortStackUsingRecursion(st1);
        System.out.println("\nStack elements after sorting:");
        printStack(st1);
    }

    private static void sortStackUsingRecursion(Stack<Integer> st1) {
        if(! st1.isEmpty())
        {
            int x=st1.pop();
            sortStackUsingRecursion(st1); // recursive call, holding all values while stack is not empty
            InsertAgainSortedManner(st1,x);
        }
    }

    private static void InsertAgainSortedManner(Stack<Integer> st1, int x) {
        if(st1.isEmpty() || st1.peek()<x)
        {
            st1.push(x);
            return;
        }
        int temp=st1.pop();
        InsertAgainSortedManner(st1, x);
        st1.push(temp);
    }

    private static void printStack(Stack<Integer> integerStack) {
//        for (Integer x : integerStack) {// it will print like an array but we want to print like stack
//            System.out.print(x+"  ");  //30  -5  18  14  -3
//        }// we want -3 on top that's why doing the thing below. as said isEmpty() and pop()/peek() are
//        // not allowed to use.
        ListIterator<Integer> lt=integerStack.listIterator();
        while(lt.hasNext())
            lt.next();
        while(lt.hasPrevious())
            System.out.print(lt.previous()+"  "); // -3  14  18  -5  30 this is required way to print stack
    }
}

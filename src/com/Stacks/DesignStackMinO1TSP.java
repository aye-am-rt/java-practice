package com.Stacks;
/*
Design a stack that supports getMin() in O(1) time and O(1) extra space
Question: Design a Data Structure SpecialStack that supports all the stack operations like
 push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return
 minimum element from the SpecialStack. All these operations of SpecialStack must be O(1).
 To implement SpecialStack, you should only use standard Stack data structure and no other data
 structure like arrays, list, .. etc.

Example:

Consider the following SpecialStack
16  --> TOP
15
29
19
18

When getMin() is called it should return 15,
which is the minimum element in the current stack.

If we do pop two times on stack, the stack becomes
29  --> TOP
19
18

When getMin() is called, it should return 18
which is the minimum in the current stack.*/

import java.util.Stack;

//Volatile Keyword in Java
//        Volatile keyword is used to modify the value of a variable by different threads. It is also
//        used to make classes thread safe. It means that multiple threads can use a method and
//        instance of the classes at the same time without any problem. The volatile keyword can be
//        used either with primitive type or objects. The volatile keyword does not cache the value
//        of the variable and always read the variable from the main memory. The volatile keyword cannot
//        be used with classes or methods. However, it is used with variables. It also guarantees
//        visibility and ordering. It prevents the compiler from the reordering of code.
//The contents of the particular device register could change at any time, so you need the volatile
// keyword to ensure that such accesses are not optimized away by the compiler.

public class DesignStackMinO1TSP {
    static class MyStack
    {
        Stack<Integer> st;
        Integer minElem;
        // Constructor
        MyStack() { this.st = new Stack<>(); this.minElem = Integer.MIN_VALUE; }

        void getMin()
        {
            if(st.isEmpty())
                System.out.println("stack is empty");
            else
                System.out.println("min element in stack right now is = "+minElem);
        }
        void peek()
        {
            if(st.isEmpty()) {
                System.out.println("stack is empty");
                return;
            }
            Integer t = st.peek();
            System.out.print("Top Most Element is: ");
            // If t < minEle means minEle stores value of t.
            if(t<minElem)
                System.out.println(minElem);
            else
                System.out.println(t);

        }
        void pop()
        {
            if(st.isEmpty()) {
                System.out.println("stack is empty");
                return;
            }
            System.out.print("Top Most Element Removed: ");
            Integer t = st.pop();
            if(t<minElem)
            {
                // Minimum will change as the minimum element of the stack is being removed.
                System.out.println(minElem);
                minElem = 2*minElem-t;
            }
            else
                System.out.println(t);
        }
        void push(Integer xNew)
        {
            if (st.isEmpty()) {
                minElem = xNew;
                st.push(xNew);
                System.out.println("number inserted in stack = "+xNew);
                return;
            }
            if(xNew<minElem)
            {
                st.push(2*xNew-minElem);
                minElem=xNew;
            }
            else
                st.push(xNew);

            System.out.println("number inserted in stack = "+xNew);
        }
    }
    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
        s.getMin();
    }
}
/**

How does this approach work?
When element to be inserted is less than minEle, we insert “2x – minEle”. The important thing to
 notes is, 2x – minEle will always be less than x (proved below), i.e., new minEle and while popping
 out this element we will see that something unusual has happened as the popped element is less than
 the minEle. So we will be updating minEle.

How 2*x - minEle is less than x in push()?
x < minEle which means x - minEle < 0

// Adding x on both sides
x - minEle + x < 0 + x

2*x - minEle < x

We can conclude 2*x - minEle < new minEle
While popping out, if we find the element(y) less than the current minEle, we find the new
 minEle = 2*minEle – y.

How previous minimum element, prevMinEle is, 2*minEle - y
in pop() is y the popped element?

// We pushed y as 2x - prevMinEle. Here
// prevMinEle is minEle before y was inserted
y = 2*x - prevMinEle

// Value of minEle was made equal to x
minEle = x .

new minEle = 2 * minEle - y
= 2*x - (2*x - prevMinEle)
= prevMinEle // This is what we wanted

Exercise:
Similar approach can be used to find the maximum element as well. Implement a stack that supports
 getMax() in O(1) time and constant extra space.

*/


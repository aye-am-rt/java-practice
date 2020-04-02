package com.practiceTab2.StacksMake;

//Find maximum in stack in O(1) without using additional stack
//        The task is to design a stack which can get the maximum value in the stack in O(1) time without
//        using an additional stack.

public class FindMaxO1 {
    static class StackBlock
    {
        int value,localMax;
    }
    static class Stack
    {
        StackBlock[] S;
        int size,top;

        public Stack(int size) {
            this.size = size;
            this.S=new StackBlock[size];
            for (int i = 0; i < size; i++) {
                S[i]=new StackBlock();
            }
            this.top=-1;
        }
        void push(int elem)
        {
            if(top==size-1)
                System.out.println("stack is full cant push");
            else
            {
                top++;
                if(top==0)
                {
                    S[top].value=elem;
                    S[top].localMax=elem;
                }
                else
                {
                    if(S[top-1].localMax>elem)
                    {
                        S[top].value=elem;
                        S[top].localMax=S[top-1].localMax;
                    }
                    else
                    {
                        S[top].value=elem;
                        S[top].localMax=elem;
                    }
                }
                System.out.println( elem+ " ==> is inserted in stack top");
            }
        }
        void pop()
        {
            if(top==-1)
            {
                System.out.println("stack is empty");
            }
            else
            {
                top--;
                System.out.println("Element popped from stack top");
            }

        }
        void max()
        {
            if(top==-1)
            {
                System.out.println(" stack is empty ");
            }
            else
            {
                System.out.println("max value in stack right now = "+S[top].localMax);
            }
        }
    }
    // Driver code
    public static void main(String args[])
    {

        // Create stack of size 5
        Stack S1=new Stack(5);
        S1.push(2);
        S1.max();
        S1.push(6);
        S1.max();
        S1.pop();
        S1.max();
    }
}

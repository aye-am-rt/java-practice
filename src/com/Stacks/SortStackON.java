package com.Stacks;
/*

Sort a stack using a temporary stack
Given a stack of integers, sort it in ascending order using another temporary stack.
Examples:
Input : [34, 3, 31, 98, 92, 23]
Output : [3, 23, 31, 34, 92, 98]
Input : [3, 5, 1, 4, 2, 8]
Output : [1, 2, 3, 4, 5, 8]

We follow this algorithm.

Create a temporary stack say tmpStack.
While input stack is NOT empty do this:
Pop an element from input stack call it temp
while temporary stack is NOT empty and top of temporary stack is greater than temp,
pop from temporary stack and push it to the input stack
push temp in temporary stack
The sorted numbers are in tmpStack
*/

import java.util.Stack;

public class SortStackON {
    public static void main(String[] args)
    {
        Stack<Integer> inputStack= new Stack<>();
        inputStack.add(34);
        inputStack.add(3);
        inputStack.add(31);
        inputStack.add(98);
        inputStack.add(92);
        inputStack.add(23);

        Stack<Integer> tempTopMax=SortTheStack(inputStack);
        System.out.println("sorted numbers are = ");
        while (! tempTopMax.isEmpty())
        {
            System.out.print(tempTopMax.pop()+"  ");
        }

    }

    private static Stack<Integer> SortTheStack(Stack<Integer> inputStack) {
        Stack<Integer> tempStack=new Stack<>();
        while(! inputStack.isEmpty())
        {
            int tmp=inputStack.pop();
            while(! tempStack.isEmpty() && tmp>tempStack.peek())
            {
                inputStack.push(tempStack.pop());
            }
            tempStack.push(tmp);
        }
        return tempStack;
    }
}

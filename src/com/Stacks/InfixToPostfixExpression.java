package com.Stacks;

import java.util.Stack;

/*
Infix expression:
The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression:
The expression of the form a b op. When an operator is followed for every pair of operands.
        Why postfix representation of the expression?
        The compiler scans the expression either from left to right or from right to left.
        Consider the below expression: a op1 b op2 c op3 d
        If op1 = +, op2 = *, op3 = +
        The compiler first scans the expression to evaluate the expression b * c, then again scan the
        expression to add a to it. The result is then added to d after another scan.
        The repeated scanning makes it very in-efficient. It is better to convert the expression to
        postfix(or prefix) form before evaluation.
        The corresponding expression in postfix form is: abc*+d+. The postfix expressions can be
        evaluated easily using a stack. We will cover postfix expression evaluation in a separate post.*/
public class InfixToPostfixExpression {
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stackChar = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c= exp.charAt(i);
            // If the scanned character is an operand, add it to output.
            if(Character.isLetterOrDigit(c))
                result.append(c);
            // If the scanned character is an '(', push it to the stack.
            else if(c=='(')
                stackChar.push(c);
            //  If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if(c==')')
            {
                while (!stackChar.isEmpty() && stackChar.peek()!='(')
                    result.append(stackChar.pop());

                if(! stackChar.isEmpty() && stackChar.peek() !='(')
                    return "Invalid infix expression";
                else
                    stackChar.pop();
            }
            else  // // an operator is encountered
            {
                while (! stackChar.isEmpty() && CheckPrecedence(c)<=CheckPrecedence(stackChar.peek()))
                {
                    if(stackChar.peek()=='(')
                        return "invalid infix expression ";
                    result.append(stackChar.pop());
                }
                stackChar.push(c);
            }
        }
        // pop all the operators from the stack
        while (!stackChar.isEmpty())
        {
            if(stackChar.peek() == '(')
                return "Invalid infix Expression";
            result.append(stackChar.pop());
        }
        return result.toString();
    }

    private static int CheckPrecedence(char ch) {

        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}

package com.Stacks;

import java.util.Stack;

/**
Stack | Set 4 (Evaluation of Postfix Expression)
The Postfix notation is used to represent algebraic expressions. The expressions written in postfix
 form are evaluated faster compared to infix notation as parenthesis are not required in postfix.
 We have discussed infix to postfix conversion. In this post, evaluation of postfix expressions is discussed.

Following is algorithm for evaluation postfix expressions.
1) Create a stack to store operands (or values).
2) Scan the given expression and do following for every scanned element.
…..a) If the element is a number, push it into the stack
…..b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and
 push the result back to the stack
3) When the expression is ended, the number in the stack is the final answer*/

public class PostFixEvaluation {
    // Driver program to test above functions
    public static void main(String[] args)
    {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println("postfix evaluation: "+evaluatePostfix(exp));
    }

    private static int evaluatePostfix(String exp) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c= exp.charAt(i);
            if(c!=' ')
            {
                // If the scanned character is an operand (number here),extract the number
                // Push it to the stack.
                if(Character.isDigit(c))
                {
                    int n=0;
                    //extract the characters and store it in num
                    while(Character.isDigit(c))
                    {
                        n=n*10+ Character.getNumericValue(c);
                        i++;
                        c=exp.charAt(i);
                    }
                    i--;
                    st.push(n);
                }
                else// If the scanned character is an operator, pop two elements from stack apply the operator
                {
                    int val1=st.pop();
                    int val2=st.pop();
                    switch (c)
                    {
                        case '+':
                            st.push(val2+val1);
                            break;

                        case '-':
                            st.push(val2- val1);
                            break;

                        case '/':
                            st.push(val2/val1);
                            break;

                        case '*':
                            st.push(val2*val1);
                            break;
                        default:
                            st.push(val2);
                            st.push(val1);
                            break;
                    }
                }
            }
        }
        return st.pop();
    }
}

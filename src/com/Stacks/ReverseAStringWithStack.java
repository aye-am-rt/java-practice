package com.Stacks;
//Stack | Set 3 (Reverse a string using stack)
//        Given a string, reverse it using stack. For example “GeeksQuiz” should be converted to
//        “ziuQskeeG”.
//
//        Following is simple algorithm to reverse a string using stack.
//
//        1) Create an empty stack.
//        2) One by one push all characters of string to stack.
//        3) One by one pop all characters from stack and put
//        them back to string.

public class ReverseAStringWithStack {
    static class MyStack
    {
        int size;int top;char[] arr;

        public MyStack(int size) {
            this.size = size;
            this.top=-1;
            this.arr=new char[size];
        }
        boolean isEmpty()
        {return (top<0);}

        boolean pushInStack(char x)
        {
            if(top>size)
            {
                System.out.println("Stack overflow");
                return false;
            }
            top+=1;
            arr[top]=x;
            return true;
        }
        int popStack()
        {
            if(top<0)
            {
                System.out.println("stack underflow");
                return 0;
            }
            char x=arr[top];
            top-=1;
            return x;
        }

    }
    public static void main(String[] args)
    {
        StringBuffer sBuf=new StringBuffer("StringsAreImmutable");
        reverseUsingStack(sBuf);
        System.out.println("Reversed String = ");
        System.out.println(sBuf.toString());
        //char c=Character.forDigit(10,16);
        //System.out.println(c);

        char[] str = "abc".toCharArray();
        reverseUsingHalfLoop(str);
        System.out.println("Reversed string is " + String.valueOf(str));
    }

    private static void reverseUsingStack(StringBuffer sbuf) {
        int n=sbuf.length();
        MyStack obj=new MyStack(n);
        for (int i = 0; i < n; i++) {
            obj.pushInStack(sbuf.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            char ch= (char) obj.popStack();
            sbuf.setCharAt(i,ch);
        }
    }
    static void swap(char[] a, int index1, int index2) {
        char temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    // A stack based function to reverse a string
    static void reverseUsingHalfLoop(char[] str) {
        // get size of string
        int n = str.length, i;
        for (i = 0; i < n / 2; i++) {
            swap(str, i, n - i - 1);
        }
    }
}

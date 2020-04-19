package com.Stacks;

//Reverse a stack without using extra space in O(n)
//        Reverse a Stack without using recursion and extra space. Even the functional Stack is not
//        allowed.
//        Examples:
//        Input : 1->2->3->4
//        Output : 4->3->2->1
/**
We have discussed a way of reversing a string in below post.
Reverse a Stack using Recursion

The above solution requires O(n) extra space. We can reverse a string in O(1) time if we
internally represent the stack as a linked list. Reverse a stack would require a reversing a
linked list which can be done with O(n) time and O(1) extra space.

Note that push() and pop() operations still take O(1) time.*/

public class ReverseAStack {
    static class stackNode
    {
        int data;
        stackNode next;

        public stackNode(int data) {
            this.data = data;
            this.next=null;
        }
    }
    static class stack
    {
        stackNode top;
        public void push(int data)
        {
            if(this.top==null)
            {
                top=new stackNode(data);
                return;
            }
            stackNode temp=new stackNode(data);
            temp.next=this.top;
            this.top=temp;
        }
        public stackNode pop()
        {
            stackNode sTop=this.top;
            this.top=this.top.next;
            return sTop;
        }
        public void Reverse()
        {
            stackNode prev,curr,suc;
            curr=prev=this.top;
            curr=curr.next;
            prev.next=null;
            while(curr != null)
            {
                suc=curr.next;
                curr.next=prev;
                prev=curr;
                curr=suc;
            }
            this.top=prev;
        }
        public void displayStack()
        {
            stackNode temp=this.top;
            while (temp != null)
            {
                System.out.print(temp.data+"  ");
                temp=temp.next;
            }
            System.out.println("NULL");
        }
    }
    public static void main(String[] args)
    {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Original Stack");
        s.displayStack();

        // reverse
        s.Reverse();

        System.out.println("Reversed Stack");
        s.displayStack();
    }
}

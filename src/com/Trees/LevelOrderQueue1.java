package com.Trees;

/** QUEUE INTERFACE IN JAVA
Being an interface the queue needs a concrete class for the declaration and the most common
classes are the PriorityQueue and LinkedList in Java.It is to be noted that both the implementations
are not thread safe. PriorityBlockingQueue is one alternative implementation if thread safe implementation
 is needed. Few important characteristics of Queue are:

The Queue is used to insert elements at the end of the queue and removes from the beginning of the queue.
It follows FIFO concept.
The Java Queue supports all methods of Collection interface including insertion, deletion etc.
LinkedList, ArrayBlockingQueue and PriorityQueue are the most frequently used implementations.
If any null operation is performed on BlockingQueues, NullPointerException is thrown.


BlockingQueues have thread-safe implementations.
The Queues which are available in java.util package are Unbounded Queues
The Queues which are available in java.util.concurrent package are the Bounded Queues.
All Queues except the Deques supports insertion and removal at the tail and head of the queue respectively.
 The Deques support element insertion and removal at both ends.*/

/** LinkedList in Java =============>
Due to the dynamicity and ease of insertions and deletions, they are preferred over the arrays.
It also has few disadvantages like the nodes cannot be accessed directly instead we need to start from
the head and follow through the link to reach to a node we wish to access.
To store the elements in a linked list we use a doubly linked list which provides a linear data
structure and also used to inherit an abstract class and implement list and deque interfaces.*/

import java.util.LinkedList;
import java.util.Queue;

public class  LevelOrderQueue1 {

    static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        // Let us create binary tree shown in above diagram
       /*             1
                   /     \
                  2       3
                /   \       \
               4     5       6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        printLevelOrderQueue(root);

    }

    private static void printLevelOrderQueue(Node rtNode) {
        if(rtNode == null)
            return;
        Queue<Node> nodeQueue=new LinkedList<>();
        // Pushing root node into the queue.
        nodeQueue.add(rtNode);
        // Pushing delimiter into the queue.
        nodeQueue.add(null);
        while(! nodeQueue.isEmpty())
        {
            Node currTopNode = nodeQueue.poll();
            if(currTopNode==null)
            {
                if(! nodeQueue.isEmpty())
                {
                    nodeQueue.add(null);
                    System.out.println();
                }
            }
            else
            {
                if(currTopNode.left != null)
                    nodeQueue.add(currTopNode.left);
                if(currTopNode.right != null)
                    nodeQueue.add(currTopNode.right);

                System.out.print(currTopNode.data+"  ");
            }
        }
    }
}

/* Method	Description
boolean add(E e)	It is used to append the specified element to the end of a list.
void add(int index, E element)	It is used to insert the specified element at the specified position
 index in a list.
boolean addAll(Collection<? extends E> c)	It is used to append all of the elements in the specified
 collection to the end of this list, in the order that they are returned by the specified collection's
 iterator.
boolean addAll(Collection<? extends E> c)	It is used to append all of the elements in the specified
collection to the end of this list, in the order that they are returned by the specified collection's
iterator.
boolean addAll(int index, Collection<? extends E> c)	It is used to append all the elements in the
specified collection, starting at the specified position of the list.
void addFirst(E e)	It is used to insert the given element at the beginning of a list.
void addLast(E e)	It is used to append the given element to the end of a list.
void clear()	It is used to remove all the elements from a list.
Object clone()	It is used to return a shallow copy of an ArrayList.
boolean contains(Object o)	It is used to return true if a list contains a specified element.
Iterator<E> descendingIterator()	It is used to return an iterator over the elements in a deque in
reverse sequential order.
E element()	It is used to retrieve the first element of a list.
E get(int index)	It is used to return the element at the specified position in a list.
E getFirst()	It is used to return the first element in a list.
E getLast()	It is used to return the last element in a list.
int indexOf(Object o)	It is used to return the index in a list of the first occurrence of the
specified element, or -1 if the list does not contain any element.
int lastIndexOf(Object o)	It is used to return the index in a list of the last occurrence of the
specified element, or -1 if the list does not contain any element.
ListIterator<E> listIterator(int index)	It is used to return a list-iterator of the elements in
proper sequence, starting at the specified position in the list.
boolean offer(E e)	It adds the specified element as the last element of a list.
boolean offerFirst(E e)	It inserts the specified element at the front of a list.
boolean offerLast(E e)	It inserts the specified element at the end of a list.
E peek()	It retrieves the first element of a list
E peekFirst()	It retrieves the first element of a list or returns null if a list is empty.
E peekLast()	It retrieves the last element of a list or returns null if a list is empty.
E poll()	It retrieves and removes the first element of a list.
E pollFirst()	It retrieves and removes the first element of a list, or returns null if a list is empty.
E pollLast()	It retrieves and removes the last element of a list, or returns null if a list is empty.
E pop()	It pops an element from the stack represented by a list.
void push(E e)	It pushes an element onto the stack represented by a list.
E remove()	It is used to retrieve and removes the first element of a list.
E remove(int index)	It is used to remove the element at the specified position in a list.
boolean remove(Object o)	It is used to remove the first occurrence of the specified element in a list.
E removeFirst()	It removes and returns the first element from a list.
boolean removeFirstOccurrence(Object o)	It is used to remove the first occurrence of the
specified element in a list (when traversing the list from head to tail).
E removeLast()	It removes and returns the last element from a list.
boolean removeLastOccurrence(Object o)	It removes the last occurrence of the specified element
 in a list (when traversing the list from head to tail).
E set(int index, E element)	It replaces the element at the specified position in a list with the
specified element.
Object[] toArray()	It is used to return an array containing all the elements in a list in proper
sequence (from first to the last element).
<T> T[] toArray(T[] a)	It returns an array containing all the elements in the proper sequence
 (from first to the last element); the runtime type of the returned array is that of the specified array.
int size()	It is used to return the number of elements in a list.
*/

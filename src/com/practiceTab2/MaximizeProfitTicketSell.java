package com.practiceTab2;

/*Maximize the profit after selling the tickets
Given an array seats[] where seat[i] is the number of vacant seats in the ith row in a stadium
for a cricket match. There are N people in a queue waiting to buy the tickets. Each seat costs
equal to the number of vacant seats in the row it belongs to. The task is to maximize the profit
 by selling the tickets to N people.
Examples:
Input: seats[] = {2, 1, 1}, N = 3
Output: 4
Person 1: Sell the seat in the row with
2 vacant seats, seats = {1, 1, 1}
Person 2: All the rows have 1 vacant
seat each, seats[] = {0, 1, 1}
Person 3: seats[] = {0, 0, 1}*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**Approach: In order to maximize the profit, the ticket must be for the seat in a row which has the
 *  maximum number
 * of vacant seats and the number of vacant seats in that row will be decrement by 1 as one of the seats
 * has just been sold. All the persons can be sold a seat ticket until there are vacant seats.
 * This can be computed efficiently with the help of a priority_queue.*/

public class MaximizeProfitTicketSell {
    public static void main(String[] args)
    {
        int[] arr={1,2,4}; //    2,3,4,5,1   using this answer ==  22
        int N=3;  //             n=6
        // Arrays.sort(arr, Collections.reverseOrder()); does not work because its for list not int[].
        //  until you make your own comparator to sort it in rev order.
        // better would be to make arrayList from this array,and use
        // collections.sort(listName,Collections.reverseorder())
        MaximizeProfitTicketSellArList(arr,N,arr.length);
        MaximizeProfitTicketSellPQueue(arr,N,arr.length);
    }

    private static void MaximizeProfitTicketSellArList(int[] ticArray, int NumOfPPersons, int lArr) {
//        ArrayList<Integer> PqAList=new ArrayList<>();
//        for (int i = 0; i < lArr; i++) {
//            PqAList.add(ticArray[i]);
//        }
        ArrayList<Integer> PqAList= IntStream.of(ticArray).boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.sort(PqAList, Collections.reverseOrder());
        System.out.println(PqAList);

        /** This is the another way we can write things but its little hard to understand.
         *  converting array of ints to ArrayList of Integers.

         ArrayList<Integer> PqAList= IntStream.of(ticArray).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));
        PqAList.sort(Collections.reverseOrder());*/

        int MaxProfitYet=0;
        int countPeople=0;
        while(countPeople<NumOfPPersons)
        {
            PqAList.sort(Collections.reverseOrder()); // to maintain maxHeap Property
            int top=PqAList.get(0); // Like .peek()
            //System.out.println("before remove "+PqAList);
            PqAList.remove(0);// Like .pop() in heap== deleting top element
            //System.out.println("after remove ="+PqAList);
            //System.out.println("************************");

            if(top==0) // # If there are no vacant seats
                break;
            MaxProfitYet = MaxProfitYet + top;
            PqAList.add(top-1); // this automatically adds element in end of ArrayList.
            // no need to get size() - 1 index and put value there.
            countPeople+=1;
        }
        System.out.println("Max profit possible == "+MaxProfitYet);
    }

    // static int[] seats = new int[]{ 1, 2, 4 }; we can declare this like that so that the function
    // doesnt have to take array as argument, direct access possible
    private static void MaximizeProfitTicketSellPQueue(int[] arr, int N, int ln) {
        // Priority queue that stores the count of empty seats
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        // Insert each array element into the priority queue
        for (int i = 0; i < ln; i++)
        { q.add(arr[i]); }

        int ticketsSold=0;
        int maxProfit=0;
        while(ticketsSold<N && !q.isEmpty() && q.peek()>0)
        {
            maxProfit=maxProfit+q.peek();
            int temp=q.poll();   // q.remove() anything
            q.add(temp-1);
            ticketsSold+=1;
        }
        System.out.println("max profit by priority queue(rev order) MaxHeap == "+maxProfit);
    }
}

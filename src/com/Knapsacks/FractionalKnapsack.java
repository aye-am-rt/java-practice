package com.Knapsacks;

import java.util.Arrays;
import java.util.Comparator;

/**
Fractional Knapsack Problem
Given weights and values of n items, we need to put these items in a knapsack of capacity W
 to get the maximum total value in the knapsack.

In the 0-1 Knapsack problem, we are not allowed to break items. We either take the whole item
 or don’t take it.

Input:
Items as (value, weight) pairs
arr[] = {{60, 10}, {100, 20}, {120, 30}}
Knapsack Capacity, W = 50;
Output:
Maximum possible value = 240
by taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be
 60+100+(2/3)(120) = 240

In Fractional Knapsack, we can break items for maximizing the total value of knapsack.
 This problem in which we can break an item is also called the fractional knapsack problem.

Input :
Same as above
Output :
Maximum possible value = 240
By taking full items of 10 kg, 20 kg and 2/3rd of last item of 30 kg


 An efficient solution is to use Greedy approach. The basic idea of the greedy approach is
 to calculate the ratio value/weight for each item and sort the item on basis of this ratio.
 Then take the item with the highest ratio and add them until we can’t add the next item as a
 whole and at the end add the next item as much as we can. Which will always be the optimal
 solution to this problem.

 A simple code with our own comparison function can be written as follows, please see sort function
 more closely, the third argument to sort function is our comparison function which sorts the item
 according to value/weight ratio in non-decreasing order.
 After sorting we need to loop over these items and add them in our knapsack satisfying
 above-mentioned criteria.

 */

public class FractionalKnapsack {

    // Time complexity O(n log n)
    public static void main(String[] args)
    {
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        double maxValue = getMaxValue(wt, val, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);

    }
    static class ItemValue
    {
        Double cost;
        double wt, val, ind;
        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = ((double)val / wt);
        }
    }

    private static double getMaxValue(int[] wt, int[] val, int capacity) {
        ItemValue[] iValArray= new ItemValue[wt.length];
        for (int i = 0; i < wt.length; i++) {
            iValArray[i] = new ItemValue(wt[i],val[i],i);
        }
        //sorting items by value
        Arrays.sort(iValArray, (o1, o2) -> o2.cost.compareTo(o1.cost));

//        Arrays.sort(iValArray, new Comparator<ItemValue>() {
//            @Override
//            public int compare(ItemValue o1, ItemValue o2) {
//                return o2.cost.compareTo(o1.cost);
//            }
//        });

        double totalValue =0d;
        for (ItemValue i : iValArray) {
            int currWt=(int)i.wt;
            int currVal=(int)i.val;

            if(capacity-currWt >= 0)
            {
                // this weight can be picked while
                capacity = capacity - currWt;
                totalValue += currVal;
            }
            else
            {
                // item cant be picked whole
                double fraction = (double)capacity/currWt;
                totalValue += currVal * fraction;
                capacity = (int) ( capacity - (currWt * fraction) );
                break;
            }
        }
        return totalValue;

    }
}

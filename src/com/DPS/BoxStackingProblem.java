package com.DPS;


import java.util.Arrays;
import java.util.Comparator;

/**
Box Stacking Problem | DP-22
You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i),
 width w(i) and depth d(i) (all real numbers). You want to create a stack of boxes which is as tall
 as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base
 of the lower box are each strictly larger than those of the 2-D base of the higher box. Of course,
 you can rotate a box so that any side functions as its base. It is also allowable to use multiple
 instances of the same type of box.


 Following are the key points to note in the problem statement:
 1) A box can be placed on top of another box only if both width and depth of the upper placed box
 are smaller than width and depth of the lower box respectively.
 2) We can rotate boxes such that width is smaller than depth. For example, if there is a box with
 dimensions {1x2x3} where 1 is height, 2×3 is base, then there can be three possibilities,
 {1x2x3}, {2x1x3} and {3x1x2}
 3) We can use multiple instances of boxes. What it means is, we can have two different rotations
 of a box as part of our maximum height stack.

 Following is the solution based on DP solution of LIS problem.

 1) Generate all 3 rotations of all boxes. The size of rotation array becomes 3 times the size of
 original array. For simplicity, we consider depth as always smaller than or equal to width.

 2) Sort the above generated 3n boxes in decreasing order of base area.

 3) After sorting the boxes, the problem is same as LIS with following optimal substructure property.
 MSH(i) = Maximum possible Stack Height with box i at top of stack
 MSH(i) = { Max ( MSH(j) ) + height(i) } where j < i and width(j) > width(i) and depth(j) > depth(i).
 If there is no such j then MSH(i) = height(i)

 4) To get overall maximum height, we return max(MSH(i)) where 0 < i < n
 */

public class BoxStackingProblem {
    static class Box implements Comparable<Box>
    {
        int h;
        int w;
        int d;
        int area;

        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
            if(h>=0 && w>=0 && d>=0)
                this.area = (this.w * this.d);
            else
                this.area = 0;
        }

        @Override
        public String toString() {
            return "{h="+h+", w="+w+",d="+d+", area="+area+"}";
        }

        /* Sorting the Boxes on the bases of Area in non Increasing order.*/
        @Override
        public int compareTo(Box anotherBox) {
            return (anotherBox.area - this.area);  // decreasing order max first.
        }
    }

    /* Returns the height of the tallest stack that can be formed with give type of boxes */
    static int maxStackHeight(Box[] arr, int n)
    {
        Box[] rotations = new Box[n*3];

        /* New Array of boxes is created -  considering all 3 possible rotations,
        with width always greater than equal  to width */
        for (int i = 0; i < n; i++) {
            Box boxI= arr[i];
            /* Original Box*/
            rotations[3*i] = new Box(boxI.h, Math.max(boxI.w,boxI.d), Math.min(boxI.w,boxI.d));
            /* First rotations of box*/
            rotations[3*i+1] = new Box(boxI.w, Math.max(boxI.h,boxI.d), Math.min(boxI.h,boxI.d));
            /* Second rotations of box*/
            rotations[3*i + 2] = new Box(boxI.d, Math.max(boxI.w,boxI.h), Math.min(boxI.w,boxI.h));
        }
//        MODIFIED CLASS CONSTRUCTOR TO CALCULATE AREA AT THE TIME OF OBJECT MAKING ITSELF
//        /* Calculating base area of  each of the boxes.*/
//        for (Box box : rotations) {
//            box.area = box.w * box.d;
//        }
        Arrays.sort(rotations);
        System.out.println("rotations Array after sorting = ");
        System.out.println(Arrays.toString(rotations));

        int count = 3*n;
         /* Initialize msh values for all  indexes
        msh[i] --> Maximum possible Stack Height  with box i on top */
        int[] msh = new int[count];
        int maxFound=-1;
        /* Computing optimized msh[]  values in bottom up manner */
        for (int i = 0; i < count; i++)
        {
            msh[i] = 0;
            Box currB = rotations[i];
            int val = 0;
            for (int j = 0; j < i; j++)
            {
                Box prevBox= rotations[j];
                if(currB.w<prevBox.w && currB.d<prevBox.d )
                {
                    val = Math.max(val,msh[j]);
                }
            }
            msh[i] = val+currB.h;
            maxFound = Math.max(msh[i],maxFound);
        }
        return maxFound;
    }


    /* Driver program to test above function */
    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);
        System.out.println("The maximum possible "+ "height of stack is " + maxStackHeight(arr,4));
    }
}
//    In the above program, given input boxes are {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32}.
//    Following are all rotations of the boxes in decreasing order of base area.
//
//        10 x 12 x 32
//        12 x 10 x 32
//        32 x 10 x 12
//        4 x 6 x 7
//        4 x 5 x 6
//        6 x 4 x 7
//        5 x 4 x 6
//        7 x 4 x 6
//        6 x 4 x 5
//        1 x 2 x 3
//        2 x 1 x 3
//        3 x 1 x 2
//        The height 60 is obtained by boxes { {3, 1, 2}, {1, 2, 3}, {6, 4, 5}, {4, 5, 6},
//        {4, 6, 7}, {32, 10, 12}, {10, 12, 32}}
//
//        Time Complexity: O(n^2)
//        Auxiliary Space: O(n)

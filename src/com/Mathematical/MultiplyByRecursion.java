package com.Mathematical;
//
//Multiply two integers without using multiplication, division and bitwise operators, and no loops
//        By making use of recursion, we can multiply two integers with the given constraints.
//
//        To multiply x and y, recursively add x y times.

public class MultiplyByRecursion {

    /* function to multiply two numbers x and y*/
    static int multiply(int x, int y) {

        /* 0 multiplied with anything gives 0 */
        if (y == 0)
            return 0;

        /* Add x one by one */
        if (y > 0)
            return (x + multiply(x, y - 1));

        /* the case where y is negative */
        if (y < 0)
            return -multiply(x, -y);

        return -1;
    }

    // Driver code
    public static void main(String[] args) {

        System.out.print("\n" + multiply(5, -11));
    }
}

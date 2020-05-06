package com.Strings;

//Use nested loops.
//        Outer loops will decide the starting point.
//        First inner loops will decide the group size. Starting from 1 and goes up string character
//        array size.
//        Most inner loop will create the sub strings and print it.
//        See the code below for more understanding.

public class allSubStrings3 {
    public static void print(String input){
        // using 3 loops bad complexity
        int length = input.length();
        //start point
        for (int startPoint = 0; startPoint <length ; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <=length ; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                for (int j = startPoint ; j < grps ; j++) {
                    System.out.print(input.charAt(j));
                }
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        String input = "abc";
        print(input);
    }
}

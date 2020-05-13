package com.Arrays.practiceTab2;
/**
Later when I catch-up with him, he told me about his interview experience and said that this question
 is quite popular on game programming domain and companies like Electronic arts and Sony. Why? because
 this is also used as collision detection algorithm, not very sophisticated but it is a quite popular
 collision detection algorithm for many arcade games like Super Mario Bros, Pac-Ma n, Donkey Kong and
 Breakout.

Since you can represent the characters and enemy as rectangle you can find out when an arrow hit the
 character or when he got one up by checking two rectangles are intersecting with each other. This looks v
 ery interesting problem to me and so I decided to take a look at this one. Btw, if you are interested in
 learning algorithms, I would suggest a brand new book, Grooking Algorithm by Aditya Bhargava. I was reading
 this book in the last couple of weekend and I have thoroughly enjoyed it.

How to check if two Rectangle Overlaps
The algorithm to check if two rectangles are overlapping or not is very straight forward but before
 that you need to know how you can represent a rectangle in Java programs? Well, a rectangle can be
 represented by two coordinates, top left, and bottom right. As part of the problem you will be given
 four coordinates L1, R1 and L2, R2, top left and bottom right coordinate of two rectangles and you need
 to write a function isOverlapping() which should return true if rectangles are overlapping or false if they
 are not.
*/


public class CheckRectanglesOverlap {

    public static void main(String[] args) {
        MyPoint l1 = new MyPoint(0, 10);
        MyPoint r1 = new MyPoint(10, 0);
        MyPoint l2 = new MyPoint(5, 5);
        MyPoint r2 = new MyPoint(15, 0);

        Rectangle first = new Rectangle(l1, r1);
        Rectangle second = new Rectangle(l2, r2);

        if (first.isOverLapping(second)) {
            System.out.println("Yes, two rectangles are intersecting with each other");
        } else {
            System.out.println("No, two rectangles are not overlapping with each other");
        }
    }

}

class MyPoint {
    int x;
    int y;

    public MyPoint(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}

class Rectangle {

    private final MyPoint topLeft;
    private final MyPoint bottomRight;

    public Rectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean isOverLapping(Rectangle other) {
        if (this.topLeft.x > other.bottomRight.x // R1 is right to R2
                || this.bottomRight.x < other.topLeft.x // R1 is left to R2
                || this.topLeft.y < other.bottomRight.y // R1 is above R2
                || this.bottomRight.y > other.topLeft.y) { // R1 is below R1
            return false;
        }
        return true;
    }
}

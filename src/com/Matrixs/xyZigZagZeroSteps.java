package com.Matrixs;
/**
 Number of steps required to reach point (x,y) from (0,0) using zig-zag way
 Given a coordinate (x, y). The task is to calculate the number of steps required to reach point
 (x, y) from (0, 0) using zig-zag way and you cannot travel in straight line for more than 1 unit.
 Also, start moving along Y axis.
Approach: By sketching a small diagram we can see the two cases:

Case 1: If x is less than y then answer will always be x + y + 2*((y-x)/2).
Case 2: If x is greater than equal to y then answer will always be x + y + 2*(((x-y)+1)/2).*/

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
Check if the tower of sight issue occurs or not
Given four co-ordinates A, B, C and D where towers need to be constructed, the task is to check
 if the tower of sight issue occurs or not.
Tower of sight issue occurs if the towers at A or C lies in the line joining B and D or vice versa.

Examples:
Input: A = (0, 0), B = (0, -2), C = (2, 0), D = (0, 2)
Output: Yes
Explanation:
Tower A lies in the line joining B and D.*/
//If A and C are parallel to the X-axis, check if B or D has y coordinate equal to that of A and C
// and x coordinate in between that of A and C.
//        If A and C are parallel to the Y-axis, check if B or D has x coordinate equal to that of A
//        and C and y coordinate in between that of A and C.
//        Otherwise, check if B or D satisfies the line equation of A and C.
//        Similarly follow the above three steps to check if A or C lies in between B or D.

public class xyZigZagZeroSteps {
    // Function to return the required position
    static int countSteps(int x, int y)
    {
        if (x < y)
        {
            return x + y + 2 * ((y - x) / 2);
        }
        else
        {
            return x + y + 2 * (((x - y) + 1) / 2);
        }
    }
    public static void main(String[] args)
    {
        int x = 4, y = 3;
        System.out.println(countSteps(x, y));

        // Point A
        Point2D a = new Point2D.Double( 0, 0 );
        // Point B
        Point2D b = new Point2D.Double( 1, 1 );
        // Point C
        Point2D c = new Point2D.Double( 2, 0 );
        // Point D
        Point2D d = new Point2D.Double( 2, 1 );
        CheckIfTowerOfSightProblemOccurs(a, b, c, d);
    }
// Tower of sight issue occurs if the towers at A or C lies in the line joining B and D or vice versa.
    private static void CheckIfTowerOfSightProblemOccurs(Point2D a, Point2D b,
                                                         Point2D c, Point2D d) {
        // line joining a and c
        Line2D ac = new Line2D.Double(a,c);
        // line joining b and d
        Line2D bd = new Line2D.Double(b,d);

/*        System.out.println("ac x1 "+ac.getX1());
        System.out.println("ac x2 "+ac.getX2());
        System.out.println("ac y1 "+ac.getY1());
        System.out.println("ac y2 "+ac.getY2());
        System.out.println("P1 ac == "+ ac.getP1());
        System.out.println("P2 ac == "+ ac.getP2());*/

        System.out.println(ac.intersectsLine(bd));
//        System.out.println(ac.contains(bd.getP1()));
//        System.out.println(ac.contains(bd.getP2()));
/**      public boolean contains(Rectangle2D r)
        Tests if the interior of this Line2D entirely contains the specified Rectangle2D.
        This method is required to implement the Shape interface, but in the case of Line2D objects
         it always returns false since a line contains no area.*/
//        System.out.println("ac bdx1 bdy1 "+ ac.contains(bd.getX1(),bd.getY1()));
//        System.out.println("ac bdx2 bdy2 "+ ac.contains(bd.getX2(),bd.getY2()));

        //System.out.println("ac 1,0 "+ ac.contains(0,0));

        // check if b lies on ac line
        // (y-y1)/(x-x1)  =  (y2-y1)/(x2-x1)
        double m = (c.getY()-a.getY())/(c.getX()-a.getX());
        if((b.getY()-a.getY())/(b.getX()-a.getX()) == m)  // check b
            System.out.println(" point b lies on line ac");
        else if((d.getY()-a.getY())/(d.getX()-a.getX()) == m)  // check d lies or not
            System.out.println(" point d lies on line ac");
        else
            System.out.println(" no tower of sight problem ");






    }
}

package com.Strings;

public class allSubstrings2 {
    public static void main(String[] args)
    {
        String str = "abcd";
        printSubSeq(str, "");
    }

    private static void printSubSeq(String s1, String s0) {
        if(s1.length()==0)
        { System.out.print(" "+s0+" ");return;}
        char ch=s1.charAt(0);
        String ros=s1.substring(1);
        printSubSeq(ros,s0);
        printSubSeq(ros,s0+ch);
    }
}

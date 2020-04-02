package com.practiceTab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class allSubstrings1 {
    public static void main(String[] args) throws IOException {
        System.out.print("give a string to print substrings = ");
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str1=br.readLine().strip();
        System.out.print("give a number to check not relevant = ");
        int n=Integer.parseInt(br.readLine().strip());
        System.out.println("n= "+n);
        System.out.println(printAllSubs(str1, str1.length()));
    }

    private static ArrayList<String> printAllSubs(String str1, int n) {
        ArrayList<String> al=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                al.add(str1.substring(i,j));
            }
        }
        return al;
    }
}
//    d  c  cd  b  bd  bc  bcd  a  ad  ac  acd  ab  abd  abc  abcd      1 type
//    [ a, ab, abc, abcd, b, bc, bcd, c, cd, d]                         2 type
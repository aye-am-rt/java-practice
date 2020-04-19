package com.Bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XorExceptI {
    public static void main(String[] args) throws IOException {
        System.out.print("give space separated  numbers to make xor array = ");
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] intLs=br.readLine().strip().split("\\s");
        System.out.println(Arrays.toString(makeXors(intLs, intLs.length)));
    }

    private static String[] makeXors(String[] intLs, int length) {
        int xor=0;
        for (int i = 0; i < length; i++) {
            xor^=Integer.parseInt(intLs[i]);
        }
        for (int i = 0; i < length; i++) {
            intLs[i]=String.valueOf(xor^Integer.parseInt(intLs[i]));
        }
        return intLs;
    }
}

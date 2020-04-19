package com.Arrays.SubsetSums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSumDP {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().strip().split("\\s");
        int findSum=Integer.parseInt(br.readLine().strip());
        if (checkSubsetSum(arr, arr.length, findSum))
            System.out.println("Found a subset" + " with given sum");
        else
            System.out.println("No subset with" + " given sum");
    }

    private static boolean checkSubsetSum(String[] arr, int length, int findSum) {
        boolean[][] subset2D =new boolean[findSum+1][length+1];
        for (int i = 0; i <= length; i++) {
            subset2D[0][i]=true;
        }
        for (int i = 1; i <= findSum; i++) {
            subset2D[i][0]=false;
        }
        for (int i = 1; i <=findSum ; i++) {
            for (int j = 1; j <=length ; j++) {
                subset2D[i][j]=subset2D[i][j-1];
                if(i>=Integer.parseInt(arr[j-1]))
                { subset2D[i][j]=subset2D[i][j] || subset2D[i-Integer.parseInt(arr[j-1])][j-1]; }
            }
        }
        for (int i = 0; i <=findSum ; i++) {
            for (int j = 0; j <=length ; j++) {
                System.out.print(subset2D[i][j]+"  ");
            }
            System.out.println();
        }
        return subset2D[findSum][length];
    }
}

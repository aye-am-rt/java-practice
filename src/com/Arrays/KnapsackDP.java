package com.Arrays;

public class KnapsackDP {
    public static void main(String[] args)
    {
        int[] val={60,100,120};
        int[] wts={10,20,30};
        int WMax=50;
        int n=val.length;
        System.out.println(Knapsack01DP(val,wts,WMax,n));
    }

    private static int Knapsack01DP(int[] val, int[] wts, int wMax, int n) {
        int[][] K=new int [n+1][wMax+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < wMax+1; j++) {
                if(i==0 || j==0)
                    K[i][j]=0;
                else if(wts[i-1]<=j)
                    K[i][j]=Math.max(val[i-1]+K[i-1][j-wts[i-1]],K[i-1][j]);
                else
                    K[i][j]=K[i-1][j];
            }
        }
        return K[n][wMax];
    }
}

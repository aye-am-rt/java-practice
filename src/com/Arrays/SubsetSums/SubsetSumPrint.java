package com.Arrays.SubsetSums;
/* perfect sum problem - print all subsets with given sum  */

import java.util.ArrayList;

public class SubsetSumPrint {
    static boolean[][] dp;
    public static void main(String[] args)
    {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("give size of array ");
//        int n=sc.nextInt();
//        int [] set = new int[n];
//        Point ar[]=new Point[n];
//        for( int i=0;i<n;i++)
//        {
//            System.out.print(" give "+ i +" element of set ");
//            set[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(set));
//        System.out.print("give sum to check in array ");
//        int sum=sc.nextInt();
///*        for(int i: set){ //for printing array
//            System.out.println(i);
//        }
        int [] set = {3,34,4,12,2,1,6};
        int sum = 7;
        PrintPossibleSubsets(set, set.length, sum);
    }

    private static void PrintPossibleSubsets(int[] arr, int ln, int findSum) {
        if (ln == 0 || findSum<0 ) {
            return;
        }
        dp=new boolean[findSum+1][ln+1];
        for (int i = 0; i <= ln; i++) {
           dp[0][i]=true;
        }
        for (int i = 1; i <= findSum; i++) {
            dp[i][0]=false;
        }
        for (int i = 1; i <= findSum ; i++) {
            for (int j = 1; j <= ln; j++) {
                dp[i][j] = dp[i][j - 1];
                if (arr[j-1]<=i) {  //if element at current length in array is greater than currentFindSum
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
                }
            }
        }
//        for (int i = 0; i <=findSum ; i++) {
//            for (int j = 0; j <=ln ; j++) {
//                System.out.print(dp[i][j]+"     ");
//            }
//            System.out.println();
//        }
        if(dp[findSum][ln])
        {
            ArrayList<Integer> p=new ArrayList<>();
            printSubsetRec(arr,ln,findSum,p);
        }
        else
        {
            System.out.println(" no subset with given sum");
            return;
        }

    }

    private static void printSubsetRec(int[] arr, int ln, int findSum, ArrayList<Integer> p) {
      if(ln==0 && findSum!=0 && dp[findSum][0])
      {
          p.add(arr[ln]);
          System.out.println(p);
          p.clear();
          return;
      }
      if(ln==0 && findSum==0)
      {
          System.out.println(p);
          p.clear();
          return;
      }
      if(dp[findSum][ln-1])
      {
          ArrayList<Integer> b = new ArrayList<>(p);
          //System.out.println("did this new list b ");
          printSubsetRec(arr,ln-1,findSum,b);
      }
      if(findSum>=arr[ln-1] && dp[findSum-arr[ln-1]][ln-1])
      {
          p.add(arr[ln-1]);
          printSubsetRec(arr,ln-1,findSum-arr[ln-1],p);
      }

    }
}

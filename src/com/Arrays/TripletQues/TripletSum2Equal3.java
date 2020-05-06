package com.Arrays.TripletQues;

import java.util.Arrays;

public class TripletSum2Equal3 {
    public static void main(String[] args)
    {
        int[] arr = {5,32,1,7,10,50,19,21,2};
        int n=arr.length;
        System.out.print(PrintTripletSum2Equals3(arr, n));
    }

    private static String PrintTripletSum2Equals3(int[] arr, int n) {
        if (n < 3) {
            throw new IllegalArgumentException();
        }
        StringBuilder sBld=new StringBuilder();
        Arrays.parallelSort(arr);
        for (int i = n-1; i > -1; i--) {
            int j=0;
            int k=(i-1);
            while(j<k)
            {
                if(arr[i]==(arr[j]+arr[k]))
                {
                    System.out.println("triplets are = "+ arr[j]+" , "+arr[k]+" , "+arr[i]);
                    sBld.append("( ")
                            .append(arr[j]).append(", ")
                            .append(arr[k]).append(", ")
                            .append(arr[i]).append(" ) ");
                    j+=1;k-=1;
                }
                 else if(arr[i]>(arr[j]+arr[k]))
                     j+=1;
                 else
                     k-=1;
            }

        }
        return sBld.toString();
    }
}

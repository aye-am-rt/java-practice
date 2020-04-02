package com.practiceTab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class mergeSort {
    public static void main(String[] args)
    {
/*      Scanner scanner = new Scanner(System.in);
        int numOfBlocks = scanner.nextInt();
        int weightArray[] = new weightArray[numOfBlocks]; // new int[3], new double[3] can also go.
        for(int i=0;i<numOfBlocks;i++)
        {
            weightArray[i] = scanner.nextInt();
        }
        scanner.close();*/

        Scanner sc= new Scanner(System.in);
        System.out.print("give space separated integers to sort = ");
        String[] nLine=sc.nextLine().strip().split(" ");
        int n= nLine.length;
        int[] arr= new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(nLine[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mergeSortArray(arr,n)));
    }

    private static int[] mergeSortArray(int[] arr, int n) {
        if(n==0)
        { return(null);}
        if(n==1)
        {return (arr);}
        int mid=n/2;
        int[] left=Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,n);
        return(mergeBackwards(
                        Objects.requireNonNull(mergeSortArray(left, left.length)),
                        mergeSortArray(right,right.length)
                        ));
    }

    private static int[] mergeBackwards(int[] left, int[] right) {
        int l=0;
        int r=0;
        ArrayList<Integer> al=new ArrayList<>();
        while(l<left.length && r<right.length)
        {
            if(left[l]<right[r])
            { al.add(left[l]);l++; }
            else
            { al.add(right[r]);r++; }
        }
        //list1.addAll(list2);
        while(l<left.length)
        { al.add(left[l]);l++; }
        while (r<right.length)
        { al.add(right[r]);r++; }

        int[] result=new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            result[i]=al.get(i);
        }
        return result;
    }
}

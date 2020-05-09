package com.vmware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test1 {
    public static void main(String[] args)
    {
        int[] arr1= {-2, -3, -4, -1, 4, -2, 5, -3};
        int n= arr1.length;
        System.out.println("original array = ");
        System.out.println(Arrays.toString(arr1));
        //{-4. -3, -3 , -2, -2, -1, 5,4}
        System.out.println("modified array = ");
        CollectNegLeftPosRight(arr1,n);
        System.out.println("************ making bi tonic now *****************");
        MakeArrayBi_tonic(arr1,n);

    }

    private static void MakeArrayBi_tonic(int[] arr, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        ArrayList<Integer> negList=new ArrayList<>();
        ArrayList<Integer> posList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i]<=0)
                negList.add(arr[i]);
            else
                posList.add(arr[i]);
        }
        Collections.sort(negList);
        //Collections.sort(posList,Collections.reverseOrder());
        posList.sort(Collections.reverseOrder());
        System.out.print("after normal sorting neg elements == ");
        System.out.println(negList);
        System.out.print("after Collections.reverseOrder() sorting pos elements == ");
        System.out.println(posList);
        for (int i = 0; i < negList.size(); i++) {
            arr[i]=negList.get(i);
        }
        for (int i = 0; i < posList.size(); i++) {
            arr[i+negList.size()]=posList.get(i);
        }
        System.out.println("final bi tonic array = ");
        System.out.println(Arrays.toString(arr));
    }

    private static void CollectNegLeftPosRight(int[] arr1, int n) {
        if(n<1)
            throw new IllegalArgumentException();
        int left=0;
        int right=n-1;
        while(left<right)
        {
            if(arr1[left]>0 && arr1[right]<0)
            {
                int temp= arr1[left];
                arr1[left]=arr1[right];
                arr1[right]=temp;
                left++;
                right--;
            }
            else {
                if (arr1[right] > 0)
                    right--;
                if (arr1[left] < 0)
                    left++;
            }

        }
        System.out.println(Arrays.toString(arr1));
    }
}

package com.vmware;

import java.util.Arrays;

public class CountGreaterElemsAtRightEach {
    public static void UpdateQAZ(int[] A , int low, int mid, int high)
    {
        int maxElem = Arrays.stream(A).max().getAsInt();
        int[] qazAns = new int[maxElem+1];
        Arrays.fill(qazAns,0);

        int i,j;

        int added_qaz = 0;

        i = mid;
        j = high;

        while ( ( i >= 0 ) && ( j > mid ) )
        {
            if ( A[ j ] > A[ i ] )
            {
                added_qaz++;
                j--;
            }
            else
            {
                qazAns[ A[ i ] ] += added_qaz;
                i--;
            }
        }

        if ( j <= mid )
        {
            for (int x = i ; x >=low ; x-- )
            {
                qazAns[ A[ x ] ] += added_qaz;
            }
        }

        //System.out.println(Arrays.toString(qazAns));
        for (int k = 0; k < maxElem ; k++)
        {
            if(qazAns[k] != 0)
                System.out.println("index(Element) = "+k+" qazOf(element)= "+(qazAns[k]+1) );
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {33 , 48 , 26 , 58 , 41 , 59};
        int size = arr.length;
        UpdateQAZ(arr,0,(size/2),size-1);

    }
}

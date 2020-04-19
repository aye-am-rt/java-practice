package com.Matrixs;

public class SearchSortedMatrix {
    public static void main(String[] args)
    {
        int[][] matrix= {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target=99;
        // solution////////////////
        int R=matrix.length;
        int C=matrix[0].length;

        int i=0;
        int j=C-1;
        boolean flagFound=false;
        while(i<R && j>-1)
        {
           if(matrix[i][j]==target)
           {
               System.out.println("target found at i = "+i+" j = "+j+" index cell");
               flagFound=true;
               break;
           }
           else if(matrix[i][j] < target)
           { i+=1; }
           else
           { j-=1; }
        }
        if(!flagFound)
            System.out.println("not found in matrix");
    }
}

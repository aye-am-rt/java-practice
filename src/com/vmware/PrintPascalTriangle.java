package com.vmware;

import java.util.Scanner;

public class PrintPascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type N: ");
        int n = scanner.nextInt();
        System.out.println("\n***** printing stack overflow  way no space o(n^2) time" + "*****\n");
        pascalTriangle(n);
        System.out.println("\n***** printing second way but this uses n^2 space matrix" + "**********\n");
        pascalTriangleUsingMatrix(n);
        System.out.println("\n***** printing by geeks way o(N^2) time, O(1) space " + "*******\n");
        pascalTriangleGeeksWay(n);
        scanner.close();
    }

    private static void pascalTriangleGeeksWay(int n) {
        for(int line = 1; line <= n; line++)
        {
            int C=1;        // used to represent C(line, i)
            for(int i = 1; i <= line; i++)
            {// The first value in a line is always 1
                System.out.print(C+"  ");
                C = C * (line - i) / i;
            }
            System.out.println(" ");
        }
    }

    public static void pascalTriangle(final int N) {
        int row, num;
        for (int i = 0; i < N; i++)
        {
            num = 1;
            row = i + 1;
            for (int col = 0; col <= i; col++)
            {
                if (col != 0)
                    num = num * (row - col) / col;
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
    public static void pascalTriangleUsingMatrix(final int N) {
        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    triangle[i][0] = 1;
                else
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                System.out.print(triangle[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

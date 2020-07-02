package com.Matrixs;

public class ReplaceOsByXs {
    static int M = 6;
    static int N = 6;
    public static void main (String[] args)
    {
        char[][] mat = {{'X', 'O', 'X', 'O', 'X', 'X'},
                        {'X', 'O', 'X', 'X', 'O', 'X'},
                        {'X', 'X', 'X', 'O', 'X', 'X'},
                        {'O', 'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'O', 'X', 'O'},
                         {'O', 'O', 'X', 'O', 'O', 'O'}};

        replaceSurrounded(mat);

        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println("");
        }
    }

    private static void replaceSurrounded(char[][] mat) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(i==0 || j==0 || i==M-1 || j==N-1) { }
                else
                {
                    if(mat[i][j]=='O')
                    {
                        if(mat[i-1][j]=='X' && mat[i+1][j]=='X' && mat[i][j-1]=='X' && mat[i][j+1]=='X')
                        {
                            mat[i][j]='X';
                        }
                    }
                }
            }
        }
    }
}
//    Time Complexity of the above solution is O(MN).

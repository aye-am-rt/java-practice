package com.practiceTab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class stringPermBackTrack {
    public static void main(String[] args) throws IOException {
        System.out.print("give a string = ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strLs = br.readLine();
        System.out.println(allPermsBT(strLs.strip(), 0,strLs.length()));
    }
    static ArrayList<String> al = new ArrayList<>();
    private static ArrayList<String> allPermsBT(String st1, int left, int right) {
        if(left==right)
        { al.add(st1); }
        else
        {
            for (int i = left; i <right ; i++) {
                String sp1=swapIndex(st1,left,i);
                allPermsBT(sp1,left+1,right);
                swapIndex(sp1,left,i);
            }
        }
        return(al);
    }

    private static String swapIndex(String st,int lIndex, int rIndex) {
        char temp=st.charAt(lIndex);
        char[] chars=st.toCharArray();
        chars[lIndex]=chars[rIndex];
        chars[rIndex]=temp;
        return(new String(chars));
        //or we can use StringBuilder,iterate over char array add each element in sb then return sb.toString()
    }
}

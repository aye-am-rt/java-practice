package com.practiceTab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionSystem {
    public static void main(String[] args)
    {
        String[] arr={"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println(ReturnListOfSuggestions(arr,searchWord,arr.length));
    }

    private static List<List<String>> ReturnListOfSuggestions(String[] arr, String searchWord, int length) {
        List<List<String>> ansLists=new ArrayList<>();
        //String s1="moneypot";
        ArrayList<String> iniList=new ArrayList<>(Arrays.asList(arr));
        //StringBuilder sbl=new StringBuilder(arr[0]);
        for (int i = 0; i < searchWord.length() ; i++) {
            String s=searchWord.substring(0,i+1);
            //System.out.print("inilist=="+iniList);
            //System.out.println(" s== "+s);
            ArrayList<String> al=MatchEachLetter(iniList,s);
            if(al.size()>3)
            {
                Collections.sort(al);
                ansLists.add(al.subList(0,3));
            }
            else
            {
                ansLists.add(al);
            }
            iniList.clear();
            iniList.addAll(al);
            // or  inlist=al;  could also have worked;
        }
        //System.out.println(Arrays.toString(s1.split("x",2)));
        return ansLists;
    }

    private static ArrayList<String> MatchEachLetter(ArrayList<String> iniList, String s) {
        ArrayList<String> subAns=new ArrayList<>();
        for (String value : iniList) {
            //System.out.print(value.substring(0, s.length()));
            //System.out.println("   "+s+" value == "+value);
            //System.out.println("**************");
            if (value.substring(0, s.length()).equalsIgnoreCase(s)) {
                subAns.add(value);
            }
        }
        //System.out.println(" subAns== "+subAns);
        //System.out.println("**************");
        return subAns;
    }
}

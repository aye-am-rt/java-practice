package com.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class stringPermutations {
    public static void main(String[] args) throws IOException {
        System.out.print("give a string = ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strLs = br.readLine();
        System.out.println(allPerms(strLs.strip(), ""));
    }

    static Set<String> hash_Set = new HashSet<>();

    private static Set<String> allPerms(String sGiven, String sIni) {
        if (sGiven.length() == 0) {
            hash_Set.add(sIni);
            return hash_Set;
        }
        for (int i = 0; i < sGiven.length(); i++) {
            char ch = sGiven.charAt(i);
            String ros = sGiven.substring(0, i) + sGiven.substring(i + 1);
            allPerms(ros, sIni + ch);
        }
        return hash_Set;
    }
}

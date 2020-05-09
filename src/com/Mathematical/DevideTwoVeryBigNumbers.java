package com.Mathematical;

import java.util.Arrays;

public class DevideTwoVeryBigNumbers {
    public static void main(String[] args)
    {
        String number = "1248163264128256512";
        int divisor = 125;
        System.out.println(longDivision(number, divisor));
    }

    private static String longDivision(String number, int divisor) {
        StringBuilder ans= new StringBuilder();
        // Find prefix of number that is larger than divisor.
        int idx = 0;
        char[] numDigits = number.toCharArray();
        System.out.println(Arrays.toString(numDigits));
        int temp = Character.getNumericValue(numDigits[idx]);  // int temp = numDigits[idx] - '0';
        System.out.println("first temp= "+temp);
        while(temp<divisor)
        {
            temp = 10*temp + Character.getNumericValue(numDigits[++idx]);
        }
        //idx+=1;
        while (idx < numDigits.length) // or number.length()
        {
            ans.append(temp / divisor);
            temp = (temp % divisor) * 10  + (Character.getNumericValue(numDigits[idx++]));
        }
        System.out.println("last idx= "+idx);
        if(ans.length()==0)
            return "0";
        else
            return ans.toString();

    }
}

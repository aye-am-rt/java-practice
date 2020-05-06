package com.Arrays.GST;

import java.util.Arrays;

public class MultiplyVeryBigNumArrays {
    public static void multiplyTwoNumber(int[] A, int[] B){
        int[] C = new int[A.length+B.length];
        int s = C.length-1;

        for(int j=B.length-1; j>=0; j--){
            int carry=0;
            int shift = s;
            for(int i=A.length-1; i>=0; i--){
                int m = A[i]*B[j];
                int sum = m+C[shift]+carry;
                int num = sum%10;
                carry = sum/10;
                C[shift] = num;
                shift--;
            }
            C[shift]=C[shift]+carry;
            s--;
        }
        System.out.println(Arrays.toString(C));
    }
    public static void main(String[] args)
    {
        int[] num1Array={3,4,5,6,7};
        int[] num2Array={9,7,8,6};
        multiplyTwoNumber(num1Array,num2Array);

        // can be used to find square of very big number just multiply it with itself.
        // str1==str2==given number

        String str1 = "-1235421415454545454545454544";
        String str2 = "1714546546546545454544548544544545";
        if ((str1.charAt(0) == '-' || str2.charAt(0) == '-') && (str1.charAt(0) != '-' || str2.charAt(0) != '-'))
            System.out.print("-");

        if(str1.charAt(0)=='-' && str2.charAt(0)!='-')
            str1=str1.substring(1);
        else if(str1.charAt(0)!='-' && str2.charAt(0)=='-')
            str2=str2.substring(1);
        else if(str1.charAt(0)=='-' && str2.charAt(0)=='-')
        {
            str1=str1.substring(1);
            str2=str2.substring(1);
        }
        System.out.println(multiplyTwoNumberStringsBig(str1,str2));
    }

    private static String multiplyTwoNumberStringsBig(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        if(l1==0 || l2==0)
            return "0";

        int[] result=new int[l1+l2];
        int i_n1=0;
        int i_n2=0;
        for (int i = l1-1; i >-1 ; i--) {
            int carry=0;
            int n1= Character.getNumericValue(str1.charAt(i)); // num1.charAt(i) - '0';
            // To shift position to left after every multiplication of a digit in num2
            i_n2 = 0;
            for (int j = l2-1; j > -1; j--) {
                int n2=Character.getNumericValue(str2.charAt(j)); // str2.charAt(j)-'0';
                int sum=n1*n2 + result[i_n1+i_n2]+carry;
                carry=sum/10;
                result[i_n1+i_n2]=sum%10;
                i_n2+=1;
            }
            if(carry>0)
                result[i_n1+i_n2]+=carry;
            i_n1+=1;
        }
        int i=result.length-1;  // this is for we can traverse the array from back-end
        // ignore '0's from the end which will actually become start of our Answer Number
        while (i>=0 && result[i]==0) // That's why ignoring them so that no zero comes in front.
            i--;
        if(i==-1)
            return "0";
        StringBuilder sbl=new StringBuilder();
        while (i>=0)
            sbl.append(result[i--]);
        return sbl.toString();
    }
}

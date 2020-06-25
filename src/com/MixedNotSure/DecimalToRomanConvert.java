package com.MixedNotSure;

import java.util.HashMap;

/**
Converting Decimal Number lying between 1 to 3999 to Roman Numerals
Given a number, find its corresponding Roman numeral.
Examples:

Input : 9
Output : IX

Input : 40
Output : XL

Input :  1904
Output : MCMIV
Following is the list of Roman symbols which include subtractive cases also:

SYMBOL       VALUE
I             1
IV            4
V             5
IX            9
X             10
XL            40
L             50
XC            90
C             100
CD            400
D             500
CM            900
M             1000

 Idea is to convert the units, tens, hundreds, and thousands places of the given number
 separately. If the digit is 0, then there’s no corresponding Roman numeral symbol.
 The conversion of digit’s 4’s and 9’s are little bit different from other digits because
 these digits follows subtractive notation.

 Algorithm to convert decimal number to Roman Numeral
 Compare given number with base values in the order 1000, 900, 500, 400, 100, 90, 50, 40, 10,
 9, 5, 4, 1. Base value which is just smaller or equal to the given number will be the initial
 base value (largest base value) .Divide the number by its largest base value, the corresponding
 base symbol will be repeated quotient times, the remainder will then become the number for
 future division and repetitions.The process will be repeated until the number becomes zero.

 Example to demonstrate above algorithm:

 Convert 3549 to its Roman Numerals
 Output:
 MMMDXLIX

 Explanation:

 Step 1
 Initially number = 3549
 Since 3549 >= 1000 ; largest base value will be 1000 initially.
 Divide 3549/1000. Quotient = 3, Remainder =549. The corresponding symbol M will be repeated thrice.

 Step 2
 Now, number = 549
 1000 > 549 >= 500 ; largest base value will be 500.
 Divide 549/500. Quotient = 1, Remainder =49. The corresponding symbol D will be repeated once.

 Step 3
 Now, number = 49
 50 > 49 >= 40 ; largest base value is 40.
 Divide 49/40. Quotient = 1, Remainder = 9. The corresponding symbol XL will be repeated once.

 Step 4
 Now, number = 9
 10> 9 >= 9 ; largest base value is 9.
 Divide 9/9. Quotient = 1, Remainder = 0. The corresponding symbol IX will be repeated once.

 Step 5
 Finally number becomes 0, algorithm stops here.
 Output obtained MMMDXLIX.

 */

public class DecimalToRomanConvert {
    public static void main(String[] args) {
        int number = 3549;
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] values = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        printRoman(number,nums,values);
        System.out.println("\nsecond way to print = ");
        System.out.println(intToRoman(number));
    }

    private static void printRoman(int number, int[] nums, String[] values) {
        if(values.length == 0 || nums.length != values.length)
        {
            System.out.println("not right values given");
            return;
        }
        HashMap<Integer,String> baseMap =  new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            baseMap.put(nums[i],values[i]);
        }
        System.out.println(baseMap);

        int i = 12 ;
        while(number!=0)
        {
            int div =  number/nums[i];
            number %= nums[i];

            while(div != 0)
            {
                System.out.print(values[i]+"");
                div-=1;
            }
            i-=1;
        }
    }
/*Another Approach 1::
In this approach we have to first observe the problem. The number given in problem statement
can be maximum of 4 digits. The idea to solve this problem is:

Divide the given number into digits at different places like one’s , two’s , hundred’s or
thousand’s.
Starting from the thousand’s place print the corresponding roman value. For example, if
the digit at thousand’s place is 3 then print the roman equivalent of 3000.
Repeat the second step until we reach one’s place.
Example:
Suppose the input number is 3549. So, starting from thousand’s place we will start printing the
roman equivalent. In this case we will print in the order as given below:
First: Roman equivalent of 3000
Second: Roman equivalent of 500
Third: Roman equivalent of 40
Fourth: Roman equivalent of 9
So, the output will be: MMMDXLIX*/

    // Function to calculate roman equivalent
    static String intToRoman(int num)
    {
        // storing roman values of digits from 0-9
        // when placed at different places
        String[] m = {"", "M", "MM", "MMM"};

        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Converting to roman
        String thousands = m[num/1000];
        String hundreds = c[(num%1000)/100];
        String tens = x[(num%100)/10];
        String ones = i[num%10];

        return thousands + hundreds + tens + ones;
    }

}

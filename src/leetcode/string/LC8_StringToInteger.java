package leetcode.string;

public class LC8_StringToInteger {
    /*
    Problem stmt:
   change the string to integer
   Gist: take the first character -> multiply by 10 + add the next charcter
         repeat the above process
   check if the string length is "" then return 0
   increament the i pointer until it is whitespace
   chek for sign if it is '+' or '-'

   1. Check for empty strings
   2. Check for leading space and remove
   3. Handle signs
   4. Convert the character to number by subtracting with character '0'
   5. check for the overflow condition
   6. return the digit
     */

    public static int atoi(String str) {
        int index = 0;
        //trim the leading and trailing white space
        str = str.trim();
        char[] ch = str.toCharArray();
        // initiate sign variable as positive for now
        int sign = 1; // -1 for negative

        if(index < ch.length && (ch[index]== '-' || ch[index] == '+')) {
            if(ch[index] == '-') sign = -1;
            index++;
        }

        // initiate the result variable
        int result = 0;

        // initiate the overflow variable
        int overFlow = Integer.MAX_VALUE / 10;

        while(index < ch.length) {
            int digit = ch[index] - '0';
            if(digit < 0 || digit > 9) break;

            // check the overflow
            if(overFlow < result || (overFlow == result && Integer.MAX_VALUE %10 < digit))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result*10 + digit;
            index++;
        }

        return result*sign;
    }

    public static void main(String[] args) {
        String s = "4193 with words";
        System.out.println(atoi(s));
    }


}

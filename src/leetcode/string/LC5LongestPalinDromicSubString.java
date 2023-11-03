package leetcode.string;

public class LC5LongestPalinDromicSubString {

    /*
    maxString = 0
    2 pointer approach
    low = 0, high=0

    for loop:
        check for odd number length
        low=high=i
        while(string at low == string at high) {
        low--;
       high++;
       if(low == -1 && high==str.length) break the while loop
        }
        // extract the substring and update the maxString accordingly

        repeat the above steps for even length
     */
    public static String longestPalindromicSubstring(String str) {

        if(str.length() <= 1) return "str";

        String maxString = "";

        for(int i=1; i<str.length(); i++) {

            //check for odd length
            int low=i;
            int high=i;

            while(str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if(low == -1 || high == str.length())
                    break;
            }
            // extract the substring
            String palindrome = str.substring(low+1, high);
            if(palindrome.length() > maxString.length()) {
                maxString  = palindrome;
            }

            //check for even length
            low=i-1;
             high=i;

            while(str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if(low == -1 || high == str.length())
                    break;
            }
            // extract the substring
             palindrome = str.substring(low+1, high);
            if(palindrome.length() > maxString.length()) {
                maxString  = palindrome;
            }
        }

        return maxString;
    }

    public static void main(String[] args) {
        String s = "EBBABAD";
        System.out.println(longestPalindromicSubstring(s));
    }
}

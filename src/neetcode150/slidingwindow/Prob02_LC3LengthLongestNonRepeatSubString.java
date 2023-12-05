package neetcode150.slidingwindow;

import java.util.*;

public class Prob02_LC3LengthLongestNonRepeatSubString {

    public  static int  lengthOfLongestSubstring(String s) {
        // Initialize the maximum length of the substring
        int ans = 0;

        // Create a HashMap to store the last index of each character in the string
        HashMap<Character, Integer> map = new HashMap<>();

        // Initialize the left pointer of the substring
        int left = 0;

        // Loop through the characters in the string
        for(int right = 0; right < s.length(); right++){
            // Get the current character at the right pointer
            char ch = s.charAt(right);

            // Check if the character is not present in the current substring
            if(!map.containsKey(ch)) {
                // If not present, add it to the HashMap with its index
                map.put(ch, right);
            } else {
                // If the character is already in the substring, update the left pointer
                // Move the left pointer to the right of the last occurrence of the character
                // (prevents counting duplicate characters in the current substring)
                left = Math.max(left, map.get(ch) + 1);

                // Update the index of the character in the HashMap
                map.put(ch, right);
            }

            // Update the maximum length of the substring
            ans = Math.max(ans, right - left + 1);
        }

        // Return the maximum length of the substring without repeating characters
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

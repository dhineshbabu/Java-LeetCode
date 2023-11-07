package leetcode.string;
import java.util.*;

public class LC76MinimumWindowSubstring {
    // Sliding window algorithm
    /*
    Variables: count=3, left=0, right=12, minLength=13, found=false;
    Data structure: Need a hashmap(for each character in substring to 1)
    reduce count and map.get(ch) if the char is found
     */

    public static String minWindow(String s, String t) {
        // Step 1: Check for edge cases
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return ""; // Return an empty string if any of the conditions are met.
        }

        // Step 2: Initialize variables
        int[] map = new int[128]; // An array to store character frequency counts.
        int count = t.length();  // Counter for characters in string 't' to be matched.
        int start = 0, end = 0;  // Pointers for the sliding window.
        int minLen = Integer.MAX_VALUE; // Minimum window length, initially set to a large value.
        int startIndex = 0;  // Starting index of the minimum window.

        // Step 3: Build a character frequency map for string 't'
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray(); // Convert string 's' to a character array.

        // Step 4: Sliding window approach
        while (end < chS.length) {
            // Check if the character at 's[end]' is needed for the current window.
            if (map[chS[end++]]-- > 0) {
                count--; // Decrement 'count' if a needed character is found.
            }

            // Use a nested while loop to contract the window while 'count' is zero.
            while (count == 0) {
                // If the current window is smaller than the minimum found so far.
                if (end - start < minLen) {
                    startIndex = start; // Update 'startIndex' to the start of the new minimum window.
                    minLen = end - start; // Update 'minLen' to the length of the new minimum window.
                }

                // Increment 'start' to contract the window.
                if (map[chS[start++]]++ == 0) {
                    count++; // If a needed character is removed from the window, increment 'count'.
                }
            }
        }

        // Step 5: Return the minimum window as a new string or an empty string if no valid window found.
        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}

package neetcode150.slidingwindow;

import java.util.*;

public class Prob05_LC76MinimumWindowSubstring {
    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

     */

    public static String minWindow(String s, String t) {
        // Check for null or empty strings
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

        // Create a map to store the frequency of characters in string t
        Map<Character, Integer> map = new HashMap<>();

        // Initialize the map with the frequency of characters in string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Initialize pointers, count, and variables for tracking the minimum window
        int i = 0, j = 0, count = map.size();
        int left = 0, right = s.length() - 1, min = s.length();
        boolean found = false;

        // Iterate through the characters in string s
        while (j < s.length()) {
            char endChar = s.charAt(j++);

            // Update the map and count when encountering a character in string t
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) count -= 1;
            }

            // If count is still greater than 0, continue searching for the window
            if (count > 0) continue;

            // Shrink the window from the left until count becomes greater than 0 again
            while (count == 0) {
                char startChar = s.charAt(i++);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) count += 1;
                }
            }

            // Update the minimum window if the current window is smaller
            if ((j - i) < min) {
                left = i;
                right = j;
                min = j - i;
                found = true;
            }
        }

        // If no valid window is found, return an empty string
        return !found ? "" : s.substring(left - 1, right); // [left-1, right - 1]
    }

}

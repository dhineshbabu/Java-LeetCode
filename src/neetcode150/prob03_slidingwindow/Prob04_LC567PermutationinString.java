package neetcode150.prob03_slidingwindow;

public class Prob04_LC567PermutationinString {
    /*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
     */

    public static boolean checkInclusion(String s1, String s2) {
        // Get the lengths of both strings
        int len1 = s1.length(), len2 = s2.length();

        // If the length of s1 is greater than s2, s1 cannot be a permutation of s2
        if (len1 > len2) return false;

        // Initialize an array to count the occurrences of characters in the current window
        int[] count = new int[26];

        // Initialize the count array based on the characters in the first window of size len1
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        // Check if the count array is all zeros (indicating a valid permutation)
        if (allZero(count)) return true;

        // Iterate through the remaining windows of size len1 in s2
        for (int i = len1; i < len2; i++) {
            // Update the count array by excluding the leftmost character and including the current character
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;

            // Check if the count array is all zeros (indicating a valid permutation)
            if (allZero(count)) return true;
        }

        // If no valid permutation is found in any window, return false
        return false;
    }

    // Helper method to check if all elements in the array are zeros
    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}

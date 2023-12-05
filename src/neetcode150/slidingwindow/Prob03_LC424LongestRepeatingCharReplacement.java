package neetcode150.slidingwindow;

public class Prob03_LC424LongestRepeatingCharReplacement {
    /*
    You are given a string s and an integer k. You can choose any character of the string and change it to
    any other uppercase English character. You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Example 1:

    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

    // check this explanation in comments
     https://leetcode.com/problems/longest-repeating-character-replacement/solutions/91271/java-12-lines-o-n-sliding-window-solution-with-explanation/

     */

    public static int characterReplacement(String s, int k) {
        // Time Complexity: O(n)

        // Initialize an array to store the frequency of characters
        int[] frequency = new int[26];

        // Initialize variables to keep track of the maximum length and the maximum frequency
        int maxLength = 0, maxF = 0;

        // Initialize the left pointer of the window
        int left = 0;

        // Loop through the characters in the string
        for(int right = 0; right < s.length(); right++){
            // Update the frequency of the current character and find the maximum frequency
            maxF = Math.max(maxF, ++frequency[s.charAt(right) - 'A']);

            // Check if the current window size minus the maximum frequency is greater than k
            if(right - left + 1 - maxF > k) {
                // If so, shrink the window by moving the left pointer to the right
                // and decrease the frequency of the character at the left pointer
                frequency[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the maximum length of a substring with at most k replacements
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}

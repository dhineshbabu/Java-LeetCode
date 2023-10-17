package leetcode.string;

public class LC424LongestRepeatingCharacterReplacement {
    public static int charReplacement(String s, int k) {
        // Time Complexity: O(n)
        int[] frequency = new int[26];
        int maxLength = 0, maxF = 0;
        int left = 0;
        for(int right=0; right<s.length(); right++){
            maxF = Math.max(maxF, ++frequency[s.charAt(right) - 'A']);

            if(right - left + 1 - maxF > k) {
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("The max repeating chars count : "+ charReplacement("AABAAV", 1));
    }
}

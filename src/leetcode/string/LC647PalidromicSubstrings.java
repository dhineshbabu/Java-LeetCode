package leetcode.string;

public class LC647PalidromicSubstrings {
    public int countSubstrings(String s) {
        // Time complexity: O(n^2)
        int count = 0;
        for(int i=0; i< s.length(); i++) {
            count += findSub(s, i, i);
            count += findSub(s, i , i+1);
        }
        return count;
    }

    public int findSub(String s, int left, int right) {
        int count = 0;
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count += 1;
            left--;
            right++;
        }
        return count;
    }
}

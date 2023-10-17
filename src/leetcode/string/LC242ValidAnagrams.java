package leetcode.string;

public class LC242ValidAnagrams {
    public static boolean validAnagrams(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<map.length; i++) {
            if(map[i] > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println("Anagram check is: "+ validAnagrams(s, t));
    }
}

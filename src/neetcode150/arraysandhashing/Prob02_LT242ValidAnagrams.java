package neetcode150.arraysandhashing;

public class Prob02_LT242ValidAnagrams {
    /*
    Given two strings s and t,
    return true if t is an anagram of s, and false otherwise.

    s1 and s2 consist of lowercase English letters.

     */

    public static boolean validAnagrams(String s1, String s2) {
        // base case
        if(s1.length() != s2.length()) {
            return false;
        }


        // array to increment and decrement count
        int[] map = new int[26];

        // go through the string and update the array numbers
        // increase for s1 and decrease the same index for s2

        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)-'a']++;
            map[s2.charAt(i)-'a']--;
        }

        for (int i = 0; i < map.length; i++) {
            if(map[i] > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validAnagrams("kani", "akni"));
        System.out.println(validAnagrams("adadsadsa", "fgf"));
    }
}

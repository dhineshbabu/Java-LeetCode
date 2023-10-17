package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49GroupAnagrams {
    public static List<List<String>> groupAnagram(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] ch_arr = str.toCharArray();
            Arrays.sort(ch_arr);
            String sortedStr = new String(ch_arr);
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Anagram group is: ");
        System.out.println(groupAnagram(strs));

    }
}

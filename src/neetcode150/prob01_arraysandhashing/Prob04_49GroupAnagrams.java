package neetcode150.prob01_arraysandhashing;

import java.util.*;

public class Prob04_49GroupAnagrams {
    /*
    Given an array of strings strs, group the anagrams together.
    You can return the answer in any order.
     */

    public static List<List<String>> groupAnagrams(String [] strs) {
        // checking base
        if(strs == null || strs.length == 0) return new ArrayList<>(new ArrayList<>());

        // create a map to store the values
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] ch = str.toCharArray();
            //sort to compare with stored char
            Arrays.sort(ch);

            String sortedStr = new String(ch);
            // check if the map contains the string
            if(!map.containsKey(sortedStr)) {
                // then  add it
                map.put(sortedStr, new ArrayList<String>());
            }
            // add the current actual string to the value in the array list in the map
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        for(List<String> groups: groupAnagrams(strs)) {
            System.out.println(groups);
        }


    }

}

/*
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
 */
package leetcode.string;
import java.util.*;

public class LC438FindAllAnagrams {

    /*
    Sliding window approach
     */

    public static List<Integer> findAllAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        System.out.println(map);

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;


        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }

    public static List<Integer> findAllAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] balanceArray = new int[26];
        if(p.length() > s.length()) return result;

        // fill up the balance array in such a way that reduce 1 for all the index that contain letters in p aray
        for(Character c: p.toCharArray()){
            balanceArray[c-'a']--;
        }

        // loop through the source array and do the following stps
        for(int end=0; end<s.length(); end++) {
            // increase the first character count
            balanceArray[s.charAt(end)-'a']++;

            //if end crosses the p array length then reduce the left most char to 0 if it is not part of anagram
            if(end >= p.length()) {
                balanceArray[s.charAt(end-p.length()) - 'a']--;
            }

            // check the balance array to become 0 in all the iterations
            if(Arrays.stream(balanceArray).allMatch(b -> b==0)) {
                result.add(end-p.length()+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAllAnagrams(s, p));

        // using the second method
        System.out.println(findAllAnagrams2(s, p));
    }
}

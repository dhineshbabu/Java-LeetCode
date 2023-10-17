package leetcode.string;

import java.util.HashMap;
import java.util.Stack;

public class LC20ValidParanthesis {
    public static boolean isValidParanthesis(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(map.containsKey(curr)) {
                char pop = stack.size() != 0 ? stack.pop() : '#';
                if(pop != map.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println("Paranthesis validation: " + isValidParanthesis(s));
    }
}

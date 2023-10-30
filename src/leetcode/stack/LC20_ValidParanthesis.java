package leetcode.stack;

import java.util.Stack;

public class LC20_ValidParanthesis {
    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for(char c: input.toCharArray()) {
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c) {
                // if the popped item is not a valid closing bracket then return false
                return false;
            }
        }
        return stack.isEmpty(); // stack must be empty if it is a valid bracket
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}

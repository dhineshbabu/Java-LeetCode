package neetcode150.prob04_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob01_LC20ValidParantheses {
    /*
    Idea is to push the closing parantheses when there is a opening bracket

     */

    public static boolean isValid(String s){
        // Initiate the stack
        Deque<Character> stack = new ArrayDeque<>();

        // check the individual character
        for(char c: s.toCharArray()) {
            if(c =='(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}

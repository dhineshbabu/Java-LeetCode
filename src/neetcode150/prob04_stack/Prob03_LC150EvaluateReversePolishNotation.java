package neetcode150.prob04_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob03_LC150EvaluateReversePolishNotation {
    /*
    Example 1:

    Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
     */

    public static int evaluateExpr(String[] tokens) {
        int a, b;

        // Initiate the stack
        Deque<Integer> stack = new ArrayDeque<>();

        // Loop through tokens
        for(String s: tokens) {
            // for addition
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if(s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a-b);
            } else if(s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a/b);
            } else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evaluateExpr(s)); //2

    }
}

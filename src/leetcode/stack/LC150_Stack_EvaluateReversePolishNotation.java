package leetcode.stack;

import java.util.Stack;

public class LC150_Stack_EvaluateReversePolishNotation {
    public static int evalExpression(String[] tokens) {
        int a,b;
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if(s.equals("/")) {
                b=stack.pop();
                a=stack.pop();
                stack.push(a/b);
            } else if(s.equals("-")) {
                b=stack.pop();
                a=stack.pop();
                stack.push(a-b);
            }
            else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] inputToken = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalExpression(inputToken));
    }
}

package leetcode.stack;

import java.util.Stack;

public class LC155_Stack_MinStack {
    Stack<Long> stack = new Stack<>();
    Long mini;

    public LC155_Stack_MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int value) {
        Long val = Long.valueOf(value);
        if(stack.isEmpty()) {
            stack.push(val);
            mini = val;
        }  else {
            if(val < mini) {

                stack.push(2*val-mini);
                mini = val;
            } else {
                stack.push(val);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        Long val = stack.pop();

        if(val < mini) {
            mini = 2*mini - val;
        }
    }

    public int top() {
        Long val = stack.peek();
        if(val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }


}

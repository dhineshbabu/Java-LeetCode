package neetcode150.prob04_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob02_LC155Minstack {
    /*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.

     */
// initiate the variables and stack
    Deque<Long> stack = new ArrayDeque<>(); // Using Deque to represent the stack
    Long mini; // Variable to store the current minimum value in the stack

    public Prob02_LC155Minstack() {
        mini = Long.MAX_VALUE; // Initialize mini to the maximum possible value initially
    }

    //push
    public void push(int value) {
        Long val = Long.valueOf(value);

        if(stack.isEmpty()) {
            // If the stack is empty, simply push the value and update mini
            stack.push(val);
            mini = val;
        } else {
            // If the stack is not empty, compare the new value with the current minimum
            if(val < mini) {
                // If the new value is less than the current minimum,
                // push a modified value that helps to track the change in minimum
                stack.push((2 * val) - mini);
                mini = val; // Update the minimum to the new value
            } else {
                // If the new value is greater than or equal to the current minimum,
                // simply push the new value onto the stack
                stack.push(val);
            }
        }
    }

    // pop
    public void pop() {
        if(stack.isEmpty()) return;

        Long val = stack.pop(); // Pop the top element from the stack

        if(val < mini) {
            // If the popped value is less than the current minimum,
            // it means a change in the minimum value occurred during the push operation.
            // Update mini to the previous minimum using the formula: 2 * previous_minimum - popped_value
            mini = 2 * mini - val;
        }
    }

    // top
    public int top() {
        Long val = stack.peek(); // Get the top element of the stack

        if(val < mini) {
            // If the top element is less than the current minimum,
            // return the current minimum as it represents the actual value
            return mini.intValue();
        }

        // Otherwise, return the top element as is
        return val.intValue();
    }

    // getMin
    public int getMin() {
        return mini.intValue(); // Return the current minimum value
    }

}

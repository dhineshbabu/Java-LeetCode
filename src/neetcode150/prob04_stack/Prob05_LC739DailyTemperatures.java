package neetcode150.prob04_stack;

import java.util.*;

public class Prob05_LC739DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        // Iterate through the temperatures array
        for (int i = 0; i < temperatures.length; i++) {
            // Check if the current temperature is greater than the temperature at the index on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // If true, update result array with the number of days to wait for a warmer temperature
                int idx = stack.pop(); // Get the index from the stack
                result[idx] = i - idx; // Calculate the difference and update the result at the index
            }

            // Push the current index onto the stack for future comparisons
            stack.push(i);
        }

        // Return the result array containing the number of days to wait for a warmer temperature for each day
        return result;
    }

    public static void main(String[] args) {
        Prob05_LC739DailyTemperatures solution = new Prob05_LC739DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);

        // Print the result
        for (int days : result) {
            System.out.print(days + " ");
        }
    }
}

package neetcode150.prob04_stack;
import java.util.*;

public class Prob04_LC22GenerateParantheses  {
    // Create a result list to store generated parentheses combinations
    static List<String> result = new ArrayList<>();

    // Root function to initiate the recursive generation of parentheses
    public static List<String> generateParenthesis(int n) {
        generateValue(result, 0, 0, n, ""); // Start the recursive generation with initial parameters
        return result; // Return the list of generated combinations
    }

    // Recursive function for backtracking to generate valid parentheses combinations
    public static void generateValue(List<String> result, int open, int close, int n, String str) {
        // Base case: If the length of the generated string is equal to 2*n,
        // add it to the result list and return to stop further recursion
        if(str.length() == 2 * n) {
            result.add(str);
            return;
        }

        // If the count of open parentheses is less than n,
        // it's possible to add an open parenthesis in the current position
        if(open < n) {
            generateValue(result, open + 1, close, n, str + "(");
        }

        // If the count of close parentheses is less than the count of open parentheses,
        // it's possible to add a close parenthesis in the current position
        if(close < open) {
            generateValue(result, open, close + 1, n, str + ")");
        }
    }

    // Main method to test the generation of parentheses combinations
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3)); // Print the generated combinations for n=3
    }

    /*
    Recursive call visualization:

    generateParanthesis(3)
   |
   +--- generateValue(result=[], open=0, close=0, n=3, str="")
        |
        +--- generateValue(result=[], open=1, close=0, n=3, str="(")
        |    |
        |    +--- generateValue(result=[], open=2, close=0, n=3, str="((")
        |    |    |
        |    |    +--- generateValue(result=[], open=3, close=0, n=3, str="(((")
        |    |    |    |
        |    |    |    +--- generateValue(result=["((()))"], open=3, close=1, n=3, str="((()))")
        |    |    |
        |    |    +--- generateValue(result=["((()))"], open=3, close=2, n=3, str="((()))")
        |    |
        |    +--- generateValue(result=["((()))"], open=2, close=1, n=3, str="(()")
        |    |    |
        |    |    +--- generateValue(result=["((()))"], open=3, close=1, n=3, str="(()()")
        |    |    |
        |    |    +--- generateValue(result=["((()))"], open=3, close=2, n=3, str="(()())")
        |    |
        |    +--- generateValue(result=["((()))"], open=2, close=2, n=3, str="(()())")
        |
        +--- generateValue(result=["((()))"], open=1, close=1, n=3, str="()")
        |    |
        |    +--- generateValue(result=["((()))"], open=2, close=1, n=3, str="()(")
        |    |    |
        |    |    +--- generateValue(result=["((()))"], open=3, close=1, n=3, str="()(())")
        |    |    |
        |    |    +--- generateValue(result=["((()))"], open=3, close=2, n=3, str="()(())")
        |    |
        |    +--- generateValue(result=["((()))"], open=2, close=2, n=3, str="()(())")
        |
        +--- generateValue(result=["((()))"], open=1, close=2, n=3, str="())")
        |    |
        |    +--- generateValue(result=["((()))"], open=2, close=2, n=3, str="())(")
        |    |    |
        |    |    +--- generateValue(result=["((()))"], open=3, close=2, n=3, str="())()")
        |    |
        |    +--- generateValue(result=["((()))"], open=2, close=2, n=3, str="())()")
        |
        +--- generateValue(result=["((()))"], open=1, close=3, n=3, str="())")
            |
            +--- generateValue(result=["((()))"], open=2, close=3, n=3, str="())(")
            |    |
            |    +--- generateValue(result=["((()))"], open=3, close=3, n=3, str="())()")
            |
            +--- generateValue(result=["((()))"], open=2, close=3, n=3, str="())()")

     */
}

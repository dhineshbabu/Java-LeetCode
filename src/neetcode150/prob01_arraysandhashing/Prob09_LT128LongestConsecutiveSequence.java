package neetcode150.prob01_arraysandhashing;

import java.util.*;

public class Prob09_LT128LongestConsecutiveSequence {
    /*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

        You must write an algorithm that runs in O(n) time.

        Example 1:

        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
        Example 2:

        Input: nums = [0,3,7,2,5,8,4,6,0,1]
        Output: 9

        idea is to use hashmap for storing the visited history
     */

    public static int longestSequence(int[] nums) {
        int longestLength = 0;

        Map<Integer, Boolean> exploredMap = new HashMap<>();

        // add all the elements in the array as key and set value as flase
        for(int num: nums) {
            exploredMap.put(num, Boolean.FALSE);
        }

        // iterate through the array
        for(int num: nums) {
            int currentLength = 1;

            // check in forward condition
            int nextNum = num + 1;
            while(exploredMap.containsKey(nextNum) && exploredMap.get(nextNum) == false) {
                currentLength++;
                exploredMap.put(nextNum, true);

                // increment
                nextNum++;
            }

            // check for previous number
            int prevNum = num -1;

            while (exploredMap.containsKey(prevNum) && exploredMap.get(prevNum) ==  false) {
                currentLength++;
                exploredMap.put(prevNum, true);

                // decrement and move back
                prevNum--;
            }

            // validate the max length
            longestLength = Math.max(currentLength, longestLength);
        }

        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestSequence(nums));
    }
}

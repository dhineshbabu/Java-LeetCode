package neetcode150.prob01_arraysandhashing;

import java.util.*;

public class Prob03_LT01TwoSum {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
     */

    public static int[] twoSum(int[] arr, int sum) {
         Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // calculate the complement for each number
            int complement = sum - arr[i];

            // check if the complement is available in the hashmap
            if(map.containsKey(complement)) {
                // return the items
                return new int[]{i, map.get(complement)};
            }
            // add the current element index to the map
            map.put(arr[i], i);
        }

        // if not found return an empty array
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 18))); //[2, 1]
    }
}

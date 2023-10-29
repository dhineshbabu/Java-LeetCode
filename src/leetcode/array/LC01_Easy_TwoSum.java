package leetcode.array;

import java.util.*;

public class LC01_Easy_TwoSum {

    // Time complexity: O(n^2)
    public static int[] twoSumIterative(int[] num, int target) {
        for (int i=0; i< num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                if(num[i] + num[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {};
    }

    // using single pass hashmap
    public static int[] twoSumHashMap(int[] num, int target) {
        // Create the hashmap to store the numbers and index
        Map<Integer, Integer> map = new HashMap<>();
        int n = num.length;
        for(int i=0; i<num.length; i++) {
            int complement = target-num[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(num[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,9,6,7};

        System.out.println(Arrays.toString(twoSumIterative(nums, 13)));
        System.out.println(Arrays.toString(twoSumHashMap(nums, 15)));
    }
}

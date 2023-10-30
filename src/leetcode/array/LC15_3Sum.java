package leetcode.array;

import java.util.*;

public class LC15_3Sum {
    // This approach follows O(n^2) with 2 nested loops

    public static List<List<Integer>> threeArraySum(int[] nums) {
        if(nums.length <3 || nums == null) return new ArrayList<>();

        // sort the array in place
        Arrays.sort(nums);

        // initiate the result set
        Set<List<Integer>> result = new HashSet<>();

        for(int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] inputArr = {-1, 0, 1, 2, -1, 4};
        System.out.println(threeArraySum(inputArr));
    }
}

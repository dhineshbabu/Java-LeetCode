package neetcode150.prob02_twopointers;
import java.util.*;

public class Prob03_LC15ThreeSum {
    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
     */

    public static List<List<Integer>> threeSum(int[] nums) {
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
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}


package neetcode150.prob02_twopointers;

import java.util.Arrays;

public class Prob02_LT167TwoSumInputArraySorted {
    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.
     */

    public static int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length-1;

        while(p1 < p2) {
            int sum = numbers[p1]+numbers[p2];
            if(sum > target) {
                p2--;
            } else if (sum < target) {
                p1++;
            } else {
                return new int[]{p1, p2};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,5,7,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

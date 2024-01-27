package neetcode150.prob01_arraysandhashing;

import java.util.Arrays;

public class Prob06_LT238ProductOfArrayExceptSelf {
    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    You must write an algorithm that runs in O(n) time and without using the division operation.

    calcualate the left sum and right sum arrays
     */

    public static int[] productExceptSelf(int[] nums) {
        // array to store left side of element product
        int[] left = new int[nums.length];

        // array to store right side of element product
        int[] right = new int[nums.length];

        // calculate the left products
        left[0] = 1;
        for(int i=1; i<nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        // calculate the right products
        right[nums.length-1] = 1;
        for(int i=nums.length-2; i>-1; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];

        // finally result is the sum of left sum * right sum array for that respective index
        for(int i=0; i<nums.length;i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }
}

package leetcode.array;

import java.util.Arrays;

public class LC238_ProductofArrayExceptSelf {

    public static int[] productArray(int[] nums) {
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

        for(int i=0; i<nums.length;i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,12,5,3};
        System.out.println(Arrays.toString(productArray(nums)));
    }
}

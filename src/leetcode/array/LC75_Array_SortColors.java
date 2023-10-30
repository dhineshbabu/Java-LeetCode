package leetcode.array;

import java.util.Arrays;

public class LC75_Array_SortColors {
    public static void sortColors(int[] nums) {

        // uses 3 pointers approach
        int start=0, middle=0, end=nums.length-1;

        while(middle <= end) {
            if(nums[middle] == 0) {
                swap(nums, start, middle);
                middle++;
                start++;
            } else if(nums[middle] == 1) {
                // just increase the middle to the next item
                middle++;
            } else if(nums[middle] == 2) {
                swap(nums, end, middle);
                end--;
            }
        }
    }

    private static void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

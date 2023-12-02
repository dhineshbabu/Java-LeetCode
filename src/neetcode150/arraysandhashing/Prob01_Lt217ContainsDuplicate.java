package neetcode150.arraysandhashing;

import java.util.HashSet;

public class Prob01_Lt217ContainsDuplicate {
    /*
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
     */

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])){
                return true;
            }
            hashSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6,5,1};
        System.out.println("Contains duplicate: " + containsDuplicate(nums) );
    }
}

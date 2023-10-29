package leetcode.array;

import java.util.HashSet;

public class LC217_ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        // Time complexity: O(n)

        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6, 8,4};
        System.out.println("Contain Duplicate: " + containsDuplicate(nums));
    }
}

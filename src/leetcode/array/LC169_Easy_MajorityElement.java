package leetcode.array;

public class LC169_Easy_MajorityElement {
    public static int majorityElement(int[] nums) {
        // Moore's voting algorithm
        // Time complexity: O(n)
        // Space complexity: O(1)

        int votes = 1;
        int majority = nums[0];

        // loop through the response of the array
        for(int i=1; i<nums.length; i++) {
            if(votes == 0) {
                majority = nums[i];
                votes++;
            } else if(majority == nums[i]) {
                votes++;
            } else {
                votes--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,3,1,2,2};
        System.out.println(majorityElement(nums));
    }
}

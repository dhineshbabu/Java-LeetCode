package neetcode150.twopointers;

public class Prob05_LC42TrappingRainWater {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.
     */

    public static int trap(int[] height) {
        // Time complexity: O(n)
        // Space complexity: O(1)

        // Initialize two pointers at the beginning and end of the array
        int left = 0, right = height.length - 1;

        // Variable to store the total water content
        int waterContent = 0;

        // Variables to track the maximum height encountered from the left and right
        int maxLeft = 0, maxRight = 0;

        // Continue until the two pointers meet
        while (left <= right) {
            // If the height at the left pointer is less than or equal to the height at the right pointer
            if (height[left] <= height[right]) {
                // If the height at the left pointer is greater than or equal to the maximum height encountered from the left
                if (height[left] >= maxLeft)
                    maxLeft = height[left];
                else
                    // Add the water content based on the difference between the maximum left height and the current left height
                    waterContent += maxLeft - height[left];

                // Move the left pointer to the right
                left++;
            } else {
                // If the height at the right pointer is greater than or equal to the maximum height encountered from the right
                if (height[right] >= maxRight)
                    maxRight = height[right];
                else
                    // Add the water content based on the difference between the maximum right height and the current right height
                    waterContent += maxRight - height[right];

                // Move the right pointer to the left
                right--;
            }
        }

        // Return the total water content trapped
        return waterContent;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}

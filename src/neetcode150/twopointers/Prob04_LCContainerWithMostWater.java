package neetcode150.twopointers;

public class Prob04_LCContainerWithMostWater {
    /*

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.


     */

    public static int maxArea(int[] height) {
        // Initialize two pointers, one at the beginning and one at the end of the array
        int left = 0;
        int right = height.length - 1;

        // Initialize a variable to store the maximum area
        int maxArea = 0;

        // Continue until the two pointers meet
        while (left < right) {
            // Calculate the current area using the minimum height between the two pointers
            // multiplied by the distance between them
            int currentArea = Math.min(height[left], height[right]) * (right - left);

            // Update the maximum area if the current area is greater
            maxArea = Math.max(currentArea, maxArea);

            // Move the pointers towards each other based on the shorter height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Return the maximum area found
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

}

package leetcode.array;

public class LC42_Array_TrappingRainWater {
    public int trap(int[] height) {

        //complexity: O(n)
        // Space complexity: O(1)
        int left=0, right=height.length-1;
        int waterContent = 0;
        int maxLeft = 0, maxRight=0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] >= maxLeft) maxLeft=height[left];
                else waterContent += maxLeft-height[left];
                // reduce left pointer in any case
                left++;
            } else {
                // if the right pointer is less than left pointer value(array[pointer])
                if(height[right] >= maxRight) maxRight=height[right];
                else waterContent += maxRight-height[right];
                // reduce right pointer in any case
                right--;
            }
        }

        return waterContent;
    }
}

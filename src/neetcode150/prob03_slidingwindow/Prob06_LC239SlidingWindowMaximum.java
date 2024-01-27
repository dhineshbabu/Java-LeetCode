package neetcode150.prob03_slidingwindow;
import java.util.*;
public class Prob06_LC239SlidingWindowMaximum {
    /*
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
     */

    public static int[] maxSlidingWindow(int[] a, int k) {
        // Get the length of the array
        int n = a.length;

        // Create an array to store the maximum values in each sliding window
        int[] r = new int[n - k + 1];

        // Initialize an index for the result array
        int ri = 0;

        // Create a deque to store indices
        Deque<Integer> q = new ArrayDeque<>();

        // Iterate through the array elements
        for (int i = 0; i < a.length; i++) {
            // Remove numbers that are out of the current window range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }

            // Remove smaller numbers in the current window range as they are not needed
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            // Add the current index to the deque
            q.offer(i);

            // If the window size is reached (i >= k - 1), store the maximum value in the result array
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }

        // Return the array containing maximum values in each sliding window
        return r;
    }
    public static void main(String args[]) {
        int i, j, n, k = 3, x;
        int arr[]={4,0,-1,3,5,3,6,8};
        int ans[] = maxSlidingWindow(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");

    }

}

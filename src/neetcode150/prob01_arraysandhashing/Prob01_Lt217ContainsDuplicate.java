package neetcode150.prob01_arraysandhashing;

import java.util.HashSet;

public class Prob01_Lt217ContainsDuplicate {
    /*
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
     */

    // Method to check if an array contains any duplicates
    public static boolean containsDuplicate(int[] nums) {
        // HashSet to store unique elements encountered in the array
        HashSet<Integer> hashSet = new HashSet<>();

        // Loop through each element in the array
        for (int num : nums) {
            // Check if the HashSet already contains the current element
            if (hashSet.contains(num)) {
                // If duplicate found, return true
                return true;
            }
            // Add the current element to the HashSet
            hashSet.add(num);
        }

        // If the loop completes without finding duplicates, return false
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,6,5,1};
        System.out.println("Contains duplicate: " + containsDuplicate(nums) );
    }
}

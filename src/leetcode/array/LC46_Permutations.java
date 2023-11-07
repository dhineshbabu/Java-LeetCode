package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC46_Permutations {
    // classical backtracking problem with recursion
    // we need to print all the permutations of a given array of numbers
    // Need helper method for this

    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // helper recursive method
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    public static void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums) {
        // write the base case: once the current templist reaches the nums.length

        if(tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
        }

        // iterate over each character and do the backtrackling
        for(int number: nums) {

            // skip if the element is already added in the current temp list
            if (tempList.contains(number)) {
                continue;
            }

            // else add the new element to the tempList
            tempList.add(number);

            // Go back to try another element
            backtrack(resultList, tempList, nums);

            // remove the added element in the previous backtrack
            tempList.remove(tempList.size()-1);
        }


    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        List<List<Integer>> permutations = permutation(nums);
        permutations.stream()
                .forEach(System.out::print);
    }

}

package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L8_Array_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void findCombinations(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> newCombination) {
        if(index == candidates.length) {
            // if the sum meets the target them the result will be 0 for the interim target
            if(target ==  0) {
                result.add(new ArrayList<>(newCombination));
            }
            return;
        }

        if(candidates[index] <= target) {
            newCombination.add(candidates[index]);
            // try to recursive add the same values to see if the same+same sum returns target
            findCombinations(index, candidates, target-candidates[index], result, newCombination);
            //if the result is not as expected then remove this number and go to the next number in the candidates with another recursive call
            newCombination.remove(newCombination.size()-1);
        }

        // check for the next element in the candidates array
        findCombinations(index+1, candidates, target, result, newCombination);
    }

    // main function
    public static void main(String[] args) {
        int[] array = {2,3,5};
        int target = 8;
        List<List<Integer>> output = combinationSum(array, target);
        System.out.println(output);
    }

}

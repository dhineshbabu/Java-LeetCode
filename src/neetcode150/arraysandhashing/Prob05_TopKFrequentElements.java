package neetcode150.arraysandhashing;

import java.util.*;

public class Prob05_TopKFrequentElements {
    /*
    Given an integer array nums and an integer k, return the k most frequent elements.
    You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
     */

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Create a HashMap to store the frequency of each number
        Map<Integer, Integer> hm = new HashMap<>();

        // Step 2: Create a bucket array to store numbers based on their frequencies
        List<Integer>[] bucket = new List[nums.length + 1];

        // Step 3: Create a list to store the final result
        List<Integer> res = new ArrayList<>();

        // Step 4: Populate the HashMap with the frequency of each number
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 5: Populate the bucket array based on the frequency of each number
        for(int key: hm.keySet()){
            int frequency = hm.get(key);
            if(bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            // 2 numbers can have the same frequecy
            // so arraylist is better for adding in the freq bucket array
            bucket[frequency].add(key);
        }

        // Step 6: Traverse the bucket array in reverse order to get top K frequent elements
        for(int pos = bucket.length-1; pos >= 0; pos--){
            if(bucket[pos] != null){
                for(int i = 0; i < bucket[pos].size() && res.size() < k; i++)
                    res.add(bucket[pos].get(i));
            }
        }

        // Step 7: Return the final result
        return res;
    }

    // using priorityQueue method

    public static List<Integer> topKFrequentPQ(int[] nums, int k) {
        // Step 1: Create a HashMap to store the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        // Step 2: Populate the HashMap with the frequency of each number
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Step 3: Create a minHeap using PriorityQueue to keep track of the top K frequent elements
        // The comparison is based on the frequency of elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        // Step 4: Add entries to the minHeap and keep its size at most K
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the entry with the smallest frequency
            }
        }

        // Step 5: Retrieve the top K frequent elements from the minHeap
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res.add(entry.getKey());
        }

        // Step 6: Return the final result
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        // top k elements
        System.out.println("Top K Elements");
        System.out.println(topKFrequent(nums, k));
    }

}

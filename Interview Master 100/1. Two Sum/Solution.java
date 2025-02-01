// https://leetcode.com/problems/two-sum/submissions/1446932852/?utm_source=instabyte.io&utm_medium=referral&utm_campaign=interview-master-100

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return ans;
    }
}

// Intuition

// To improve our runtime complexity, we need a more efficient way to check if the complement exists in the array. 
// If the complement exists, we need to get its index. What is the best way to maintain a mapping of each element in the array to its index? 
// A hash table.

// We can reduce the lookup time from O(n) to O(1) by trading space for speed. A hash table is well suited for this purpose
// because it supports fast lookup in near constant time. I say "near" because if a collision occurred, a lookup could degenerate to O(n) time. 
// However, lookup in a hash table should be amortized O(1) time as long as the hash function was chosen carefully.

// Algorithm

// It turns out we can do it in one-pass. While we are iterating and inserting elements into the hash table, 
// we also look back to check if current element's complement already exists in the hash table. If it exists, we have found a solution and return the indices immediately.

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }
}
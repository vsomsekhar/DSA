// https://leetcode.com/problems/majority-element-ii/description/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
        int arrayLength = nums.length;

        for (int i = 0; i < arrayLength; i++) {
            if (count1 == 0 && nums[i] != element2) {
                count1 = 1;
                element1 = nums[i];
            }
            else if (count2 == 0 && nums[i] != element1) {
                count2 = 1;
                element2 = nums[i];
            }
            else if (element1 == nums[i])
                count1++;
            else if (element2 == nums[i])
                count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;

        for (int i = 0; i < arrayLength; i++) {
            if (element1 == nums[i])
                count1++;
            if (element2 == nums[i])
                count2++;
        }

        if (count1 > arrayLength/3 && count2 > arrayLength/3)
            return List.of(element1, element2);
        else if (count1 > arrayLength/3)
            return List.of(element1);
        else if (count2 > arrayLength/3)
            return List.of(element2);
        else 
            return List.of();

    }
}

// 1. Boyer-Moore Majority Voting Solution
// Create variables to track counts and candidates for potential majority elements.
// First Pass - Find Potential Majority Elements:
// Iterate through the input array and identify potential majority element candidates.
// Update the candidates based on specific conditions.
// Maintain counts for each candidate.
// Second Pass - Count Occurrences:
// Iterate through the input array again to count the occurrences of the potential majority elements.
// Compare the counts with a threshold to determine the majority elements.
// Return Majority Elements.
// Complexity
// Time complexity: O(N)
// Since we are iterating over the array in two passes then the complexity is 2 * N which is O(N).
// Space complexity: O(1)
// Since we are only storing constant variables then the complexity is O(1).

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0; // Counters for the potential majority elements
        int candidate1 = 0, candidate2 = 0; // Potential majority element candidates

        // First pass to find potential majority elements.
        for (int i = 0; i < nums.length; i++) {
            // If count1 is 0 and the current number is not equal to candidate2, update candidate1.
            if (count1 == 0 && nums[i] != candidate2) {
                count1 = 1;
                candidate1 = nums[i];
            } 
            // If count2 is 0 and the current number is not equal to candidate1, update candidate2.
            else if (count2 == 0 && nums[i] != candidate1) {
                count2 = 1;
                candidate2 = nums[i];
            } 
            // Update counts for candidate1 and candidate2.
            else if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } 
            // If the current number is different from both candidates, decrement their counts.
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3; // Threshold for majority element

        // Second pass to count occurrences of the potential majority elements.
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            }
        }

        // Check if the counts of potential majority elements are greater than n/3 and add them to the result.
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }
}
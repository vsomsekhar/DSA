// https://leetcode.com/problems/rearrange-array-elements-by-sign/submissions/1477107958/

class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] answer = new int[nums.length];

        int i = 0, positiveIndex = 0, negativeIndex = 1;

        while(i < nums.length) {
            if (nums[i] > 0) {
                answer[positiveIndex] = nums[i];
                positiveIndex = positiveIndex + 2;
            } else {
                answer[negativeIndex] = nums[i];
                negativeIndex = negativeIndex + 2;
            }
            i++;
        }
        
        return answer;
    }
}

// Here we are directly putting values in the ans vector with the help of 2 pointer approach where initially both the indexes pos and neg are 0 and 1.
// If we encounter positive element then will put values in the ans vector with the help of ans[pos] = nums[i] and if found negative element then ans[neg] = nums[i].

// Complexity
// Time complexity:
// O(n)

// Space complexity:
// O(n)


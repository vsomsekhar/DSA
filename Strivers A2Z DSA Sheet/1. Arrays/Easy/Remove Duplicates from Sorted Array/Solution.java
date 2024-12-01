// https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1467311186/

public class Solution {
    public int removeDuplicates(int[] nums) {

        int indexPointer = 0;
        int traversalPointer = 1;

        while (traversalPointer < nums.length) {
            if (nums[indexPointer] != nums[traversalPointer]) {
                nums[indexPointer+1] = nums[traversalPointer];
                indexPointer++;
                traversalPointer++;
            } else {
                traversalPointer++;
            }
        }

        return indexPointer + 1;
        
    }
}

// [1, 1, 2, 2]

// Intuition:
// The Intuition is to use two pointers, i and j, to iterate through the array. The variable j is used to keep track of the current index where a unique element should be placed. The initial value of j is 1 since the first element in the array is always unique and doesn't need to be changed.

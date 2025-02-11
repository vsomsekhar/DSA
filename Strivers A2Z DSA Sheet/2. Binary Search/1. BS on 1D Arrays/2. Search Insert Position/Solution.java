// https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int low = 0, mid = 0, high = nums.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return target > nums[mid] ? mid + 1 : mid;
    }
}
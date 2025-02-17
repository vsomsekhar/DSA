// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMin(int[] nums) {
        
        int low = 0, high = nums.length - 1;
        int lowest = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[low] <= nums[high]) {
                lowest = Math.min(lowest, nums[low]);
                break;
            }

            if (nums[low] <= nums[mid]) {
                lowest = Math.min(lowest, nums[low]);
                low = mid + 1;
            }
            else {
                lowest = Math.min(lowest, nums[mid]);
                high = mid - 1;
            }

        }

        return lowest;
    }
}
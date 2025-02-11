// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid])
                return mid;

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid])
                    high = mid - 1;
                else 
                    low = mid + 1;
            } 
            else {
                if (target >= nums[mid] && target <= nums[high])
                    low = mid + 1;
                else 
                    high = mid - 1;
            }
            
        }

        return -1;
    }
}

// https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/3879263/100-binary-search-easy-video-o-log-n-optimal-solution/
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// lower bound and upper bound way

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];
        int length = nums.length;
        int lowerBound = lowerBound(nums, target, length);
        int upperBound = upperBound(nums, target, length);

        if (lowerBound == length || nums[lowerBound] != target) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        } else {
            ans[0] = lowerBound;
            ans[1] = upperBound - 1;
            return ans;
        }
    }

    // nums[mid] >= target
    private int lowerBound(int[] nums, int target, int length) {
        int low = 0, mid = 0, high = length - 1, lowerBound = length;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    // nums[mid] > target
    private int upperBound(int[] nums, int target, int length) {
        int low = 0, mid = 0, high = length - 1, upperBound = length;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                upperBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upperBound;
    }

}

// time complexity: 2 O(logn) and space complexity: O(1)


// this is same time complexity and space complexity but without lowerBound and upperBound

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int length = nums.length;
        int[] ans = new int[2];

        ans[0] = findFirst(nums, target, length);
        ans[1] = findLast(nums, target, length);

        return ans;
    }

    private int findFirst(int[] nums, int target, int length) {
        int low = 0, mid = 0, high = length - 1, ans = -1;
 
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                ans = mid;
                high = mid - 1;
            } 
            else if (target > nums[mid]) 
                low = mid + 1;
            else 
                high = mid - 1;
        }

        return ans;
    }

    private int findLast(int[] nums, int target, int length) {
        int low = 0, mid = 0, high = length - 1, ans = -1;
 
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                ans = mid;
                low = mid + 1;
            } 
            else if (target > nums[mid]) 
                low = mid + 1;
            else 
                high = mid - 1;
        }

        return ans;
    }

}
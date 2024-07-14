class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int length = nums.length;

        for(int i = 0; i < length; i++) {
            if (nums[i] > nums[(i+1) % length]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
        
    }
}


https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
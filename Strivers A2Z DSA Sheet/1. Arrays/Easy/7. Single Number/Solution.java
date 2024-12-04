// https://leetcode.com/problems/single-number/submissions/1469218909/

class Solution {
    public int singleNumber(int[] nums) {

        int xor = 0;

        for (int n : nums) {
            xor = xor ^ n;
        }

        return xor;
        
    }
}
// https://leetcode.com/problems/maximum-subarray/submissions/1473347210/

class Solution {
    public int maxSubArray(int[] nums) {

        int i = 0, max = nums[0], currentMax = 0;

        while (i < nums.length) {
            currentMax = currentMax + nums[i];

            if (max < currentMax)
                max = currentMax;

            if (currentMax < 0)
                currentMax = 0;
            
            i++;
        }

        return max;
        
    }
}

// Intution: Start traversing your array keep each element in the sum and every time keep the max of currSum and prevSum.
// But the catch here is that if at any point sum becomes negative then no point keeping it because 0 is obviously greater than negative, so just make your sum 0.

// Now here in this question you can see that you can also be asked some more things like :

// Length of the max subarray
// Elements of the max subarray
// Start and End index of max subarray
// This is very important concept from interview point so try to get the ans of above mentioned point and have confidence on this algorithm.

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);
            
            if(sum<0) sum = 0;
        }
        
        return max;
    }
}
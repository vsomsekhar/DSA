// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1466303766/?utm_source=instabyte.io&utm_medium=referral&utm_campaign=interview-master-100

class Solution {
    public int maxProfit(int[] prices) {

        int length = prices.length;
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;

        if (prices.length == 0 || prices == null)
            return 0;

        for (int i = 0; i < length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            if (profit  < prices[i] - buyPrice) {
                profit = prices[i] - buyPrice;
            }
        }
        
        return profit;
        
    }
}

// Kadane's Algorithm - Since no one has mentioned about this so far :) (In case if interviewer twists ...

// The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a good thing for everybody to know.

// All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

// Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.

public int maxProfit(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for(int i = 1; i < prices.length; i++) {
        maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
        maxSoFar = Math.max(maxCur, maxSoFar);
    }
    return maxSoFar;
}
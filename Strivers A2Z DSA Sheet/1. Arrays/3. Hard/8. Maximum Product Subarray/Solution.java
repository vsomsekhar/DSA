// https://leetcode.com/problems/maximum-product-subarray/description/

class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int leftProduct = 1, rightProduct = 1; // Stores the running product from both directions
        int maxProduct = nums[0]; // Initialize with the first element as the max product
        
        for (int i = 0; i < n; i++) {

            // Reset product to 1 if it becomes 0, to avoid multiplication issues
            leftProduct = (leftProduct == 0) ? 1 : leftProduct;
            rightProduct = (rightProduct == 0) ? 1 : rightProduct;
            
            // Calculate product from the left side (nums[0] to nums[n-1])
            leftProduct *= nums[i];
            
            // Calculate product from the right side (nums[n-1] to nums[0])
            rightProduct *= nums[n - 1 - i];
            
            // Update maxProduct by considering both directions
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        
        return maxProduct;
        
    }
}

// https://leetcode.com/problems/reverse-pairs/solutions/127560/reverse-pairs/
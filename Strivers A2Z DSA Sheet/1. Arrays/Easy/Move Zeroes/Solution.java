// https://leetcode.com/problems/move-zeroes/submissions/1467393062/

class Solution {
    public void moveZeroes(int[] nums) {

        // Initialize a pointer to keep track of the position of the last non-zero element found.
        int lastNonZeroFoundAt = -1;
        // Variable to store the array's length to avoid recalculating it.
        int arrayLength = nums.length;

        // Iterate over the array.
        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            // If the current element is not zero,
            if (nums[currentIndex] != 0) {
                // Increment the lastNonZeroFoundAt.
                lastNonZeroFoundAt++;

                // Swap the current element with the element at the lastNonZeroFoundAt position.
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[currentIndex];
                nums[currentIndex] = temp;
            }
        }
        
    }
}


// The idea is that we go through the array and gather all zeros on our road.

// Let's take our example:
// the first step - we meet 0.
// Okay, just remember that now the size of our snowball is 1. Go further.

// 0 , 1, 0, 3, 12

// Next step - we encounter 1. Swap the most left 0 of our snowball with element 1.

// 1, 0 ,0 , 3, 12

// Next step - we encounter 0 again! Our ball gets bigger, now its size = 2.

// Next step - 3. Swap again with the most left zero. Looks like our zeros roll all the time

// 1, 3, 0, 0, 12

// Next step - 12. Swap again:

// 1, 3, 12, 0, 0

//We reached finish!

class Solution {
     public void moveZeroes(int[] nums) {
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}
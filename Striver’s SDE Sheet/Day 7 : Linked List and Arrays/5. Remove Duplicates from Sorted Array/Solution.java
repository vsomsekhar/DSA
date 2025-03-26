// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// ✅ Intuition
// 	1.	Since the array is sorted, duplicates will always appear next to each other.
// 	2.	Use two pointers:
// 	•	i → Iterate through the array.
// 	•	k → Tracks the position where the next unique element should be placed.
// 	3.	If the current element (nums[i]) is different from the last unique element (nums[k - 1]), store it at nums[k] and increment k.

// ⸻

// ⏰ Time Complexity
// 	•	O(n) → We iterate through the array once.

// ⸻

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used (modifying the array in place).

class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // Initialize the count of unique elements to 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Overwrite the next unique element
                k++;
            }
        }
        
        return k;

    }
}


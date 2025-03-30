// https://leetcode.com/problems/max-consecutive-ones/description/

// ✅ Intuition
// 	1.	Keep a running count of consecutive 1s using count.
// 	2.	When a 0 is found:
// 	•	Compare count with max and update max if needed.
// 	•	Reset count to 0.
// 	3.	After the loop, handle the case where the array ends with 1s by doing a final Math.max() check.

// ⸻

// ⏰ Time Complexity
// 	•	O(n) → We traverse the array once.

// ⸻

// 🪴 Space Complexity
// 	•	O(1) → Constant extra space used.

class Solution {
    /**
     * Intuition:
     * - The goal is to find the maximum number of consecutive 1s in a binary array.
     * - Use two variables:
     *   - `count` → Keeps track of the current streak of 1s.
     *   - `max` → Keeps track of the highest streak of consecutive 1s.
     * - If a `1` is found, increase `count`.
     * - If a `0` is found:
     *   - Update `max` with the highest streak so far.
     *   - Reset `count` to 0.
     * - After the loop, update `max` to account for the last streak (if the array ends with 1s).
     */

    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0; // Keeps track of current streak of 1s
        int max = 0;   // Keeps track of the maximum streak of 1s

        for (int val : nums) {
            if (val == 1) {
                count++; // Increase streak if 1 is found
            } else {
                max = Math.max(max, count); // Update max streak if needed
                count = 0; // Reset current streak
            }
        }

        // Update max to account for the last streak (if array ends with 1s)
        return Math.max(count, max);
    }
}